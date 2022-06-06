package guestbook.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import guestbook.entity.Guestbook;

public class JPAService {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	public JPAService() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("demo");
		}
		em = emf.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public List<Guestbook> queryGuestbook() {
		Query query = em.createQuery("select g from guestbook g"); // JPQL
		return query.getResultList();
	}
}
