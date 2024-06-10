package com.laptrinhjavaweb.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;

@Controller
public class adminUserController {
//
//	@Autowired
//	private IUserService userservice;
//
//	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
//	public ModelAndView adminUserPage(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView("admin/user");
//
//		try {
//			List<UserDTO> listuser;
//			String key = request.getParameter("txtsearch");
//			mav.addObject("key", key);
//			int page = 0; // Trang mặc định
//			int size = 5; // Số lượng phần tử trên mỗi trang
//			String pageStr = request.getParameter("page");
//			if (pageStr != null && !pageStr.isEmpty()) {
//				page = Integer.parseInt(pageStr);
//			}
//			mav.addObject("currentPage", page);
//
//			if (key == null || key.isEmpty()) {
//				listuser = userservice.getAllUser();
//			} else {
//				listuser = userservice.getUserByName(key);
//			}
//
//			// Tính chỉ mục bắt đầu và kết thúc cho trang hiện tại
//			int start = page * size;
//			int end = Math.min(start + size, listuser.size());
//
//			// Lấy chỉ mục từ start đến end của listuser
//			List<UserDTO> paginatedUsers = listuser.subList(start, end);
//
//			mav.addObject("listuser", paginatedUsers);
//			mav.addObject("totalPages", (int) Math.ceil((double) listuser.size() / size));
//			mav.addObject("totalrow", (int) Math.ceil((double) listuser.size()));
//			return mav;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return mav;
//		}
//	}
//
//	@RequestMapping(value = "/admin/useredit", method = RequestMethod.GET)
//	public ModelAndView editUserPage(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView("admin/user_edit");
//
//		return mav;
//	}
}
