package br.com.mykidpet.modelo.petdamaquina;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.mykidpet.modelo.maquina.Maquina;
import br.com.mykidpet.modelo.tag.Tag;
import br.com.mykidpet.modelo.usuario.Usuario;

@Entity
public class PetDaMaquina implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	private String apelido;//12 caracteres
	private String email; // 36 caracteres
    @OneToMany(mappedBy="petDaMaquina")
    private List<Bebida>bebidas;
    @OneToMany(mappedBy="petDaMaquina")
    private List<Refeicao>refeicoes;
	@OneToOne
	private Tag tag;
	@ManyToOne
	private Maquina maquina;	
	@OneToOne
	private Usuario dono;

	// Getters and Setters
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

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public List<Refeicao> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<Refeicao> refeicoes) {
		this.refeicoes = refeicoes;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	
	
}