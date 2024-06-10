package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.ChairTimeDTO;

public interface IChairTimeService {
	int addChairTime(ChairTimeDTO chairTimeDTO) throws Exception;
	void deleteChairTime(int idchair, int idMovieTimeRoom);
	ChairTimeDTO updateChairTime(int idChairTime) throws Exception;
	void updateChairsTime(int[] idChairTimes) throws Exception;

	List<Integer> addChairsTime(int[] idChairs, int idMovieTimeRoom) throws Exception;
}
