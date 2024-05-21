package com.agudelo.examenes.repository;



import org.springframework.data.repository.CrudRepository;

import com.agudelo.commons.models.entity.Examen;


public interface ExamenRepository extends CrudRepository <Examen, Long> {
	

	
}
