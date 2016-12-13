package br.com.mykidpet.modelo.maquina;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.mykidpet.modelo.petdamaquina.PetDaMaquina;

@Entity
public class Maquina implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@OneToMany(mappedBy="maquina")
	private List <PetDaMaquina> petDaMaquina;
	@ManyToOne
	private ModeloDeMaquina modeloDeMaquina;
}
