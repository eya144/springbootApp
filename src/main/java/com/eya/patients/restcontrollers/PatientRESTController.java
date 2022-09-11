package com.eya.patients.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eya.patients.entities.Patient;
import com.eya.patients.service.PatientService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientRESTController {
@Autowired
PatientService patientService;
@RequestMapping(method = RequestMethod.GET)
public List<Patient> getAllpatients() {
return patientService.getAllPatients();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Patient getpatientById(@PathVariable("id") Long id) {
return patientService.getPatient(id);
 }
@RequestMapping(method = RequestMethod.POST)
public Patient createpatient(@RequestBody Patient patient) {
return patientService.savePatient(patient);
}
@RequestMapping(method = RequestMethod.PUT)
public Patient updatepatient(@RequestBody Patient patient) {
return patientService.updatePatient(patient);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deletepatient(@PathVariable("id") Long id)
{
	patientService.deletePatientById(id);
}
@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
public List<Patient> getpatientsByCatId(@PathVariable("idCat") Long idCat) {
return patientService.findByServiceIdCat(idCat);
}



}
