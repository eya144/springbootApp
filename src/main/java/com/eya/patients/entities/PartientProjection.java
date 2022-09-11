package com.eya.patients.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPatient", types = { Patient.class })

public interface PartientProjection {
	public String getNomParfum();

}
