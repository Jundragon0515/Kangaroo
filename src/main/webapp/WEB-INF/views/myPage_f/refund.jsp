<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="../resources/img/fav.png">
<!-- Author Meta -->
<meta name="author" content="CodePixar">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Kangaroo Shop</title>
<!--
		CSS
		============================================= -->
<link rel="stylesheet" href="../resources/css/linearicons.css">
<link rel="stylesheet" href="../resources/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/css/themify-icons.css">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/owl.carousel.css">
<link rel="stylesheet" href="../resources/css/nice-select.css">
<link rel="stylesheet" href="../resources/css/nouislider.min.css">
<link rel="stylesheet" href="../resources/css/ion.rangeSlider.css" />
<link rel="stylesheet"
	href="../resources/css/ion.rangeSlider.skinFlat.css" />
<link rel="stylesheet" href="../resources/css/magnific-popup.css">
<link rel="stylesheet" href="../resources/css/main.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
<script src="https://code.jquery.com/jquery-3.4.0.min.js">
</script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script>
   $(function() {
     $("#sub").on("click",function(){
    	 var message =$("#message").val();
    	 $.ajax({
    		 url:"refund",
    		 data:{
    			 message : message,
    	 		 seq : "${seq}"
    		 }
    	 }).done(function(resp){
    		 alert("환불요청 완료");
    		 opener.location.reload();
    		 close();
    	 });
     });
   })
</script>

<style>
h1 {
	text-align: center;
}

#wrapper {
	width: 400px;
	margin: auto;
}

#logoWrapper {
	width: 100%;
	margin: auto;
	text-align: center;
}

#logo {
	width: 150px;
}

#wrapper>div {
	margin: 10px 0px;
}

.btn {
	margin-left: 10px;
}


.banner {
	text-align: center;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="logoWrapper">
			<img src="../resources/img/logo.png" id="img" width="150px">
		</div>
		<div class="mb-3">
			<h1>환불하기</h1>
		</div>
		<div class="form-group mb-3">
			<textarea class="form-control" name="message" id="message" rows="5"
				placeholder="환불 사유를 입력해주세요" onfocus="this.placeholder = ''"
				onblur="this.placeholder = '환불 사유를 입력해주세요'"></textarea>
		</div>
		<div class=" text-right">
			<input type="button" id="sub" value="전송" class="primary-btn">
		</div>
	</div>

	<script src="../resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="../resources/js/jquery.nice-select.min.js"></script>
	<script src="../resources/js/jquery.sticky.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.magnific-popup.min.js"></script>
	<script src="../resources/js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="../resources/js/gmaps.min.js"></script>
	<script src="../resources/js/main.js"></script>
</body>

</html>