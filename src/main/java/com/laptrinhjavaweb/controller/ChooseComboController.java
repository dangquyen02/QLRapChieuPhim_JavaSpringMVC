package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptrinhjavaweb.dto.ChairTicketDTO;
import com.laptrinhjavaweb.dto.ComboDTO;
import com.laptrinhjavaweb.dto.ComboTicketDTO;
import com.laptrinhjavaweb.dto.TicketDTO;
import com.laptrinhjavaweb.entity.ComboEntity;
import com.laptrinhjavaweb.service.IComboService;
import com.laptrinhjavaweb.service.ITicketService;
import com.laptrinhjavaweb.service.impl.ComboService;

@Controller
public class ChooseComboController {

	@Autowired
	private IComboService comboService;
	@Autowired
	private ITicketService ticketService;

	@RequestMapping(value = "/choncombo", method = RequestMethod.POST)
	public String chonCombo(HttpServletRequest request,RedirectAttributes redirectAttributes) {
		
		try {
			// Lấy các giá trị từ request
			String id = request.getParameter("id");
			String hoten = request.getParameter("hoten");
			String email = request.getParameter("email");
			String sdt = request.getParameter("sdt");
			String idRoom = request.getParameter("idRoom");
			String idMovie = request.getParameter("idMovie");
			String idTimeRoom = request.getParameter("idTimeRoom");
			String suatchieu = request.getParameter("suatchieu");
			String tenphim = request.getParameter("tenphim");
			String ngaychieu = request.getParameter("ngaychieu");
			String phongchieu = request.getParameter("phongchieu");
			String idChair = request.getParameter("idChair");
			String chairCode = request.getParameter("chairCode");
			String chairQuantity = request.getParameter("chairQuantity");
			String chairPrice = request.getParameter("chairPrice"); // Cần cập nhật sau

			TicketDTO ticketDTO = new TicketDTO();
			ticketDTO.setIdUser(Integer.parseInt(id));
			ticketDTO.setIdMovie(Integer.parseInt(idMovie));
			ticketDTO.setTicketCode("11111"); // Cần thay bằng mã vé tạo tự động
			ticketService.addTicket(ticketDTO);
			
			int ticketId = ticketService.getLastInsertedTicketId();
			
			ChairTicketDTO chairTicketDTO = new ChairTicketDTO();
			chairTicketDTO.setIdChairTime(41);
			chairTicketDTO.setIdTicket(ticketId);
			ticketService.addTicketToChair(chairTicketDTO);
			// Chuyển các giá trị bằng RedirectAttributes
			
	        redirectAttributes.addAttribute("id", id);
	        redirectAttributes.addAttribute("hoten", hoten);
	        redirectAttributes.addAttribute("email", email);
	        redirectAttributes.addAttribute("sdt", sdt);
	        redirectAttributes.addAttribute("idRoom", idRoom);
	        redirectAttributes.addAttribute("idMovie", idMovie);
	        redirectAttributes.addAttribute("idTimeRoom", idTimeRoom);
	        redirectAttributes.addAttribute("suatchieu", suatchieu);
	        redirectAttributes.addAttribute("tenphim", tenphim);
	        redirectAttributes.addAttribute("ngaychieu", ngaychieu);
	        redirectAttributes.addAttribute("phongchieu", phongchieu);
	        redirectAttributes.addAttribute("idChair", idChair);
	        redirectAttributes.addAttribute("chairCode", chairCode);
	        redirectAttributes.addAttribute("chairQuantity", chairQuantity);
	        redirectAttributes.addAttribute("chairPrice", chairPrice);
			return "redirect:/hienthicombo";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
	}
	@RequestMapping(value = "/hienthicombo", method = RequestMethod.GET)
	public ModelAndView HienThiCombo(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("customer/chooseCombo");
		try {
			List<ComboDTO> listcombo = comboService.getcombo();

			// Lấy các giá trị từ request
			String id = request.getParameter("id");
			String hoten = request.getParameter("hoten");
			String email = request.getParameter("email");
			String sdt = request.getParameter("sdt");
			String idRoom = request.getParameter("idRoom");
			String idMovie = request.getParameter("idMovie");
			String idTimeRoom = request.getParameter("idTimeRoom");
			String suatchieu = request.getParameter("suatchieu");
			String tenphim = request.getParameter("tenphim");
			String ngaychieu = request.getParameter("ngaychieu");
			String phongchieu = request.getParameter("phongchieu");
			String idChair = request.getParameter("idChair");
			String chairCode = request.getParameter("chairCode");
			String chairQuantity = request.getParameter("chairQuantity");
			String chairPrice = request.getParameter("chairPrice"); // Cần cập nhật sau

			mav.addObject("id", id);
			mav.addObject("hoten", hoten);
			mav.addObject("email", email);
			mav.addObject("sdt", sdt);
			mav.addObject("idRoom", idRoom);
			mav.addObject("idMovie", idMovie);
			mav.addObject("idTimeRoom", idTimeRoom);
			mav.addObject("suatchieu", suatchieu);
			mav.addObject("tenphim", tenphim);
			mav.addObject("ngaychieu", ngaychieu);
			mav.addObject("phongchieu", phongchieu);
			mav.addObject("idChair", idChair);
			mav.addObject("chairCode", chairCode);
			mav.addObject("chairQuantity", chairQuantity);
			mav.addObject("chairPrice", chairPrice);
			mav.addObject("lstcombo", listcombo);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			return mav;
		}
	}
}