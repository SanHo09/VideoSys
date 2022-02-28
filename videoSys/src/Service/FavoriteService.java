package Service;

import java.util.List;

import models.Favorite;
import models.User;
import models.Video;

public interface FavoriteService {
	public List<Favorite> findByUserID(String userID);
	public List<Favorite> findByVideoID(String videoID);
	public Favorite findByUserIdAndVideoId(String userID, String videoID);
	public Favorite create(User user, Video video);
	public Favorite update(Favorite favorite);
	public Favorite delete(Favorite favorite);
	public String generationID();
}
