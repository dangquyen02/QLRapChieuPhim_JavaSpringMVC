package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.ComboDTO;

public interface IComboService {
	//lấy danh sách combo
	List<ComboDTO> getcombo() throws Exception;
	
	ComboDTO getCombobyid(int id);
}	
