package com.agudelo.curso.services;

import org.springframework.stereotype.Service;

import com.agudelo.commons.service.CommonService;
import com.agudelo.commons.service.CommonServiceImpl;
import com.agudelo.commons.models.entity.Curso;
import com.agudelo.curso.repository.CursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CommonService <Curso>{


}
