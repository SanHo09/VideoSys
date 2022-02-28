package Service.impl;

import java.util.Date;
import java.util.List;

import DAO.CommentDao;
import DAO.impl.CommentDaoImpl;
import Service.CommentService;
import models.Comment;
import models.User;
import models.Video;

public class CommentServiceImpl implements CommentService {
 
	private CommentDao dao;
	
	public CommentServiceImpl() {
		dao = new CommentDaoImpl();
	}
	
	@Override
	public List<Comment> findByUserID(String userID) {
		// TODO Auto-generated method stub
		return dao.findByUserID(userID);
	}

	@Override
	public List<Comment> findByVideoID(String videoID) {
		// TODO Auto-generated method stub
		return dao.findByVideoID(videoID);
	}

	@Override
	public Comment findByUserIdAndVideoId(String userID, String videoID) {
		// TODO Auto-generated method stub
		return dao.findByUserIdAndVideoId(userID, videoID);
	}

	@Override
	public Comment create(User user, Video video, String content) {
		Comment comment = new Comment();
		comment.setUser(user);
		comment.setVideo(video);
		comment.setContent(content);
		comment.setCommentDate(new Date());
		return dao.create(comment);
	}

	@Override
	public Comment update(Comment comment) {
		return dao.update(comment);
	}

	@Override
	public Comment delete(Comment comment) {
		return dao.delete(comment);
	}

	@Override
	public Comment findByID(String id) {
		return dao.findById(id);
	}

}
