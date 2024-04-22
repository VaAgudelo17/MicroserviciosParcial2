package com.agudelo.usuario.service;
import java.util.Optional;
import com.agudelo.usuario.models.entity.Alumno;


public interface AlumnoService {
	public Iterable <Alumno> findAll();
	public Optional <Alumno> findById(Long id );
	public Alumno save (Alumno alumno);
	public void deleteById (Long id);

}
