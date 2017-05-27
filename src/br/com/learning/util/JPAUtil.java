package br.com.learning.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = null;
	
	public EntityManager getEntityManager() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("financas");
		
		return entityManagerFactory.createEntityManager();
	}
	
}
