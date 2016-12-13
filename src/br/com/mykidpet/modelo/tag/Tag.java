package br.com.mykidpet.modelo.tag;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.mykidpet.modelo.petdamaquina.PetDaMaquina;

@Entity
public class Tag  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ModeloDeTag modeloDeTag;
	@OneToOne
	private PetDaMaquina petDaMaquina;
//	@ManyToMany
//	private List<Maquina> maquinas;
	
	
	// getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ModeloDeTag getModeloDeTag() {
		return modeloDeTag;
	}
	public void setModeloDeTag(ModeloDeTag modeloDeTag) {
		this.modeloDeTag = modeloDeTag;
	}
	public PetDaMaquina getPetDaMaquina() {
		return petDaMaquina;
	}
	public void setPetDaMaquina(PetDaMaquina petDaMaquina) {
		this.petDaMaquina = petDaMaquina;
	}
	
}
