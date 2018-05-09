package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.Patient;

@Service
public class PatientRepositoryImpl implements PatientRepository {

	@Autowired
    private PatientRepositorySQL patientRepository;
	
	@Override
	public Patient addPatient(String name, int age, String phoneNumber,
			String emailId) {
		Patient patient = new Patient(name, age, phoneNumber, emailId);
		patientRepository.save(patient);
		System.out.println("PatientId: "+patient.getId());
		return patient;
	}
}