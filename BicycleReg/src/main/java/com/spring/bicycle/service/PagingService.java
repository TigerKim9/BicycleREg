package com.spring.bicycle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bicycle.domain.FundedDTO;
import com.spring.bicycle.domain.InquiryDTO;
import com.spring.bicycle.domain.NoticeDTO;
import com.spring.bicycle.domain.PagingDAO;
import com.spring.bicycle.domain.ProjectFundingDTO;



@Service
public class PagingService {
	private PagingDAO pgdao;
	
	@Autowired
	public void setDao(PagingDAO pgdao
			
			) {
		this.pgdao = pgdao;
	}
	
	public PagingService() { }
	
	public int countBoard(String selid) {
		return pgdao.countBoard(selid);
	}

	public List<ProjectFundingDTO> selectBoard(String selid, int start,int cntPage) {
		return pgdao.selectBoard(selid,start,cntPage);
	}

	public int cuserevent(String event) {
		return pgdao.cuserevent(event);
	}

	public int cusernotice(String notice) {
		return pgdao.cusernotice(notice);
	}

	public List<NoticeDTO> userNotice(String notice, int start, int cntPage) {
		return pgdao.userNotice(notice, start, cntPage);
	}

	public List<NoticeDTO> userEvent(String event, int start, int cntPage) {
		return pgdao.userEvent(event, start, cntPage);
	}

	public int countnotice() {
		return pgdao.countnotice();
	}

	public List<NoticeDTO> selectNotice(int start, int cntPage) {
		return pgdao.selectNotice(start, cntPage);
	}

	public int countMfl(int prnum) {
		return pgdao.countMfl(prnum);
	}

	public List<FundedDTO> selectMfl(String useremail, int start, int cntPage) {
		return pgdao.selectMfl(useremail, start, cntPage);
	}

	public int countInquiry(String useremail) {
		return pgdao.countInquiry(useremail);
	}

	public List<InquiryDTO> selectInquiry(String useremail, int start, int cntPage) {
		return pgdao.selectInquiry(useremail, start, cntPage);
	}

	public int adntcount() {
		return pgdao.adntcount();
	}

	public List<NoticeDTO> ntcList(int start, int cntPage) {
		return pgdao.ntcList(start, cntPage);
	}

	public int adAllProj() {
		return pgdao.adAllProj();
	}

	public List<ProjectFundingDTO> adProjList(int start, int cntPage) {
		return pgdao.adProjList(start, cntPage);
	}
	

	
}
