<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <form action="/action_page.php" style="margin-left: 300px">
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
                        <a href="register.html" class="nav-link">Đăng Ký</a>
                    </li>
                    <li class="nav-item">
                        <a href="login.html" class="nav-link">Đăng Nhập</a>
                    </li>
                    <li class="nav-item">
                        <a href="admin/admin.html" class="nav-link">Quản lý</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>