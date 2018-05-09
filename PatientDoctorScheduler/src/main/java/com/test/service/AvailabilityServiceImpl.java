package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.AvailabilityDTO;
import com.test.dto.BookSlotDTO;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
	
	@Autowired
	private Repository repository;

	@Override
	public boolean bookSlot(BookSlotDTO bookSlotDTO) {
		List<AvailabilityDTO> scheduleListforPatient = repository.getAvailabilityByPatientId(bookSlotDTO.getPatientId());
		for(AvailabilityDTO availabilityDTO : scheduleListforPatient) {
			if(availabilityDTO.getStartTime().equalsIgnoreCase(bookSlotDTO.getStartTime())) {
				return false;
			}
		}
		
		List<AvailabilityDTO> scheduleListforDoctor = repository.getAvailabilityByDoctorId(bookSlotDTO.getDoctorId());
		for(AvailabilityDTO availabilityDTO : scheduleListforDoctor) {
			if(availabilityDTO.getStartTime().equalsIgnoreCase(bookSlotDTO.getStartTime())) {
				return false;
			}
		}
		
		AvailabilityDTO availabilityDTO =  new AvailabilityDTO();
		availabilityDTO.setPatientId(bookSlotDTO.getPatientId());
		availabilityDTO.setDoctorId(bookSlotDTO.getDoctorId());
		availabilityDTO.setStartTime(bookSlotDTO.getStartTime());
		
		repository.addAvailability(availabilityDTO);
		return true;
	}

}