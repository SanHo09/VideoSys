package Service;

import java.util.List;

import models.Comment;
import models.User;
import models.Video;

public interface CommentService {
	public List<Comment> findByUserID(String userID);
	public List<Comment> findByVideoID(String videoID);
	public Comment findByUserIdAndVideoId(String userID, String videoID);
	public Comment create(User user, Video video, String content);
	public Comment update(Comment comment);
	public Comment delete(Comment comment);
	public Comment findByID(int id);
}
