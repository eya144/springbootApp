package com.eya.patients.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eya.patients.entities.Service;
import com.eya.patients.entities.Patient;

public interface PatientService {

	Patient savePatient(Patient p);
	Patient updatePatient(Patient p);
	void deletePatient(Patient p);
	void deletePatientById(Long id);
	Patient getPatient(Long id);
	List<Patient> getAllPatients();
	List<Patient> findByNomPatient(String nom);
	List<Patient> findByNomPatientContains(String nom);
	List<Patient> findByNomPrix (String nom, Double prix);
	List<Patient> findByService (Service Service);
	List<Patient> findByServiceIdCat(Long id);
	List<Patient> findByOrderByNomPatientAsc();
	List<Patient> trierPatientsNomsPrix();
	List<Patient> findByNomServiceContains (String nom);

	
	
	Page<Patient> getAllPatientsParPage(int page, int size);
	
}
