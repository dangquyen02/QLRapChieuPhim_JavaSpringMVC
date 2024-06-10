package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.ChairDTO;

public interface IChairService {
	List<ChairDTO> findChairByIdRoom(int idRoom);
	List<ChairDTO> getBookedChairs(int idMovieTimeRoom);
	List<ChairDTO> getUnbookedChairs(int idRoom,int idMovieTimeRoom);
	ChairDTO findOneById(int idCinemaChair);
	
	ChairDTO getChairbyid(int id);
}
