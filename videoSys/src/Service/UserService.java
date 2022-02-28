package Service;

import java.util.List;

import models.User;

public interface UserService {
	public User findById(String id);
	public User findByEmail(String email);
	public User findByUserNameAndPassword(String userName, String password);
	public List<User> findAll();
	public List<User> findAll(int pageNumber, int pageSize);
	public User create(User user);
	public User update(User user);
	public User delete(User user);
	public String generationID();
}
