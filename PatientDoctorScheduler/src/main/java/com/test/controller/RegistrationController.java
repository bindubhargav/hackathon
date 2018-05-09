package com.test.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.dto.PatientDetailsRequestDTO;
import com.test.dto.PatientDetailsResponseDTO;
import com.test.dto.Patient;
import com.test.service.PatientRepositorySQL;
import com.test.service.RegistrationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.dto.DoctorDTO;
import com.test.service.DoctorRegistrationService;

@RestController
public class RegistrationController {
	
    @Autowired
    private DoctorRegistrationService doctorRegistrationService;
    private RegistrationService registrationService;

	@RequestMapping(value = "/api/doctor/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerDoctor(HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody DoctorDTO doctorDTO) throws JsonProcessingException 
	{
		if(doctorRegistrationService.addDoctor(doctorDTO)) {
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @RequestMapping(value = "/api/patient/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<PatientDetailsResponseDTO> registerPatient(HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody PatientDetailsRequestDTO requestDTO) throws JsonProcessingException 
	{
		try {
			Patient patient = registrationService.registerPatient(requestDTO.getName(), requestDTO.getAge(), 
					requestDTO.getPhoneNumber(), requestDTO.getEmail());	
			PatientDetailsResponseDTO responseDTO = new PatientDetailsResponseDTO();
			responseDTO.setPatientId(patient.getId());
			responseDTO.setName(patient.getName());			
	        return new ResponseEntity<PatientDetailsResponseDTO>(responseDTO, HttpStatus.OK);
	        
		} catch (Exception e) {			
			return new ResponseEntity<PatientDetailsResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }


}