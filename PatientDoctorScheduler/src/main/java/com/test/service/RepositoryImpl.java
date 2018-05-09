package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.DoctorDTO;
import com.test.dto.PatientDTO;

@Service
public class RepositoryImpl implements Repository {

	@Autowired
    private PatientRepositorySQL patientRepository;
	
	@Autowired
    private DoctorRepositorySQL doctorRepository;
	
	@Override
	public void addDoctor(DoctorDTO doctorDTO) {
			doctorRepository.save(doctorDTO);
	}
	
	@Override
	public void addPatient(PatientDTO patient) {
		patientRepository.save(patient);
	}
	
	@Override
	public PatientDTO getPatient(PatientDTO patient) {
		return patientRepository.findByName(patient.getName());
	}
}