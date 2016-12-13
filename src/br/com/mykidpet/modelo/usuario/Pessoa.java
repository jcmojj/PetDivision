package br.com.mykidpet.modelo.usuario;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String rg;
	private String celular;
	private String telefoneFixo;
	@OneToOne(mappedBy="pessoa")
	private Usuario dono;
	@ManyToOne
	private Endereco endereco;
	

	
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pessoa(String nome, String cpf, String rg, String celular, String telefoneFixo, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.celular = celular;
		this.telefoneFixo = telefoneFixo;
		this.endereco = endereco;
	}
	// Getters and setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Usuario getDono() {
		return dono;
	}
	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
	
}
