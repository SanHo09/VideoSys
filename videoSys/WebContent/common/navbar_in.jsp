<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!-- navbar-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
	<div class="container-fluid">
		<a href="#" class="navbar-branch"> <!--logo here-->
		</a>
		<h1 class="logo me-auto me-lg-0" style="padding-left: 20px;">
			<a href="../home/index" class="logo-text" style="text-decoration: none !important;"> <b>VideoSys</b>
			</a>
		</h1>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbar-reponsive">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- 
		<div class="search-container">
			<form action="/action_page.php">
				<input type="text" placeholder="Search.." name="search" id="search">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
		 -->

		<div class="collapse navbar-collapse" id="navbar-reponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a href="../home/index"class="nav-link">Trang Chủ</a></li>

				<c:choose>
					<c:when test="${empty sessionScope.user}">
						<li><a href="../account/admin" class="nav-link">Quản lý</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item active"><a href="../user/edit?id=${sessionScope.user.userID}"class="nav-link">Tài Khoản</a></li>
					</c:otherwise>
				</c:choose>

				<li><a href="../account/sign-out" class="nav-link">Đăng Xuất</a></li>

			</ul>
		</div>
	</div>
</nav>