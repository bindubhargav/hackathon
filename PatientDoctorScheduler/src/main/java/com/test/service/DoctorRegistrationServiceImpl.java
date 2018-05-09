package com.test.service;

import com.test.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorRegistrationServiceImpl implements DoctorRegistrationService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public boolean addDoctor(DoctorDTO doctorDTO) {
		try {
			doctorRepository.save(doctorDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Iterable<DoctorDTO> listDoctors() {
		try {
			Iterable<DoctorDTO> doctorDTO = doctorRepository.findAll();
			return doctorDTO; 
		} catch (Exception e) {
			return null;
		}
	}
}
