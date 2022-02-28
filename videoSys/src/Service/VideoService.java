package Service;

import java.util.List;

import models.Video;

public interface VideoService {
	public Video findById(String id);
	public Video findByLink(String link);
	public List<Video> findAll();
	public List<Video> findAll(int pageNumber, int pageSize);
	public Video create(Video video);
	public Video update(Video video);
	public Video delete(String link);
	public String generationID();
}
