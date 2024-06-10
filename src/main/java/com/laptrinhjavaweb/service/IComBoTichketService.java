package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.ComboTicketDTO;

public interface IComBoTichketService {
	void deleteComboTicket(ComboTicketDTO comboTicketDTO);
	
	//lấy danh sách comboticket
		List<ComboTicketDTO> getcombotiket() throws Exception;
}
