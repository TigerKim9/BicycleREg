package com.spring.bicycle.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BicycleDTO {
	
	private String bicycleRegNum;
	
	private String bicycleKinds;
	
	private String bicycleCompany;
		
	private String bicycleAddress;
	
	private String bicycleOwner;

	
}
