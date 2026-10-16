package com.adityax.homeservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adityax.homeservices.dto.ServiceResponse;
import com.adityax.homeservices.service.ServiceCatalogService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
	
	private final ServiceCatalogService service;
	
	public ServiceController(ServiceCatalogService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<ServiceResponse> getServices(@RequestParam(required = false) String search){
		
		return service.getServices(search);
	}
	
	@GetMapping("/{id}")
	public ServiceResponse getService(@PathVariable Long id) {
		return service.getService(id);
	}

}
