package Service.impl;

import java.util.List;

import DAO.AdminDao;
import DAO.impl.AdminDaoImpl;
import Service.AdminService;
import models.Admin;

public class AdminServiceImpl implements AdminService {

	AdminDao dao;
	
	public AdminServiceImpl() {
		dao = new AdminDaoImpl();
	}
	
	@Override
	public Admin findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Admin findByFullName(String fullName) {
		return dao.findByFullName(fullName);
	}

	@Override
	public Admin findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public Admin findByUserNameAndPassword(String userName, String password) {
		return dao.findByUserNameAndPassword(userName, password);
	}

	@Override
	public List<Admin> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Admin> findAll(int pageNumber, int pageSize) {
		return findAll(pageNumber, pageSize);
	}

	@Override
	public Admin create(Admin admin) {
		admin.setAdminID(generationID());
		admin.setActive(true);
		return dao.create(admin);
	}

	@Override
	public Admin update(Admin admin) {
		return dao.update(admin);
	}

	@Override
	public Admin delete(Admin admin) {
		admin.setActive(false);
		return dao.update(admin);
	}

	@Override
	public String generationID() {
		return dao.generationID();
	}
	
}
