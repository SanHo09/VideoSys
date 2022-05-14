package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;

import Service.impl.AdminServiceImpl;
import Service.impl.UserServiceImpl;
import Service.impl.VideoServiceImpl;
import models.Admin;
import models.User;
import models.Video;

public class testIndex extends HttpServlet{
	
	AdminServiceImpl aService = new AdminServiceImpl();
	UserServiceImpl uService = new UserServiceImpl();
	VideoServiceImpl vService = new VideoServiceImpl();
	Admin currentAdmin;
	Admin aExpected;
	int videoNumExpected;
	
	@Before 
	public void init() {
		aExpected = aService.findById("AD01");
		videoNumExpected = 10;
	}
	
	@Test
	public void testAdmin1() {
		System.out.println("User khong the co ID giong Admin");
		User user = uService.findById("AD01");
		assertEquals(aExpected, user);
	}
	
	
	@Test
	public void testAdmin2() {
		System.out.println("Dang nhap bang Admin");
		Admin admin = aService.findById("AD01");
		assertEquals(aExpected, admin);
	}
	
	@Test
	public void testvideoList1() {
		System.out.println("Kiem tra so luong video");
		List<Video> listVideo = vService.findAll();
		assertEquals(videoNumExpected, listVideo.size());
	}
	
	@Test
	public void testvideoList2() {
		System.out.println("Kiem tra so luong video");
		List<Video> listVideo = vService.findAll();
		assertEquals(videoNumExpected, listVideo.size()+1);
	}
}
