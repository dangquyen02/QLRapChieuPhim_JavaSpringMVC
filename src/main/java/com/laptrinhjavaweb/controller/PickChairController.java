package com.laptrinhjavaweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.ChairTicketDTO;
import com.laptrinhjavaweb.dto.ComboTicketDTO;
import com.laptrinhjavaweb.dto.MovieDTO;
import com.laptrinhjavaweb.dto.TicketDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.TicketEntity;
import com.laptrinhjavaweb.service.ITicketService;
@Controller
public class PickChairController {
	@Autowired
	private ITicketService ticketservice;
	@RequestMapping(value = "/chonghe", method = RequestMethod.GET)
	public ModelAndView displayChonGhe(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String idRoom = request.getParameter("idRoom");
		String idMovie = request.getParameter("idMovie");
        String idTimeRoom = request.getParameter("idTimeRoom");
        String suatchieu = request.getParameter("suatchieu");
        String tenphim = request.getParameter("tenphim");
        String ngaychieu = request.getParameter("ngaychieu");
        String phongchieu = request.getParameter("phongchieu");
        
        
        mav.addObject("idRoom", idRoom);
        mav.addObject("idMovie", idMovie);
        mav.addObject("idTimeRoom", idTimeRoom);
        mav.addObject("suatchieu", suatchieu);
        mav.addObject("tenphim", tenphim);
        mav.addObject("ngaychieu", ngaychieu);
        mav.addObject("phongchieu", phongchieu);
	    
	    mav.setViewName("customer/pickchair");
	    
	    return mav;
	}
	
}

