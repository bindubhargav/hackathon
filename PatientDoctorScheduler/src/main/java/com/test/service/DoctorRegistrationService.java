package com.test.service;

import org.springframework.stereotype.Service;

import com.test.dto.DoctorDTO;

@Service
public interface DoctorRegistrationService {

	public boolean addDoctor(DoctorDTO doctorDTO);
	public Iterable<DoctorDTO> listDoctors();
}
