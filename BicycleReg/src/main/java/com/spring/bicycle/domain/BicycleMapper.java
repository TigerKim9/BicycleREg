package com.spring.bicycle.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BicycleMapper {
	
	int registBicycle(Bicycle bicycle);
	
	List<BicycleDTO> bicycleList(String id);
}
