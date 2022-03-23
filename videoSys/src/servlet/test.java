package servlet;

import java.awt.print.Pageable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
import Util.JpaUtil;
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
		VideoServiceImpl vService = new VideoServiceImpl();
//		ShareDaoImpl daa = new ShareDaoImpl();
		UserServiceImpl cService = new UserServiceImpl();
//		AdminService aService = new AdminServiceImpl();
//		Admin user = new Admin();
//		user.setEmail("a");
//		user.setFullName("1");
//		user.setPassword("1");
//		aService.create(user);
//		VideoServiceImpl vC = new VideoServiceImpl();
//		UserServiceImpl uC = new UserServiceImpl();
//		User user = uC.findById("US01");
//		Video video = vC.findById("VD01");
//		CommentServiceImpl cs = new CommentServiceImpl();
		//cs.create(user, video, "+1 Phim Hay");
//		Comment c = cs.findByUserIdAndVideoId(user.getUserID(), video.getVideoID());
//		cs.delete(c);
		//JpaUtil.sendEmail("sangpvps18851@fpt.edu.vn", "5qzKTbnhyhc", "Phạm Vĩnh Sang");
		List<Video> list = findALL(true);
	}
	
	public static List<Video> findALL(boolean existIsActive) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoSys");
		EntityManager em = emf.createEntityManager();
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT o FROM ").append("Video").append(" o");
		if(existIsActive==true) { 
			jpql.append(" WHERE o.active = 1");
		}
		Query query = em.createQuery(jpql.toString(), Video.class);
		query.setFirstResult(1);
		query.setMaxResults(6);
		return query.getResultList();
	}
}
