package servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import Service.AdminService;
import Service.CommentService;
import Service.FavoriteService;
import Service.UserService;
import Service.VideoService;
import Service.impl.AdminServiceImpl;
import Service.impl.CommentServiceImpl;
import Service.impl.FavoriteServiceImpl;
import Service.impl.UserServiceImpl;
import Service.impl.VideoServiceImpl;
import models.Admin;
import models.Comment;
import models.Favorite;
import models.User;
import models.Video;
@MultipartConfig
@WebServlet({
		"/home/index",
		"/home/contact",
		"/account/sign-in",
		"/account/sign-up",
		"/account/sign-out",
		"/account/admin",
		"/account/edit",	
		"/account/insert",
		"/account/update",
		"/account/delete",
		"/account/accountList",
		"/video/edit",
		"/video/insert",
		"/video/update",
		"/video/delete",
		"/video/search",
		"/video/detail",
		"/video/like",
		"/video/share",
		"/video/videoList",
		"/video/uploadFile",
		"/comment/postComment"
		
})
public class runServlet extends HttpServlet {
	
	VideoService vService = new VideoServiceImpl();
	UserService uService = new UserServiceImpl();
	AdminService aService = new AdminServiceImpl();	
	FavoriteService fService = new FavoriteServiceImpl();
	CommentService cService = new CommentServiceImpl();
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if(uri.contains("index")) {
			doGetIndex(req, resp);
		} else if(uri.contains("sign-in")) {
			doGetlogin(req, resp);
		} else if(uri.contains("sign-up")) {
			doGetSignup(req, resp);
		} else if(uri.contains("sign-out")) {
			doGetSignout(req, resp);
		} else if(uri.contains("detail")) {
			doGetDetail(req,resp);
		} else if(uri.contains("admin")) {
			doGetAdmin(req, resp);
		} else if(uri.contains("videoList")) {
			doGetvideoList(req, resp);
		} else if(uri.contains("/video/insert")) {
			doGetInsertVideo(req, resp);
		} else if(uri.contains("/video/edit")) {
			doGetEditVideo(req, resp);
		} else if(uri.contains("/video/delete")) {
			doGetDeleteVideo(req, resp);
		} else if(uri.contains("accountList")) {
			doGetAccountList(req, resp);
		} else if(uri.contains("/account/insert")) {
			doGetInsertAccount(req, resp);
		} else if(uri.contains("/account/edit")) {
			doGetEditAccount(req, resp);
		} else if(uri.contains("/account/delete")) {
			doGetDeleteAccount(req, resp);
		} else {
			doGetIndex(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if(uri.contains("sign-in")) {
			doPostLogin(req, resp);
		} else if(uri.contains("sign-up")) {
			doPostSignup(req, resp);
		} else if(uri.contains("detail")) {
			doGetDetail(req,resp);
		} else if(uri.contains("like")) {
			doPostLike(req, resp);
		} else if(uri.contains("uploadFile")) {
			doPostUploadFile(req, resp);
		} else if(uri.contains("share")) {
			
		} else if(uri.contains("/video/insert")) {
			doPostInsertVideo(req, resp);
		} else if(uri.contains("/video/edit")) {
			doPostUpdateVideo(req, resp);
		} else if(uri.contains("/account/insert")) {
			doPostInsertAccount(req, resp);
		} else if(uri.contains("/account/edit")) {
			doPostEditAccount(req, resp);  
		} else if(uri.contains("/comment/postComment")) {
			doPostComment(req, resp);
		} else {
			doGetIndex(req, resp);
		}
	}
	
	protected void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Video> list = vService.findAll();
		req.setAttribute("videoList", list);
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}
	
	protected void doGetlogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	
	protected void doGetSignup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}
	
	protected void doGetSignout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getSession().invalidate();
		doGetlogin(req, resp);
	}
	
	protected void doGetDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Video video = vService.findById(id);
		List<Video> list = vService.findAll();
		List<Comment> commentList = cService.findByVideoID(id);
		try {
			if(!req.getSession().getAttribute("user").equals(null)) {
				User user = (User)req.getSession().getAttribute("user");
				video.setViews(video.getViews()+1);
				vService.update(video);
				Favorite favorite = fService.findByUserIdAndVideoId(user.getUserID(), video.getVideoID());
				req.setAttribute("favorite", favorite);
			}
		} catch(Exception ex) {
			
		}
		
		req.setAttribute("commentList", commentList);
		req.setAttribute("recomendList", list);
		req.setAttribute("video", video);
		req.getSession().setAttribute("video", video);
		req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
	}
	
	protected void doGetAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> userList = uService.findAll();
		List<Video> videoList = vService.findAll();
		req.setAttribute("userList", userList);
		req.setAttribute("videoList", videoList);
		req.getRequestDispatcher("/views/admin/admin.jsp").forward(req, resp);;
	}
	
	protected void doGetvideoList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> userList = uService.findAll();
		List<Video> videoList = vService.findAll();
		req.setAttribute("userList", userList);
		req.setAttribute("videoList", videoList);
		req.getRequestDispatcher("/views/admin/video_list.jsp").forward(req, resp);
	}
	
	protected void doGetAccountList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> accountList = uService.findAll();
		req.setAttribute("accountList", accountList);
		req.getRequestDispatcher("/views/admin/account_list.jsp").forward(req, resp);
	}
	
	protected void doGetInsertVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/admin/insertVideo.jsp").forward(req, resp);
	}
	
	protected void doGetInsertAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/admin/insertAccount.jsp").forward(req, resp);
	}
	
	protected void doGetEditVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("videoID");
		Video currentVideo = vService.findById(id);
		req.setAttribute("currentVideo", currentVideo);
		req.getRequestDispatcher("/views/admin/editVideo.jsp").forward(req, resp);
	}
	
	protected void doGetEditAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userID");
		User currentUser = uService.findById(id);	
		req.setAttribute("currentUser", currentUser);
		req.getRequestDispatcher("/views/admin/editAccount.jsp").forward(req, resp);
	}
	
	protected void doGetDeleteVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("videoID");
		Video currentVideo = vService.findById(id);
		vService.delete(currentVideo.getLink());
		doGetvideoList(req, resp);
	}
	
	
	protected void doGetDeleteAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userID");
		User currentUser = uService.findById(id);
		uService.delete(currentUser);
		doGetAccountList(req, resp);
	}
	
	protected void doPostLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("userID");
		String password = req.getParameter("password");
		User user = uService.findByUserNameAndPassword(userID, password);
		Admin admin = aService.findByUserNameAndPassword(userID, password);
		if(admin!=null) {
			req.getSession().setAttribute("admin", admin);
			doGetAdmin(req, resp);
			return;
		}
		if(user!=null) {
			req.getSession().setAttribute("user", user);
			doGetIndex(req, resp);
			return;
		}
		req.setAttribute("message", "*Sai tên đăng nhập hoặc mật khẩu");
		doGetlogin(req, resp);
	}
	
	protected void doPostSignup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID = req.getParameter("userID");
		String fullName = req.getParameter("fullName");
		String password = req.getParameter("password");
		String confirm = req.getParameter("conFirmPassword");
		String email = req.getParameter("email");
		
		List<User> list = uService.findAll();
		for(User i:list) {
			if(i.getUserID().equals(userID)) {
				req.setAttribute("message", "* Tài Khoản đã tồn tại");
				doGetSignup(req, resp);
				return;
			}
		}
		if(!password.equals(confirm)) {
			req.setAttribute("message", "* 2 mật khẩu không trùng nhau");
			doGetSignup(req, resp);
			return;
		} else {
			User user = new User();
			user.setUserID(userID);
			user.setFullName(fullName);
			user.setEmail(email);
			user.setPassword(password);
			uService.create(user);
			doGetlogin(req, resp);	
			return;
		}		
	}
	
	protected void doPostLike(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = (User)req.getSession().getAttribute("user");
			Video video = (Video)req.getSession().getAttribute("video");
			Favorite favorite = fService.findByUserIdAndVideoId(user.getUserID(), video.getVideoID());
			if(favorite==null) {
				fService.create(user, video);
			} else {
				fService.delete(fService.findByUserIdAndVideoId(user.getUserID(), video.getVideoID()));
			}
		} catch(Exception ex) {
			
		}
		resp.setStatus(204);
	}
	
	protected void doPostUploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File dir = new File("C:\\Users\\Sang\\Desktop\\FPT_Poly\\spring2022\\java4\\VideoSys\\Java4\\videoSys\\WebContent\\views\\img");
		Part photo = req.getPart("poster");
		File PhotoFile = new File(dir, photo.getSubmittedFileName());		
		photo.write(PhotoFile.getAbsolutePath());
		req.setAttribute("img", PhotoFile);
		String uri = req.getRequestURI();
		if(uri.contains("edit")) {
			doGetEditVideo(req, resp);
		} else {
			doGetInsertVideo(req, resp);
		}
	}
	
	protected void doPostInsertVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("txtTitle");
		String poster = req.getParameter("imgName");
		String description = req.getParameter("txtDescription");
		String link = req.getParameter("txtLink").split("=")[1];
		System.out.println(link);
		Video video = new Video();
		video.setPoster(poster);
		video.setTitle(title);
		video.setDescription(description);
		video.setLink(link);
		vService.create(video);
		doGetvideoList(req, resp);
	}
	
	protected void doPostUpdateVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("videoID");
		String title = req.getParameter("txtTitle");
		String poster = req.getParameter("imgName");
		String description = req.getParameter("txtDescription");
		String link = req.getParameter("txtLink").split("=")[1];
		Video  currentVideo = vService.findById(id);
		System.out.println(link);
		Video video = new Video();
		video.setViews(currentVideo.getViews());
		video.setVideoID(id);
		video.setPoster(poster);
		video.setTitle(title);
		video.setDescription(description);
		video.setLink(link);
		vService.update(video);
		doGetvideoList(req, resp);
	}
	
	
	
	protected void doPostInsertAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		User user = new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());
			uService.create(user);
			doGetAccountList(req, resp);
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
	}
	
	protected void doPostEditAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("userID");
		String pw = req.getParameter("password");
		String email = req.getParameter("email");
		String fullName = req.getParameter("fullName");
		User user = uService.findById(id);
		user.setUserID(user.getUserID());
		user.setPassword(pw);
		user.setEmail(email);
		user.setFullName(fullName);
		uService.update(user);
		doGetAccountList(req, resp);
	}
	
	protected void doPostComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String content = req.getParameter("content");
		if(content.length()>8) { 
			try {
				User user = (User)req.getSession().getAttribute("user");
				Video video = (Video)req.getSession().getAttribute("video");
				Comment comment = new Comment();
				comment.setUser(user);
				comment.setVideo(video);
				comment.setContent(content);
				cService.create(user, video, content);
			} catch (Exception ex) {
				
			}
		} else {
			req.setAttribute("Để tránh bị Spam vui Lòng nhập bình luận lớn hơn 8 ký tự", "commentMessage");
		}
		doGetDetail(req, resp);
	}
	
	
}
