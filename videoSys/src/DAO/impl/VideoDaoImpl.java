package DAO.impl;

import java.util.List;

import DAO.AbtractDao;
import DAO.VideoDao;
import models.Admin;
import models.Video;

public class VideoDaoImpl extends AbtractDao<Video> implements VideoDao{

	@Override
	public Video findById(String id) {
		return super.findById(Video.class ,id);
	}

	@Override
	public Video findByLink(String link) {
		String jpql = "SELECT v FROM Video v WHERE v.link=?0";
		return super.findOne(Video.class, jpql, link);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return super.findALL(Video.class, true, pageNumber, pageSize);
	}
	
	@Override
	public String generationID() {
		try {
			Video lastVideo = super.findLastEntity(Video.class, "VIDEO", "videoID");
			Integer numberOfID = Integer.parseInt(lastVideo.getVideoID().substring(2))+1;
			if(numberOfID<10) {
				return "VD0"+numberOfID;
			}
			return "VD"+numberOfID;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "VD01";
		}
			
	}
}
