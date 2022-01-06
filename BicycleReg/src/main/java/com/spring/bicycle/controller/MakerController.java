package com.spring.bicycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bicycle.service.MakerService;


@Controller
@RequestMapping("/withus/maker")
public class MakerController {
	
	private MakerService makerService;
	
	@Autowired
	public void setMakerService(MakerService makerService) {
		this.makerService = makerService;
	}

}
