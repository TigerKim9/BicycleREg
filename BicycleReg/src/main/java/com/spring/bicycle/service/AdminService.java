package com.spring.bicycle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bicycle.domain.NoticeDAO;
import com.spring.bicycle.domain.NoticeDTO;
import com.spring.bicycle.domain.ProjectFundingDAO;
import com.spring.bicycle.domain.ProjectFundingDTO;
import com.spring.bicycle.domain.SellerDAO;
import com.spring.bicycle.domain.UserDAO;
import com.spring.bicycle.domain.UserDTO;


@Service
public class AdminService {

	UserDAO userDao;
	ProjectFundingDAO projDao;
	SellerDAO selDao;
	NoticeDAO noticeDao;

	@Autowired
	public void setDao(UserDAO userDao, ProjectFundingDAO projDao, SellerDAO selDao, NoticeDAO noticeDao) {
		this.userDao = userDao;
		this.projDao = projDao;
		this.selDao = selDao;
		this.noticeDao = noticeDao;
	}

	public AdminService() { }

	public List<UserDTO> userList() {
		return userDao.select();
	}

	public List<UserDTO> list(int from, int pageRows) {
		return userDao.selectFromRow(from, pageRows);
	}

	public int count() {
		return userDao.countAll();
	}

	public int updateUser(UserDTO dto) {
		return userDao.updateUser(dto);
	}

	public int deleteByAiid(int[] aiids) {
		return userDao.deleteByAiid(aiids);
	}

	public List<UserDTO> selectByAiid(int aiid) {
		return userDao.selectByAiid(aiid);
	}

	/* ----- Project ----- */
	public List<ProjectFundingDTO> projList() {
		return projDao.select();
	}

	public List<ProjectFundingDTO> selectByPrnum(int prnum) {
		return projDao.selectByPrnum(prnum);
	}

	public int deleteByPrnum(int prnum) {
		return selDao.deleteByPrnum(prnum);
	}

	public int update(ProjectFundingDTO dto) {
		return selDao.updateProject(dto);
	}

	/* ----- Notice ----- */
	public List<NoticeDTO> selectByNum(int num) {
		return noticeDao.selectByNum(num);
	}

	public int noticeInsert(NoticeDTO dto) {
		return noticeDao.noticeInsert(dto);
	}

	public int noticeUpdate(NoticeDTO dto) {
		return noticeDao.noticeUpdate(dto);
	}

	public int deleteByNum(int num) {
		return noticeDao.deleteByNum(num);
	}

	public List<NoticeDTO> adminNtList() {
		return noticeDao.adminNtList();
	}

}
