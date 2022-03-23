package DAO;

import java.util.List;

import models.Comment;
import models.Favorite;
import models.User;

public interface CommentDao {
	public Comment findById(int id);
	public List<Comment> findByUserID(String userID);
	public List<Comment> findByVideoID(String videoID);
	public Comment findByUserIdAndVideoId(String userID, String videoID);
	public Comment create(Comment comment);
	public Comment update(Comment comment);
	public Comment delete(Comment comment);
}
