package com.agudelo.examenes.service;

import com.agudelo.commons.models.entity.Examen;
import com.agudelo.commons.service.CommonService;

public interface ExamenService extends CommonService <Examen> {
	public Examen save (Examen examen);
	public void deleteById (Long id);
}
