package com.adityax.homeservices.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "service_id", nullable = false)
	private ServiceItem service;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 10)
	private String phone;
	
	@Column(nullable = false, length = 500)
	private String address;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(name = "time_slot", nullable = false)
	private LocalTime timeSlot;
	
	@Column(nullable = false, length = 20)
	private String status = "PENDING";
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@PrePersist
	public void onCreate() {
		if(createdAt == null) {
			createdAt = LocalDateTime.now();
		}
		if(status == null) {
			status = "PENDING";
		}
	}
	
	public Booking() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ServiceItem getService() {
		return service;
	}

	public void setService(ServiceItem service) {
		this.service = service;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(LocalTime timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
}
