package com.agudelo.examenes.service;

import org.springframework.stereotype.Service;

import com.agudelo.commons.models.entity.Pregunta;
import com.agudelo.commons.service.CommonService;
import com.agudelo.commons.service.CommonServiceImpl;
import com.agudelo.examenes.repository.PreguntaRepository;



@Service
public class PreguntaServiceImpl extends CommonServiceImpl<Pregunta, PreguntaRepository> implements CommonService <Pregunta>{
	

}
