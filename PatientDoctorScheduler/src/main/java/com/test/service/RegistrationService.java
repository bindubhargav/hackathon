package com.test.service;

import org.springframework.stereotype.Service;

import com.test.dto.Patient;

@Service
public interface RegistrationService {
	Patient registerPatient(String name, int age, String phoneNumber, String emailId) throws Exception;
}
