package com.eya.patients.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eya.patients.entities.Service;


@RepositoryRestResource(path = "rest")
public interface ServiceRepository extends JpaRepository<Service, Long> {

	
}
