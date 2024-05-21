package com.agudelo.usuario.controller;



import java.util.HashMap;


import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agudelo.commons.controller.CommonController;
import com.agudelo.commons.models.entity.Alumno;
import com.agudelo.usuario.service.AlumnoService;



@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService>{
	
	@Value("${config.balanceador.test}")
	private String balanceadorTest;
	
	@GetMapping("/balanceador-test")
	public ResponseEntity<?>balanceadorTest(){
		 Map<String, Object> response = new HashMap<String, Object>();
		    response.put("balanceador", balanceadorTest);
		    response.put("alumno", service.findAll());
		    return ResponseEntity.ok().body(response);
	}
	
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?>editar(@RequestBody Alumno alumno,@PathVariable Long id){
		Optional<Alumno>ob=service.findById(id);
		if (ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Alumno alumnoDb = ob.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	

}
