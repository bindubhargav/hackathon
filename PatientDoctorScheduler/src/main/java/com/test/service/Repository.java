package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.dto.AvailabilityDTO;
import com.test.dto.DoctorDTO;
import com.test.dto.PatientDTO;

@Service
public interface Repository {
    void addPatient(PatientDTO patient);

	void addDoctor(DoctorDTO doctorDTO);

	PatientDTO getPatient(PatientDTO patient);

	void addAvailability(AvailabilityDTO availabilityDTO);

	List<AvailabilityDTO> getAvailabilityByDoctorId(String doctorId);

	List<AvailabilityDTO> getAvailabilityByPatientId(String patientId);
}