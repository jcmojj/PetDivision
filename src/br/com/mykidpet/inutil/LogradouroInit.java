package br.com.mykidpet.inutil;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
//@Singleton
public class LogradouroInit {
//
//	@PersistenceUnit
//	private EntityManagerFactory factory;
//	
//	@Produces
//	@RequestScoped
//	public EntityManager getEntityManager() {
//		return factory.createEntityManager();
//	}
//	
//	public void close(@Disposes EntityManager manager) {
//		manager.close();
//	}
//
////	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {	
//	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
//		System.out.println("TESTE do LOGRADOURO INIT");
////		EntityManager manager = this.getEntityManager();
//		
//		//		Map<String,Boolean> addedOrOverridenProperties = new HashMap<String,Boolean>();
////
////		// Let's suppose we are using Hibernate as JPA provider
////		addedOrOverridenProperties.put("hibernate.show_sql", true);
////
////		EntityManager manager =Persistence.createEntityManagerFactory("java:/mykidpetDS", addedOrOverridenProperties).createEntityManager();
////		manager.getTransaction().begin();
////		manager.getTransaction().commit();
////		manager.close();				
////		EntityManager manager2 = Persistence.createEntityManagerFactory("mykidpet").createEntityManager();
////		manager2.getTransaction().begin();
////		manager2.getTransaction().begin();
////		manager2.getTransaction().commit();
////		manager2.close();
//		
//		//		try {
////			InputStream is = new FileInputStream(
////					"C:/Users/User/Desktop/workspace/petDivisionReal/src/br/com/mykidpet/modelo/dono/logradouros");
////			InputStreamReader isr = new InputStreamReader(is);
////			BufferedReader br = new BufferedReader(isr);
////			String s = br.readLine();
////
////			Logradouro logradouro;
////
////			while (s != null) {
////				logradouro = new Logradouro();
////				logradouro.setLogradouro(s);
////				manager.persist(logradouro);
////				s = br.readLine();
////				System.out.println("while - nova linha: " + s);
////			}
////			br.close();
////		} catch (FileNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		manager.getTransaction().commit();
////		manager.close();		
//	}
//
//	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
//	
//	}
}
