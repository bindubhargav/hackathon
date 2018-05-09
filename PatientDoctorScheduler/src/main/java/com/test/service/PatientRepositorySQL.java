package com.test.service;

import org.springframework.data.repository.CrudRepository;

import com.test.dto.Patient;
public interface PatientRepositorySQL extends CrudRepository<Patient, Integer> {
    Patient findByName(String name);
}