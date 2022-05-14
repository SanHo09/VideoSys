package servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

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
import Service.ShareService;
import Service.UserService;
import Service.VideoService;
import Service.impl.AdminServiceImpl;
import Service.impl.CommentServiceImpl;
import Service.impl.FavoriteServiceImpl;
import Service.impl.ShareServiceImpl;
import Service.impl.UserServiceImpl;
import Service.impl.VideoServiceImpl;
import Util.JpaUtil;
import models.Admin;
import models.Comment;
import models.Favorite;
import models.Share;
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
		"/account/uploadFile",
		"/video/videoList",
		"/video/uploadFile",
		"/comment/postComment",
		"/comment/edit",
		"/comment/delete",
		"/user/edit",
		"/user/chooseImage",
		"/account/forgotPassword",
		"/account/changePassword"
})
public class runServlet extends HttpServlet {
	
	VideoService vService = new VideoServiceImpl();
	UserService uService = new UserServiceImpl();
	AdminService aService = new AdminServiceImpl();	
	FavoriteService fService = new FavoriteServiceImpl();
	CommentService cService = new CommentServiceImpl();
	ShareService sScerice = new ShareServiceImpl();
	int VIDEO_MAX_PAGE_SIZE = 6;
	
	
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
		} else if(uri.contains("/user/edit")) {
			doGetProfile(req, resp);
		} else if(uri.contains("/user/chooseImage")) {
			doPostChooseFileUser(req, resp);
		} else if(uri.contains("/account/forgotPassword")) {
			doGetForgotPassword(req, resp);
		} else if(uri.contains("/account/changePassword")) {
			doGetChangePassword(req, resp);
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
			doPostShareVideo(req, resp);
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
		} else if(uri.contains("/comment/edit")) {
			doPostEditComment(req, resp);
		}  else if(uri.contains("/comment/delete")) {
			doPostDeleteComment(req, resp);
		} else if(uri.contains("/user/chooseImage")) {
			doPostChooseFileUser(req, resp);
		} else if(uri.contains("/user/edit")) {
			doPostEditUser(req,resp);
		} else if(uri.contains("/account/changePassword")) {
			doPostChangePassword(req, resp);
		} else {
			doGetIndex(req, resp);
		}
	}
	
	protected void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Số Trang Web
		List<Video> countVideo = vService.findAll();
		int maxPage = (int)Math.ceil(countVideo.size()/(double)VIDEO_MAX_PAGE_SIZE);
		System.out.println(maxPage);
		req.setAttribute("maxPage", maxPage);
		// số video trong trang tương ứng
		List<Video> listVideo;
		String page = req.getParameter("page");
		if(page==null) {
			listVideo = vService.findAll();
			req.setAttribute("currentPage", 1);
		} else {
			listVideo = vService.findAll();
			req.setAttribute("currentPage", Integer.valueOf(page));
		}
		
		req.setAttribute("videoList", listVideo);
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
			ex.printStackTrace();
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
		req.getRequestDispatcher("/views/admin/admin.jsp").forward(req, resp);
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
		System.out.println(currentUser.getImage());
		req.setAttribute("currentUser", currentUser);
		req.getRequestDispatcher("/views/admin/editAccount.jsp").forward(req, resp);
	}
	
	protected void doGetDeleteVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("videoID");
		Video currentVideo = vService.findById(id);
		vService.delete(currentVideo.getVideoID());
		doGetvideoList(req, resp);
	}
	
	
	protected void doGetDeleteAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userID");
		User currentUser = uService.findById(id);
		uService.delete(currentUser);
		doGetAccountList(req, resp);
	}
	
	protected void doGetProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User currentUser = uService.findById(id);
		req.setAttribute("favoriteList", currentUser.getFavorites());
		req.setAttribute("shareList", currentUser.getShares());
		req.setAttribute("currentUser", currentUser);
		req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
	}
	
	
	
	protected void doPostLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("userID");
		String password = req.getParameter("password");
		User user = uService.findByUserNameAndPassword(userID, password);
		Admin admin = aService.findByUserNameAndPassword(userID, password);
		if(admin!=null) {
			req.getSession().setAttribute("admin", admin);
			List<Admin> adminList = aService.findAll();
			req.setAttribute("adminList", adminList);
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
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
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
		if(userID.length()<6) {
			req.setAttribute("message", "* Tài khoản phải có độ dài lớn hơn 6");
			doGetSignup(req, resp);
			return;
		} else if(password.length()<6) {
			req.setAttribute("message", "* mật khẩu phải có độ dài lớn hơn 6");
			doGetSignup(req, resp);
			return;
		} if(!password.equals(confirm)) {
			req.setAttribute("message", "* 2 mật khẩu không trùng nhau");
			doGetSignup(req, resp);
			return;
		} else {
			try {
				User user = new User();
				user.setUserID(userID);
				user.setFullName(fullName);
				user.setEmail(email);
				user.setPassword(password);
				user.setImage("userProfile.jpg");
				uService.create(user);
				doGetlogin(req, resp);	
				return;
			} catch(Exception ex) {
				
			}
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
		String status = req.getParameter("status");
		System.out.println(uri);
		if(uri.contains("/videoSys/video")) {
			if(status.contains("edit")) {
				doGetEditVideo(req, resp);
			} else {
				doGetInsertVideo(req, resp);
			}
		} else {
			if(status.contains("edit")) {
				doGetEditAccount(req, resp);
			} else {
				doGetInsertAccount(req, resp);
			}
		}
	}
	
	protected void doPostChooseFileUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File dir = new File("C:\\Users\\Sang\\Desktop\\FPT_Poly\\spring2022\\java4\\VideoSys\\Java4\\videoSys\\WebContent\\views\\img");
		Part photo = req.getPart("userImage");
		System.out.println("ok");
		System.out.println(photo.getSubmittedFileName());
		File PhotoFile = new File(dir, photo.getSubmittedFileName());		
		photo.write(PhotoFile.getAbsolutePath());
		req.setAttribute("img", PhotoFile);
		doGetProfile(req, resp);
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
		video.setVideoID(vService.generationID());
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
		try {
			vService.update(video);
		} catch(Exception ex)  {
			ex.printStackTrace();
		}
		doGetvideoList(req, resp);
	}
	
	
	
	protected void doPostInsertAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		User user = new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());
			user.setUserID(uService.generationID());
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
		String image = req.getParameter("imgName");
		User user = uService.findById(id);
		user.setUserID(user.getUserID());
		user.setPassword(pw);
		user.setEmail(email);
		user.setFullName(fullName);
		user.setImage(image);
		uService.update(user);
		doGetAccountList(req, resp);
	}
	
	protected void doPostComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String content = req.getParameter("content");
		if(content.length()>3) { 
			try {
				User user = (User)req.getSession().getAttribute("user");
				Video video = (Video)req.getSession().getAttribute("video");
				Comment comment = new Comment();
				comment.setUser(user);
				comment.setVideo(video);
				comment.setContent(content);
				cService.create(user, video, content);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			req.setAttribute("Để tránh bị Spam vui Lòng nhập bình luận lớn hơn 8 ký tự", "commentMessage");
		}
		doGetDetail(req, resp);
	}
	
	protected void doPostEditComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String content = req.getParameter("editContent");
		String id = req.getParameter("cmtId");
		Comment comment = cService.findByID(Integer.parseInt(id));
		comment.setContent(content);
		cService.update(comment);
		doGetDetail(req, resp);
	}
	
	protected void doPostDeleteComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("cmtId");
		Comment comment = cService.findByID(Integer.parseInt(id));
		cService.delete(comment);
		doGetDetail(req, resp);
	}
	
	protected void doPostShareVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		User user = (User)req.getSession().getAttribute("user");
		Video video = (Video)req.getSession().getAttribute("video");
		if(!req.getSession().getAttribute("user").equals(null)) { 
			JpaUtil.sendEmail(email, video.getLink(), user.getFullName());
			Share share = new Share();
			share.setUser(user);
			share.setVideo(video);
			share.setEmail(email);
			sScerice.create(share);
		}
		resp.setStatus(204);
	}
	
	protected void doPostEditUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("userID");
		System.out.println(id);
		String pw = req.getParameter("password");
		String email = req.getParameter("email");
		System.out.println(email);
		String fullName = req.getParameter("fullName");
		String image = req.getParameter("imgName");
		User user = uService.findById(id);
		user.setUserID(user.getUserID());
		user.setPassword(pw);
		user.setEmail(email);
		user.setFullName(fullName);
		user.setImage(image);
		uService.update(user);
		doGetProfile(req, resp);
	}
	
	protected void doGetForgotPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forGotPassword.jsp").forward(req, resp);
	}
	String PIN = "";
	protected void doGetChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("userID");
		System.out.println(userID);
		User user;
		this.PIN = randomString();
		if(userID==null||userID.equals("")) {
			req.setAttribute("message", "Vui lòng nhập tài khoản");
			doGetForgotPassword(req, resp);
			return;
		}
			user = uService.findById(userID);
			JpaUtil.sendCodeEmail(user.getEmail(), PIN);
			req.setAttribute("currentUser2", user);
			req.getRequestDispatcher("/views/changePassword.jsp").forward(req, resp);
		
	}
	
	protected void doPostChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String currentUser = req.getParameter("userID");
		User user = uService.findById(currentUser);
		System.out.println(user.getUserID());
		String password = req.getParameter("password");
		String confirm = req.getParameter("confirm");
		String pin = req.getParameter("pin");
		
		if(!password.contains(confirm)) {
			req.setAttribute("message", "Mật khẩu không trùng nhau");
			req.getRequestDispatcher("/views/changePassword.jsp").forward(req, resp);
		} else if(!this.PIN.equals(pin)) {
			req.setAttribute("message", "Sai mã PIN");
			req.getRequestDispatcher("/views/changePassword.jsp").forward(req, resp);
		} else {
			user.setPassword(password);
			uService.update(user);
			doGetlogin(req, resp);
		}
		
	}
	
	private String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        
        System.out.println(generatedString);
        return generatedString;
    }
	
}
