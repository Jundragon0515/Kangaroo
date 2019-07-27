<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
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
<style>
#layer {
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	height: 50%;
	display: flex;
	align-items: center;
	justify-content: center;
	display: -webkit-flex; -webkit-align-item; center;
	-webkit-justify-content: center;
}

#row {
	margin-top: 80px;
	margin-bottom: 80px;
	background-color: #ffffff95;
	width: 300px;
	height: 400px;
	border-radius: 10px;
}

.row>div {
	text-align: center;
}

#login_btn, #kakao_login_btn, #sign_up_btn, #toMain_btn {
	width: 222px;
	height: 49px;
}

#naver_login_btn {
	width: 222px;
	height: 49px;
	background-color: transparent;
	border: none;
	cursor: pointer;
}

b, sup, sub, u, del {
	color: black;
}
.nav_b {
	border: 0px;
	background: 000000;
	width: 100%;
}

.nav_b:hover {
	cursor: pointer;
}

.nav_ul * {
	text-align: center;
}
</style>
<style>
	.subtitle{
		float: right;
		
	}

	#title_input{
		width:100%;
	}
	
	h1{
		text-align: center;
	}
	#writting{
		height: 500px;
	}
	.mid_nav_one{
		float: left;
	}
	#btnclass{
		float: right;
	}
</style>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script>
      function noSpaceForm(obj) { // 공백사용못하게
         var str_space = /\s/; // 공백체크
         if (str_space.exec(obj.value)) { //공백 체크
            alert("해당 항목에는 공백을 사용할수 없습니다.\n\n공백은 자동적으로 제거 됩니다.");
            obj.focus();
            obj.value = obj.value.replace(' ', ''); // 공백제거
            return false;
         }
         // onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"
      }
   </script>
<script>
	$(function() {
		 <c:choose>
	    <c:when test="${logintype!='admin'}">
	    	alert("관리자만 이용 가능합니다");
	    $(location).attr("href", "notice_main");
	    </c:when>
    </c:choose> 
		$("#reset").on("click",function(){
			if (confirm("뒤로가기?") == true){    //확인
				$("#renotice").attr("action", "resetnotice");
				$("#renotice").submit();
			 }else{   //취소
			     return false;
			 }
			
			 // no 번호를 이용하여 서치후 다시 돌아가는것처럼 보이게한다
		})
		$("#input").on("click",function(){
			if(confirm("입력 하시겠습니까?") == true){
				if($("#title_input").val() == "" || $("#writting").val() == ""){
		    		alert("값을 제대로 입력해 주세요.");
		    		return false;
		    	}else{
		    		return true;
		    	}
			}else{ // 취소
				return false;
			}
		})
		
		$("#sign_up_btn").on("click", function() {
			location.href = "insert";
		});
		$("#toMain_btn").on("click", function() {
			location.href = "/";
		});
	});
	onload = function() {
	};
</script>
</head>
<body>
<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display logo_h -->
					<a class="navbar-brand logo_h" href="/"><img
						src="../resources/img/logo.png" width="60px" alt="">
						Kangaroo</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset"
						id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<!-- 							<li class="nav-item active"><a class="nav-link" href="/">Home</a></li> -->
									<li class="nav-item"><a class="nav-link" href="/trade">중고
											직거래</a></li>
									<li class="nav-item"><a class="nav-link" href="/trade_safe">중고
											안전거래</a></li>
									<li class="nav-item"><a class="nav-link" href="/auction">중고
											경매</a></li>
							<li class="nav-item "><a class="nav-link" href="/">공지사항</a></li>
							<c:choose>
								<c:when test="${logintype=='admin'}">
									<li class="nav-item "><a class="nav-link" href="/admin">관리자페이지</a></li>
									<li class="nav-item "><a class="nav-link" href="/logout">로그아웃</a></li>
								</c:when>
								<c:when test="${logintype=='naver'}">
									<li class="nav-item submenu dropdown"><a href="#"
										class="nav-link dropdown-toggle" data-toggle="dropdown"
										role="button" aria-haspopup="true" aria-expanded="false"><img
											src="../resources/img/account.png" width="35px"></a>
										<ul class="dropdown-menu nav_ul">
											<li class="nav-item "><a class="nav-link" href="/goCart">찜목록</a></li>
											<li class="nav-item "><a class="nav-link"
												href="/goMyPage">마이페이지</a></li>
											<li class="nav-item "><a class="nav-link"
												href="/toPoint">포인트충전</a></li>
											<li class="nav-item "><input type="button"
												class="nav-link nav_b" id="logout_na" value="로그아웃"></li>
										</ul></li>
								</c:when>
								<c:when test="${logintype=='kakao'}">
									<li class="nav-item submenu dropdown"><a href="#"
										class="nav-link dropdown-toggle" data-toggle="dropdown"
										role="button" aria-haspopup="true" aria-expanded="false"><img
											src="../resources/img/account.png" width="40px"></a>
										<ul class="dropdown-menu nav_ul">
											<li class="nav-item "><a class="nav-link" href="/goCart">찜목록</a></li>
											<li class="nav-item "><a class="nav-link"
												href="/goMyPage">마이페이지</a></li>
											<li class="nav-item "><a class="nav-link"
												href="/toPoint">포인트충전</a></li>
											<li class="nav-item "><input type="button"
												class="nav-link nav_b" id="logout_ka" value="로그아웃"></li>
										</ul></li>
								</c:when>
								<c:when test="${logintype=='email'}">
									<li class="nav-item submenu dropdown"><a href="#"
										class="nav-link dropdown-toggle" data-toggle="dropdown"
										role="button" aria-haspopup="true" aria-expanded="false"><img
											src="../resources/img/account.png" width="40px"></a>
										<ul class="dropdown-menu nav_ul">
											<li class="nav-item "><a class="nav-link" href="/goCart">찜목록</a></li>
											<li class="nav-item "><a class="nav-link"
												href="/goMyPage">마이페이지</a></li>
											<li class="nav-item "><a class="nav-link"
												href="/toPoint">포인트충전</a></li>
											<li class="nav-item "><a class="nav-link" href="/logout">로그아웃</a></li>
										</ul></li>
								</c:when>
								<c:otherwise>
									<li class="nav-item "><a class="nav-link"
										href="/login_main">로그인</a></li>
									<li class="nav-item "><a class="nav-link" href="/insert">회원가입</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
	<div class="container">
		<div
			class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
			<div class="col-first">
				<h1>로그인 메인</h1>
				<nav class="d-flex align-items-center"> <a href="/">메인페이지<span
					class="lnr lnr-arrow-right"></span></a> <a href="/login_main">공지사항
					메인<span class="lnr "></span>
				</a> </nav>
			</div>
		</div>
	</div>
	</section>
	<!-- show time  -->
<main>
   <form action="noticeupdate.do" id="renotice" method="post" enctype="multipart/form-data" >
   <div class="row">
	   <div class="container mb-5" id="board"  >
	   		<div id="mid_nav">
	   			<div class="mid_nav_title col-12 my-3"><h1>공지사항</h1></div>
	   			<input type="hidden" name="no" value="${dtos.no}">
	   			<div class="mid_nav_one col-lg-2 col-md-2 col-sm-12 mb-2  "><h3 id="title_title" style="align-content: center;">제목</h3></div>
	   			<div class="mid_nav_one col-lg-10 col-md-10 col-sm-12 mb-2"><input type="text" id="title_input" name="title" value="${dtos.title}" onkeyup="noSpaceForm(this);"></div>
	   			<div class="mid_nav_one col-lg-12 col-md-12 col-sm-12 mb-2"><input type="file"  name="images" id="file" style="float:left" ></div>
		   	<input type="hidden" name="image" value="${dtos.image}">
	   		</div>
		   	<textarea class="form-control mb-2" id="writting" rows="3"  name="contents" onkeyup="noSpaceForm(this);">${dtos.contents}</textarea>
		   	<div class="mb-2" id="btnclass"><input id="input" type="submit" class="btn btn-warning mr-2" value="입력"><input class="btn btn-warning" type="button" id="reset" value="취소"></div>
	   	</div>
   	</div>
   	</form>
  </main>
	<!-- show time  -end- -->
	<footer class="footer-area section_gap">
	<div class="container">
		<div class="row">
			<div class="col-lg-3  col-md-6 col-sm-6">
				<div class="single-footer-widget">
					<h6>About Us</h6>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore dolore magna aliqua.</p>
				</div>
			</div>
			<div class="col-lg-4  col-md-6 col-sm-6">
				<div class="single-footer-widget">
					현재 활성화된 경매수
					<!-- 						<h6>Newsletter</h6> -->
					<!-- 						<p>Stay update with our latest</p> -->
					<!-- 						<div class="" id="mc_embed_signup"> -->

					<!-- 							<form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" -->
					<!-- 							 method="get" class="form-inline"> -->

					<!-- 								<div class="d-flex flex-row"> -->

					<!-- 									<input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '" -->
					<!-- 									 required="" type="email"> -->


					<!-- 									<button class="click-btn btn btn-default"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button> -->
					<!-- 									<div style="position: absolute; left: -5000px;"> -->
					<!-- 										<input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text"> -->
					<!-- 									</div> -->

					<!-- 									<div class="col-lg-4 col-md-4"> -->
					<!-- 												<button class="bb-btn btn"><span class="lnr lnr-arrow-right"></span></button> -->
					<!-- 											</div>   -->
					<!-- 								</div> -->
					<!-- 								<div class="info"></div> -->
					<!-- 							</form> -->
					<!-- 						</div> -->
				</div>
			</div>
			<div class="col-lg-3  col-md-6 col-sm-6">
				<div class="single-footer-widget mail-chimp">
					현재 총 거래 량
					<!-- 						<h6 class="mb-20">Instragram Feed</h6> -->
					<!-- 						<ul class="instafeed d-flex flex-wrap"> -->
					<!-- 							<li><img src="../resources/img/i1.jpg" alt=""></li> -->
					<!-- 							<li><img src="../resources/img/i2.jpg" alt=""></li> -->
					<!-- 							<li><img src="../resources/img/i3.jpg" alt=""></li> -->
					<!-- 							<li><img src="../resources/img/i4.jpg" alt=""></li> -->
					<!-- 							<li><img src="../resources/img/i5.jpg" alt=""></li> -->
					<!-- 							<li><img src="../resources/img/i6.jpg" alt=""></li> -->
					<!-- 							<li><img src="../resources/img/i7.jpg" alt=""></li> -->
					<!-- 							<li><img src="../resources/img/i8.jpg" alt=""></li> -->
					<!-- 						</ul> -->
				</div>
			</div>
			<div class="col-lg-2 col-md-6 col-sm-6">
				<div class="single-footer-widget">
					<h6>Follow Us</h6>
					<p>Let us be social</p>
					<div class="footer-social d-flex align-items-center">
						<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
							class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-dribbble"></i></a> <a href="#"><i
							class="fa fa-behance"></i></a>
					</div>
				</div>
			</div>
		</div>
		<div
			class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
			<p class="footer-text m-0">
				<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				Copyright &copy;
				<script>
					document.write(new Date().getFullYear());
				</script>
				All rights reserved | This template is made with <i
					class="fa fa-heart-o" aria-hidden="true"></i> by <a
					href="https://colorlib.com" target="_blank">Colorlib</a>
				<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			</p>
		</div>
	</div>
	</footer>
	<!-- End footer Area -->
	<!-- End footer Area -->
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
	<script type='text/javascript'>
		Kakao.init('473f4afca91d6d42fb0364e90c3df475');
		Kakao.Auth.createLoginButton({
			container : '#kakao-login-btn',
			success : function(authObj) {
				location.href = "login.ka";
			},
			fail : function(err) {
				alert(JSON.stringify(err));
			}
		});
	</script>
</body>
</html>