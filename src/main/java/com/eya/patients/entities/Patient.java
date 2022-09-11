package com.eya.patients.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPatient;
	@NotNull
	@Size (min = 4,max = 15)
	@Column(unique=true)
	private String nomPatient;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixConsultation;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date RDV;
	@ManyToOne
private Service service;
	public Service getservice() {
		return service;
	}

	public void setservice(Service service) {
		this.service = service;
	}

	public Patient() {
		super();
	}

	public Patient(String nomPatient, Double prixConsultation, Date RDV,Service cat) {
		super();
		this.nomPatient = nomPatient;
		this.prixConsultation= prixConsultation;
		this.RDV = RDV;
		service=cat;
	}

	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public Double getprixConsultation() {
		return prixConsultation;
	}

	public void setprixConsultation(Double prixConsultation) {
		this.prixConsultation = prixConsultation;
	}

	public Date getRDV() {
		return RDV;
	}

	public void setRDV(Date RDV) {
		this.RDV = RDV;
	}

	@Override
	public String toString() {
		return "Patient [idPatient=" + idPatient + ", nomPatient=" + nomPatient + ", prixConsultation=" + prixConsultation
				+ ", RDV=" + RDV + ", service=" + service + "]";
	}

	
	
	
}