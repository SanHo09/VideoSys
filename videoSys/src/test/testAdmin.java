package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Service.impl.VideoServiceImpl;
import models.Video;

public class testAdmin {
	VideoServiceImpl vService = new VideoServiceImpl();
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
	
	
	
}