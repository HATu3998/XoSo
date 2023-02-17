<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-latest.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/styles/metro/notify-metro.css" />
	
	<script src="PATH_TO_FILE/alertify.min.js"></script>
	<link rel="stylesheet" href="PATH_TO_FILE/alertify.css" />
	<link rel="stylesheet" href="PATH_TO_FILE/alertify.default.css" />
<link rel ="stylesheet" href="CSS/adminStyle.css">

<style><%@include file="./CSS/adminStyle.css"%></style>
</head>
<body><h1>đây là kết quả tìm kiếm</h1>
<table class="table">
    <thead>
      <tr>
        <th>Mã User</th>
        <th>Tài Khoản</th>
        <th>Họ Tên</th>
        <th>Địa Chỉ</th>
        <th>SDT</th>
      </tr>
    </thead>
     <c:forEach var="x" items="${listS}">
      <tr>
        <td>${x.maUser}</td>
        <td>${x.taiKhoanKH}</td>
        <td>${x.hoTen}</td>
        <td>${x.diaChi}</td>
        <td>${x.sdt}</td>
      
      </tr>
    </c:forEach>
     </tbody> </table>
    <button class="btn" type="button"><a href="PangdingUser">Trở lại</a></button> 
</body>
</html>