package br.com.mykidpet.modelo.dono;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Dono  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String email;	// max 36 caracteres
	private String apelido; // max 12 caracteres
	@OneToOne
	private Pessoa pessoa;
//	@ManyToMany
//	private List<Pet> pets;
//	@ManyToMany
//	private List<Maquina> maquinas;
//	@OneToMany
//	private List<Dono> donosAutorizados;
//	@OneToMany
//	private List<Pet> petsAutorizados;
	
	
	
	public Dono(String email, String apelido) {
		super();
		this.email = email;
		this.apelido = apelido;
		//this.pessoa = pessoa;
		}

	
	public Dono() {
		super();
		// TODO Auto-generated constructor stub
	}


	// getters and setters
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
//	public List<Pet> getPets() {
//		return pets;
//	}
//	public void setPets(List<Pet> pets) {
//		this.pets = pets;
//	}
//	public List<Maquina> getMaquinas() {
//		return maquinas;
//	}
//	public void setMaquinas(List<Maquina> maquinas) {
//		this.maquinas = maquinas;
//	}
//	public List<Dono> getDonosAutorizados() {
//		return donosAutorizados;
//	}
//	public void setDonosAutorizados(List<Dono> donosAutorizados) {
//		this.donosAutorizados = donosAutorizados;
//	}
//	public List<Pet> getPetsAutorizados() {
//		return petsAutorizados;
//	}
//	public void setPetsAutorizados(List<Pet> petsAutorizados) {
//		this.petsAutorizados = petsAutorizados;
//	}
	
	
}
