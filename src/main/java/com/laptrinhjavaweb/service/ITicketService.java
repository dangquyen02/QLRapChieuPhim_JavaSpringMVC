package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.ChairTicketDTO;
import com.laptrinhjavaweb.dto.ComboTicketDTO;
import com.laptrinhjavaweb.dto.TicketDTO;

public interface ITicketService {
	void addTicket(TicketDTO ticketDTO);
    void addTicketToChair(ChairTicketDTO chairTicketDTO);
    void addTicketToCombo(ComboTicketDTO comboTicketDTO);
    int getLastInsertedTicketId();
    void xacnhanvethanhcong(TicketDTO ticketDTO);
    void xacnhanvethatbai(TicketDTO ticketDTO);
    void xacnhanhuyve(TicketDTO ticketDTO);
    void huyve(TicketDTO ticketDTO);
    void huygiaodich(TicketDTO ticketDTO);

    
    
//	void addTicket(TicketDTO ticketDTO);
//    void addTicketToChair(ChairTicketDTO chairTicketDTO);
//    void addTicketToCombo(ComboTicketDTO comboTicketDTO);
//    int getLastInsertedTicketId();
//    void xacnhanve(TicketDTO ticketDTO);
//    
//    TicketDTO findOneById(int idTicked);
//    List<TicketDTO> getTicket(int idUser) throws Exception;
//    
//    List<TicketDTO> getAllTicket() throws Exception;
////	List<TicketDTO> getTicketByName(String search) throws Exception;
//	List<TicketDTO> getTicketByIdUser(int idUser) throws Exception;
//	List<TicketDTO> getTicketsByIdUser(int[] idUser) throws Exception;
}
