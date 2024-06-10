package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ChairTicketDTO;

public interface IChairTicketService {
	void addChairTicket(ChairTicketDTO chairTicketDTO);
	void deleteChairTicket(ChairTicketDTO chairTicketDTO);
}
