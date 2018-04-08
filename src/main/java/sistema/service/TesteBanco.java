package sistema.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sistema.models.Grupo;

public class TesteBanco {

	public static void main(String[] args) {

		EntityManagerFactory factory;
		System.out.println(1);
		EntityManager em;
		System.out.println(2);
		factory = Persistence.createEntityManagerFactory("Cruzeirao");
		System.out.println(3);
		em = factory.createEntityManager();
		System.out.println(4);
		em.find(Grupo.class, 1);
		System.out.println(5);
		
	}

}
