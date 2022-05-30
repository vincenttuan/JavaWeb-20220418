package jpa.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import jpa.entity.Person;

public class JPAService {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	public JPAService() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("demo");
		}
		em = emf.createEntityManager();
	}
	
	public void addPerson(Person person) {
		synchronized (em) {
			EntityTransaction etx = em.getTransaction();
			etx.begin(); // 開始
			em.persist(person); // 存入 person
			etx.commit(); // 提交
		}
	}
	
	
}
