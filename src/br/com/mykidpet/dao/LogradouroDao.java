package br.com.mykidpet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.mykidpet.modelo.usuario.Logradouro;

@Stateless
public class LogradouroDao {

	@Inject
	EntityManager manager;

	// @TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void adiciona(Logradouro logradouro) {
		this.manager.persist(logradouro);
	}

	public Logradouro busca(Integer id) {
		return this.manager.find(Logradouro.class, id);
	}

	public List<Logradouro> lista() {
		return this.manager.createQuery("select d from Logradouro d", Logradouro.class).getResultList();
	}

	public void remove(Logradouro logradouro) {
		Logradouro logradouroParaRemover = this.manager.find(Logradouro.class, logradouro.getId());
		this.manager.remove(logradouroParaRemover);
	}

	public void altera(Logradouro logradouro) {
		this.manager.merge(logradouro);
	}

	public List<Logradouro> listaTodos() {
		CriteriaQuery<Logradouro> query = manager.getCriteriaBuilder().createQuery(Logradouro.class);
		query.select(query.from(Logradouro.class));

		List<Logradouro> lista = manager.createQuery(query).getResultList();

		return lista;
	}

//	public List<Pessoa> listaTodos() {
//		CriteriaQuery<Pessoa> query = manager.getCriteriaBuilder().createQuery(Pessoa.class);
//		query.select(query.from(Pessoa.class));
//
//		List<Pessoa> lista = manager.createQuery(query).getResultList();
//
//		return lista;
//	}

}
