package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.AvailabilityDTO;
import com.test.dto.BookSlotDTO;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
	
	@Autowired
	private AvailabilityRepository availabilityRepository;

	@Override
	public boolean bookSlot(BookSlotDTO bookSlotDTO) {
		List<AvailabilityDTO> scheduleListforPatient = availabilityRepository.findByPatientId();
		for(AvailabilityDTO availabilityDTO : scheduleListforPatient) {
			if(availabilityDTO.getStartTime().equalsIgnoreCase(bookSlotDTO.getStartTime())) {
				return false;
			}
		}
		
		List<AvailabilityDTO> scheduleListforDoctor = availabilityRepository.findByDoctorId();
		for(AvailabilityDTO availabilityDTO : scheduleListforDoctor) {
			if(availabilityDTO.getStartTime().equalsIgnoreCase(bookSlotDTO.getStartTime())) {
				return false;
			}
		}
		
		AvailabilityDTO availabilityDTO =  new AvailabilityDTO();
		availabilityDTO.setPatientId(bookSlotDTO.getPatientId());
		availabilityDTO.setDoctorId(bookSlotDTO.getDoctorId());
		availabilityDTO.setStartTime(bookSlotDTO.getStartTime());
		
		availabilityRepository.save(availabilityDTO);
		return true;
	}

}
