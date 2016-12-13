package br.com.mykidpet.modelo.usuario;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Logradouro implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true)
	private String logradouro;
	@OneToMany(mappedBy="logradouro")
	private List<Endereco> endereco;
	
	
	// constructor	
	public Logradouro(Integer id, String logradouro, List<Endereco> endereco) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.endereco = endereco;
		
	
	}

	// getters and setters
	public String getLogradouro() {
		return logradouro;
	}

	public Logradouro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Logradouro(String logradouro) {
		super();
		this.logradouro = logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
