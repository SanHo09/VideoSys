package DAO;

import java.awt.Window.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Util.JpaUtil;

public class AbtractDao<T> {
	public static final EntityManager em = JpaUtil.getEntityManager();
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public T findById(Class<T> clazz, String id) {
		return em.find(clazz, id);
	}
	
	public List<T> findAll(Class<T> clazz, Boolean existIsActive) {
		String entityName = clazz.getSimpleName();
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT o FROM ").append(entityName).append(" o");
		if(existIsActive==true) { 
			jpql.append(" WHERE o.active = 1");
		}
		TypedQuery<T> query = em.createQuery(jpql.toString(), clazz);
		return query.getResultList();
	}
	
	public List<T> findALL(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize) {	
		String entityName = clazz.getSimpleName();
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT o FROM").append(entityName).append(" o");
		if(existIsActive==true) {
			jpql.append("WHERE o.active = 1");
		}
		TypedQuery<T> query = em.createQuery(jpql.toString(), clazz);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	public T findOne(Class<T> clazz, String jpql, Object ...params) {
		TypedQuery<T> query = em.createQuery(jpql, clazz);
		for(int i=0;i<params.length;i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result 	= query.getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	public List<T> findMany(Class<T> clazz, String jpql, Object ...params) {
		TypedQuery<T> query = em.createQuery(jpql, clazz);
		for(int i=0;i<params.length;i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}
	
	public List<Object[]> findManyByNativeQuery(Class<T> clazz, String jpql, Object ...params) {
		Query query = em.createNativeQuery(jpql, clazz);
		for(int i=0;i<params.length;i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}
	
	public T create(T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			System.out.println("Create succeeded");
			return entity;
		} catch(Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
		return null;
	}
	
	public T update(T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			System.out.println("Update succeeded");
			return entity;
		} catch(Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
		return null;
	}
	
	public T delete(T entity) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Update succeeded");
			return entity;
		} catch(Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
		return null;
	}
	
	public T findLastEntity(Class<T> clazz, String table, String format) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT TOP 1 * FROM ").append(table);
		jpql.append(" ORDER BY ").append(format).append(" DESC");
		Query query = em.createNativeQuery(jpql.toString(), clazz);
		return  (T)query.getSingleResult();
	}
	

	
	
	
	
}
