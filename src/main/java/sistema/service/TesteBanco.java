package sistema.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sistema.models.Grupo;

public class TesteBanco {

	public static void main(String[] args) {

		EntityManagerFactory factory;
		EntityManager em;
		factory = Persistence.createEntityManagerFactory("Cruzeirao");
		em = factory.createEntityManager();
		em.find(Grupo.class, 1);	
	}
}
