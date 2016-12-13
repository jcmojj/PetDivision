package br.com.mykidpet.dao;

import javax.ejb.Stateless;

import br.com.mykidpet.modelo.usuario.Paesci;

@Stateless
public class PaesciDao extends Dao<Paesci> {

	public PaesciDao() {
		super(Paesci.class);
		// TODO Auto-generated constructor stub
	}
}
