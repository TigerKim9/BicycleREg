package com.spring.bicycle.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bicycle.domain.Bicycle;
import com.spring.bicycle.service.BicycleService;

@Controller
@RequestMapping("/bicycle")
public class BicycleController {
	
	
	private BicycleService bicycleService;
	

	@GetMapping("/regist")
	public String registBicycle(Bicycle bicycle) {
		System.out.println(SecurityContextHolder.getContext().getAuthentication());
		bicycleService.insertBicycle(bicycle);
		
		return "/registBicycle";
	}
}

