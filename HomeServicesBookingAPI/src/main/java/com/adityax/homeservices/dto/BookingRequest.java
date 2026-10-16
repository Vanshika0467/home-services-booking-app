package com.adityax.homeservices.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookingRequest(
		
		@NotNull(message = "serviceId is required")
		@Positive(message = "serviceId must be positive")
		Long serviceId,
		
		@NotBlank(message = "name cannot be empty")
		@Size(max = 100, message = "name must be at most 100 characters")
		String name,
		
		@NotBlank(message = "phone cannot be empty")
		@Pattern(regexp = "^[0-9]{10}$", message = "phone must be exactly 10 digits")
		String phone,
		
		@NotBlank(message = "address cannot be empty")
		@Size(max = 500, message = "address must be most 500 characters")
		String address,
		
		@NotNull(message = "date is required")
		@FutureOrPresent(message = "date cannot be in the past")
		LocalDate date,
		
		@NotNull(message = "timeSlot is required")
		LocalTime timeSlot
		) {

}
