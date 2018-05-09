package com.test.service;

import org.springframework.stereotype.Service;

import com.test.dto.DoctorDTO;
import com.test.dto.PatientDTO;

@Service
public interface Repository {
    void addPatient(PatientDTO patient);

	void addDoctor(DoctorDTO doctorDTO);

	PatientDTO getPatient(PatientDTO patient);
}