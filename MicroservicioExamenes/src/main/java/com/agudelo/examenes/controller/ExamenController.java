package com.agudelo.examenes.controller;



import java.util.List;


import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agudelo.commons.controller.CommonController;
import com.agudelo.commons.models.entity.Examen;
import com.agudelo.commons.models.entity.Pregunta;
import com.agudelo.examenes.service.ExamenService;



@RestController
@RequestMapping("/api/examenes")
public class ExamenController extends CommonController<Examen, ExamenService> {
	
	private ExamenService examenService; 


    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

	@PutMapping("/editarExamen/{id}")
    public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
        Optional <Examen> ob = service.findById(id);

        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Examen examenDB = ob.get();
        examenDB.setNombre(examen.getNombre());
        examenDB.setCreateAt(examen.getCreateAt());
        examenDB.setPreguntas(examen.getListaPreguntas());

        return ResponseEntity.status(HttpStatus.CREATED).body(examenService.save(examenDB)); 
    }
	
	
	@PutMapping("/{id}/asignar-pregunta")
	public ResponseEntity<?> asignarPregunta(@RequestBody List<Pregunta> pregunta, @PathVariable Long id) {
		
		Optional<Examen> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Examen examenDB = ob.get();
		pregunta.forEach( a -> {
			examenDB.addPregunta(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDB));
	}
	
	
	@PutMapping("/{id}/eliminar-pregunta")
	public ResponseEntity<?> asignarPregunta(@RequestBody Pregunta pregunta, @PathVariable Long id) {
		
		Optional<Examen> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Examen examenDB = ob.get();
		
		examenDB.removePregunta(pregunta);
		
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
	

}
