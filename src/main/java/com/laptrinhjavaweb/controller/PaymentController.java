package com.laptrinhjavaweb.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptrinhjavaweb.config.VNPayConfig;
import com.laptrinhjavaweb.dto.ChairTicketDTO;
import com.laptrinhjavaweb.dto.ComboTicketDTO;
import com.laptrinhjavaweb.dto.PaymentDTO;
import com.laptrinhjavaweb.dto.TicketDTO;
import com.laptrinhjavaweb.service.IChairTicketService;
import com.laptrinhjavaweb.service.IChairTimeService;
import com.laptrinhjavaweb.service.IComBoTichketService;
import com.laptrinhjavaweb.service.ITicketService;
import com.laptrinhjavaweb.service.impl.VNPayService;
import com.opensymphony.module.sitemesh.Config;

@Controller
public class PaymentController {

	@Autowired
    private ITicketService ticketService;
	
	@Autowired
    private VNPayService vnPayService;
	
	@Autowired
	private IChairTicketService chairticketService;
	@Autowired
	private IComBoTichketService comboticketService;
	@Autowired
	private IChairTimeService chairtimeService;
	

	@RequestMapping(value = "/submitOrder", method = RequestMethod.GET)
	public ModelAndView submitOrder(HttpSession session,
	        HttpServletRequest request,
	        RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("customer/payment");
		
		int comboPrice = Integer.parseInt(request.getParameter("comboPrice"));
		int chairPrice = Integer.parseInt(request.getParameter("chairSumPrice"));
		String idTimeRoom = request.getParameter("idTimeRoom");
		String idChair = request.getParameter("idChairs");
		String idTicket = request.getParameter("idTicket"); 
		int orderTotal = comboPrice + chairPrice;
		String orderInfo = idTicket;
		
	    String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	    String vnpayUrl = vnPayService.createOrder(orderTotal, orderInfo, baseUrl);
	    
	    mav.addObject("vnpayUrl", vnpayUrl); 
	    mav.addObject("orderTotal", orderTotal);
	    mav.addObject("orderInfo", orderInfo);
	    session.setAttribute("idTimeRoom", idTimeRoom);
	    session.setAttribute("idChairs", idChair);
	    return mav; 
	}
	
	@RequestMapping( value = "/vnpay-payment", method = RequestMethod.GET)
    public String GetMapping(HttpServletRequest request, HttpSession session,
	        RedirectAttributes redirectAttributes) {
       try {
    	   int paymentStatus = vnPayService.orderReturn(request);
           String ticketCode = request.getParameter("vnp_TxnRef");
           String orderInfo = request.getParameter("vnp_OrderInfo");
           String paymentTime = request.getParameter("vnp_PayDate");
           String transactionId = request.getParameter("vnp_TransactionNo");
           String totalPrice = request.getParameter("vnp_Amount");
           String idChairs =  session.getAttribute("idChairs").toString();
           String idTimeRoom =  session.getAttribute("idTimeRoom").toString();
           
           redirectAttributes.addAttribute("ticketCode", ticketCode);
           redirectAttributes.addAttribute("orderId", orderInfo);
           redirectAttributes.addAttribute("totalPrice", totalPrice);
           redirectAttributes.addAttribute("paymentTime", paymentTime);
           redirectAttributes.addAttribute("transactionId", transactionId);
           TicketDTO ticketDTO = new TicketDTO();
       	ticketDTO.setId_Ticket(Integer.parseInt(orderInfo));
       	ticketDTO.setTotalAmount(Float.parseFloat(totalPrice)/100);
       	ticketDTO.setTicketCode(ticketCode);
           
           if (paymentStatus == 1) {
           	redirectAttributes.addAttribute("message", "Thanh toán thành công");
           	List<Integer> isdChairTime = (List<Integer>) session.getAttribute("idsChairTime");
           	int ids[] = new int[isdChairTime.size()];
           	for(int i = 0; i<isdChairTime.size();i++) {
           		ids[i] = isdChairTime.get(i).intValue();
           	}
           	chairtimeService.updateChairsTime(ids);
           	ticketService.xacnhanvethanhcong(ticketDTO);
   		} else {
   			redirectAttributes.addAttribute("message", "Thanh toán thất bại");
   			
   			

   			ticketService.xacnhanvethatbai(ticketDTO);
   			
   		}
           
	} catch (Exception e) {
		e.printStackTrace();
	}
        return "redirect:/transaction"; 
    }
	
	@RequestMapping(value = "/cancelTicket", method = RequestMethod.GET)
	public String cancelTicket(
	        HttpServletRequest request,
	        RedirectAttributes redirectAttributes) {
		String orderInfo = request.getParameter("orderInfo");
		String orderTotal = request.getParameter("orderTotal");
		String idTimeRoom = request.getParameter("idTimeRoom");
		String idChair = request.getParameter("idChairs");
		

		
		TicketDTO dto = new TicketDTO();
		dto.setId_Ticket(Integer.parseInt(orderInfo));
		dto.setTotalAmount(Float.parseFloat(orderTotal));
		
		ticketService.xacnhanhuyve(dto);
		redirectAttributes.addAttribute("message", "Bạn đã xác nhận hủy vé thành công!");
		
	    return "redirect:/transaction"; 
	}
}
