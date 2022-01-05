package com.spring.bicycle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bicycle.domain.AdminMainDAO;
import com.spring.bicycle.domain.SellerMainDTO;


@Service
public class AdminMainService {

	AdminMainDAO dao;

	@Autowired
	public void setDao(AdminMainDAO dao) {
		this.dao = dao;
	}

	public List<SellerMainDTO> admin_category() {
		System.out.println("asdasd");
		return dao.admin_category();
	}

	public List<SellerMainDTO> admin_totalPrice() {
		return dao.admin_totalPrice();
	}

	public List<SellerMainDTO> admin_lastTotalPrice() {
		return dao.admin_lastTotalPrice();
	}

}
