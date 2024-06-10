package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.RoomDTO;
import com.laptrinhjavaweb.entity.RoomEntity;

@Component
public class RoomConverter {

	public RoomDTO toDTO (RoomEntity roomEntity) {
		RoomDTO dto = new RoomDTO();
		dto.setIdRoom(roomEntity.getIdRoom());
		dto.setRoomCode(roomEntity.getRoomCode());
		dto.setChairTotal(roomEntity.getChairTotal());
		return dto;
	}
}
