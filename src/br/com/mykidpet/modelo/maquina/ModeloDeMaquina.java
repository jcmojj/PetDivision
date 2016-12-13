package br.com.mykidpet.modelo.maquina;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.com.mykidpet.modelo.tag.ModeloDeTag;

@Entity
public class ModeloDeMaquina implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@OneToMany(mappedBy="modeloDeMaquina")
	private List<Maquina> maquinas;
	@ManyToMany
	private List<ModeloDeTag> modelosDeTag;
}