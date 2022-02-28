<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Import Boostrap css, js, font awesome here -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">       
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <LINK REL="stylesheet" HREF="<c:url value='/views/CSS/index.css'/>" TYPE="text/css">
    <LINK REL="stylesheet" HREF="<c:url value='/views/CSS/navbar.css'/>" TYPE="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>VideoSys</title>
</head>
<body>
    <!-- navbar-->
    <c:choose>
    	<c:when test="${empty sessionScope.admin && empty sessionScope.user}">
    		<%@include file="../common/navbar_out.jsp" %> 
    	</c:when>
    	<c:otherwise>
    		<%@include file="../common/navbar_in.jsp" %>
    	</c:otherwise>
    </c:choose>
    
        <!--Carousel-->
    <div id="slides" class="carousel slide" data-ride="carousel">
        <ul class="carousel-indicators">
            <li data-target="#slides" data-slide-to="0" class="active"></li>
            <li data-target="#slides" data-slide-to="1"></li>
            <li data-target="#slides" data-slide-to="2"></li>
            <li data-target="#slides" data-slide-to="3"></li>
        </ul>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://wallpapercave.com/wp/wp6897018.jpg">
                <div class="carousel-caption">
                    <h1 class="display2">VideoSys</h1>
                    <h3>Xem video miễn phí, nhanh chóng</h3>
                    <form action="../account/sign-in" >
	                    <button type="submit" formaction="../home/contact" class="btn btn-outline-light btn-lg" button>
	                        Liên Hệ      
	                    </button>
	                    <button type="submit" class="btn btn-primary btn-lg">
	                        Đăng Nhập
	                    </button>
	                </form>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://www.wallpapertip.com/wmimgs/91-916500_movie-poster.jpg">
                <div class="carousel-caption">
                    <h1 class="display2">VideoSys</h1>
                    <h3>Xem video miễn phí, nhanh chóng</h3>
                    <form action="../account/sign-in" >
	                    <button type="submit" formaction="../home/contact" class="btn btn-outline-light btn-lg" button>
	                        Liên Hệ      
	                    </button>
	                    <button type="submit" class="btn btn-primary btn-lg">
	                        Đăng Nhập
	                    </button>
	                </form>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://wallpapercave.com/wp/V3zePuM.jpg">
                <div class="carousel-caption">
                    <h1 class="display2">VideoSys</h1>
                    <h3>Xem video miễn phí, nhanh chóng</h3>
                    <form action="../account/sign-in" >
	                    <button type="submit" formaction="../home/contact" class="btn btn-outline-light btn-lg" button>
	                        Liên Hệ      
	                    </button>
	                    <button type="submit" class="btn btn-primary btn-lg">
	                        Đăng Nhập
	                    </button>
	                </form>
                </div>
            </div>
            <div class="carousel-item">
                <img src="http://cdn.wallpaperhi.com/1920x1080/20120307/transformers%20movies%20film%20movie%20posters%201920x1080%20wallpaper_www.wallpaperhi.com_33.jpg">
                <div class="carousel-caption">
                    <h1 class="display2">VideoSys</h1>
                    <h3>Xem video miễn phí, nhanh chóng</h3>
                   <form action="../account/sign-in" >
	                    <button type="submit" formaction="../home/contact" class="btn btn-outline-light btn-lg" button>
	                        Liên Hệ      
	                    </button>
	                    <button type="submit" class="btn btn-primary btn-lg">
	                        Đăng Nhập
	                    </button>
	                </form>
                </div>
            </div>
            
        </div>
    </div>
    <!--content-->
    <div class="container-fluid padding" style="margin-top: 50px !important;" id="content">
        <div class="row welcome text-center">
            <div class="col-12">
                <h1 class="display-4">
                   	Video mới cập nhật
                </h1>
            </div>
            <hr>
        </div>
        
    </div>
    <!-- list product -->
    <div class="container">
        <div class="row" id="card-group">
        	<c:forEach items="${videoList}" var="video">
        		<div class="card" style="width: 18rem;">
	                <a href="" class="">
	                    <img class="card-img-top" src="<c:url value='/views/img/${video.poster}'/>" height="400px" width="250px" alt="Card image cap">
	                </a>
	                <div class="card-body">
	                <h5 class="card-title">${video.title}</h5>
	                <p class="card-text">Lượt xem: ${video.views} <i class="fa fa-eye"></i></p>
	                <a href="../video/detail?id=${video.videoID}" class="btn btn-primary">Xem Phim</a>
	                <a href="../video/share?id=${video.videoID}" class="btn btn-primary" id="share">Chia sẻ</a>
	                </div>
	            </div>
        	</c:forEach>
            

        </div>
        <br>
        <div class="button-group">
            <button class="control"><<</button>
            <button class="control">>></button>
        </div>
        <hr class="short">
    </div>
    <!--Contact-->
    <div class="container-fluid padding">
        <div class="row text-center padding">
            <div class="col-12">
                <h2>Liên Hệ</h2>
            </div>
            <div class="col-12 social padding">
                <a href="#" id=""><li class="fab fa-facebook"></li></a>
                <a href="#" id=""><li class="fab fa-google-plus"></li></a>
                <a href="#" id=""><li class="fab fa-instagram"></li></a>
                <a href="#" id=""><li class="fab fa-youtube"></li></a>
            </div>
        </div>
    </div>
    <footer>
        <div class="container-fluid padding">
            <div class="row text-center">
                <div class="col-md-4">
                    <h1>
                        <a href="#" class="logo-text" >
                            <b>VideoSys</b>
                        </a>
                    </h1>
                    <hr class="light">
                    <p>111-222-333</p>
                    <p>myEmail@gmail.com</p>
                    <p>123, silicon valey, US</p>
                </div>

                
                <div class="col-md-4">
                    <br>
                    <br>
                    <h2>
                        Phim Mới
                    </h2>
                    <p>Phim lẻ</p>
                    <p>Phim bộ</p>
                </div>

                <div class="col-md-4">
                    <br>
                    <br>
                    <h2>
                        Email Liên Hệ
                    </h2>
                    <p>myEmail@gmail.com</p>
                    <p>notmyEmail@gmail.com</p>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>