package DAO;

import java.util.List;

import DAO.impl.UserDaoImpl;
import models.User;
import models.Video;

public interface VideoDao {
	public Video findById(String id);
	public Video findByLink(String link);
	public List<Video> findAll();
	public List<Video> findAll(int pageNumber, int pageSize);
	public Video create(Video video);
	public Video update(Video video);
	public Video delete(Video video);
	public String generationID();
}
