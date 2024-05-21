package com.agudelo.commons.models.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
public class Pregunta {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private Long Id;
	private String texto;
	
	@Column(name= "create_at")
	@Temporal (TemporalType.TIMESTAMP)
	
	private Date createAt;
	
	@PrePersist
	private void prePersiste() {
		this.createAt = new java.util.Date();
	}

	
	@JsonIgnoreProperties(value = {"preguntas"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="examen_id")
	private Examen examen;
	
	
	
	
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
	        this.Id = id;
	}
	
	public String getTexto() {
        return texto;
    }
    
    public void setTexto(String nombre) {
        this.texto = nombre;
    }
    public Date getCreateAt() {
        return (Date) createAt;
    }
    
   
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    
    public Examen getExamen(){
    	return examen;
    }
    
    public void setExamen (Examen examen) {
    	this.examen=examen;
    }
    
    public Pregunta() {
        
    }
   

    
  
    
    @Override
    public String toString() {
        return "Pregunta{" +
               "id=" + Id +
               ", nombre='" + texto + '\'' +
               ", createAt=" + createAt +
               '}';
    }

}
