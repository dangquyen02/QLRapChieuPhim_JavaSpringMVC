package com.laptrinhjavaweb.dto;
import java.io.Serializable;
import lombok.Data;

@Data
public class RoomDTO {
	private static final long serialVersionUID = 1L;
	private int idRoom;
	private String RoomCode;
	private int chairTotal;
}
