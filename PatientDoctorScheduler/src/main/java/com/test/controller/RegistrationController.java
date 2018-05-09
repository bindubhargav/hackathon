package com.test.controller;

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
import com.test.service.DoctorRegistrationService;

@RestController
public class RegistrationController {
	
    @Autowired
    private DoctorRegistrationService doctorRegistrationService;

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

}