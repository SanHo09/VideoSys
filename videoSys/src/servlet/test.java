package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminDao;
import DAO.ShareDao;
import DAO.UserDao;
import DAO.impl.AdminDaoImpl;
import DAO.impl.FavoriteDaoImpl;
import DAO.impl.ShareDaoImpl;
import DAO.impl.UserDaoImpl;
import Service.AdminService;
import Service.impl.AdminServiceImpl;
import Service.impl.CommentServiceImpl;
import Service.impl.FavoriteServiceImpl;
import Service.impl.UserServiceImpl;
import Service.impl.VideoServiceImpl;
import models.Admin;
import models.Comment;
import models.Share;
import models.User;
import models.Video;


public class test {
	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
//		FavoriteDaoImpl Fdao = new FavoriteDaoImpl();
//		ShareDaoImpl sDao = new ShareDaoImpl();
//		sDao.findByEmail("helllo");
//		sDao.findAll(Share.class, false);
//		FavoriteServiceImpl f = new FavoriteServiceImpl();
//		VideoServiceImpl d = new VideoServiceImpl();
//		ShareDaoImpl daa = new ShareDaoImpl();
//		UserServiceImpl da = new UserServiceImpl();
//		AdminService aService = new AdminServiceImpl();
//		Admin user = new Admin();
//		user.setEmail("a");
//		user.setFullName("1");
//		user.setPassword("1");
//		aService.create(user);
		VideoServiceImpl vC = new VideoServiceImpl();
		UserServiceImpl uC = new UserServiceImpl();
		User user = uC.findById("US01");
		Video video = vC.findById("VD01");
		CommentServiceImpl cs = new CommentServiceImpl();
		cs.create(user, video, "+1 Phim Hay");
//		Comment c = cs.findByUserIdAndVideoId(user.getUserID(), video.getVideoID());
//		cs.delete(c);
	}
}
