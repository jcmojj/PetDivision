package br.com.mykidpet.dao;

import javax.ejb.Stateless;

import br.com.mykidpet.modelo.usuario.Pessoa;

@Stateless
public class PessoaDao extends Dao<Pessoa> {

	public PessoaDao() {
		super(Pessoa.class);
		// TODO Auto-generated constructor stub
	}
	
	
}