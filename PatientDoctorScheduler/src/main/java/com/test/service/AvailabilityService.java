package com.test.service;

import org.springframework.stereotype.Service;

import com.test.dto.BookSlotDTO;

@Service
public interface AvailabilityService {
	public boolean bookSlot(BookSlotDTO bookSlotDTO);
}