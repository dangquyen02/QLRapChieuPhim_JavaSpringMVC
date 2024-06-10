package com.laptrinhjavaweb.dto;

import com.laptrinhjavaweb.entity.ChairTypeEntity;
import com.laptrinhjavaweb.entity.RoomEntity;

import lombok.Data;

@Data
public class ChairDTO {
	private int idCinemaChair;
	private String chairCode;
	private ChairTypeEntity idChairType;
	private RoomEntity idRoom;
}
