package com.agudelo.examenes.service;

import com.agudelo.commons.models.entity.Pregunta;
import com.agudelo.commons.service.CommonService;

public interface PreguntaService extends CommonService <Pregunta> {
	public Pregunta save (Pregunta pregunta);
	public void deleteById (Long id);

}
