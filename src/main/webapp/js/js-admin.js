/**
 * 
 */charset="UTF-8";
 $(document).ready(function(){
	$(".content-item").not(":first").hide();
	$(".tab-item").eq(0).addClass("active");
	$(".tab-item").click(function(){
		$(".tab-item").removeClass("active").eq($(this).index()).addClass("active");
		$(".content-item").slideUp().eq($(this).index()).slideDown();
		$("#tab-Update").hide();
	});
	
});

$(document).ready(function(){
	$("#tab-Update").hide();
	
	$(".UpdateButton").click(function(){
		$(".content-item").hide();
		$("#tab-Update").show();
	});
	
});

$(document).ready(function () {
	$(".deleteConfirm").click(function () {
	var answer = confirm("delete confirmation?");
	return answer;
	});
	});
function notify() {
			$.notify("Access granted", "success");
		}
		
		alertify.confirm("Message", function (e) {
		    if (e) {
		        // user clicked "ok"
		    } else {
		        // user clicked "cancel"
		    }
		});
		
		function validateForm()
{
    
    var tinh = document.form1.tinh.value;
    var ngay = document.form1.ngay.value;
    var tam = document.form1.tam.value;
    var bay = document.form1.bay.value;
    var sau = document.form1.sau.value;
    var nam = document.form1.nam.value;
    var bon = document.form1.bon.value;
    var ba = document.form1.ba.value;
    var hai = document.form1.hai.value;
    var mot = document.form1.mot.value;
    var db = document.form1.db.value;
 
   if (tinh == null || tinh == "") {
alert("Ma tinh empty!");
return false;
}
// else if (password.length < 6) {
//alert("Mật khẩu ít nhất 6 ký tự");
//return false;
else if (ngay == null || ngay == "") {
	alert("ngay empty!");
	return false;
} else if (tam == null || tam == ""|| tam=='0') {
	alert("Giai Tam empty !");
	return false;
}
else if (bay == null || bay == "") {
	alert("Giai Bay empty !");
	return false;
}
else if (sau == null || sau == "") {
	alert("Giai sau empty !");
	return false;
}
else if (nam == null || nam == "") {
	alert("Giai nam empty !");
	return false;
}
else if (bon == null || bon == "") {
	alert("Giai bon empty !");
	return false;
}
else if (ba == null || ba == "") {
	alert("Giai ba empty !");
	return false;
}
else if (hai == null || hai == "") {
	alert("Giai hai empty !");
	return false;
}
else if (mot == null || mot == "") {
	alert("Giai nhat empty !");
	return false;
}
else if (db == null || db == "") {
	alert("Giai DB empty !");
	return false;
}

}
function validateFormAdd()
{
 	 
    var tinh = document.form1.tinh.value;
    var ngay = document.form1.ngay.value;
    var tam = document.form1.tam.value;
    var bay = document.form1.bay.value;
    var sau = document.form1.sau.value;
    var nam = document.form1.nam.value;
    var bon = document.form1.bon.value;
    var ba = document.form1.ba.value;
    var hai = document.form1.hai.value;
    var mot = document.form1.mot.value;
    var db = document.form1.db.value;
 
             
   if (tinh == null || tinh == "") {
alert("Ma tinh empty!");
return false;
}
// else if (password.length < 6) {
//alert("Mật khẩu ít nhất 6 ký tự");
//return false;
else if (ngay == null || ngay == "") {
	alert("ngay empty!");
	return false;
} else if (tam == null || tam == ""|| tam=='0') {
	alert("Giai Tam empty !");
	return false;
}
else if (bay == null || bay == "") {
	alert("Giai Bay empty !");
	return false;
}
else if (sau == null || sau == "") {
	alert("Giai sau empty !");
	return false;
}
else if (nam == null || nam == "") {
	alert("Giai nam empty !");
	return false;
}
else if (bon == null || bon == "") {
	alert("Giai bon empty !");
	return false;
}
else if (ba == null || ba == "") {
	alert("Giai ba empty !");
	return false;
}
else if (hai == null || hai == "") {
	alert("Giai hai empty !");
	return false;
}
else if (mot == null || mot == "") {
	alert("Giai nhat empty !");
	return false;
}
else if (db == null || db == "") {
	alert("Giai DB empty !");
	return false;
}

}


function validateUser()
{
    
    var tk = document.form1.tk.value;
    var mk = document.form1.mk.value;
     var mk2 = document.form1.mk2.value;
    var ht = document.form1.ht.value;
    var dc = document.form1.dc.value;
    var sdt = document.form1.sdt.value;
    
 
   if (tk == null || tk == "") {
alert("tk khong the trong!");
return false;
}
 else if (mk.length < 6) {
alert("Mat Khau it nhat 6 ky tu");
return false;}
 else if (mk != mk2) {
alert("Mat Khau nhap lai khong giong");
return false;}
else if (ht == null || ht == "") {
	alert("ho&ten empty !");
	return false;
}
else if (dc == null || dc == "") {
	alert("Dia Chi empty !");
	return false;
}
else if (sdt.length < 10) {
alert("SDT it nhat 10 ky tu");
return false;}


}

function validateLogin(){
	 var tk = document.form1.username.value;
    var mk = document.form1.password.value;
    
    
   if (tk == null || tk == "") {
alert("tk khong the trong!");
return false;
}
 else if (mk == null || mk == "") {
	alert("Mat Khau empty !");
	return false;
}

function validateChangePass(){
	 var tk = document.form1.tk.value;
    var mk = document.form1.mk.value;
    var mk2 = document.form1.mk2.value;
    var mk3 = document.form1.mk3.value;
    
   if (tk == null || tk == "") {
alert("tk khong the trong!");
return false;
}
 else if (mk == null || mk == "") {
	alert("Mat Khau empty !");
	return false;
}
else if (mk2.length < 6) {
alert("Mat Khau it nhat 6 ky tu");
return false;}
 else if (mk == mk2) {
alert("Mat Khau cu va moi giong nha");
return false;}
else if (mk2 != mk3) {
alert("Mat Khau nhap lai khong giong");
return false;}
}


function validateSearch()
{
    
    var ngay = document.form1.ngay.value;
    var veso = document.form1.veso.value;
    
    
 
   if (ngay == null || ngay == "") {
alert("ngay khong the trong!");
return false;
}
else if (veso == null || veso == "") {
alert("ngay khong the trong!");
return false;
}

 }
}