package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.Patient;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
    private PatientRepository patientRepository;
	
	@Override
	public Patient registerPatient(String name, int age, String phoneNumber,
			String emailId) throws Exception {
		try{
			Patient patient = patientRepository.addPatient(name, age, phoneNumber, emailId);
			return patient;
		}	
		catch(Exception ex){
			System.out.println("Exception occured while registering user: "+ name + "; Exception: " + ex);
			throw ex;
		}
	}

}
