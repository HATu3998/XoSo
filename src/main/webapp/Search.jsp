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
        <th>Mã Vé</th>
        <th>Mã Tỉnh</th>
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
     <c:forEach var="x" items="${listTinh}">
      <tr>
        <td>${x.maVe}</td>
        <td>${x.maTinh}</td>
        <td>${x.ngay}</td>
        <td>${x.giaiTam}</td>
        <td>${x.giaiBay}</td>
        <td>${x.giaiSau}</td>
        <td>${x.giaiNam}</td>
        <td>${x.giaiBon}</td>
        <td>${x.giaiBa}</td>
        <td>${x.giaiHai}</td>
        <td>${x.giaiMot}</td>
        <td>${x.giaiDB}</td>
 
      </tr>
    </c:forEach>
    
     
    </tbody>
  </table>
    <button class="btn" type="button"><a href="PagingControl">Trở lại</a></button> 
</body>
</html>