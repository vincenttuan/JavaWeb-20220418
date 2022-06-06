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
		// JPQL 所指的 Guestbook 是 entity 的名字而非 table name guestbook
		// 所以本題 select g from Guestbook g 成功
		//       select g from guestbook g 失敗 
		Query query = em.createQuery("select g from Guestbook g"); // JPQL
		return query.getResultList();
	}
}
