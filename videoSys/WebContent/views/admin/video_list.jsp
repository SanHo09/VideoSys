<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Alert - Mazer Admin Dashboard</title>

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
							<h3>Danh Sách Video</h3>
							<p class="text-subtitle text-muted">Quản lý danh sách video</p>
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

			<div class="edit">
				<button class="btn-create">
					<a href="../video/insert" style="color: white;"><span class="btn-plus">+</span>New</a>
				</button>
			</div>
			<div class="table">
				<table id="customers">
					<tr>
						<th>Video ID</th>
						<th>Title</th>
						<th>Poster</th>
						<th>Views</th>
						<th>Description</th>
						<th>link</th>
						<th>edit</th>
					</tr>
					<c:forEach items="${videoList}" var="item">
						<tr>
							<td>${item.videoID}</td>
							<td>${item.title}</td>
							<td>${item.poster}</td>
							<td>${item.views}</td>
							<td>${item.description}</td>
							<td>${item.link}</td>
							<td>
								<div class="menu-nav">
									<div class="dropdown-container" tabindex="-1">
										<div class="three-dots"></div>
										<div class="dropdown">
											<button class="btn-edit" onclick="setID()">
												<a href="../video/edit?videoID=${item.videoID}"
													style="color: black"> Edit </a>
											</button>
											<button class="btn-edit">
												<a href="../video/delete?videoID=${item.videoID}" onclick="if (!confirm('Bạn có chắc muốn xóa video này ?')) return false;" style="color: black" > Delete </a>
											</button>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<input type="hidden" name="id" value="" id="takeID">

			</div>



		</div>
	</div>
	<script
		src="<c:url value='/views/admin/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js' />"></script>
	<script
		src="<c:url value='/views/admin/assets/js/bootstrap.bundle.min.jss' />"></script>
	<script src="<c:url value='/views/admin/assets/js/mazer.js' />"></script>

</body>

</html>
