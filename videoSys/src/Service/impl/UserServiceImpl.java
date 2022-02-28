package Service.impl;

import java.util.List;

import DAO.UserDao;
import DAO.impl.UserDaoImpl;
import Service.UserService;
import models.User;

public class UserServiceImpl implements UserService {

		
	UserDao dao = new UserDaoImpl();
	
	@Override
	public User findById(String id) {
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		return dao.findByUserNameAndPassword(userName, password);
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public User create(User user) {
		user.setActive(true);
		return dao.create(user);
	}

	@Override
	public User update(User user) {
		user.setActive(Boolean.TRUE);
		return dao.update(user);
	}

	@Override
	public User delete(User user) {
		user.setActive(false);
		return dao.update(user);
	}

	@Override
	public String generationID() {
		return dao.generationID();
	}

}
