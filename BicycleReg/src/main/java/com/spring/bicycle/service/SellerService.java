package com.spring.bicycle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bicycle.domain.ProjectFundingDAO;
import com.spring.bicycle.domain.ProjectFundingDTO;
import com.spring.bicycle.domain.SellerDAO;
import com.spring.bicycle.domain.SellerDTO;

@Service
public class SellerService {

	SellerDAO dao;
	ProjectFundingDAO projDao;

	@Autowired
	public void setDao(SellerDAO dao, ProjectFundingDAO projDao) {
		this.dao = dao;
		this.projDao = projDao;
	}
	
	public SellerService() {}
	
	public int regSeller(SellerDTO seller) {
		return dao.regSeller(seller);
	}
	
	public String existEmail(String useremail) {
		return dao.existEmail(useremail);
	}
	
	public Integer cntMyProj(String selid) {
		return dao.cntMyProj(selid);
	}
	
	public List<ProjectFundingDTO> myProjList(String selid) {
		return dao.myProjList(selid);
	}
	
	public List<ProjectFundingDTO> viewMyProj(int prnum) {
		return projDao.selectByPrnum(prnum);
	}
	
	public Integer write_project(ProjectFundingDTO dto) {
		return dao.write_project(dto);
	}
	
	public int updateProject(ProjectFundingDTO dto) {
		return dao.updateProject(dto);
	}
	
	public int deleteByPrnum(int prnum) {
		return dao.deleteByPrnum(prnum);
	}
}
