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
import com.test.service.RegistrationService;

@RestController
public class AppointmentSchedulerController {
	
    @Autowired
    private RegistrationService registrationService;

	@RequestMapping(value = "/api/doctor/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<DoctorDTO>> registerDoctor()
	{
		Iterable doctorsList = registrationService.listDoctors();
		if(doctorsList != null)
			return new ResponseEntity<Iterable<DoctorDTO>>(doctorsList, HttpStatus.OK);
		return new ResponseEntity<Iterable<DoctorDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}