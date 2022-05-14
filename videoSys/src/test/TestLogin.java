package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Service.impl.UserServiceImpl;
import models.User;

public class TestLogin {
	UserServiceImpl uDao = new UserServiceImpl();
	// Du lieu Test
	
	@Test
	public void testLogin1() {
		System.out.println("Test Khi ko nhap tai khoan");
		User user = uDao.findByUserNameAndPassword("", "123456");
		assertEquals(uDao.findById(""), null);
	}
	
	@Test
	public void testLogin2() {
		System.out.println("Test Khi ko nhap mat khau");
		User user = uDao.findByUserNameAndPassword("US01", "");
		assertEquals(uDao.findById(""), null);
	}
	
	@Test
	public void testLogin3() {
		System.out.println("Test Khi nhap dung");
		User user = uDao.findByUserNameAndPassword("US01", "123456789");
		assertEquals(uDao.findById("US01"), user);
	}
	
	
	
	
	
}
