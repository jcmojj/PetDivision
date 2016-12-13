package br.com.mykidpet.modelo.usuario;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;

import br.com.mykidpet.modelo.pet.Pet;

@Entity
public class Usuario  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Email @Column(length=36, nullable=true, unique=true)
	private String email;	// max 36 caracteres
	@Column(nullable=true, unique=true)
	private String senha; // max 12 caracteres
	@Column(length=12, nullable=true)
	private String apelido; // max 12 caracteres
	@Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCriacao;
	@Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAlteracao;
	@OneToOne
	private Pessoa pessoa;
	@OneToMany(mappedBy="usuario")
	private List<Pet> pets;
//	@ManyToMany
//	private List<Pet> pets;
//	@ManyToMany
//	private List<Maquina> maquinas;
//	@OneToMany
//	private List<Dono> donosAutorizados;
//	@OneToMany
//	private List<Pet> petsAutorizados;
	
	
	
	public Usuario(String email, String apelido) {
		super();
		this.email = email;
		this.apelido = apelido;
		//this.pessoa = pessoa;
		}

	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getApelido() {
		return apelido;
	}


	public void setApelido(String apelido) {
		this.apelido = apelido;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public List<Pet> getPets() {
		return pets;
	}


	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}


	public Calendar getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}


	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}



}
