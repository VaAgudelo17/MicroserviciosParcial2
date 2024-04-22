package com.agudelo.usuario.repository;


import org.springframework.data.repository.CrudRepository;


import com.agudelo.usuario.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository <Alumno, Long>{

}
