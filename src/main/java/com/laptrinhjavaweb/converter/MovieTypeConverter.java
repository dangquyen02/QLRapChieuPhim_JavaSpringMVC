package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.MovieTypeDTO;
import com.laptrinhjavaweb.entity.MovieTypeEntity;

@Component
public class MovieTypeConverter {
	public MovieTypeDTO toDTO (MovieTypeEntity movietypeEntity) {
		MovieTypeDTO dto = new MovieTypeDTO();
		dto.setIdMovieType(movietypeEntity.getIdMovieType());
		dto.setTypeName(movietypeEntity.getTypeName());
		return dto;
	}
}
