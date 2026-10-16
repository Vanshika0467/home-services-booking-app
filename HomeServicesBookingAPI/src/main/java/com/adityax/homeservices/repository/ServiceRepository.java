package com.adityax.homeservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adityax.homeservices.entity.ServiceItem;

public interface ServiceRepository extends JpaRepository<ServiceItem, Long> {

	List<ServiceItem> findByNameContainingIgnoreCase(String search);
}
