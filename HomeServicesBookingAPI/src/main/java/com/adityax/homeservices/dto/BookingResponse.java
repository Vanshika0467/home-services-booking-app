package com.adityax.homeservices.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record BookingResponse(
		Long id,
		Long serviceId,
		String serviceName,
		String name,
		String phone,
		String address,
		LocalDate date,
		LocalTime timeSlot,
		String status,
		LocalDateTime createdAt		
		) {

}
