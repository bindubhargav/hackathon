package com.test.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.dto.AvailabilityDTO;

public interface AvailabilityRepository extends CrudRepository<AvailabilityDTO, Integer>{
	List<AvailabilityDTO> findByPatientId();
	List<AvailabilityDTO> findByDoctorId();
}
