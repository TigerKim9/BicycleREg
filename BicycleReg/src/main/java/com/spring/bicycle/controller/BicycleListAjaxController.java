//package com.spring.bicycle.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
//import org.apache.tomcat.util.http.parser.Authorization;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.AuthenticatedPrincipal;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.spring.bicycle.domain.BicycleDTO;
//import com.spring.bicycle.service.BicycleService;
//
//import sun.text.normalizer.ICUBinary.Authenticate;
//
//
//@RestController
//@RequestMapping("/**")
//public class BicycleListAjaxController {
//	
//	private static final Logger logger = LoggerFactory.getLogger(BicycleListAjaxController.class);
//	
//	@Autowired
//	BicycleService bicycleservice;
//	
//	@PostMapping("/updateLike")
//	public Map<String, String> updateLike(@RequestBody BicycleDTO dto) throws Exception{
//		
//		
//		Map<String, String> map = new HashMap<String, String>();
//		
//		try {
//			bicycleService.bicycleList(id);
//			map.put("result", "success");
//		} catch (Exception e) {
//			e.printStackTrace();
//			map.put("result", "fail");
//		}
//		
//		return map;
//	}
//}
