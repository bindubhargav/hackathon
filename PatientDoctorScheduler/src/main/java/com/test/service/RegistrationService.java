package com.test.service;

import org.springframework.stereotype.Service;

import com.test.dto.DoctorDTO;
import com.test.dto.PatientDTO;

@Service
public interface RegistrationService {
	boolean addDoctor(DoctorDTO doctorDTO);
	Iterable<DoctorDTO> listDoctors();
	PatientDTO registerPatient(PatientDTO patient) throws Exception;
}
