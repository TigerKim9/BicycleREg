package com.spring.bicycle.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.bicycle.domain.NoticeDTO;
import com.spring.bicycle.domain.PagingDTO;
import com.spring.bicycle.domain.ProjectFundingDTO;
import com.spring.bicycle.service.AdminMainService;
import com.spring.bicycle.service.AdminService;
import com.spring.bicycle.service.FundedService;
import com.spring.bicycle.service.PagingService;
import com.spring.bicycle.service.ProjectFundingService;
import com.spring.bicycle.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private AdminService adminService;
	private FundedService fundedService;
	private ProjectFundingService projFundingService;
	private UserService userService;
	private AdminMainService adMainService;
	private PagingService pagingService;
	
	
	@Autowired
	public void setService(AdminService adminService, FundedService fundedService,
			ProjectFundingService projFundingService, UserService userSerivce, AdminMainService adMainService, PagingService pagingService) {
		this.adminService = adminService;
		this.fundedService = fundedService;
		this.projFundingService = projFundingService;
		this.userService = userSerivce;
		this.adMainService = adMainService;
		this.pagingService=pagingService;
	}
	
	public String printEmail(Principal principal) {
	      String regex = "^[0-9]*$";
	      String emailRegex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]" + "([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	      
	      try {
	         String prc = principal.getName();
	         if (prc != null) {
	            if (Pattern.matches(emailRegex, prc)) { // 자체 로그인시
	               return prc;
	            }
	            if (Pattern.matches(regex, prc)) { // 구글, 카카오 로그인이라면
	               prc = principal.toString();
	               prc = StringUtils.remove(prc, "has_email=true,"); // 카카오 이메일 추출 위해
	            }
	            System.out.println("원 API : " + prc);

	            String regprc = StringUtils.substringBetween(prc, "email=", ",");// 'email=' 과 ',' 사이의 값을 가져옴.
	            return regprc;
	         }
	      } catch (NullPointerException e) {
	         return null;
	      }
	      return null;
	   }
	
	@RequestMapping("/main")
	public String adminMainPage(Model model, Principal principal) {
		model.addAttribute("tdUsers", userService.todayUsers());
		model.addAttribute("tdProj", projFundingService.todayProjects());
		model.addAttribute("admin_totalPrice", adMainService.admin_totalPrice());
		model.addAttribute("admin_lastTotalPrice", adMainService.admin_lastTotalPrice());
		model.addAttribute("admin_category", adMainService.admin_category());
		
		if (fundedService.allFundedPrice() != null) {
			model.addAttribute("allFundPrice", fundedService.allFundedPrice());
		} else {
			model.addAttribute("allFundPrice", "0");
		}
		
		model.addAttribute("prc", printEmail(principal));
		return "admin/adminMain";
	}
	
	@RequestMapping("/managingUser")
	public String ManagingUserPage(Model model, Principal principal) {
		model.addAttribute("prc", printEmail(principal));
		return "admin/managingUser";
	}
	
	/* ----- Project 관련 ----- */
	@RequestMapping("managingProject")
	public String ManagingProjPage(Model model, Principal principal, PagingDTO dto, Integer num1 ,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage
			) {
		
		
		if(num1 == null)
		{
			num1=1;
		}
		// 관리자단의 모든 프로젝트 보여주기
		int total = pagingService.adAllProj();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		LocalDate today = LocalDate.now();
	      model.addAttribute("today", today);
		dto = new PagingDTO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", dto);
		
//		model.addAttribute("allProj", projFundingService.allProjects());
		List<ProjectFundingDTO> adProjList = pagingService.adProjList(dto.getStart(), dto.getCntPage());
		model.addAttribute("list", adProjList);
//		model.addAttribute("list", adminService.projList());
		model.addAttribute("prc", printEmail(principal));
		return "admin/managingProject";
	}
	
	@GetMapping("/viewProject")
	public String viewProject(int prnum, Model model) {
		int likes = (int) ((fundedService.likesCnt(prnum) != null) ? fundedService.likesCnt(prnum) : 0);
		model.addAttribute("list", adminService.selectByPrnum(prnum));
		model.addAttribute("likes", likes);
		return "admin/viewProject";
	}
	
	@GetMapping("/deleteProject")
	public String deleteProject(int prnum, Model model) {
		model.addAttribute("result", adminService.deleteByPrnum(prnum));
		return "admin/deleteProject";
	}
	
	@RequestMapping("/updateProject")
	public String updateProject(int prnum, Model model) {
		model.addAttribute("list", adminService.selectByPrnum(prnum));
		return "admin/updateProject";
	}
	
	@PostMapping("/updateOkProject")
	public String updateOkProject(ProjectFundingDTO dto, Model model) {		
		model.addAttribute("result", adminService.update(dto));
		return "admin/updateOkProject";
	}
	
	/* ----- Notice 관련 ----- */
	@RequestMapping("/managingNotice")
	   public String ManagingNoticePage(Model model, Principal principal,
	         PagingDTO dto, Integer num1 ,
	         @RequestParam(value="nowPage", required=false)String nowPage,
	         @RequestParam(value="cntPerPage", required=false)String cntPerPage
	         ) {
	      
	      if(num1 == null)
	      {
	         num1=1;
	      }
	      
	      // notice관련 모든 글이 보여야함
	      int total = pagingService.adntcount();
	      if (nowPage == null && cntPerPage == null) {
	         nowPage = "1";
	         cntPerPage = "5";
	      } else if (nowPage == null) {
	         nowPage = "1";
	      } else if (cntPerPage == null) { 
	         cntPerPage = "5";
	      }
	      dto = new PagingDTO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
	      model.addAttribute("paging", dto);
	      
//	      String selid = printEmail(principal);
	      model.addAttribute("list", pagingService.ntcList(dto.getStart(), dto.getCntPage()));
	      model.addAttribute("prc", printEmail(principal));
	      return "admin/managingNotice";
	   }
	
	@GetMapping("/viewNotice")
	public String viewNotice(int num, Model model) {
		model.addAttribute("list", adminService.selectByNum(num));
		return "admin/viewNotice";
	}
	
	@RequestMapping("/writeNotice")
	public String writeNotice(NoticeDTO dto, Model model, Principal principal) {		
		model.addAttribute("category", dto.getCategory());
		model.addAttribute("userEmail", printEmail(principal));
		return "admin/writeNotice";
	}
	
	@RequestMapping("/writeOkNotice")
	public String writeOkNotice(@ModelAttribute("w") @Valid NoticeDTO dto, Model model) {
		model.addAttribute("result", adminService.noticeInsert(dto));
		model.addAttribute("dto", dto);
		return "admin/writeOkNotice";
	}
	
	@RequestMapping("/updateNotice")
	public String updateNotice(int num, Model model) {
		model.addAttribute("list", adminService.selectByNum(num));
		return "admin/updateNotice";
	}
	
	@RequestMapping("/updateOkNotice")
	public String updateOkNotice(@ModelAttribute("w") @Valid NoticeDTO dto, Model model) {
		model.addAttribute("result", adminService.noticeUpdate(dto));
		return "admin/updateOkNotice";
	}
	
	@RequestMapping("/deleteNotice")
	public String deleteNotice(int num, Model model) {
		model.addAttribute("result", adminService.deleteByNum(num));
		return "admin/deleteNotice";
	}
	
	
}
