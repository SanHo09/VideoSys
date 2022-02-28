<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<LINK REL="stylesheet" HREF="<c:url value='/views/CSS/detail.css'/>"
	TYPE="text/css">
<LINK REL="stylesheet" HREF="<c:url value='/views/CSS/navbar.css'/>"
	TYPE="text/css">
<title>Details</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.admin && empty sessionScope.user}">
			<%@include file="../common/navbar_out.jsp"%>
		</c:when>
		<c:otherwise>
			<%@include file="../common/navbar_in.jsp"%>
		</c:otherwise>
	</c:choose>
	<!--content-->
	<div class="container">
		<div class="row">
			<!--Video-->
			<div class="col-8" id="video">
				<div class="embed-responsive embed-responsive-21by9">
					<iframe width="580" height="335"
						src="https://www.youtube.com/embed/${video.link}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>
				<br>
				<h3>${video.title }</h3>
				<br>
				<!-- views, like, share,... -->
				<div class="container">
					<div class="col-12" id="left">
						<div class="row">
							<div class="col-4">
								<span>${video.views} Views 25 Dec 2020</span>
							</div>
							<div class="col-8">
								<div class="bg-white">
									<div class="d-flex flex-row fs-12">
										<c:choose>
											<c:when test="${favorite.user.userID!=null}">
												<form action="../video/like" method="POST">
													<div class="like p-2 cursor">
														<button type="submit">
															<i class="fa fa-thumbs-o-up" id="like"
																onclick="setLike();" style="color: blue"><span
																class="ml-1">Like</span></i>
														</button>
													</div>
												</form>
											</c:when>
											<c:otherwise>
												<form action="../video/like" method="POST">
													<div class="like p-2 cursor">
														<button type="submit">
															<i class="fa fa-thumbs-o-up" id="like"
																onclick="setLike();" style="color: black"><span
																class="ml-1">Like</span></i>
														</button>
													</div>
												</form>
											</c:otherwise>
										</c:choose>
										<div class="like p-2 cursor">
											<i class="fa fa-commenting-o"><span class="ml-1">Comment</span></i>
										</div>
										<div class="like p-2 cursor">
											<button type="submit" formaction="../video/share">
												<i class="fa fa-share"><span class="ml-1">Share</span></i>
											</button>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<!--commet-->
				<c:choose>
			    	<c:when test="${not empty sessionScope.user}">
			    		<div class="bg-light p-2">
							<form action="../comment/postComment?id=${video.videoID}" method="POST">
								<div class="d-flex flex-row align-items-start">
									<img class="rounded-circle" src="https://i.imgur.com/RpzrMR2.jpg"
										width="40">
									<textarea class="form-control ml-1 shadow-none textarea" name="content" value="${commentMessage }"></textarea>
								</div>
								<div class="mt-2 text-right">
									<button class="btn btn-primary btn-sm shadow-none" type="submit">Post
										comment</button>
									<button class="btn btn-outline-primary btn-sm ml-1 shadow-none"
										type="button">Cancel</button>
								</div>
							</form>
						</div>
			    	</c:when>
			    	<c:otherwise>
			    		<h3>Đăng Nhập để được bình luận</h3>
			    	</c:otherwise>
			    </c:choose>
				
				<hr>

				<div class="row d-flex justify-content-center mt-100 mb-100">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body text-center">
								<h4 class="card-title">Latest Comments</h4>
							</div>
							<div class="comment-widgets">
								<!-- Comment Row -->
								<c:forEach items="${commentList}" var="i">
									<div class="d-flex flex-row comment-row m-t-0">
									<div class="p-2">
										<img src="https://i.imgur.com/Ur43esv.jpg" alt="user"
											width="50" class="rounded-circle">
									</div>
									<div class="comment-text w-100">
										<h6 class="font-medium">${i.user.fullName}</h6>
										<span class="m-b-15 d-block">${i.content}</span>	
										<div class="comment-footer">
											<span class="text-muted float-right">${i.commentDate}</span>
											<button type="button" class="btn btn-cyan btn-sm">Edit</button>
											<button type="button" class="btn btn-success btn-sm">Publish</button>
											<button type="button" class="btn btn-danger btn-sm">Delete</button>
										</div>
									</div>
								</div>
								</c:forEach>
								
								<!-- Comment Row -->
								
							</div>
							<!-- Card -->
						</div>
					</div>
				</div>

			</div>
			<!--Recomend-->

			<div class="col-4" style="background-color: white; margin-top: 50px;"
				id="recomend">
				<c:forEach items="${recomendList}" var="i">
					<c:choose>
						<c:when test="${i.videoID!=video.videoID}">
							<div class="thumbnail">
								<div class="row">
									<!--thumbnail img-->
									<div class="col-6">
										<a href="../video/detail?id=${i.videoID}" class=""> <img
											src="<c:url value='/views/img/${i.poster}' />" width="168px"
											height="200px">
										</a>
									</div>
									<div class="col-6">
										<a href="../video/detail?id=${i.videoID}" class="">
											<div class="thumbnail">
												<span>${i.title}</span><br> <small>${i.description}</small><br>
												<small>${i.views} views </small>
											</div>
										</a>
									</div>
								</div>
							</div>
						</c:when>
					</c:choose>

				</c:forEach>
			</div>



		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@include file="../common/footer.jsp"%>
	<script type="text/javascript">
		function setLike() {
			var like = document.getElementById("like");

			console.log(like)
			if (like.style.color == "black") {
				like.style.color = "blue";

			} else {
				like.style.color = "black";
			}

		}
	</script>
</body>
</html>