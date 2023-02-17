<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="">
<!-- To declare your language - read more here: https://www.w3.org/International/questions/qa-html-language-declarations -->
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-latest.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/styles/metro/notify-metro.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="./CSS/index.css"%>
<%@include file="./CSS/display.css"%>
</style>
<style type="text/css">
body{font-size:100%;}
</style>
 <jsp:useBean id="a" class="XoSoDAO.DAO" scope="request"></jsp:useBean>
</head>
<body>

<script type="text/javascript">
<%@include file="./js/js-admin.js"%>
</script>

    <div id="box-schatten1">
      <div id="box-schatten2">
        <div id="box-innen1">
          <div id="box-innen2">
            
      
            <div id="nav-oben">
              <h3 class="unsichtbar">Xổ Số</h3>
             
              <ul>
                <li><a href="PagingIndex">Xổ Số</a></li>
                <li><a href="#">Thống Kê</a></li>
                <li><a href="#">In Vé Dò</a></li>
                <li><a href="#">Thông Tin</a></li>
                 <li><a href="#">Help?</a></li>
              
                 <c:if test="${sessionScope.acc == null}">
                 <li><a href="Login.jsp">Login</a></li>
                   <li><a href="Register .jsp">Register</a></li>
                 </c:if>
       <c:if test="${sessionScope.acc != null}">
        <li><a href="history?id=${sessionScope.acc.maUser}&&index=1">Lịch Sử</a></li>
       <li><a href="Logout">Logout</a></li>
        <li><a href="changePassword.jsp">ChangePassword</a></li>
       </c:if>
               
              </ul>
            </div>
            
            
             <div id="box-innen3">
              <div id="box-seitennavi1">
                <div id="box-seitennavi2">
                  <ul>
                  <li class="selectedOneNoLinksLeft">
                      <div class="selectedOneNoLinksLeft">Dò Vé Online</div>
                    </li>
                    <li>
                    <c:if test="${sessionScope.acc == null}">
                    <form action="inSearch" method="post" onsubmit="return validateSearch()" name="form1">
    <label for="ngay">Ngày</label><br>
    <input id="ngay" name="ngay" type="text" value="" required><br>

    <label>Vé Số</label><br>
    <input id="veso" name="veso" type="text" value="" required><br>
    
    <label for="tinh">Tỉnh</label>    
    <select class="form-control" name="tinh" id="tinh">
    <c:forEach var="o" items="${listTinh}">
  <option  value="${o.tenTinh}" selected>${o.tenTinh}</option>
 
    </c:forEach>  </select>
  <div class="buttonSubmit">
    <input class="buSub" type="submit" name="submit" value="Tìm" /></div>
</form>  </c:if>
          
          <c:if test="${sessionScope.acc != null}" >
                    <form action="inSearch" method="get" onsubmit="return validateSearch()" name="form1">
    <label for="ngay">Ngày</label><br>
    <input id="ngay" name="ngay" type="text" value="" required><br>

    <label>Vé Số</label><br>
    <input name="veso" type="text" value="" required>
     <input name="maUse" type="hidden" value="${sessionScope.acc.maUser}"><br>
    
    <label for="tinh">Tỉnh</label>    
    <select class="form-control" name="tinh" id="tinh">
    <c:forEach var="o" items="${listTinh}">
  <option  value="${o.tenTinh}" selected>${o.tenTinh}</option>
 
    </c:forEach>  </select>
 <div class="buttonSubmit">
    <input class="buSub" type="submit" name="submit" value="Search" /></div>
</form>  </c:if>
                    </li>
                    
                    
                    <li class="selectedOne">
                      <div class="selectedOne">Miền</div>
                      <ul>
                        <li><a href="PagingMien?mien=MB&&index=1">Miền Bắc</a></li>
                        <li><a href="PagingMien?mien=MT&&index=1">Miền Trung</a></li>
                        <li><a href="PagingMien?mien=MN&&index=1">Miền Nam</a></li>
                      </ul>
                    </li>
                    <li><a href="#">Đổi số trúng</a></li>
                    <li><a href="#">Navigation - Level 1</a></li>
                    <li class="selectedOneNoLinksLeft">
                      <div class="selectedOneNoLinksLeft">Navigation - Level 2 Active - no sub-categories</div>
                    </li>
                  </ul>
                </div>
                <div id="seitennavi-abschluss"></div>
                <div id=""><img style="width:230px" src="https://images.xoso.me/news_xosome/2016/06/01/PR/ket-qua-xo-so-mien-bac_3.png" alt=""><br>
                  <div class="name-des-lesers-der-woche"></div>
                </div>
              </div>
            
              <div id="box-hauptinhalt">
                <div id="box-werbung2">
                <a href="#"><img src="https://image.thanhnien.vn/w660/Uploaded/2022/cqjwqcqdh/2020_06_09/kqxs2-4-6_jssz_wsph.jpg" alt=""></a>
                <a href="#"><img src="https://xoso.com.vn/medias/kqxs.png" alt=""></a>
                <a href="#"><img src="https://photo-cms-tpo.epicdn.me/w890/Uploaded/2022/dr-ofjbflyr/2021_11_20/ket-qua-xo-so-do-9903.jpg" alt=""></a>
                  <p>Xổ Số</p>
                </div>
                <div id="box-inhalt">
                  <h1>Xổ Số Kiến Thiết</h1>
                   <h3>${error}</h3>
             
              <c:forEach var="x" items="${listPage}">  
              <table class="rtable rtable--flip">
    <thead>
    <tr>
      <th>Ngày</th>
       <th>Tỉnh</th>
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
      
        <td>${x.ngay}</td>
        <td>${x.tenTinh}</td>
        <td>${x.giaiTam}</td>
        <td>${x.giaiBay}</td>
        <td>${x.giaiSau}</td>
        <td>${x.giaiNam}</td>
        <td>${x.giaiBon}</td>
        <td>${x.giaiBa}</td>
        <td>${x.giaiHai}</td>
        <td>${x.giaiMot}</td>
        <td>${x.giaiDB}</td> </tr>
   
   
  </tbody>
</table> <hr> </c:forEach>
               
               
                  <hr>
                 
                <nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:forEach begin="1" end="${a.getNumPage()}" var="x">
  
    <li class="page-item ${inde==x?"active":""}"><a class="page-link" href="PagingIndex?index=${x}">${x}</a></li>

    </c:forEach>
     <li class="page-item"> <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>   
                  
                  <h2>Xổ Số</h2>
                  <div class="galerie">
                    <div class="galerie-unten">
                      <p>Xổ Số</p>
                      <div class="galeriebild-gross"><a href="#"><img src="https://www.minhchinh.com/upload/images/veso/IMG_0005(158).png" alt=""></a></div>
                      <p class="blaettern"> | <a href="#">&#8679; Overview &#8679;</a> | </p>
                    </div>
                  </div>
                  <hr>
        
        </div>
      </div>
    </div>
    <div id="fusszeile">
      <div class="innen">Title of your company &#183; Adress &#183; Phone:&nbsp;01010101 &#183; Mobile:&nbsp;01010101 &#183; <a href="#"><span class="spamschutz" title="Your email">mail@domain.com</span></a> &#183; <a href="#" title="back to home">mydomain.com</a> &#183; Template by <a href="http://netzfeld.de" target="_blank">Netzfeld</a></div>
    </div>
  </div>
</div>
</body>
</html>