package com.eya.patients.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eya.patients.entities.Service;


public interface ServiceService {
	List<Service> getAllServices();

	Service saveService(Service Service);
	Page<Service> getAllServicesParPage(int page, int size);
	void deleteServiceById(Long id);
	Service getService(Long id);
	
	Service updateService(Service c);
}