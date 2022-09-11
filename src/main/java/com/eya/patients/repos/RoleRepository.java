package com.eya.patients.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eya.patients.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);
	Optional<Role> findById(Long id);
	
}
