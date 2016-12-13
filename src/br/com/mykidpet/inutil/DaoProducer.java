package br.com.mykidpet.inutil;

//public class DaoProducer {
//	@Inject
//	private EntityManager em;
//
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Produces
//	public Dao createDao(InjectionPoint injectionPoint) throws ClassNotFoundException {
//		ParameterizedType type = (ParameterizedType) injectionPoint.getType();
//		Class classe = (Class) type.getActualTypeArguments()[0];
//		return new Dao(classe, em);
//	}
//}

// @ApplicationScoped
// public class DaoProducer {
//
// @PersistenceUnit
// private EntityManagerFactory factory;

// @Produces
// @RequestScoped
// public Dao<Object> getDao(Class<T> classe) {
// return new Dao(classe);
// }

// public void close(@Disposes EntityManager manager) {
// manager.close();
// }

// }
