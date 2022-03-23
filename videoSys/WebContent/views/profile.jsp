<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Import Boostrap css, js, font awesome here -->
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

<LINK REL="stylesheet" HREF="<c:url value='/views/CSS/navbar.css'/>"
	TYPE="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<LINK REL="stylesheet" HREF="<c:url value='/views/CSS/profile.css'/>"
	TYPE="text/css">
<LINK REL="stylesheet" HREF="<c:url value='/views/CSS/table.css'/>"
	TYPE="text/css">
<title>VideoSys</title>
</head>
<body>
	<!-- navbar-->
	<c:choose>
		<c:when test="${empty sessionScope.admin && empty sessionScope.user}">
			<%@include file="../common/navbar_out.jsp"%>
		</c:when>
		<c:otherwise>
			<%@include file="../common/navbar_in.jsp"%>
		</c:otherwise>
	</c:choose>

	<div class="container">
		<div class="main-body">

			<!-- Breadcrumb -->
			<nav aria-label="breadcrumb" class="main-breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="../home/index">Home</a></li>
					<li class="breadcrumb-item"><a href="../user/edit?id=${sessionScope.user.userID}">User</a></li>
					<li class="breadcrumb-item active" aria-current="page">User
						Profile</li>
				</ol>
			</nav>
			<!-- /Breadcrumb -->

			<div class="row gutters-sm">
				<div class="col-md-4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<form action="../user/chooseImage?id=${currentUser.userID}"
									method="POST" enctype="multipart/form-data">
									<c:choose>
										<c:when test="${empty img.name}">
											<img src="<c:url value='/views/img/${currentUser.image}'/>"
												alt="Admin" class="rounded-circle" width="150" height="150">
											<input type="hidden" name="imgName"
												value="${currentUser.image}">
										</c:when>

										<c:otherwise>
											<img src="<c:url value='/views/img/${img.name}'/>"
												alt="Admin" class="rounded-circle" width="150" height="150">
											<input type="hidden" name="imgName" value="${img.name}">
										</c:otherwise>
									</c:choose>
									<div class="mt-3">
										<h4>${currentUser.fullName}</h4>
										<button class="btn btn-primary"
											onclick="document.getElementById('getFile').click()"
											type="button">Chọn Ảnh</button>
										<input type="file" id="getFile" style="display: none"
											name="userImage"
											value="<c:url value='/views/img/${currentUser.image}'/>"
											onchange="this.form.submit()">
									</div>
								</form>
							</div>
						</div>
					</div>
					<form method="POST" action="../user/edit?id=${currentUser.userID}"  id="edit">
					<div class="card mt-3">
						<ul class="list-group list-group-flush">
							<li
								class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
								<h6 class="mb-0">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round"
										class="feather feather-globe mr-2 icon-inline">
										<circle cx="12" cy="12" r="10"></circle>
										<line x1="2" y1="12" x2="22" y2="12"></line>
										<path
											d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z"></path></svg>
									Website
								</h6> <span class="text-secondary">https://videoSys.com</span>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
								<h6 class="mb-0">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round"
										class="feather feather-github mr-2 icon-inline">
										<path
											d="M9 19c-5 1.5-5-2.5-7-3m14 6v-3.87a3.37 3.37 0 0 0-.94-2.61c3.14-.35 6.44-1.54 6.44-7A5.44 5.44 0 0 0 20 4.77 5.07 5.07 0 0 0 19.91 1S18.73.65 16 2.48a13.38 13.38 0 0 0-7 0C6.27.65 5.09 1 5.09 1A5.07 5.07 0 0 0 5 4.77a5.44 5.44 0 0 0-1.5 3.78c0 5.42 3.3 6.61 6.44 7A3.37 3.37 0 0 0 9 18.13V22"></path></svg>
									Github
								</h6> <span class="text-secondary">https://github.com/Java4</span>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
								<h6 class="mb-0">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round"
										class="feather feather-twitter mr-2 icon-inline text-info">
										<path
											d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path></svg>
									Twitter
								</h6> <span class="text-secondary">https://twitter.com/videoSys</span>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
								<h6 class="mb-0">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round"
										class="feather feather-instagram mr-2 icon-inline text-danger">
										<rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect>
										<path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path>
										<line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line></svg>
									Instagram
								</h6> <span class="text-secondary">https://instagram/videoSys</span>
							</li>
							<li
								class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
								<h6 class="mb-0">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round"
										class="feather feather-facebook mr-2 icon-inline text-primary">
										<path
											d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path></svg>
									Facebook
								</h6> <span class="text-secondary">https://facebook/videoSys</span>
							</li>
						</ul>
					</div>
					
				</div>
				
				<div class="col-lg-8">
					<div class="card">
						<div class="card-body">
							<div class="row mb-3">
								<div class="col-sm-3">
									<h6 class="mb-0">User Name</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="text" class="form-control" name="userID"
										value="${currentUser.userID}" readonly="readonly">
								</div>
							</div>
							<div class="row mb-3">
								<div class="col-sm-3">
									<h6 class="mb-0">Full Name</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="text" class="form-control" id="fullName"
										name="fullName" value="${currentUser.fullName}"
										readonly="readonly">
								</div>
							</div>
							<div class="row mb-3">
								<div class="col-sm-3">
									<h6 class="mb-0">password</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="password" class="form-control" id="password"
										name="password" value="${currentUser.password}"
										readonly="readonly">
								</div>
							</div>
							<div class="row mb-3">
								<div class="col-sm-3">
									<h6 class="mb-0">email</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="text" class="form-control" id="email" name="email"
										value="${currentUser.email}" readonly="readonly">
								</div>
							</div>
							
							
								<div class="row">
									<div class="col-sm-3"></div>
									<div class="col-sm-9 text-secondary">
										<button type="button" onclick="edit(false)"
											class="btn btn-info btn-sm">Edit</button>
										<c:choose>
											<c:when test="${empty img.name}">

												<input type="hidden" name="imgName"
													value="${currentUser.image}">
											</c:when>

											<c:otherwise>

												<input type="hidden" name="imgName" value="${img.name}">
											</c:otherwise>
										</c:choose>
										<button type="button" onclick="edit(true)" id="update"
											class="btn btn-warning btn-sm" style="display: none">Update</button>

									</div>
								</div>
							

						</div>
					</div>
					<br>
					</form>
					<div class="row gutters-sm">
						<div class="col-sm-12 mb-3">
							<div class="card h-100">
								<div class="card-body">
									<h1 style="font-size: 16px !important;">Video Đã Like</h1>
									<div class="table">
										<table id="customers">
											<tr>
												<th>Tên Video</th>
												<th>Mô Tả</th>
												<th>Ngày Like</th>
												<th>Xem</th>
											</tr>
											<c:forEach items="${favoriteList}" var="item">
												<tr>
													<td>${item.video.title}</td>
													<td>${item.video.description}</td>
													<td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${item.likeDate}" /></td>
													<td><a href="../video/detail?id=${item.video.videoID}">Xem Phim</a></td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</div>
							</div>

						</div>
					</div>
					<div class="row gutters-sm">
						<div class="col-sm-12 mb-12">
							<div class="card h-100">
								<div class="card-body">
									<h1 style="font-size: 16px !important;">Video Đã Share</h1>
									<div class="table">
										<table id="customers">
											<tr>
												<th>Tên Video</th>
												<th>Ngày Share</th>
												<th>Email</th>
											</tr>
											<c:forEach items="${shareList}" var="item">
												<tr>
													<td>${item.video.title}</td>
													<td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${item.shareDate}" /></td>
													<td>${item.email}</td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</div>
							</div>

						</div>
						
					</div>
				
				</div>
				
			</div>
			
			<script type="text/javascript">
				function edit(flag) {
					if (flag == true) {
						var password = document.getElementById("password").value;
						var confirm = prompt("Xác nhận mật khẩu","");
						if(password==confirm) {
							document.getElementById("edit").submit();
						} else {
							alert("Cập nhật thất bại, 2 mật khẩu không trùng nhau");
						}
						document.getElementById("update").style.display = "none";
					} else {
						document.getElementById("update").style.display = "inline";
					}
					document.getElementById("fullName").readOnly = flag;
					document.getElementById("password").readOnly = flag;
					document.getElementById("email").readOnly = flag;
				}
				
				function checkPassword() {
					var password = document.getElementById("password").value();
					var confirm = prompt("Xác nhận mật khẩu","");
					if(password==confirm) {
						document.getElementById("edit").submit();
					}
				}
			</script>
</body>
</html>