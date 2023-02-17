<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="./CSS/display.css"%>

</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <ul class="nav navbar-nav">
    <li><a href="Login.jsp">Login</a></li>
    <li><a href="Register .jsp">Register</a></li>
  </ul>
  <p class="navbar-text"><a href="PagingIndex">Xổ Số</a></p>
</nav>


<div class="container">
	<div class="row">

        <h1>Kết Quả Xổ Số</h1>
        <h2 style="color:red">${error}</h2>

<table class="table table-hove  rtable">
  <thead>
    <tr>
        <th>Tỉnh</th>
        <th>Ngày</th>
        <th>Giải Tám</th>
        <th>Giải Bảy</th>
        <th>Giải Sáu</th>
        <th>Giải Năm</th>
        <th>Giải Bốn</th>
        <th>Giải Ba</th>
        <th>Giải Nhì</th>
        <th>Giải Nhất</th>
        <th>Giải Đặc Biệt</th>
    </tr>
  </thead>
  <tbody>
    
    
      <tr>
      
        <td>${listPage.tenTinh}</td>
        <td>${listPage.ngay}</td>
        <td>${listPage.giaiTam}</td>
        <td>${listPage.giaiBay}</td>
        <td>${listPage.giaiSau}</td>
        <td>${listPage.giaiNam}</td>
        <td>${listPage.giaiBon}</td>
        <td>${listPage.giaiBa}</td>
        <td>${listPage.giaiHai}</td>
        <td>${listPage.giaiMot}</td>
        <td>${listPage.giaiDB}</td> </tr>
   
  
  </tbody>
</table> 




</body>
</html>