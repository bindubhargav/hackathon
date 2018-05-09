package com.test.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.dto.PatientDetailsResponseDTO;
import com.test.dto.PatientDTO;
import com.test.service.RegistrationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.dto.DoctorDTO;

@RestController
public class RegistrationController {
	
    @Autowired
    private RegistrationService registrationService;

	@RequestMapping(value = "/api/doctor/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerDoctor(HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody DoctorDTO doctorDTO) throws JsonProcessingException 
	{
		if(registrationService.addDoctor(doctorDTO)) {
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @RequestMapping(value = "/api/patient/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<PatientDetailsResponseDTO> registerPatient(HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody PatientDTO patientDTO) throws JsonProcessingException 
	{
		try {
			PatientDTO patient = registrationService.registerPatient(patientDTO);	
			PatientDetailsResponseDTO responseDTO = new PatientDetailsResponseDTO();
			responseDTO.setPatientId(patient.getId());
			responseDTO.setName(patient.getName());			
	        return new ResponseEntity<PatientDetailsResponseDTO>(responseDTO, HttpStatus.OK);
	        
		} catch (Exception e) {			
			return new ResponseEntity<PatientDetailsResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }


}