package Service.impl;

import java.util.Date;
import java.util.List;

import DAO.FavoriteDao;
import DAO.impl.FavoriteDaoImpl;
import Service.FavoriteService;
import models.Favorite;
import models.User;
import models.Video;

public class FavoriteServiceImpl implements FavoriteService {
	
	private FavoriteDao dao;
	public FavoriteServiceImpl() {
		 dao = new FavoriteDaoImpl();
	}
	
	@Override
	public List<Favorite> findByUserID(String userID) {
		return dao.findByUserID(userID);
	}

	@Override
	public List<Favorite> findByVideoID(String videoID) {
		// TODO Auto-generated method stub
		return dao.findByVideoID(videoID);
	}

	@Override
	public Favorite findByUserIdAndVideoId(String userID, String videoID) {
		// TODO Auto-generated method stub
		return dao.findByUserIdAndVideoId(userID, videoID);
	}

	@Override
	public Favorite create(User user, Video video) {
		// TODO Auto-generated method stub/
		Favorite favorite = new Favorite();
		favorite.setFavoriteID(generationID());
		favorite.setUser(user);
		favorite.setVideo(video);
		favorite.setLikeDate(new Date());
		return dao.create(favorite);
	}
	
	@Override
	public Favorite update(Favorite favorite) {
		// TODO Auto-generated method stub
		return dao.update(favorite);
	}

	@Override
	public Favorite delete(Favorite favorite) {
		return dao.delete(favorite);
	}
	
	@Override
	public String generationID() {
		// TODO Auto-generated method stub
		return dao.generationID();
	}
	
}
