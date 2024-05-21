package com.agudelo.examenes.controller;

import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;
import com.agudelo.commons.controller.CommonController;

import com.agudelo.commons.models.entity.Pregunta;
import com.agudelo.examenes.service.PreguntaService;


@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController extends CommonController<Pregunta, PreguntaService>{
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?>editar(@RequestBody Pregunta pregunta,@PathVariable Long id){
		Optional<Pregunta>ob=service.findById(id);
		if (ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Pregunta preguntaDb = ob.get();
		preguntaDb.setTexto(pregunta.getTexto());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(preguntaDb));
	}
	
	

}
