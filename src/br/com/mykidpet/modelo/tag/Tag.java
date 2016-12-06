package br.com.mykidpet.modelo.tag;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

//import br.com.mykidpet.modelo.maquina.Maquina;
//import br.com.mykidpet.modelo.pet.Pet;

@Entity
public class Tag  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ModeloDeTag modeloDeTag;
//	private Pet pet;
//	@ManyToMany
//	private List<Maquina> maquinas;
	public Tag(ModeloDeTag modeloDeTag) {
		super();
		this.modeloDeTag = modeloDeTag;
	}
	

	// getters and setters


}
