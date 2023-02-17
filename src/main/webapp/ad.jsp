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
    
        <li><a href="adminPage.jsp">Home</a></li>
        <li  class="active"><a href="PagingControl">Quản Lý Kết Quả</a></li>
        <li><a href="PangdingUser">Quản Lý Tài Khoản</a></li>
        <li><a href="Logout">Logout</a></li>
    
      </ul><br>
      <div class="input-group">
      <form action="search" method="get">
        <input type="text" name="txt" placeholder="Search.."  > </form>
      </div>
    </div>    </c:if>
 <c:if test="${sessionScope.accAdmin != null}">
    <div class="col-sm-9">
      <h4><small>Dashboard</small></h4>
      <hr>
     
      
     
 <div id="tab">
 <span class="tab-item active"><button type="button" class="btn btn-default">Dach Sách</button></span>
 <span class="tab-item"><button type="button" class="btn btn-default">Thêm Kết Quả</button></span>
 <span class="tab-item"><button type="button" class="btn btn-default">Thêm Tỉnh</button></span>
 <span class="tab-item"><button type="button" class="btn btn-default">Xóa</button></span>
 </div>
 
 <div id="tab-content" class="content-item">
 <table class="table">
    <thead>
      <tr>
        
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
     <c:forEach var="x" items="${listPage}">
      <tr>
        
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
    <td> 
    <button class="btn  UpdateButton" name="button" type="button"><a style="text-decoration: none" href="Update?sMaVe=${x.maVe}">
    Cập nhật</a></button></td>
 <td>
    
   <button class="btn deleteConfirm" button type="button" > <a style="text-decoration: none" href="delete?sMaVe=${x.maVe}">xóa</a></button>
        </td>
      </tr>
    </c:forEach>
   </tbody>
  </table>

</div>  
 
  
    <div id="tab-Update"  class="update-item"> 
  <form action="Update" method="get">
   <h2>Cập Nhật Kết Quả Xổ Số</h2>
   
    
    <div class="form-group">
  <label for="p">Mã Tỉnh</label>
     <select class="form-control" name="tinh" id="tinh">
    <c:forEach var="o" items="${listTinh}">
  <option  value="${o.maTinh}" selected>${o.tenTinh}--${o.maTinh}</option>
 
    </c:forEach>  </select>
    </div>
    <div class="form-group">
      <label for="p">Ngày</label>
      <input type="text" class="form-control" id="ngay" name="ngay" placeholder="Nhap Ngày">
    </div>
     <div class="form-group">
      <label for="p">Giải Tám</label>
      <input type="text" class="form-control" id="tam" name="tam"  placeholder="Nhap Số">
    </div>
    <div class="form-group">
      <label for="p">Giải Bảy</label>
      <input type="text" class="form-control" id="bay"  name="bay" placeholder="Nhap Số">
    </div>
    <div class="form-group">
      <label for="p">Giải Sáu</label>
      <input type="text" class="form-control" id="sau" name="sau"  placeholder="Nhap Số">
    </div>
    <div class="form-group">
      <label for="p">Giải Năm</label>
      <input type="text" class="form-control" id="nam" name="nam"  placeholder="Nhap Số">
    </div>
    <div class="form-group">
      <label for="p">Giải Bốn</label>
      <input type="text" class="form-control" id="bon"  name="bon"  placeholder="Nhap Số">
    </div>
    <div class="form-group">
      <label for="p">Giải Ba</label>
      <input type="text" class="form-control" id="ba" name="ba"  placeholder="Nhap Số">
    </div>
    <div class="form-group">
      <label for="p">Giải Hai</label>
      <input type="text" class="form-control" id="hai" name="hai"  placeholder="Nhap Số">
    </div>
    <div class="form-group">
      <label for="p">Giải Một</label>
      <input type="text" class="form-control" id="mot" name="mot"  placeholder="Nhap Số">
    </div>
    <div class="form-group">
      <label for="p">Giải DB</label>
      <input type="text" class="form-control" id="db" name="db"  placeholder="Nhap Số">
    </div>
    <button type="button" class="btn">Reset</button>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
         
     
    
    </tbody>
  </table>
  </div>
 
  

  

  
   <div class="content-item">
   <h2>Thêm Kết Quả Xổ Số</h2>
   <form action="add" method="post" onsubmit="return validateFormAdd()" name="form1">
   
    <div class="form-group">
    <label for="p">Mã Tỉnh</label>    
    <select class="form-control" name="tinh" id="tinh">
    <c:forEach var="o" items="${listTinh}">
  <option  value="${o.maTinh}" selected>${o.tenTinh}--${o.maTinh}</option>
 
    </c:forEach>  </select>
       
    </div>
    <div class="form-group">
      <label for="p">Ngày</label>
      <input type="text" class="form-control" name="ngay" id="ngay"  placeholder="Nhap Ngày" required>
    </div>
     <div class="form-group">
      <label for="p">Giải Tám</label>
      <input type="text" class="form-control" name="tam" id="tam" placeholder="Nhap Số" required>
    </div>
    <div class="form-group">
      <label for="p">Giải Bảy</label>
      <input type="text" class="form-control" name="bay" placeholder="Nhap Số" required>
    </div>
    <div class="form-group">
      <label for="p">Giải Sáu</label>
      <input type="text" class="form-control" name="sau" placeholder="Nhap Số" required>
    </div>
    <div class="form-group">
      <label for="p">Giải Năm</label>
      <input type="text" class="form-control" name="nam" placeholder="Nhap Số" required>
    </div>
    <div class="form-group">
      <label for="p">Giải Bốn</label>
      <input type="text" class="form-control" name="bon" placeholder="Nhap Số" required>
    </div>
    <div class="form-group">
      <label for="p">Giải Ba</label>
      <input type="text" class="form-control" name="ba" placeholder="Nhap Số" required>
    </div>
    <div class="form-group">
      <label for="p">Giải Hai</label>
      <input type="text" class="form-control" name="hai" placeholder="Nhap Số" required>
    </div>
    <div class="form-group">
      <label for="p">Giải Một</label>
      <input type="text" class="form-control" name="mot" placeholder="Nhap Số" required>
    </div>
    <div class="form-group">
      <label for="p">Giải DB</label>
      <input type="text" class="form-control" name="db" placeholder="Nhap Số" required>
    </div>
    <button type="button" class="btn">Reset</button>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
         </div>
         
         
   <div class="content-item">
<form  action="addControlTinh" method="post" onsubmit="return validateForm()" name="form1">
   <h2>Thêm Khu Vực</h2>
    <div class="form-group">
      <label for="e">Mã Tỉnh</label>
      <input type="text" class="form-control" id="matinh" name="matinh" placeholder="Nhap Ma Tinh">
    </div>
    <div class="form-group">
      <label for="p">Tên Tỉnh</label>
      <input type="text" class="form-control" id="tentinh" name="tentinh" placeholder="Nhap Ten Tinh">
    </div>
   <div class="form-group">
    <label for="p"> Miền</label>    
    <select class="form-control" name="tinh" id="tinh">

  <option  value="MB" selected>Miền Bắc</option>
    <option  value="MT" selected>Miền Trung</option>
      <option  value="MN" selected>Miền Nam</option>
 
      </select>
       
    </div>
 <button type="button" class="btn">Reset</button>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
 
 
  <div class="content-item">
  <h2>chọn phần tử xóa </h2>

  <form method="get"  action="delete" onclick="notify()">
<table class="table">
    <thead>
      <tr>
        <th>Chọn vé</th>
        <th>Mã vé</th>
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
    <c:forEach var="x" items="${listPage}">
      <tr>
        <td> <input type="checkbox" name="sMaVe" value="${x.maVe}" id="${x.maVe}"></td>
        <td><label for="${x.maVe}"><span></span>${x.maVe}</label></td>
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
        <td></td>
      </tr>
    </c:forEach>
    </tbody>
      </table>
      <button class="deleteConfirm" class="btn btn-primary" ><i class="fa fa-trash-o">Xóa</i></button>
   </form>
 </div>

  <nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:forEach begin="1" end="${a.getNumPage()}" var="x">
  
    <li class="page-item ${inde==x?"active":""}"><a class="page-link" href="PagingControl?index=${x}">${x}</a></li>

    </c:forEach>
     <li class="page-item"> <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>         
  
</div>
</div>

</div>

          

<footer class="bg-light text-center text-lg-start">

  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2022 Copyright:
    <a class="text-dark" href="#"></a>
  </div>
 
</footer></c:if>
</body>
</html>