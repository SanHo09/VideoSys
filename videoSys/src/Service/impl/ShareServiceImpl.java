package Service.impl;

import java.util.Date;
import java.util.List;

import DAO.ShareDao;
import DAO.impl.ShareDaoImpl;
import Service.ShareService;
import models.Share;

public class ShareServiceImpl implements ShareService {
	
	ShareDao dao;
	
	public ShareServiceImpl() {
		dao = new ShareDaoImpl();
	}
	
	@Override
	public List<Share> findByUserID(String userID) {
		return dao.findByUserID(userID);
	}

	@Override
	public List<Share> findByVideoID(String videoID) {
		return dao.findByVideoID(videoID);
	}

	@Override
	public List<Share> findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public Share findByUserIdAndVideoId(String userID, String videoID) {
		return dao.findByUserIdAndVideoId(userID, videoID);
	}

	@Override
	public Share create(Share share) {
		share.setShareID(generationID());
		share.setShareDate(new Date());
		return dao.create(share);
	}

	@Override
	public Share update(Share share) {
		return dao.update(share);
	}

	@Override
	public Share delete(Share share) {
		return dao.delete(share);
	}

	@Override
	public String generationID() {
		return dao.generationID();
	}
	
}
