<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
    <LINK REL="stylesheet" HREF="<c:url value='/views/CSS/navbar.css'/>" TYPE="text/css">
    <title>Login</title>
</head>
<body>
    <%@include file="../common/navbar_out.jsp" %>
        <div class="container">
        <div class="box">
	        <form action="../account/changePassword?userID=${currentUser2.userID}" method="POST">
	            <h2>Chúng tôi đã gửi một mã PIN vào tài khoản của bạn</h2>
	            <p></p>
		            <div class="inputBox">
		                <input type="text" name="pin" required onkeyup="this.setAttribute('value', this.value);"  value="">
		                <label>Nhập mã PIN</label>
		            </div>
		            <div class="inputBox">
		                <input type="password" name="password" required onkeyup="this.setAttribute('value', this.value);"  value="">
		                <label>Nhập Mật khẩu mới</label>
		            </div>
		            <div class="inputBox">
		                <input type="password" name="confirm" required onkeyup="this.setAttribute('value', this.value);"  value="">
		                <label>Xác nhận khẩu mới</label>
		            </div>
		             <small style="color: red">${message }</small>
		            
		            <button type="submit" class="btn-submit">Đổi Mật Khẩu</button>
	        		
	        </form>
        </div>
    </div>

    <%@include file="../common/footer.jsp" %>

</body>
</html>