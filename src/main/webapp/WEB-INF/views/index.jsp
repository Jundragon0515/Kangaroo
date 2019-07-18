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
<script
	src=https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js></script>
<!-- 모든 브라우저 호완성을 위해 추가  -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
</head>
<style>
.owl-nav {
	top: 430px;
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
		var socket = new SockJS("/gettime"); //불특정 다수의 브라우저일 경우를 위해 endpoint url 넣어야 한다
		var client = Stomp.over(socket);//연결 이후의 작업 지원 
		client.connect({}, function(resp) {
			client.subscribe("/response", function(list) {
				var result = JSON.parse(list.body);
				var z = 0;
				$(".asd").text(result[0]);
				$(".asd2").text(result[1]);
				// 	 			<c:forEach var="i" items="${main_option_list}">
				// 				$("."+"${i.no}").text(result[z++]);
				// 				</c:forEach>
			});
		})
		setInterval(function() {//시간 보내 달라는 요청
			var list = new Array();
			list[0] = "2019-07-29 23:59:59";
			list[1] = "2019-07-18 11:52:00";
			// 			<c:forEach var="i" items="${main_option_list}">
			// 				list.add("${i.end_date}");
			// 			</c:forEach>
			client.send("/app/time", {}, JSON.stringify({
				end_dates : list
			}));
		}, 400);
		
		
		$("#logout_na").on("click", function() {
			 $.ajax({
	                url:"logout",
	                type:"get"
	             }).done(function(){
	                var naver=open("https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/", "_blank", "width=100,height=100");
	                setTimeout(function(){
	                   naver.close();
	                   location.reload(true);
	                },1000);
	             });
		});
		$("#logout_ka").on("click", function() {
			 $.ajax({
	             url:"logout",
	             type:"get"
	          }).done(function(){
	             var kakao=open("https://developers.kakao.com/logout", "_blank", "width=100,height=100");
	             setTimeout(function(){
	                kakao.close();
	                location.reload(true);
	             },1000);
	          });
		});

	});
</script>
<body>
	<!-- Start Header Area -->
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
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">중고
									거래</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="/trade">중고
											직거래</a></li>
									<li class="nav-item"><a class="nav-link" href="/trade">중고
											안전거래</a></li>
									<li class="nav-item"><a class="nav-link" href="/">중고
											경매</a></li>
								</ul></li>
							<li class="nav-item "><a class="nav-link" href="/">고객센터</a></li>
							<li class="nav-item "><a class="nav-link" href="/">공지사항</a></li>

							<c:choose>
								<c:when test="${logintype=='admin'}">
									<li class="nav-item "><a class="nav-link" href="/">관리자페이지</a></li>
									<li class="nav-item "><a class="nav-link" href="/logout">로그아웃</a></li>
								</c:when>
								<c:when test="${logintype=='naver'}">
									<li class="nav-item submenu dropdown"><a href="#"
										class="nav-link dropdown-toggle" data-toggle="dropdown"
										role="button" aria-haspopup="true" aria-expanded="false"><img
											src="../resources/img/account.png" width="35px"></a>
										<ul class="dropdown-menu nav_ul">
											<li class="nav-item "><a class="nav-link" href="/">쪽지</a></li>
											<li class="nav-item "><a class="nav-link" href="/">장바구니</a></li>
											<li class="nav-item active"><a class="nav-link"
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
											<li class="nav-item "><a class="nav-link" href="/">쪽지</a></li>
											<li class="nav-item "><a class="nav-link" href="/">장바구니</a></li>
											<li class="nav-item active"><a class="nav-link"
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
											<li class="nav-item "><a class="nav-link" href="/">쪽지</a></li>
											<li class="nav-item "><a class="nav-link" href="/">장바구니</a></li>
											<li class="nav-item active"><a class="nav-link"
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
	<!-- End Header Area -->

	<!-- start banner Area -->
	<section class="banner-area">
		<div class="container">
			<div class="row fullscreen2 align-items-center justify-content-start"
				style="height: 660px;">
				<div class="col-lg-12">
					<div class="active-banner-slider owl-carousel">
						<!-- single-slide -->
						<div class="row single-slide align-items-center d-flex">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1>
										Nike New <br>Collection!
									</h1>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit, sed do eiusmod tempor incididunt ut labore et dolore
										magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation.</p>
									<div class="add-bag d-flex align-items-center">

										<span class="add-text text-uppercase">알아보기</span>
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid"
										src="../resources/img/banner/banner-img.png" alt="">
								</div>
							</div>
						</div>
						<!-- single-slide -->
						<div class="row single-slide">
							<div class="col-lg-5">
								<div class="banner-content">
									<h1>
										Nike New <br>Collection!
									</h1>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit, sed do eiusmod tempor incididunt ut labore et dolore
										magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation.</p>
									<div class="add-bag d-flex align-items-center">

										<span class="add-text text-uppercase">알아보기</span>
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid"
										src="../resources/img/banner/banner-img.png" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="owl-carousel active-product-area section_gap">
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>중고 거래</h1>
							<p>안전하게 중고 물품 거래를 해보세요!</p>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="../resources/img/product/p1.jpg"
								alt="">
							<div class="product-details">
								<h6>addidas New Hammer sole for Sports person</h6>
								<div class="price">
									<h6>$150.00</h6>
									<h6 class="asd"></h6>
								</div>
								<div class="prd-bottom">
									<a href="" class="social-info"> <span class="ti-bag"></span>
										<p class="hover-text">add to bag</p>
									</a> <a href="" class="social-info"> <span class="lnr lnr-move"></span>
										<p class="hover-text">view more</p>
									</a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="../resources/img/product/p1.jpg"
								alt="">
							<div class="product-details">
								<h6>addidas New Hammer sole for Sports person</h6>
								<div class="price">
									<h6>$150.00</h6>
									<h6 class="asd2"></h6>
								</div>
								<div class="prd-bottom">
									<a href="" class="social-info"> <span class="ti-bag"></span>
										<p class="hover-text">add to bag</p>
									</a> <a href="/detailPage" class="social-info"> <span class="lnr lnr-move"></span>
										<p class="hover-text">view more</p>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>중고 경매</h1>
							<p>중고 물품 경매에 참여 하여 좋은 가격에 원하는 물품을 얻어보세요!</p>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<c:forEach var="i" items="${main_option_list}">
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="../resources/img/product/p6.jpg"
									alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="${i.no}"></h6>
									</div>
									<div class="prd-bottom">
										<a href="" class="social-info"> <span class="ti-bag"></span>
											<p class="hover-text">add to bag</p>
										</a> <a href="" class="social-info"> <span
											class="lnr lnr-move"></span>
											<p class="hover-text">view more</p>
										</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<!-- end product Area -->

	<!-- start footer Area -->
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