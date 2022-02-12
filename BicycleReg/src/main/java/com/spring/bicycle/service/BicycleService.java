package com.spring.bicycle.service;

import org.springframework.stereotype.Service;

import com.spring.bicycle.domain.Bicycle;
import com.spring.bicycle.domain.BicycleMapper;

@Service
public class BicycleService {
	
	private BicycleMapper mapper;
	
	public int insertBicycle(Bicycle bicycle) {
		return mapper.registBicycle(bicycle);
	}
	

}
