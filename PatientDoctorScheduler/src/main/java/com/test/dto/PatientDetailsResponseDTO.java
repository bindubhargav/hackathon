package com.test.dto;

import org.springframework.stereotype.Component;

@Component
public class PatientDetailsResponseDTO {

	private int patientId;
	private String name;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
