package com.adityax.homeservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adityax.homeservices.dto.ServiceResponse;
import com.adityax.homeservices.entity.ServiceItem;
import com.adityax.homeservices.exception.ResourceNotFoundException;
import com.adityax.homeservices.repository.ServiceRepository;

@Service
public class ServiceCatalogService {

	private final ServiceRepository repository;

	public ServiceCatalogService(ServiceRepository repository) {
		this.repository = repository;
	}
	
	public List<ServiceResponse> getServices(String search){
		List<ServiceItem> items;
		
		if(search == null || search.isBlank()) {
			items = repository.findAll();
		}else {
			items = repository.findByNameContainingIgnoreCase(search.trim());
		}
		
		return items.stream().map(this::toResponse).toList();
	}
	
	public ServiceResponse getService(Long id) {
		
		ServiceItem service = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Service with id " + id + "was not found"));
		
		return toResponse(service);
    }

    public ServiceItem getEntity(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Service with id " + id + " was not found."
                        )
                );
    }

    private ServiceResponse toResponse(ServiceItem service) {

        return new ServiceResponse(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getStartingPrice(),
                service.getRating()
        );
	
    }
}
