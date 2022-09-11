package com.eya.patients.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eya.patients.entities.Service;
import com.eya.patients.entities.Patient;
import com.eya.patients.service.ServiceService;
import com.eya.patients.service.PatientService;


@Controller
public class PatientController {
	@Autowired
	PatientService PatientService;
	@Autowired
	ServiceService ServiceService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("Patient", new Patient());
	modelMap.addAttribute("mode", "new");
	List<Service> Service = ServiceService.getAllServices();

	modelMap.addAttribute("Services", Service);
	return "formPatient";
	}
	@RequestMapping("/savePatient")
	public String savePatient(@Valid Patient Patient,BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formPatient";
	
	PatientService.savePatient(Patient);
	return "redirect:/ListePatients";
	}
	@RequestMapping("/ListePatients")
	public String listePatients(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<Patient> prods = PatientService.getAllPatientsParPage(page, size);
	modelMap.addAttribute("Patients", prods);

	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	List<Service> cats = ServiceService.getAllServices();
	modelMap.addAttribute("Services", cats);

	modelMap.addAttribute("currentPage", page);
	
	
	
	return "listePatients";
	}
	
	@RequestMapping("/supprimerPatient")
	public String supprimerPatient(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	PatientService.deletePatientById(id);
	Page<Patient> prods = PatientService.getAllPatientsParPage(page,

	size);

	modelMap.addAttribute("Patients", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	List<Service> cats = ServiceService.getAllServices();
	modelMap.addAttribute("Services", cats);
	return "listePatients";
	}
	
	@RequestMapping("/modifierPatient")
	public String editerPatient(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Patient p= PatientService.getPatient(id);
		modelMap.addAttribute("Patient", p);
		modelMap.addAttribute("mode", "edit");
		
		List<Service> cats = ServiceService.getAllServices();

		modelMap.addAttribute("Services", cats);
		return "formPatient";
	}
	@RequestMapping("/updatePatient")
	public String updatePatient(@ModelAttribute("Patient") Patient Patient,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException

{
//conversion de la date

SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateCreation = dateformat.parse(String.valueOf(date));
Patient.setRDV(dateCreation);
PatientService.updatePatient(Patient);
List<Patient> prods = PatientService.getAllPatients();
modelMap.addAttribute("Patients", prods);
List<Service> cats = ServiceService.getAllServices();
modelMap.addAttribute("Services", cats);
return "listePatients";

}
	 @RequestMapping("/chercherNom")
	    public String chercherPatient(@RequestParam("nomParf") String nom,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    
	    
	    {     
		 	
	    	  List <Patient> prods = PatientService.findByNomPatientContains(nom);
	    	  
	    	  modelMap.addAttribute("Patients",prods);
	    	  List<Service> cats = ServiceService.getAllServices();
	    		modelMap.addAttribute("Services", cats);
	    	  /*Page<Patient> prod = PatientService.getAllPatientsParPage(page, size);
	    		modelMap.addAttribute("Patients", prod);

	    		modelMap.addAttribute("pages", new int[prod.getTotalPages()]);

	    		modelMap.addAttribute("currentPage", page);*/
	    	  return "resultat";
	    }  
	
	 @RequestMapping("/chercherCat")
	  public String chercherCat(@RequestParam("idSer") int idCat,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {     
		 	
	    	  List <Patient> Patients = PatientService.getAllPatients();
	    	  Patients = Patients.stream()
	                  .filter(x -> x.getservice().getidSer() == idCat)
	                  .collect(Collectors.toList());
	    	  modelMap.addAttribute("Patients",Patients);
	    	  List<Service> cats = ServiceService.getAllServices();
	    		modelMap.addAttribute("Services", cats);
	    		modelMap.addAttribute("currentPage", page);
	    	  
	    	  return "listePatients";
	    }  
	    
		  
}