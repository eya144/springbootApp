package com.eya.patients.service;

import java.util.List;

import com.eya.patients.entities.Role;

public interface RoleService {
	List <Role> findAll();
	Role findByRole(String role);



}
