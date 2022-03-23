package DAO.impl;

import java.util.List;

import DAO.AbtractDao;
import DAO.UserDao;
import models.Admin;
import models.User;

public class UserDaoImpl extends AbtractDao<User> implements UserDao {

	@Override
	public User findById(String id) {
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String jpql = "SELECT u FROM User u WHERE u.email=?0";
		return super.findOne(User.class, jpql, email);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		String jpql = "SELECT u FROM User u WHERE u.userID=?0 AND u.password=?1";
		return super.findOne(User.class, jpql, userName, password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findALL(User.class, true, pageNumber, pageSize);
	}

	@Override
	public String generationID() {
		try {
			User lastUser = super.findLastEntity(User.class, "USERS", "UserID");
			Integer numberOfID = Integer.parseInt(lastUser.getUserID().substring(2))+1;
			if(numberOfID<10) {
				return "US0"+numberOfID;
			}
			return "US"+numberOfID;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "US01";
		}	
	}
	

	
	

	
	
	
}
