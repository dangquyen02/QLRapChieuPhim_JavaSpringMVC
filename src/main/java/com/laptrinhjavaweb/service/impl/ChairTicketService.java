package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.ChairTicketDTO;
import com.laptrinhjavaweb.repository.ChairTicketRepository;
import com.laptrinhjavaweb.service.IChairTicketService;
@Service
public class ChairTicketService implements IChairTicketService{

	@Autowired
	private ChairTicketRepository chairTicketRepository;
	@Override
	public void addChairTicket(ChairTicketDTO chairTicketDTO) {
		chairTicketRepository.addTicket(chairTicketDTO.getIdChairTime(), chairTicketDTO.getIdTicket());
		
	}
	@Override
	public void deleteChairTicket(ChairTicketDTO chairTicketDTO) {
	    chairTicketRepository.deleteTicket(chairTicketDTO.getIdTicket());
	}
	
}
