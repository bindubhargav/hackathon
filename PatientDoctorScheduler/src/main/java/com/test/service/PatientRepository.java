package com.test.service;

import org.springframework.stereotype.Service;

import com.test.dto.Patient;

@Service
public interface PatientRepository {
    Patient addPatient(String name, int age, String phoneNumber, String emailId);
}