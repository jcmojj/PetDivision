package br.com.mykidpet.modelo.pet;


import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.mykidpet.modelo.usuario.Usuario;

@Entity
public class Pet implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	private String apelido;//12 caracteres
	private String email; //12 caracteres + 36 caracteres -SEM ESPACOS
	private String nome; // quantos caracteres quiser
	@Enumerated(EnumType.STRING)
	private TipoDePet tipo;
	private String raca;
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	@ManyToOne
	private Usuario usuario;
	
	
	// Getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoDePet getTipo() {
		return tipo;
	}
	public void setTipo(TipoDePet tipo) {
		this.tipo = tipo;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}





	
}
