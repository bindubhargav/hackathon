package com.test.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.dto.AvailabilityDTO;

public interface AvailabilityRepositorySQL extends CrudRepository<AvailabilityDTO, Integer>{
	List<AvailabilityDTO> findByPatientId(String patientId);
	List<AvailabilityDTO> findByDoctorId(String doctorId);
}