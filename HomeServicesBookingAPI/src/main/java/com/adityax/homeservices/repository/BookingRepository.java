package com.adityax.homeservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adityax.homeservices.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	List<Booking> findAllByOrderByCreatedAtDesc();

}
