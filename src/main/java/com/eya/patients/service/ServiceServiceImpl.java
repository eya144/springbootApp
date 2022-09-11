package com.eya.patients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.eya.patients.repos.ServiceRepository;


@Service
public  class ServiceServiceImpl implements ServiceService {
	@Autowired
	ServiceRepository serviceRepository;
	

	@Override
	public List<com.eya.patients.entities.Service> getAllServices() {
		return serviceRepository.findAll();
	}
	@Override
	public com.eya.patients.entities.Service saveService(com.eya.patients.entities.Service Service) {
		return serviceRepository.save(Service);
	}
	@Override
	public Page<com.eya.patients.entities.Service> getAllServicesParPage(int page, int size) {
		 return serviceRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public void deleteServiceById(Long id) {
		 serviceRepository.deleteById(id);
		
	}
	@Override
	public com.eya.patients.entities.Service getService(Long id) {
		 return serviceRepository.findById(id).get();
	}
	@Override
	public com.eya.patients.entities.Service updateService(com.eya.patients.entities.Service c) {
		return serviceRepository.save(c);
	}


}