package com.agudelo.usuario.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agudelo.usuario.models.entity.Alumno;
import com.agudelo.usuario.service.AlumnoService;



@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
	@Autowired
	AlumnoService service;
	
	@GetMapping
	public ResponseEntity<?> listarAlumno(){
		return ResponseEntity.ok().body(service.findAll());
	}
		
	@GetMapping("/ver/{id}")
	public ResponseEntity<?>ver(@PathVariable Long id){
		Optional <Alumno> ob=service.findById(id);
		if (ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(ob.get());
			
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?>crear(@RequestBody Alumno alumno){
		Alumno alumnoDb = service.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
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
	@DeleteMapping("/eliminar/{id}")
	private ResponseEntity<?>eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}


}
