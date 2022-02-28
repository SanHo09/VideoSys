package Service.impl;

import java.util.List;

import DAO.VideoDao;
import DAO.impl.VideoDaoImpl;
import Service.VideoService;
import models.Video;

public class VideoServiceImpl implements VideoService {

	private VideoDao dao;
	
	public VideoServiceImpl() {
		dao = new VideoDaoImpl();
	}
	
	@Override
	public Video findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Video findByLink(String link) {
		return dao.findByLink(link);
	}

	@Override
	public List<Video> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}
	
	@Override
	public Video create(Video video) {
		video.setVideoID(generationID());
		video.setActive(Boolean.TRUE);
		video.setViews(0);
		return dao.create(video);
	}
	
	@Override
	public Video update(Video video) {
		video.setActive(Boolean.TRUE);
		return dao.update(video);
	}
	
	@Override
	public Video delete(String link) {
		Video video = dao.findByLink(link);
		video.setActive(false);
		return dao.update(video);
	}
	
	@Override
	public String generationID() {
		// TODO Auto-generated method stub
		return dao.generationID();
	}
}
