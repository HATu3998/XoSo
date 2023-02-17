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
		
	<script src="PATH_TO_FILE/alertify.min.js"></script>
	<link rel="stylesheet" href="PATH_TO_FILE/alertify.css" />
	<link rel="stylesheet" href="PATH_TO_FILE/alertify.default.css" />
	
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="CSS/adminStyle.css">
<style><%@include file="./CSS/adminStyle.css"%>
	 
  body {
   background-image: url("img/earth-gd27792481_1920.jpg");
    
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
    <c:if test="${sessionScope.accAdmin == null}"><h3>Bạn không phải admin</h3></c:if>
    <c:if test="${sessionScope.accAdmin != null}">
      <h4>Nice Admin</h4>
      <ul class="nav nav-pills nav-stacked">
    
        <li class="active"><a href="adminPage.jsp">Home</a></li>
        <li><a href="PagingControl">Quản Lý Kết Quả</a></li>
        <li><a href="PangdingUser">Quản Lý Tài Khoản</a></li>
        <li><a href="Logout">Logout</a></li>
       
      </ul><br>
      <div class="input-group">
      <form action="search" method="get">
        <input type="text" name="txt" placeholder="Search.."  > </form>
      </div>
    </div>

    <div class="col-sm-9 imga">
      <h1 style="color:While;"><small>Dashboard</small></h1>
      <hr>
     
      
     

  
</div>


</div>

   

<footer class="bg-light text-center text-lg-start">

  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2022 Copyright:
    <a class="text-dark" href="#"></a>
  </div>
 
</footer>
</c:if>
</body>
</html>