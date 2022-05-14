package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Service.impl.UserServiceImpl;
import Service.impl.VideoServiceImpl;
import models.User;
import models.Video;

public class TestVideoDetail {
	VideoServiceImpl vdao = new VideoServiceImpl();
	int videoRecommendExpected;
	Video videoExpected;
	@Before
	public void init() {
		videoRecommendExpected = 9;
		videoExpected = vdao.findById("VD01");
	}
	
	
	@Test
	public void testRecomendList1() {
		System.out.println("Test Recomend List 1");
		List<Video> list = vdao.findAll();
		assertEquals(videoRecommendExpected, list.size());
	}
	
	@Test
	public void testRecomendList2() {
		System.out.println("Test Recomend List 2");
		List<Video> list = vdao.findAll();
		assertEquals(videoRecommendExpected, list.size()-1);
	}
	
	@Test
	public void testCurrentVideo1()  {
		System.out.println("Test current video 1");
		Video currentVideo = vdao.findByLink("https://www.youtube.com/watch?v=iQspI-Lf11k");
		assertEquals(videoExpected, currentVideo);
	}
	
	@Test
	public void testCurrentVideo2()  {
		System.out.println("Test current video 1");
		Video currentVideo = vdao.findByLink("https://www.youtube.com/watch?v=iQspI-Lf11k".split("=")[1]);
		assertEquals(videoExpected, currentVideo);
	}

}
	
	
