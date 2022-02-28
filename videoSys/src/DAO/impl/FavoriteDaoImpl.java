package DAO.impl;

import java.util.List;

import DAO.AbtractDao;
import DAO.FavoriteDao;
import models.Favorite;

public class FavoriteDaoImpl extends AbtractDao<Favorite> implements FavoriteDao{

	@Override
	public List<Favorite> findByUserID(String userID) {
		String jpql = "SELECT f FROM Favorite f WHERE f.user.userID=?0"
				+" ORDER BY f.likeDate DESC";
		return super.findMany(Favorite.class, jpql, userID);
	}

	@Override
	public List<Favorite> findByVideoID(String videoID) {
		String jpql = "SELECT f FROM Favorite f WHERE f.video.videoID=?0"
				+" ORDER BY f.likeDate DESC";
		return super.findMany(Favorite.class, jpql, videoID);
	}

	@Override
	public Favorite findByUserIdAndVideoId(String userID, String videoID) {
		String jpql = "SELECT f FROM Favorite f WHERE f.user.userID=?0 AND f.video.videoID=?1"
				+" ORDER BY f.likeDate DESC";
		return super.findOne(Favorite.class, jpql, userID, videoID);
	}
	
	@Override
	public String generationID() {
		try {
			Favorite lastFavorite = super.findLastEntity(Favorite.class,"FAVORITE" , "FavoriteID");
			Integer numberOfID = Integer.parseInt(lastFavorite.getFavoriteID())+1;
			if(numberOfID<10) {
				return "0"+numberOfID;
			}
			return numberOfID+"";
		} catch(Exception ex) {
			return "01";
		}
	}
}
