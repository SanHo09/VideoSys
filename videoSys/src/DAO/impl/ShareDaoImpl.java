package DAO.impl;

import java.util.List;

import DAO.AbtractDao;
import DAO.ShareDao;
import models.Favorite;
import models.Share;

public class ShareDaoImpl extends AbtractDao<Share> implements ShareDao{

	@Override
	public List<Share> findByUserID(String userID) {
		String jpql = "SELECT s FROM Share s WHERE s.userID=?0 " +
				" ORDER BY s.shareDate DESC";
		return super.findMany(Share.class, jpql, userID);
	}

	@Override
	public List<Share> findByVideoID(String videoID) {
		String jpql = "SELECT s FROM Share s WHERE s.videoID=?0 " +
				" ORDER BY s.shareDate DESC";
		return super.findMany(Share.class, jpql, videoID);
	}

	@Override
	public List<Share> findByEmail(String email) {
		String jpql = "SELECT s FROM Share s WHERE s.email=?0 " +
				" ORDER BY s.shareDate DESC";
		return super.findMany(Share.class, jpql, email);
	}

	@Override
	public Share findByUserIdAndVideoId(String userID, String videoID) {
		String jpql = "SELECT s FROM Share s WHERE s.userID=?0 AND s.videoID=?1" +
				" ORDER BY s.shareDate DESC";
		return super.findOne(Share.class, jpql, userID, videoID);
	}
	
	@Override
	public String generationID() {
		try {
			Share lastShare = super.findLastEntity(Share.class,"SHARE", "ShareID");
			Integer numberOfID = Integer.parseInt(lastShare.getShareID())+1;
			if(numberOfID<10) {
				return "0"+numberOfID;
			}
			return numberOfID+"";
		} catch(Exception ex) {
			return "01";
		}
	}

}
