package br.com.mykidpet.modelo.petdamaquina;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Refeicao  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private PetDaMaquina petDaMaquina;

//	@ManyToOne
//	Maquina maquina;
	private Calendar dataHora;
	private Integer quantidadeGrama;
	
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
	public Integer getQuantidadeGrama() {
		return quantidadeGrama;
	}
	public void setQuantidadeGrama(Integer quantidadeGrama) {
		this.quantidadeGrama = quantidadeGrama;
	}
}

