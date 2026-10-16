package com.adityax.homeservices.dto;

import java.math.BigDecimal;

public record ServiceResponse(Long id,String name,String description,BigDecimal 
		startingPrice,Double rating
		) {
	
}
