package br.com.mykidpet.managedbeam;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mykidpet.dao.LogradouroDao;
import br.com.mykidpet.dao.PaesciDao;
import br.com.mykidpet.modelo.usuario.Logradouro;
import br.com.mykidpet.modelo.usuario.Paesci;

@Named
@RequestScoped
public class DespopularBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject

	private LogradouroDao logradouroDao;

	public void logradouro() {
		Long tempoInicial = System.currentTimeMillis();
		System.out.println("Despopulando Logradouro");
		System.out.println("logradouro");
		List<Logradouro> logradouros = logradouroDao.listaTodos();
		for (Logradouro logradouro : logradouros) {
			logradouroDao.remove(logradouro);
		}
		System.out.println("Demorou " + ((float)(System.currentTimeMillis() - tempoInicial))/1000 + "segundos para despopular todos logradouro");
	}
	
	@Inject
	PaesciDao paesciDao;
	public void paesci(){
		Long tempoInicial = System.currentTimeMillis();
		System.out.println("Despopulando Paesci");
		List<Paesci> paescis = paesciDao.listaTodos();
		for(Paesci paesci : paescis){
			paesciDao.remove(paesci);
		}
		System.out.println("Demorou " + ((float)(System.currentTimeMillis() - tempoInicial))/1000 + "segundos para popular todos paesci");
	}
}