package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.AvailabilityDTO;
import com.test.dto.DoctorDTO;
import com.test.dto.PatientDTO;

@Service
public class RepositoryImpl implements Repository {

	@Autowired
    private PatientRepositorySQL patientRepository;
	
	@Autowired
    private DoctorRepositorySQL doctorRepository;
	
	@Autowired
    private AvailabilityRepositorySQL availabilityRepository;
	
	@Override
	public void addDoctor(DoctorDTO doctorDTO) {
			doctorRepository.save(doctorDTO);
	}
	
	@Override
	public void addPatient(PatientDTO patient) {
		patientRepository.save(patient);
	}
	
	@Override
	public void addAvailability(AvailabilityDTO availabilityDTO) {
		availabilityRepository.save(availabilityDTO);
	}
	
	@Override
	public List<AvailabilityDTO> getAvailabilityByDoctorId(String doctorId) {
		return availabilityRepository.findByDoctorId(doctorId);
	}	
	
	@Override
	public List<AvailabilityDTO> getAvailabilityByPatientId(String patientId) {
		return availabilityRepository.findByPatientId(patientId);
	}	
	
	@Override
	public PatientDTO getPatient(PatientDTO patient) {
		return patientRepository.findByName(patient.getName());
	}
}