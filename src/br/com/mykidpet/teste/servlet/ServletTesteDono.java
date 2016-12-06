package br.com.mykidpet.teste.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mykidpet.modelo.dono.Paesci;
import br.com.mykidpet.modelo.dono.Dono;
import br.com.mykidpet.modelo.dono.Endereco;
import br.com.mykidpet.modelo.dono.Inicializar;
import br.com.mykidpet.modelo.dono.Logradouro;
import br.com.mykidpet.modelo.dono.Pessoa;


@WebServlet("/testeServletDono")
public class ServletTesteDono extends HttpServlet {
	private static final long serialVersionUID = 2L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mymanager");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		/*Inicializar inicializar = new Inicializar();
		// Populando Logradouros
		EntityManager em2 = factory.createEntityManager();
		em2.getTransaction().begin();
		inicializar.logradouro(em2);
		em2.getTransaction().commit();
		em2.close();
		
		// Populando Ciespa
		EntityManager em3 = factory.createEntityManager();
		em3.getTransaction().begin();
		inicializar.paesci(em3);
		em3.getTransaction().commit();
		em3.close();
			*/			
		Logradouro logradouro = em.find(Logradouro.class, 1);
		Paesci ciespa = em.find(Paesci.class,1);
		Endereco endereco = new Endereco(logradouro, "Tebas", "296", "Apto 72A", "04634-031", ciespa);
		em.persist(endereco);
		Dono dono = new Dono( "jcmojj@gmail.com", "cacaio");
		em.persist(dono);
		Pessoa pessoa = new Pessoa("Jose Carlos", "331.881.858-55", "30.028.659-4", "991318300", "55626928", endereco);
		em.persist(pessoa);
		dono.setPessoa(pessoa);
		//Pessoa pessoa2 = new Pessoa("Jose Carlos", "331.881.858-55", "30.028.659-4", "991318300", "55626928", endereco);
		//em.persist(pessoa2);			
		em.getTransaction().commit();
		em.close();
		//factory.close();
		
	}
}
