package com.laptrinhjavaweb.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.laptrinhjavaweb.entity.ComboEntity;

public interface ComboRepository extends JpaRepository<ComboEntity, Integer> {
	List<ComboEntity> findAll();
	ComboEntity findByIdCombo(Integer id);
}