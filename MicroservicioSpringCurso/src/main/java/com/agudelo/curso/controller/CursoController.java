package com.agudelo.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agudelo.commons.controller.CommonController;
import com.agudelo.commons.models.entity.Alumno;
import com.agudelo.commons.models.entity.Curso;
import com.agudelo.curso.services.CursoService;


@RestController 
public class CursoController extends CommonController <Curso,CursoService>{
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?>editar(@RequestBody Curso curso,@PathVariable Long id){
		Optional<Curso>ob=service.findById(id);
		if (ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursoDb = ob.get();
		cursoDb.setNombre(curso.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}
	
	@PutMapping("/{id}/asignar-alumno")
	public ResponseEntity <?> asignarAlumnos (@RequestBody List <Alumno> alumno , @PathVariable Long id ){
		Optional<Curso>ob=service.findById(id);
		if (ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursoBd = ob.get();
		alumno.forEach(a -> {
			cursoBd.addAlumnos(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
		
	} 
	
	@PutMapping ("/eliminar-alumno/{id}")
	public ResponseEntity <?> eliminarAlumnos (@RequestBody Alumno alumno , @PathVariable Long id ){
		Optional <Curso> ob = service.findById(id);
		if (!ob.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Curso cursoDb = ob.get();
		cursoDb.removeAlumnos(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}
	
	
	

}
