package jpa.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class JPABaseServlet extends HttpServlet {
	
	private static EntityManagerFactory emf;
	protected EntityManager em;
	
	@Override
	public void init() throws ServletException {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("demo");
		}
		em = emf.createEntityManager();
	}
	
	
}
