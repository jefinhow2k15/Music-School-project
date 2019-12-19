package escola.programacao.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("escola_programacao");
		
		return factory.createEntityManager();
		
	}
	
}
