package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.TicketConverter;
import com.laptrinhjavaweb.dto.ChairTicketDTO;
import com.laptrinhjavaweb.dto.ComboTicketDTO;
import com.laptrinhjavaweb.dto.TicketDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.TicketEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.TicketRepository;
import com.laptrinhjavaweb.service.ITicketService;
@Service
public class TicketServive implements ITicketService{
	@Autowired
    private TicketRepository ticketRepository;

	@Override
	public void addTicket(TicketDTO ticketDTO) {
		ticketRepository.addTicket(ticketDTO.getTicketCode(),ticketDTO.getIdMovie(),ticketDTO.getIdUser());	
	}

	@Override
	public void addTicketToChair(ChairTicketDTO chairTicketDTO) {
		ticketRepository.addTicketToChair(chairTicketDTO.getIdChairTime(), chairTicketDTO.getIdTicket());
	}

	@Override
	public void addTicketToCombo(ComboTicketDTO comboTicketDTO) {
		ticketRepository.addTicketToCombo(comboTicketDTO.getIdCombo(), comboTicketDTO.getIdTicket(), comboTicketDTO.getQuantity(), comboTicketDTO.getSumPrice());	
	}

	@Override
	public int getLastInsertedTicketId() {	
		return ticketRepository.findLastInsertedTicket();
	}

	@Override
	public void xacnhanvethanhcong(TicketDTO ticketDTO) {
		ticketRepository.updateTicketSuccess( ticketDTO.getTicketCode(),ticketDTO.getTotalAmount(), ticketDTO.getId_Ticket());	
	}
	
	@Override
	public void xacnhanvethatbai(TicketDTO ticketDTO) {
		ticketRepository.updateTicketFail(ticketDTO.getTicketCode(),ticketDTO.getTotalAmount(), ticketDTO.getId_Ticket());	
	}
	
	@Override
	public void xacnhanhuyve(TicketDTO ticketDTO) {
		ticketRepository.updateTicketExit(ticketDTO.getTotalAmount(), ticketDTO.getId_Ticket());
	}
	
	@Override
	public void huyve(TicketDTO ticketDTO) {
		ticketRepository.deleteTicket(ticketDTO.getId_Ticket());
	}

	@Override
	public void huygiaodich(TicketDTO ticketDTO) {
		ticketRepository.updateTransactionfailed(ticketDTO.getTotalAmount(), ticketDTO.getId_Ticket());
	}
}



//@Override
//public void addTicket(TicketDTO ticketDTO) {
//	ticketRepository.addTicket(ticketDTO.getTicketCode(),ticketDTO.getIdMovie(),ticketDTO.getIdUser());
//	
//}
//
//@Override
//public void addTicketToChair(ChairTicketDTO chairTicketDTO) {
//	
//	
//	ticketRepository.addTicketToChair(chairTicketDTO.getIdChairTime(), chairTicketDTO.getIdTicket());
//}
//
//@Override
//public void addTicketToCombo(ComboTicketDTO comboTicketDTO) {
//	ticketRepository.addTicketToCombo(comboTicketDTO.getIdCombo(), comboTicketDTO.getIdTicket(), comboTicketDTO.getQuantity(), comboTicketDTO.getSumPrice());
//	
//}
//
//@Override
//public int getLastInsertedTicketId() {
//	
//	return ticketRepository.findLastInsertedTicket();
//}
//
//@Override
//public void xacnhanve(TicketDTO ticketDTO) {
//	ticketRepository.updateTicket(ticketDTO.getTotalAmount(), ticketDTO.getId_Ticket());
//	
//}
//
//@Override
//public TicketDTO findOneById(int idTicked) {
//	TicketDTO dto = new TicketDTO();
//	dto = ticketConverter.toDTO(ticketRepository.findOne(idTicked));
//	return dto;
//}
//
//@Override
//public List<TicketDTO> getTicket(int idUser) throws Exception {
//	List<TicketEntity> lstTicketEntity = ticketRepository.findAll();
//    List<TicketDTO> lstTicketDTO = new ArrayList<>();
//    for (TicketEntity ticketEntity : lstTicketEntity) {
//        TicketDTO dto = ticketConverter.toDTO(ticketEntity);
//        lstTicketDTO.add(dto);
//	
//    }
//    return lstTicketDTO;
//}
//
//@Override
//public List<TicketDTO> getAllTicket() throws Exception {
//	List<TicketEntity> entity = ticketRepository.findAll();
//	List<TicketDTO> lstTicketDTO = new ArrayList<>();
//	for (TicketEntity ticketEntity : entity) {
//		TicketDTO dto = new TicketDTO();
//		dto = ticketConverter.toDTO(ticketEntity);
//		lstTicketDTO.add(dto);
//	}
//	return lstTicketDTO;
//}
//
//@Override
//public List<TicketDTO> getTicketByIdUser(int idUser) throws Exception {
//	List<TicketEntity> lstTicketEntity = ticketRepository.findByIdUser(idUser);
//    List<TicketDTO> lstTicketDTO = new ArrayList<>();
//    for (TicketEntity ticketEntity : lstTicketEntity) {
//        TicketDTO dto = ticketConverter.toDTO(ticketEntity);
//        lstTicketDTO.add(dto);
//    }
//    return lstTicketDTO;
//}
//
//@Override
//public List<TicketDTO> getTicketsByIdUser(int[] idUser) throws Exception {
//	List<TicketDTO> listDTO = new ArrayList<TicketDTO>();
//	for(int id : idUser) {
//		List<TicketDTO> lst2 = getTicketByIdUser(id);
//		for(TicketDTO dto : lst2) {
//			listDTO.add(dto);
//		}
//	}
//	return listDTO;
//}
//
//

