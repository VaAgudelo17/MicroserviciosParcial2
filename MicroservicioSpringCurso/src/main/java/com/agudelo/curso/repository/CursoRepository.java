package com.agudelo.curso.repository;

import org.springframework.data.repository.CrudRepository;

import com.agudelo.commons.models.entity.Curso;


public interface CursoRepository extends CrudRepository <Curso, Long>{

}
