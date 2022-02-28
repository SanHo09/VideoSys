package DAO.impl;

import java.util.List;

import DAO.AbtractDao;
import DAO.AdminDao;
import models.Admin;

public class AdminDaoImpl extends AbtractDao<Admin> implements AdminDao{

	@Override
	public Admin findById(String id) {
		return super.findById(Admin.class, id);
	}

	@Override
	public Admin findByFullName(String fullName) {
		String jpql = "SELECT a FROM Admin a WHERE a.fullName LIKE %:fullName%";
		return super.findOne(Admin.class, jpql, fullName);
	}

	@Override
	public Admin findByEmail(String email) {
		String jpql = "SELECT a FROM Admin a WHERE a.fullName LIKE %:email%";
		return super.findOne(Admin.class, jpql, email);
	}

	@Override
	public Admin findByUserNameAndPassword(String userName, String password) {
		String jpql = "SELECT a FROM Admin a WHERE a.adminID=?0 AND a.password=?1";
		return super.findOne(Admin.class, jpql, userName, password);
	}

	@Override
	public List<Admin> findAll() {
		return super.findAll(Admin.class, true);
	}

	@Override
	public List<Admin> findAll(int pageNumber, int pageSize) {
		return super.findALL(Admin.class, true, pageNumber, pageSize);
	}
	
	@Override
	public String generationID() {
		try {
			Admin lastAdmin = super.findLastEntity(Admin.class, "ADMINS", "AdminID");
			Integer numberOfID = Integer.parseInt(lastAdmin.getAdminID().substring(2))+1;
			if(numberOfID<10) {
				return "AD0"+numberOfID;
			}
			return "AD"+numberOfID;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "AD01";
		}
			
	}
}
