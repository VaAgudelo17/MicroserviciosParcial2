package com.agudelo.commons.models.entity;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

import jakarta.persistence.TemporalType;

@Entity
@Table
public class Examen {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private Long Id;
	private String nombre;
	
	@Column(name= "create_at")
	@Temporal (TemporalType.TIMESTAMP)
	
	private Date createAt;
	
	@PrePersist
	private void prePersiste() {
		this.createAt = new java.util.Date();
	}
	@JsonIgnoreProperties(value = {"examen"}, allowSetters = true)
    @OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pregunta> listaPreguntas;
	
	
	
	
	public Long getId() {
		return Id;
		
	}
	
	public void setId(Long id) {
	        this.Id = id;
	}
	
	public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getCreateAt() {
        return (Date) createAt;
    }
    
   
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    
    public List<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(List<Pregunta> listaPregunta) {
        this.listaPreguntas = listaPregunta;
    }
    
    
    public void setPreguntas(List<Pregunta> preguntas) {
		this.listaPreguntas.clear();
		preguntas.forEach(this::addPregunta);
		
	}
    public void addPregunta(Pregunta pregunta) {
		this.listaPreguntas.add(pregunta);
		pregunta.setExamen(null);
	}
    public void removePregunta(Pregunta pregunta) {
		this.listaPreguntas.remove(pregunta);
		pregunta.setExamen(null);
	}
    
   
   
    
    
    @Override
    public String toString() {
        return "Examen{" +
               "id=" + Id +
               ", nombre='" + nombre + '\'' +
               ", createAt=" + createAt +
               '}';
    }
	

}
