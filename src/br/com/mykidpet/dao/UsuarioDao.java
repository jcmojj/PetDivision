package br.com.mykidpet.dao;

import javax.ejb.Stateless;

import br.com.mykidpet.modelo.usuario.Usuario;

@Stateless
public class UsuarioDao extends Dao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}
	
	
}
