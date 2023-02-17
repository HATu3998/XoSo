<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-latest.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/styles/metro/notify-metro.css" />
	
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="CSS/adminStyle.css">

<style><%@include file="./CSS/adminStyle.css"%>
<%@include file="./CSS/UserStyle.css"%>
td
{
    padding:0 15px;
}
</style>
    <jsp:useBean id="a" class="XoSoDAO.DAO" scope="request"></jsp:useBean>

</head>
<body>
<script type="text/javascript">
<%@include file="./js/js-admin.js"%>
</script>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Nice Admin</h4>
      <ul class="nav nav-pills nav-stacked">
        <li ><a href="adminPage.jsp">Home</a></li>
        <li><a href="PagingControl">Quản Lý Kết Quả</a></li>
        <li><a href="PangdingUser">Quản Lý Tài Khoản</a></li>
         <li><a href="Logout">Logout</a></li>
       
      </ul><br>
      <div class="input-group">
      <form action="SearchUser" method="get">
        <input type="text" name="txt" placeholder="Search.."  > </form>
      </div>
    </div>

    <div class="col-sm-9">
      <h4><small>Dashboard</small></h4>
      <hr>
    
 
 <div id="tab-content" class="content-item">
 <div class="register-form">
                    <form action="UpdateUser" method="post">
                        <h1>Cập nhật tài khoản</h1>
                        <div class="input-box">
  <label for="p">Mã Tài Khoản</label>
                            <input type="text" name="sid" placeholder="mã user" value="${updat.maUser}" readonly>
                        </div>
                        <div class="input-box">
  <label for="p">Tên Tài Khoản</label>
                            <input type="text" name="stk" placeholder="Nhập username" value="${updat.taiKhoanKH}" readonly>
                        </div>
                        <div class="input-box">
  <label for="p">Mật Khẩu</label>
                            <input type="password" name="smk" placeholder="Nhập mật khẩu" value="${updat.matKhau}" readonly>
                        </div>
                       <div class="input-box">
  <label for="p">Họ tên</label>
                            <input type="text" name="shoten" placeholder="Nhập họ tên" value="${updat.hoTen}">
                        </div>
                        <div class="input-box">
  <label for="p">Địa Chỉ</label>
                            <input type="text" name="sdiachi" placeholder="Nhập địa chỉ" value="${updat.diaChi}">
                        </div>
                        <div class="input-box">
  <label for="p">SDT</label>
                            <input type="text" name="sSdt" placeholder="Nhập SDT" value="${updat.sdt}">
                        </div>
                         <div class="input-box">
    <label for="p">Chọn loại tài khoản</label>    
    <select class="form-control" name="ad" id="ad">
  
  <option  value="1" selected>Admin</option>
    <option  value="0" selected>Khách hàng</option>
 
    </select>
       
    </div>
                        
                        <div class="btn-box">
                            <button type="submit">
                                Cập nhật
                            </button>
                        </div>
                    </form>
                </div></div>  
 







 </div> </div>
   </div>

<footer class="bg-light text-center text-lg-start">

  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2022 Copyright:
    <a class="text-dark" href="#"></a>
  </div>
 
</footer>
</body>
</html>