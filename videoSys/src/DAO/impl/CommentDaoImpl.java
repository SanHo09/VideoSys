package DAO.impl;

import java.util.List;

import DAO.AbtractDao;
import DAO.CommentDao;
import models.Comment;
import models.Favorite;

public class CommentDaoImpl extends AbtractDao<Comment> implements CommentDao {

	@Override
	public List<Comment> findByUserID(String userID) {
		String jpql = "SELECT c FROM Comment WHERE c.user.userID=?0"
				+" ORDER BY c.commentDate DESC";
		return super.findMany(Comment.class, jpql, userID);
	}

	@Override
	public List<Comment> findByVideoID(String videoID) {
		String jpql = "SELECT c FROM Comment c WHERE c.video.videoID=?0"
				+" ORDER BY c.commentDate DESC";
		return super.findMany(Comment.class, jpql, videoID);
	}

	@Override
	public Comment findByUserIdAndVideoId(String userID, String videoID) {
		// TODO Auto-generated method stub
		String jpql = "SELECT c FROM Comment c WHERE c.user.userID=?0 AND c.video.videoID=?1"
				+" ORDER BY c.commentDate DESC";
		return super.findOne(Comment.class, jpql, userID, videoID);
	}

	@Override
	public Comment findById(String id) {
		// TODO Auto-generated method stub
		return super.findById(Comment.class, id);
	}
	
}
