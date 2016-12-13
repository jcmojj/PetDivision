package br.com.mykidpet.dao;

import javax.ejb.Stateless;

import br.com.mykidpet.modelo.usuario.Endereco;

@Stateless
public class EnderecoDao extends Dao<Endereco> {

	public EnderecoDao() {
		super(Endereco.class);
		// TODO Auto-generated constructor stub
	}
	
	
}


