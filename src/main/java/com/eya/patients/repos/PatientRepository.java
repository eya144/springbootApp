package com.eya.patients.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eya.patients.entities.Service;
import com.eya.patients.entities.Patient;
@RepositoryRestResource(path = "rest")
public interface PatientRepository extends JpaRepository<Patient, Long> {
	static List<Patient> findByNomPatient(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	List<Patient> findByNomPatientContains(String nom);
	@Query("select p from Patient p where p.nomPatient like %?1 and p.prixConsultation > ?2")
	List<Patient> findByNomPrix (String nom, Double prix);
	
	@Query("select p from Patient p where p.service = ?1")
	
	List<Patient> findByserviceIdCat(Long id);
	List<Patient> findByOrderByNomPatientAsc();
	@Query("select p from Patient p order by p.nomPatient ASC, p.prixConsultation DESC")
	List<Patient> trierPatientsNomsPrix ();
	 @Query("select p from Patient p where p.service.nomSer like ?1")
	 List<Patient> findByNomserviceContains(String nom);
	List<Patient> findByservice(org.springframework.stereotype.Service service);

}