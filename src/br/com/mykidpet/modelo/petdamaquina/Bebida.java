package br.com.mykidpet.modelo.petdamaquina;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Bebida implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private PetDaMaquina petDaMaquina;
//	@ManyToOne
//	Maquina maquina;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	private Integer volumeMl;
	
	// Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PetDaMaquina getPetDaMaquina() {
		return petDaMaquina;
	}
	public void setPetDaMaquina(PetDaMaquina petDaMaquina) {
		this.petDaMaquina = petDaMaquina;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public Integer getVolumeMl() {
		return volumeMl;
	}
	public void setVolumeMl(Integer volumeMl) {
		this.volumeMl = volumeMl;
	}
}
