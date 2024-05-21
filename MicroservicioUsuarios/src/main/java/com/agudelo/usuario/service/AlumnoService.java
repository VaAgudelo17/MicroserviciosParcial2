package com.agudelo.usuario.service;

import com.agudelo.commons.service.CommonService;

import com.agudelo.commons.models.entity.Alumno;



public interface AlumnoService extends CommonService<Alumno> {

	public Alumno save (Alumno alumno);
	public void deleteById (Long id);

}
