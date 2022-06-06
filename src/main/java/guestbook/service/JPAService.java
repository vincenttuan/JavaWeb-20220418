package guestbook.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import guestbook.entity.Guestbook;

public class JPAService {
	private static EntityManagerFactory emf;
	private EntityManager em;

	public JPAService() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("demo");
		}
		em = emf.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public List<Guestbook> queryGuestbook() {
		// 強迫將 em 清除/關閉後新建立
		// 避免快取現象
		em.clear();
		em.close();
		em = emf.createEntityManager();
		// JPQL 所指的 Guestbook 是 entity 的名字而非 table name guestbook
		// 所以本題 select g from Guestbook g 成功
		// select g from guestbook g 失敗
		Query query = em.createQuery("select g from Guestbook g"); // JPQL
		//Query query = em.createNativeQuery("select id, username, content, createtime from guestbook", Guestbook.class);
		return query.getResultList();
	}

	public void addGuestbook(Guestbook guestbook) {
		synchronized (em) {
			EntityTransaction etx = em.getTransaction();
			etx.begin(); // 開始
			em.persist(guestbook); // 存入 guestbook
			etx.commit(); // 提交
		}
	}

	public Guestbook getGuestbookById(Integer id) {
		// 強迫將 em 清除/關閉後新建立
		// 避免快取現象
		em.clear();
		em.close();
		em = emf.createEntityManager();
		return em.find(Guestbook.class, id);
	}

	public void updateGuestbook(Guestbook guestbook) {
		synchronized (em) {
			EntityTransaction etx = em.getTransaction();
			etx.begin(); // 開始
			// 使用 merge 若該筆不存在會新增, 若該筆存在則修改
			// 使用 merge 可以在 unbind 的情況下使用
			em.merge(guestbook); // 存入/修改 guestbook
			etx.commit(); // 提交

		}
	}

	public void deleteGuestbookById(Integer id) {
		synchronized (em) {
			EntityTransaction etx = em.getTransaction();
			etx.begin(); // 開始

			Guestbook guestbook = getGuestbookById(id);
			if (guestbook != null) {
				em.remove(guestbook);
			}

			etx.commit(); // 提交
		}

	}
}
