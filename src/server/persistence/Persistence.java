package server.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Persistence {

	private EntityManagerFactory emf;

	private static Persistence persistence;

	public static Persistence getInstance() {
		if (persistence == null) {
			persistence = new Persistence();
		}

		return persistence;
	}

	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	public Persistence() {
		emf = javax.persistence.Persistence.createEntityManagerFactory("producao");
	}

	public static void closeAll() {
		if(persistence != null){
			persistence.close();
		}
	}

	private void close() {
		emf.close();
	}

}
