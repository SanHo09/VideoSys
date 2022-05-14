<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>edit Video</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.pack.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap"
	rel="stylesheet">
<LINK REL="stylesheet"
	HREF="<c:url value='/views/admin/assets/css/bootstrap.css'/>"
	TYPE="text/css">
<LINK REL="stylesheet"
	HREF="<c:url value='/views/admin/assets/vendors/iconly/bold.css'/>"
	TYPE="text/css">
<LINK REL="stylesheet"
	HREF="<c:url value='/views/admin/assets/vendors/perfect-scrollbar/perfect-scrollbar.css'/>"
	TYPE="text/css">
<LINK REL="stylesheet"
	HREF="<c:url value='/views/admin/assets/vendors/bootstrap-icons/bootstrap-icons.css'/>"
	TYPE="text/css">
<LINK REL="stylesheet"
	HREF="<c:url value='/views/admin/assets/css/app.css'/>" TYPE="text/css">
<LINK REL="shortcut icon"
	HREF="<c:url value='/views/admin/assets/images/favicon.svg'/>"
	TYPE="text/css">

<LINK REL="stylesheet" HREF="<c:url value='/views/CSS/table.css'/>"
	TYPE="text/css">
</head>

<body>
	<div id="app">
		<div id="sidebar" class="active">
			<div class="sidebar-wrapper active">
				<div class="sidebar-header">
					<div class="d-flex justify-content-between">
						<div class="logo">
							<h1 class="logo me-auto me-lg-0" style="font-size: 30px">
								<a href="../home/index" class="logo-text"> <b>VideoSys</b>
								</a>
							</h1>
							<div class="toggler">
								<a href="#" class="sidebar-hide d-xl-none d-block"><i
									class="bi bi-x bi-middle"></i></a>
							</div>
						</div>
					</div>
				</div>
				<%@include file="../../common/dashBoard.jsp"%>
				
				<button class="sidebar-toggler btn x">
					<i data-feather="x"></i>
				</button>
			</div>
		</div>
		<div id="main">
			<header class="mb-3">
				<a href="#" class="burger-btn d-block d-xl-none"> <i
					class="bi bi-justify fs-3"></i>
				</a>
			</header>

			<div class="page-heading">
				<div class="page-title">
					<div class="row">
						<div class="col-12 col-md-6 order-md-1 order-last">
							<h3>Video</h3>
							<p class="text-subtitle text-muted">Cập nhật Video</p>
						</div>
						<div class="col-12 col-md-6 order-md-2 order-first">
							<nav aria-label="breadcrumb"
								class="breadcrumb-header float-start float-lg-end">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"></li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
				<section class="section">
					<div class="row">
						<div class="col-12 col-md-6"></div>
					</div>
				</section>
			</div>
			<!-- Content here -->
			<form action="../video/uploadFile?status='edit'" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="videoID" value="${currentVideo.videoID}">
			<div class="row">
				<div class="col-3">
					<c:choose>
						<c:when test="${empty img.name}">
							<img src="<c:url value='/views/img/${currentVideo.poster}' />" width="150px"height="230px"><br>
							<input type="hidden" value="${currentVideo.poster}" name="imgName">
							<small>${currentVideo.poster}</small>
						</c:when>
						
						<c:otherwise>
							<img src="<c:url value='/views/img/${img.name}' />" width="150px"height="230px"><br>
							<input type="hidden" value="${img.name}" name="imgName">
							<small>${img.name}</small>
						</c:otherwise>
					</c:choose>
					
					
					
					<br> <br>
					<input type="file" id="file" name="poster" onchange="this.form.submit()">
						
					
				</div>
				<div class="col-9">
					<span>Video Title: </span>
					<input type="text" name="txtTitle" value="${currentVideo.title}" class="videoInput" style="width: 100%" required="required"><br>
					<br> <span>Video Description: </span>
					<input type="text" name="txtDescription" value="${currentVideo.description}" class="videoInput" style="width: 100%"><br>
					<br> <span>Link: </span>
					<input type="text" name="txtLink" class="videoInput" value="https://www.youtube.com/watch?v=${currentVideo.link}" required="required" style="width: 100%"><br>
					<br>
					<button formaction="../video/edit" class="btnUpdate">Update</button>

				</div>
			</div>

			</form>

		</div>
	</div>
	<script type="text/javascript"></script>
	<script
		src="<c:url value='/views/admin/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js' />"></script>
	<script
		src="<c:url value='/views/admin/assets/js/bootstrap.bundle.min.jss' />"></script>
	<script src="<c:url value='/views/admin/assets/js/mazer.js' />"></script>
	
</body>

</html>
