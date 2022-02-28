package Service;

import java.util.List;

import models.Share;

public interface ShareService {
	public List<Share> findByUserID(String userID);
	public List<Share> findByVideoID(String videoID);
	public List<Share> findByEmail(String email);
	public Share findByUserIdAndVideoId(String userID, String videoID);
	public Share create(Share share);
	public Share update(Share share);
	public Share delete(Share share);
	public String generationID();
}
