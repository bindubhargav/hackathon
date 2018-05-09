package com.test.service;

import org.springframework.data.repository.CrudRepository;

import com.test.dto.DoctorDTO;

public interface DoctorRepositorySQL extends CrudRepository<DoctorDTO, Integer> {
	DoctorDTO findByName(String name);   
}