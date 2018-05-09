package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.DoctorDTO;
import com.test.dto.PatientDTO;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
    private Repository repository;
	
	@Autowired
	private DoctorRepositorySQL doctorRepository;
	
	@Override
	public boolean addDoctor(DoctorDTO doctorDTO) {
		try{
			repository.addDoctor(doctorDTO);
			return true;
		}	
		catch(Exception ex){
			System.out.println("Exception occured while registering doctor: "+ doctorDTO.getName() + "; Exception: " + ex);
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
	
	@Override
	public PatientDTO registerPatient(PatientDTO patient) throws Exception {
		try{
			repository.addPatient(patient);
			PatientDTO registeredPatient = repository.getPatient(patient);
			return registeredPatient;
		}	
		catch(Exception ex){
			System.out.println("Exception occured while registering patient: "+ patient.getName() + "; Exception: " + ex);
			throw ex;
		}
	}

}
