package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ComboTicketConverter;
import com.laptrinhjavaweb.dto.ComboTicketDTO;
import com.laptrinhjavaweb.entity.ComboTicketEntity;
import com.laptrinhjavaweb.repository.ComboTicketRepository;
import com.laptrinhjavaweb.service.IComBoTichketService;
@Service
public class ComboticketService implements IComBoTichketService{
	@Autowired
	private ComboTicketRepository repo;
	
	@Autowired
	private ComboTicketConverter cv;
	
	@Override
	public void deleteComboTicket(ComboTicketDTO comboTicketDTO) {
		
		repo.deleteTicket(comboTicketDTO.getIdTicket());
	}

	@Override
	public List<ComboTicketDTO> getcombotiket() throws Exception {
		List<ComboTicketEntity> lstEntity = repo.findAll();
        List<ComboTicketDTO> lstDTO = new ArrayList<>();
        for (ComboTicketEntity Entity : lstEntity) {
        	ComboTicketDTO dto = cv.toDTO(Entity);
            lstDTO.add(dto);
        }
        return lstDTO;
	}

}
