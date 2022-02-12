package com.spring.bicycle.domain;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BicycleMapper {
	
	int registBicycle(Bicycle bicycle);
	

}
