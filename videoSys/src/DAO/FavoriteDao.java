package DAO;

import java.util.List;

import models.Favorite;
import models.User;

public interface FavoriteDao {
	public List<Favorite> findByUserID(String userID);
	public List<Favorite> findByVideoID(String videoID);
	public Favorite findByUserIdAndVideoId(String userID, String videoID);
	public Favorite create(Favorite favorite);
	public Favorite update(Favorite favorite);
	public Favorite delete(Favorite favorite);
	public String generationID();
}
