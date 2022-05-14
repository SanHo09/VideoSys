package test;

import org.junit.Test;

import Service.impl.UserServiceImpl;
import models.User;

public class TestSignIn {
	UserServiceImpl uDao = new UserServiceImpl();
	@Test
	public void signIn1() {
		System.out.println("Test sign Up khi khong nhap UserName");
		User user = new User();
		user.setUserID("");
		user.setPassword("123456");
		user.setEmail("anguyen@gmail.com");
		user.setFullName("Nguyen Van A");
		user.setActive(true);
		uDao.create(user);
	}
	
	@Test
	public void signIn2() {
		System.out.println("Test sign Up khi khong nhap Mat Khau");
		User user = new User();
		user.setUserID("US01");
		user.setPassword("");
		user.setEmail("anguyen@gmail.com");
		user.setFullName("Nguyen Van A");
		user.setActive(true);
		uDao.create(user);
	}
	
	@Test
	public void signIn3() {
		System.out.println("Test sign Up khi nhap thanh cong");
		User user = new User();
		user.setUserID("USTest");
		user.setPassword("123456");
		user.setEmail("anguyen@gmail.com");
		user.setFullName("Nguyen Van A");
		user.setActive(true);
		uDao.create(user);
	}
}
