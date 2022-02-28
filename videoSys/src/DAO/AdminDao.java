package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Admin;

public interface AdminDao {
	public Admin findById(String id);
	public Admin findByFullName(String fullName);
	public Admin findByEmail(String email);
	public Admin findByUserNameAndPassword(String userName, String password);
	public List<Admin> findAll();
	public List<Admin> findAll(int pageNumber, int pageSize);
	public Admin create(Admin admin);
	public Admin update(Admin admin);
	public Admin delete(Admin admin);
	public String generationID();
}
