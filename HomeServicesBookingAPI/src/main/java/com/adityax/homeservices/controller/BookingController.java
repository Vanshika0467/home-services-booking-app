package com.adityax.homeservices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adityax.homeservices.dto.BookingRequest;
import com.adityax.homeservices.dto.BookingResponse;
import com.adityax.homeservices.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	private final BookingService service;
	
	public BookingController(BookingService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookingResponse createBooking(@Valid @RequestBody BookingRequest request) {
		
		return service.create(request);
	}
	
	@GetMapping
	public List<BookingResponse> getBookings(){
		
		return service.getAll();
	}
	
	@PutMapping("/{id}")
	public BookingResponse updateBooking(
	        @PathVariable Long id,
	        @Valid @RequestBody BookingRequest request) {

	    return service.updateBooking(id, request);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBooking(@PathVariable Long id) {
	    service.deleteBooking(id);
	}
	
	@PatchMapping("/{id}/status")
	public BookingResponse updateBookingStatus(
	        @PathVariable Long id,
	        @RequestParam String status) {

	    return service.updateBookingStatus(id, status);
	}
}
