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
                    <form action="Update" method="post">
                        <h1>Cập nhật Kết Quả</h1>
                      <div class="form-group">
  <label for="p">Mã Tỉnh</label>
     <select class="form-control" name="tinh" id="tinh">
    <c:forEach var="o" items="${listTinh}">
  <option  value="${o.maTinh}" selected>${o.tenTinh}--${o.maTinh}</option>
 
    </c:forEach>  </select>
    </div>
     <div class="form-group">
     
      <input type="hidden" class="form-control" id="sMaVe" name="sMaVe"  value="${updat.maVe}">
    </div>
     <div class="form-group">
      <label for="p">Ngày</label>
      <input type="text" class="form-control" id="ngay" name="ngay" placeholder="${updat.ngay}"">
    </div>
     <div class="form-group">
      <label for="p">Giải Tám</label>
      <input type="text" class="form-control" id="tam" name="tam" placeholder="${updat.giaiTam}" >
    </div>
    <div class="form-group">
      <label for="p">Giải Bảy</label>
      <input type="text" class="form-control" id="bay" name="bay" placeholder="${updat.giaiBay}">
    </div>
    <div class="form-group">
      <label for="p">Giải Sáu</label>
      <input type="text" class="form-control" id="sau" name="sau" placeholder="${updat.giaiSau}" >
    </div>
    <div class="form-group">
      <label for="p">Giải Năm</label>
      <input type="text" class="form-control" id="nam" name="nam" placeholder="${updat.giaiNam}">
    </div>
    <div class="form-group">
      <label for="p">Giải Bốn</label>
      <input type="text" class="form-control" id="bon" name="bon" placeholder="${updat.giaiBon}" >
    </div>
    <div class="form-group">
      <label for="p">Giải Ba</label>
      <input type="text" class="form-control" id="ba" name="ba" placeholder="${updat.giaiBa}" >
    </div>
    <div class="form-group">
      <label for="p">Giải Hai</label>
      <input type="text" class="form-control" id="hai" name="hai" placeholder="${updat.giaiHai}" >
    </div>
    <div class="form-group">
      <label for="p">Giải Một</label>
      <input type="text" class="form-control" id="mot" name="mot" placeholder="${updat.giaiMot}" >
    </div>
    <div class="form-group">
      <label for="p">Giải DB</label>
      <input type="text" class="form-control" id="db" name="db" placeholder="${updat.giaiDB}" >
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