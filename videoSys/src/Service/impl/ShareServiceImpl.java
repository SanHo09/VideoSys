package Service.impl;

import java.util.List;

import Service.ShareService;
import models.Share;

public class ShareServiceImpl implements ShareService {
	
	ShareService dao;
	
	public ShareServiceImpl() {
		dao = new ShareServiceImpl();
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
