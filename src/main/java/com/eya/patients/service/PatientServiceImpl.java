package com.eya.patients.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eya.patients.repos.PatientRepository;
import com.eya.patients.entities.Patient;


@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	public Patient savePatient(Patient p) {
		return patientRepository.save(p);
	}

	public Patient updatePatient(Patient p) {
		return patientRepository.save(p);
	}

	public void deletepatient(Patient p) {
		patientRepository.delete(p);
	}

	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);
	}

	@Override
	public Patient getPatient(Long id) {
		return patientRepository.findById(id).get();
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	
	@Override
	public Page<Patient> getAllPatientsParPage(int page, int size) {
	return patientRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Patient> findByNomPatient(String nom) {
		// TODO Auto-generated method stub
		return PatientRepository.findByNomPatient(nom);
	}

	public List<Patient> findByNomPatientContains(String nom) {
		// TODO Auto-generated method stub
		return  PatientRepository.findByNomPatient(nom);
	}

	public List<Patient> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return patientRepository.findByNomPrix(nom, prix);

	}
	public List<Patient> findByService(Service service) {
		// TODO Auto-generated method stub
		return  patientRepository.findByservice(service);
	}

	public List<Patient> findByServiceIdCat(Long id) {
		// TODO Auto-generated method stub
		return patientRepository.findByserviceIdCat(id);

	}

	public List<Patient> findByOrderByNompatientAsc() {
		// TODO Auto-generated method stub
		return patientRepository.findByOrderByNomPatientAsc();

	}

	public List<Patient> trierpatientsNomsPrix() {
		// TODO Auto-generated method stub
		return patientRepository.trierPatientsNomsPrix();
	}
	public List<Patient> findByNomServiceContains(String Service) {
		
		return patientRepository.findByNomserviceContains(Service);
	}

	@Override
	public void deletePatient(Patient p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> findByService(com.eya.patients.entities.Service Service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> findByOrderByNomPatientAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> trierPatientsNomsPrix() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
