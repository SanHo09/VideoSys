package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Service.impl.UserServiceImpl;
import Service.impl.VideoServiceImpl;
import models.User;
import models.Video;

public class testAdmin {
	VideoServiceImpl vService = new VideoServiceImpl();
	UserServiceImpl uDao = new UserServiceImpl();
	Video expectedVideo1 = new Video();
	@Test
	public void testThemVideo1() { //test Them duoc
		// Tao video 
		Video video = new Video();
		video.setTitle("title1");
		video.setPoster("poster1");
		video.setDescription("description 1");
		video.setLink("http:link1");
		vService.create(video);
		// kiem tra xem video da duoc them hay chua
		Video currentVideo = vService.findByLink("http:link1");
		assertEquals(expectedVideo1, currentVideo);
		vService.create(video);
	}
	
	@Test
	public void testThemVideo2() { // test ko them duoc	
		// Tao video 
		Video video = new Video();
		video.setTitle("");
		video.setPoster("poster1");
		video.setDescription("description 1");
		video.setLink("");
		vService.create(video);
	}
	
	@Test
	public void testThemUser1() {
		System.out.println("Test them user khi khong nhap UserName");
		User user = new User();
		user.setUserID("");
		user.setPassword("123456");
		user.setEmail("anguyen@gmail.com");
		user.setFullName("Nguyen Van A");
		user.setActive(true);
		uDao.create(user);
	}
	
	@Test
	public void testThemUser2() {
		System.out.println("Test them user khi khong nhap Mat Khau");
		User user = new User();
		user.setUserID("US01");
		user.setPassword("");
		user.setEmail("anguyen@gmail.com");
		user.setFullName("Nguyen Van A");
		user.setActive(true);
		uDao.create(user);
	}
	
	@Test
	public void testThemUser3() {
		System.out.println("Test them user khi nhap thanh cong");
		User user = new User();
		user.setUserID("USTest2");
		user.setPassword("123456");
		user.setEmail("anguyen@gmail.com");
		user.setFullName("Nguyen Van A");
		user.setActive(true);
		uDao.create(user);
	}
	
	
	
}