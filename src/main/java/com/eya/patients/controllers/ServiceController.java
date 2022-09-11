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
public class ServiceController {
	  @Autowired
	    ServiceService ServiceService;
	  @Autowired
	    PatientService PatientService;
	 @RequestMapping("/CreateService")
	  public String CreateCat(ModelMap modelMap)
	    {
	  
	    modelMap.addAttribute("Service",new Service());
	    modelMap.addAttribute("mode","new");
	    
	    return "formService";
	    }
	 
	 @RequestMapping("/saveService")
	    public String saveService(Service Service)
	    {
	    ServiceService.saveService(Service);
		return "redirect:/ListeServices";
	    }
	 
	 @RequestMapping("/ListeServices")
	    public String listeServices(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	    	Page<Service> cats = ServiceService.getAllServicesParPage(page, size);
	    	modelMap.addAttribute("Services", cats);
	    	modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
	    	modelMap.addAttribute("currentPage", page);
	    	return "listeService";
	    }
	 
	 
	 @RequestMapping("/supprimerService")
	    public String supprimerPatient(@RequestParam("id") Long id,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	        ServiceService.deleteServiceById(id);
	        Page<Service> cats = ServiceService.getAllServicesParPage(page,size);
	        		modelMap.addAttribute("Services", cats);
	        		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
	        		modelMap.addAttribute("currentPage", page);
	        		modelMap.addAttribute("size", size);
	        		return "listeService";
	    }
	 @RequestMapping("/modifierService")
	    public String editerService(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    Service c= ServiceService.getService(id);
	    modelMap.addAttribute("Service", c);
	    modelMap.addAttribute("mode", "edit");
	    return "formService";
	    }
	 
	 
	 @RequestMapping("/updateService")
	    public String updateService(@ModelAttribute("Service") Service Service,ModelMap modelMap) throws ParseException
	    {

	        ServiceService.updateService(Service);
	        List<Service> cats = ServiceService.getAllServices();
	        modelMap.addAttribute("Services", cats);
	        return "listeService";
	    }
/*	 @RequestMapping("/chercherService")
	
	    public String chercherService(@RequestParam("nomCat") String nom,
	    		ModelMap modelMap)
	    
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List <Patient> prods = PatientService.findByNomServiceContains(nom);
	    	  System.out.println(prods);
	    	  modelMap.addAttribute("Services",prods);
	    	  
	    	  return "chercherCat";
	    } 
	@RequestMapping("/chercherService")
		
	    public String chercherService(@RequestParam("nomCat") String nom,ModelMap modelMap)
	  
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List <Patient> prods = PatientService.findByNomServiceContains(nom);
	    	  System.out.println(prods);
	    	  modelMap.addAttribute("Services",prods);
	    	  
	    	  return "chercherCat";
	    } 
*/


}
