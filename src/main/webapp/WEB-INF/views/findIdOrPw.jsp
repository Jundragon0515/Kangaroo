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
<link rel="shortcut icon" href="../resources/img/logo.png">
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
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Noto+Sans+KR|Acme|Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
<style>
* {
	font-family: 'Noto Sans KR', sans-serif;
}

body {
	-webkit-background-size: cover;
	-moz-background-size: cover;
	background-size: cover;
	-o-background-size: cover;
}

#wrapper {
	margin-top: 5%;
	background-color: #ffffff95;
	margin-right: auto;
	margin-left: auto;
	overflow: hidden;
	text-align: center;
	width: 400px;
	height: 500px;
	border-radius: 10px;
	position: relative;
}

#header {
	width: 100%;
}

#part1, #part3_id {
	margin-top: 50px;
	font-size: 20px;
}

.btn-warning {
	color: white;
}

#img {
	width: 150px;
}

#email {
	border: 1px solid rgba(0, 0, 0, 0.32);
	padding: 0px 3px;
}

#footer {
	position: absolute;
	top: 400px;
	width: 100%;
	margin: auto !important;
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
<script>
   $(function() {
	   
	   <c:choose>
		<c:when test="${logintype!=null}">
			alert("로그아웃후 이용 가능합니다");
			$(location).attr("href","/");
		</c:when>
		</c:choose>
      $("#part3_pw").hide();
      $("#part3_id").hide();
      var authStr = "yet";
      var result = "false";
      var email_send_count = 0;
      var count = 0;
      var Idemail = "";
      $("#auth_num_btn").on("click", function() { // 아이디 정규식 검사.
         var email = $("#email").val();
         var emailRegex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
         var emailResult = emailRegex.exec(email);
         if(email==""||emailResult==null){  // 아이디의 값이 없거나     아이디 양식에 맞지않아 정규식  검사로 걸러졌을떄 . 
            alert("이메일형식이 아닙니다. ID를 정확히 입력해주세요.");
            $("#email").focus();
            return;
         }
         $.ajax({ // 아이디의 값이 저장되었는지 검색 
            url : "findIdcheck",
            type : "post",
            data : {
               id : email
            }
         }).done(function(resp) {
            if (resp == "1") { // 검색으로 인해 아이디가 있을시  이;
               Idemail = email;
               $("#email").attr("readonly", "true");
               var email = $("#email").val();
               if (email_send_count == 2) {
                  alert("이메일발송은 세번까지만 가능합니다.");
               }
               if (email_send_count == 3) { 
                  alert("이메일발송버튼을 세번이상 누르셨습니다. 메인화면으로 돌아갑니다.");
                  location.href = "start.main";
               }
               Idemail = email;
               email_send_count++;
               $.ajax({
                  url : "sendAuthNum.login",
                  type : "post",
                  data : {
                     email : email
                  }
               }).done(function(resp) {
                  alert("이메일이 발송되었습니다. 인증번호를 입력해주세요.");
                  alert("확인용! 발표시에는 삭제하기 " + resp);
                  authStr = resp;
               })
            } else {
               $("#part2_pw").toggle();
               $("#findResult").text("해당 ID가 없습니다.");
               $("#part3_id").toggle();
            }
         });
      });
      $("#auth_btn").on("click", function() {
         if (authStr == "yet") {//인증이 안되어있을떄 다시 인증하게한다.
            alert("이메일인증버튼을 눌러주세요.");
            return;
         }
         var inputAuthNum = $("#input_auth").val(); // 인증번호  ajax 로인해 인증값이 있는 
         if (authStr == inputAuthNum) {
            alert("인증성공");
            $("#part2_pw").toggle();
            $("#part3_pw").toggle();
         } else {
            alert("인증실패 : " + (++count) + "회실패/3회");
         }
         if (count == 3) {
            alert("인증입력이 3회 틀렸습니다. 메인화면으로 돌아갑니다.");
            location.href = "start.main";
         }
      });
      //-----3단계
      $("#changePw").on("click", function() {
         var pw1 = $("#newPw1").val();
         var pw2 = $("#newPw2").val();
         var regex = /^[A-Za-z0-9]{6,12}$/;
         var pwRegexResult = regex.exec(pw1);
         if (pwRegexResult == null) {
            alert("비밀번호조건 :  영문&숫자 6자리  ~ 12자리");
            $("#newPw1").focus();
            return;
         } else if (pw2 != pw1) {
            alert("비밀번호 확인을 정확히 입력해주세요.");
            $("#newPw2").focus();
            return;
         }else{
         $("#part3_pw").toggle();
         $("#findResult").text("PW변경중입니다.");
         $("#part3_id").toggle();
         $.ajax({
            url : "changePw",
            type : "post",
            data : {
               id : Idemail,
               pw : pw1
            }
         }).done(function(resp) {
            console.log(resp);
            if (resp == "1") {
               $("#findResult").text("비밀번호가 변경되었습니다.");
            } else {
               $("#findResult").text("비밀번호 변경 실패");
            }
         })
         }
      });
  
   });
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
									<li class="nav-item "><a class="nav-link" href="notice_main">공지사항</a></li>
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
											<li class="nav-item "><a class="nav-link"
												href="/toPoint_exc">포인트환급</a></li>
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
											<li class="nav-item "><a class="nav-link"
												href="/toPoint_exc">포인트환급</a></li>
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
												<li class="nav-item "><a class="nav-link"
												href="/toPoint_exc">포인트환급</a></li>
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
				<h1>패스워드 찾기</h1>
				<nav class="d-flex align-items-center"> <a href="/">메인페이지<span
					class="lnr lnr-arrow-right"></span></a> <a href="/login_main">로그인 메인<span
					class="lnr lnr-arrow-right"></span></a> <a href="/login">패스워드 찾기<span
					class="lnr "></span></a></nav>
			</div>
		</div>
	</div>
	</section>
	<div id="wrapper">
		<div id="header">
			<div class="row ">
				<div class="col-12">
					<img src="../resources/img/logo.png" id="img" width="150px">
				</div>
				<div class="col-12">
					<h3>Kangaroo</h3>
				</div>
			</div>
		</div>

		<div id="part2_pw" class="mt-4">
			<div>
				<h3>PW찾기</h3>
			</div>
			<div>
				<h6>ID(이메일)를 입력해주세요</h6>
			</div>
			<div class="input-group mb-3 ml-1">
				<input id="email" type="text" class="form-control"
					placeholder="ex)moonblack_@naver.com" name="email">
				<div class="input-group-append">
					<button id="auth_num_btn" class="btn btn-warning" type="button">이메일로
						인증번호 받기</button>
				</div>
			</div>
			<div class="input-group mb-3 ml-1">
				<input id="input_auth" type="text" placeholder="인증번호 입력">
				<div class="input-group-append">
					<button id="auth_btn" class="btn btn-warning" type="button"
						id="button-addon2">인증번호 확인</button>
				</div>
			</div>
		</div>
		<div id="part3_id">
			<div id="findResult"></div>
		</div>
		<div id="part3_pw">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">변경할 비밀번호</span>
				</div>
				<input id="newPw1" type="password" class="form-control"
					placeholder="영문&숫자 6자리  ~ 12자리">
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">비밀번호 확인</span>
				</div>
				<input id="newPw2" type="password" class="form-control"
					placeholder="비밀번호를 다시한번 입력하세요">
			</div>
			<div>
				<button id="changePw" type="button" class="btn btn-warning">비밀번호변경하기</button>
			</div>
		</div>
		<div class="row" id="footer">
			<div class="col-12">
				<a class="btn btn-warning" href="login" role="button">로그인으로 돌아가기</a>
			</div>
		</div>
	</div>
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
				<script>document.write(new Date().getFullYear());</script>
				All rights reserved | This template is made with <i
					class="fa fa-heart-o" aria-hidden="true"></i> by <a
					href="https://colorlib.com" target="_blank">Colorlib</a>
				<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			</p>
		</div>
	</div>
	</footer>
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