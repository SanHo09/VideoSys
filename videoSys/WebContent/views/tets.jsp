<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">       
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <LINK REL="stylesheet" HREF="<c:url value='/views/CSS/login.css'/>" TYPE="text/css">
    <LINK REL="stylesheet" HERF="<c:url value='/views/CSS/navbar.css'/>" TYPE="text/css">
    <title>Login</title>
</head>
<body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
        <div class="container-fluid">
            <a href="#" class="navbar-branch">
                <!--logo here-->
            </a>
            <h1 class="logo me-auto me-lg-0" style="padding-left: 20px;">
                <a href="index.html" class="logo-text">
                    <b>VideoSys</b>
                </a>
            </h1>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-reponsive">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="search-container">
                <form action="/action_page.php">
                  <input type="text" placeholder="Search.." name="search" id="search">
                  <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>

            <div class="collapse navbar-collapse" id="navbar-reponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a href="index.html" class="nav-link">Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a href="register.html" class="nav-link">Đăng Nhập</a>
                    </li>
                    <li class="nav-item">
                        <a href="login.html" class="nav-link">Đăng Ký</a>
                    </li>
                    <li class="nav-item">
                        <a href="admin/admin.html" class="nav-link">Quản Lý</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="box">
            <h2>Đăng Nhập</h2>
            <p></p>
            <form>
            <div class="inputBox">
                <input type="text" name="email" required onkeyup="this.setAttribute('value', this.value);"  value="">
                <label>Username</label>
            </div>
            <div class="inputBox">
                    <input type="text" name="text" required onkeyup="this.setAttribute('value', this.value);" value="">
                    <label>Password</label>
                </div>
            <button type="submit" class="btn-submit">Xác nhận</button>
            </form>
        </div>
    </div>

    <footer>
        <div class="container-fluid">
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
                    <p>Phim Lẻ</p>
                    <p>Phim Bộ</p>
                </div>

                <div class="col-md-4">
                    <br>
                    <br>
                    <h2>
                        Email liên hệ
                    </h2>
                    <p>myEmail@gmail.com</p>
                    <p>notmyEmail@gmail.com</p>
                </div>
            </div>
        </div>
    </footer>

</body>
</html>