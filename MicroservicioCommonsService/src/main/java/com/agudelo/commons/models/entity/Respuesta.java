package com.agudelo.commons.models.entity;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table

public class Respuesta {
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
	
	
	public Long getId() {
		return Id;
		
	}
	
	public void setId(Long id) {
	        this.Id = id;
	}
	
	public String getTexto() {
        return texto;
    }
	public void setTexto(String texto) {
        this.texto = texto;
}
	
   
    public Date getCreateAt() {
        return (Date) createAt;
    }
    
   
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    
       
  
    @Override
    public String toString() {
        return "Respuesta{" +
               "id=" + Id +
               ", texto='" + texto + '\'' +
               ", createAt=" + createAt +
               '}';
    }

}
