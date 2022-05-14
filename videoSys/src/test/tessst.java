package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.commons.beanutils.BeanUtils;

import models.User;

public class tessst {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoSys");
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createQuery("SELECT o FROM User o", User.class);
		List<User> list = query.getResultList();
		em.persist(new User());
		em.merge  ("");
		em.remove (""); 
	}
}
