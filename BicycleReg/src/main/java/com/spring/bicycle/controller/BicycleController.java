package com.spring.bicycle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bicycle.service.BicycleService;

@Controller
@RequestMapping("/bicycle")
public class BicycleController {
	
	
	private BicycleService bicycleService;
	

}
