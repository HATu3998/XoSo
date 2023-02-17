<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <style><%@include file="./CSS/display.css"%>

</style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <jsp:useBean id="a" class="XoSoDAO.DAO" scope="request"></jsp:useBean>
</head>
<body>
<script type="text/javascript">
<%@include file="./js/js-admin.js"%>
</script>

<nav class="navbar navbar-inverse">
  <ul class="nav navbar-nav">
    <li><a href="Logout">Logout</a></li>
        <li><a href="changePassword.jsp">ChangePassword</a></li>
  </ul>
  <p class="navbar-text"><a href="PagingIndex">Xổ Số</a></p>
</nav>
 <div id="tab">
 <span class="tab-item active"><button type="button" class="btn btn-default">Bảng Kết Quả</button></span>
 <span class="tab-item"><button type="button" class="btn btn-default">Xóa</button></span>
 
 </div>
  <div id="tab-content" class="content-item">
<div class="container">
  <h2>Lịch Sử Đã Dò</h2>
   <table class="table">
    <thead>
      <tr>
        <th>Ngày Dò</th>
        <th>Số Dò</th>
        <th>tỉnh</th>
        <th>Kết Quả</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach var="x" items="${listPage}"> 
        <tr>
        <td>${x.ngay}</td>
        <td>${x.soDo}</td>
        <td>
        ${x.tenTinh} 
       
      </td>
        <td><c:if test="${x.ketQua==1}">
        <p style="color:red">trúng giải</p>
        </c:if>
        <c:if test="${x.ketQua==0}">
        <p>không trúng</p>
        </c:if>
        </td>
        <td>
     <button class="btn deleteConfirm" button type="button" > <a style="text-decoration: none" href="deleHistory?sMaVe=${x.maVeDo}">xóa</a></button>
        </td>
  </tr>
     </c:forEach>    
    </tbody>
  </table>
</div></div>

 <div class="content-item">
 <div class="container">
  <h2>Chọn</h2>
   <form method="get"  action="deleHistory" onclick="notify()">
   <table class="table">
    <thead>
      <tr>
      <th>Chọn vé</th>
        <th>Mã vé</th>
        <th>Ngày Dò</th>
        <th>Số Dò</th>
        <th>tỉnh</th>
        <th>Kết Quả</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach var="x" items="${listPage}"> 
        <tr>
        <td> <input type="checkbox" name="sMaVe" value="${x.maVeDo}" id="${x.maVeDo}"></td>
        <td><label for="${x.maVeDo}"><span></span>${x.maVeDo}</label></td>
        <td>${x.ngay}</td>
        <td>${x.soDo}</td>
        <td>
        ${x.tenTinh} 
       
      </td>
        <td><c:if test="${x.ketQua==1}">
        <p style="color:red">trúng giải</p>
        </c:if>
        <c:if test="${x.ketQua==0}">
        <p>không trúng</p>
        </c:if>
        </td>
       
  </tr>
     </c:forEach>    
    </tbody>
  </table>
    <button class="deleteConfirm" class="btn btn-primary" ><i class="fa fa-trash-o">Xóa</i></button></form>
</div>
 </div>
<button><a href="PagingIndex">Trở về</a></button>

    
     <c:if test="${sessionScope.acc != null}">
     <nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:forEach begin="1" end="${a.getNumPageHistory()}" var="x">
  
    <li class="page-item ${inde==x?"active":""}"><a class="page-link" href="history?id=${sessionScope.acc.maUser}&&index=${x}">${x}</a></li>

    </c:forEach>
     <li class="page-item"> <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
    </nav></c:if>
       
</body>
</html>
