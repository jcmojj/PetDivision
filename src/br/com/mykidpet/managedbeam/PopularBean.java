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
import br.com.mykidpet.util.Popular;

@Named // bean do cdi
@RequestScoped
public class PopularBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	// private Dao<Logradouro> logradouroDao;
	private LogradouroDao logradouroDao;

	public void logradouro() {
		Long tempoInicial = System.currentTimeMillis();
		System.out.println("Populando Logradouro");
		String endereco = "C:/Users/User/Desktop/workspace/petDivisionReal/src/br/com/mykidpet/modelo/dono/logradouros";
		List<Logradouro> logradouros = new Popular().logradouro(endereco);
		for (Logradouro logradouro : logradouros) {
			logradouroDao.adiciona(logradouro);
		}
		System.out
				.println("Demorou " + ((float)(System.currentTimeMillis() - tempoInicial))/1000 + "segundos para popular todos logradouros");
	}

	@Inject
	private PaesciDao paesciDao;

	public void paesci() {
		Long tempoInicial = System.currentTimeMillis();
		System.out.println("Populando Paesci");
		String endereco = "C:/Users/User/Desktop/workspace/petDivisionReal/src/br/com/mykidpet/modelo/dono/paesci";
		List<Paesci> paescis = new Popular().paesci(endereco);
		for (Paesci paesci : paescis) {
			paesciDao.adiciona(paesci);
		}
		System.out.println("Demorou " + ((float)(System.currentTimeMillis() - tempoInicial))/1000 + "segundos para popular todos paesci");
	}

}
