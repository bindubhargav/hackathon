package com.test.service;

import org.springframework.data.repository.CrudRepository;

import com.test.dto.PatientDTO;
public interface PatientRepositorySQL extends CrudRepository<PatientDTO, Integer> {
    PatientDTO findByName(String name);
}