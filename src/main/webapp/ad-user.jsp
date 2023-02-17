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
     <c:if test="${sessionScope.accAdmin == null}"><h3>Bạn không phải admin</h3></c:if>
    <c:if test="${sessionScope.accAdmin != null}">
      <h4>Nice Admin</h4>
      <ul class="nav nav-pills nav-stacked">
        
        <li ><a href="adminPage.jsp">Home</a></li>
        <li><a href="PagingControl">Quản Lý Kết Quả</a></li>
        <li class="active"class="active"><a href="PangdingUser">Quản Lý Tài Khoản</a></li>
        <li><a href="Logout">Logout</a></li>
       
      </ul><br>
      <div class="input-group">
      <form action="SearchUser" method="get">
        <input type="text" name="txt" placeholder="Search.."  > </form>
      </div>
    </div></c:if>
 <c:if test="${sessionScope.accAdmin != null}">
    <div class="col-sm-9">
      <h4><small>Dashboard</small></h4>
      <hr>
      <div id="tab">
 <span class="tab-item active"><button type="button" class="btn btn-default">Danh Sách</button></span>
 <span class="tab-item"><button type="button" class="btn btn-default">Thêm Tài Khoản</button></span>
 <span class="tab-item"><button type="button" class="btn btn-default">Cập nhật Admin</button></span>
 <span class="tab-item"><button type="button" class="btn btn-default">Đổi mật khẩu</button></span>
  <span class="tab-item"><button type="button" class="btn btn-default">Xóa</button></span>
  <h2 style="color:red">${error}</h2>
 </div>
 
 <div id="tab-content" class="content-item">
 <table class="table">
    <thead>
      <tr>
        <th>Mã User</th>
        <th>Tài Khoản</th>
        <th>Họ Tên</th>
        <th>Địa Chỉ</th>
        <th>SDT</th>
        <th>Phân loại</th>
       
      </tr>
    </thead>
     <c:forEach var="x" items="${listPage}">
      <tr>
        <td>${x.maUser}</td>
        <td>${x.taiKhoanKH}</td>
        <td>${x.hoTen}</td>
        <td>${x.diaChi}</td>
        <td>${x.sdt}</td>
        <td>
<c:if test="${x.isAdmin==1}">  <p>  <c:out value = "admin"/><p></c:if>
<c:if test="${x.isAdmin==0}">  <p>  <c:out value = "Khách"/><p></c:if>
</td>
        
       <td> 
   <button class="btn  UpdateButton" name="button" type="button"><a style="text-decoration: none" href="UpdateUser?sMaVe=${x.maUser}&&stk=${x.taiKhoanKH}">
    Cập nhật</a></button>
    
   <button class="btn deleteConfirm" type="button" > <a style="text-decoration: none" href="deleteUser?sMaVe=${x.maUser}">xóa</a></button>
        </td>
      </tr>
    </c:forEach>
     </tbody> </table></div>  
 


     
   <div id="tab-Update"  class="update-item"> 
  <div class="register-form">
                    <form action="" method="post">
                        <h1>Cập nhật tài khoản</h1>
                        <div class="input-box">

                            <input type="text" placeholder="mã user">
                        </div>
                        <div class="input-box">

                            <input type="text" placeholder="Nhập username">
                        </div>
                        <div class="input-box">

                            <input type="password" placeholder="Nhập mật khẩu">
                        </div>
                       <div class="input-box">

                            <input type="text" placeholder="Nhập họ tên">
                        </div>
                        <div class="input-box">

                            <input type="text" placeholder="Nhập địa chỉ">
                        </div>
                        <div class="input-box">

                            <input type="text" placeholder="Nhập SDT">
                        </div>
                        
                        
                        <div class="btn-box">
                            <button type="submit">
                                Đăng ký
                            </button>
                        </div>
                        
                    </form>
                </div>
  </div>     
 



 <div class="content-item">
   <h2>Thêm Tài Khoản </h2>
   <form action="addUser" method="post" name="form1" onsubmit="return validateUser()" >
   <div class="form-group">
      <label for="p">Tài Khoản</label>
      <input type="text" class="form-control" name="tk"  placeholder="Nhap tài khoản">
    </div>
     <div class="form-group">
      <label for="p">Mật Khẩu</label>
      <input type="password" class="form-control" name="mk" placeholder="Nhap mật khẩu">
    </div>
    <div class="form-group">
      <label for="p">Họ Tên</label>
      <input type="text" class="form-control" name="ht" placeholder="Nhap họ tên">
    </div>
    <div class="form-group">
      <label for="p">Địa Chỉ</label>
      <input type="text" class="form-control" name="dc" placeholder="Nhap địa chỉ">
    </div>
    <div class="form-group">
      <label for="p">SDT</label>
      <input type="text" class="form-control" name="sdt" placeholder="Nhap Số điện thoại">
    </div>
     <div class="form-group">
      <label for="p">Mặc định tài khoản tạo là tài khoản khách </label>
      <input type="hidden" class="form-control" name="isUser" placeholder="Tài khoản khách" value="0"  readonly>
    </div>
   
    <button type="button" class="btn">Reset</button>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
         </div>
         
         <div class="content-item">
   <h2>Cập nhật tài khoản </h2>
   <p>${error}</p>
   <form action="isAdmin" method="post" name="form1">
  <div class="form-group">
      <label for="p">Tài Khoản</label>
      <input type="text" class="form-control" name="tk"  placeholder="Nhap tài khoản">
    </div>
     
   <div class="form-group">
    <label for="p">Chọn loại tài khoản</label>    
    <select class="form-control" name="ad" id="ad">
  
  <option  value="1" selected>Admin</option>
    <option  value="0" selected>Khách hàng</option>
 
    </select>
       
    </div>
    <button type="button" class="btn">Reset</button>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
         </div>
         
         
         
   <div class="content-item">
 <h2>Đổi mật khẩu </h2>
   <form action="SendMailP" method="post" name="form1">
   <div class="form-group">
      <label for="p">Tài Khoản</label>
      <input type="text" class="form-control" name="tk"  placeholder="Nhap tài khoản">
    </div>
    
    <button type="button" class="btn">Reset</button>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
 </div>
 
  <div class="content-item">
  <h2>chọn phần tử xóa</h2>
  <form method="get"  action="deleListUser" onclick="notify()">
<table class="table">
    <thead>
      <tr>
        <th>Chọn vé</th>
       <th>Tài Khoản</th>
        <th>Họ Tên</th>
        <th>Địa Chỉ</th>
        <th>SDT</th>
        <th>Phân loại</th>
      </tr>
    </thead>
    <c:forEach var="x" items="${listPage}">
      <tr>
        <td> <input type="checkbox" name="sMaVe" value="${x.maUser}" id="${x.maUser}"></td>
        <td>${x.taiKhoanKH}</td>
        <td>${x.hoTen}</td>
        <td>${x.diaChi}</td>
        <td>${x.sdt}</td>
        <td>
<c:if test="${x.isAdmin==1}">  <p>  <c:out value = "admin"/><p></c:if>
<c:if test="${x.isAdmin==0}">  <p>  <c:out value = "Khách"/><p></c:if>
</td>
      </tr>
    </c:forEach>
    </tbody>
      </table>
      <button class="deleteConfirm" class="btn btn-primary" ><i class="fa fa-trash-o">Xóa</i></button>
   </form>
 </div>

 <nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:forEach begin="1" end="${a.getNumPageUser()}" var="x">
  
    <li class="page-item ${inde==x?"active":""}"><a class="page-link" href="PangdingUser?index=${x}">${x}</a></li>

    </c:forEach>
     <li class="page-item"> <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>         
 
 </div> </div>
 
 
   </div>
  

<footer class="bg-light text-center text-lg-start">

  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2022 Copyright:
    <a class="text-dark" href="#"></a>
  </div>
 
</footer>  </c:if>
</body>
</html>