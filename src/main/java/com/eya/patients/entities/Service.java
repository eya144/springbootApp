package com.eya.patients.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Service {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idSer;
@NotNull
@Size (min = 4,max = 50)
@Column(unique=true)
private String nomSer;
private String docteur;
@JsonIgnore
@OneToMany(mappedBy = "Service")
private List<Patient> Patients;
public Service() {}
public Service(String nomSer, String docteur, List<Patient> Patients)
{

super();
this.nomSer = nomSer;
this.docteur = docteur;
this.Patients = Patients;
}
public Long getidSer() {
return idSer;
}
public void setidSer(Long idSer) {
this.idSer = idSer;
}
public String getnomSer() {
return nomSer;
}
public void setnomSer(String nomSer) {
this.nomSer = nomSer;
}
public String getdocteur() {
return docteur;
}
public void setdocteur(String docteur) {
this.docteur = docteur;
}
public List<Patient> getProduits() {
return Patients;
}
public void setProduits(List<Patient> Patients) {
this.Patients = Patients;
}
}
