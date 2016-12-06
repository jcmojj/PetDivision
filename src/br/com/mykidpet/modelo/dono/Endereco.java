package br.com.mykidpet.modelo.dono;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Logradouro logradouro;
	private String endereco;
	private String numero;
	private String complemento;
	private String cep;
	@ManyToOne
	private Paesci paesci;
	@OneToMany(mappedBy="endereco")
	private List<Pessoa> pessoas;

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(Logradouro logradouro, String endereco, String numero, String complemento, String cep,
			Paesci paesci) {
		super();
		this.logradouro = logradouro;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.paesci = paesci;
	}

	// getters and setters

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Paesci getPaesci() {
		return paesci;
	}

	public void setPaesci(Paesci paesci) {
		this.paesci = paesci;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
