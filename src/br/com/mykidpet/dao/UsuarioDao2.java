package br.com.mykidpet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.mykidpet.modelo.usuario.Pessoa;
import br.com.mykidpet.modelo.usuario.Usuario;

@Stateless
public class UsuarioDao2 {

	@Inject
	EntityManager manager;

	// @TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void adiciona(Usuario usuario) {
		this.manager.persist(usuario);
	}

	public Usuario busca(Integer id) {
		return this.manager.find(Usuario.class, id);
	}

	public List<Usuario> lista() {
		return this.manager.createQuery("select d from Usuario d", Usuario.class).getResultList();
	}

	public void remove(Usuario usuario) {
		Usuario usuarioParaRemover = this.manager.find(Usuario.class, usuario.getId());
		this.manager.remove(usuarioParaRemover);
	}

	public void altera(Usuario usuario) {
		this.manager.merge(usuario);
	}

	public List<Usuario> listaTodosUsuarios() {
		CriteriaQuery<Usuario> query = manager.getCriteriaBuilder().createQuery(Usuario.class);
		query.select(query.from(Usuario.class));

		List<Usuario> lista = manager.createQuery(query).getResultList();

		return lista;
	}

	public List<Pessoa> listaTodos() {
		CriteriaQuery<Pessoa> query = manager.getCriteriaBuilder().createQuery(Pessoa.class);
		query.select(query.from(Pessoa.class));

		List<Pessoa> lista = manager.createQuery(query).getResultList();

		return lista;
	}

}
