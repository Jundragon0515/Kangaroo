<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
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
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
</head>
<style>
/* * {
	box-sizing: border-box;
	border: 1px solid black;
} */

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

/* 등록상품 메인 이미지  */
.product-img-size {
	width: 330px;
	height: 230px;
}

/*카드리스트 마우스 오버*/
.card:hover {
	border: solid 1px #ffba00;
	margin: 1px;
}

/* 오른쪽 TOP 버튼 */
.btn-fixed {
	position: fixed;
	top: 540px;
	cursor: pointer;
}

#soldOut {
	position: relative;
	left: 180px;
	font-size: 15px;
}

.footerTitle {
	font-size: 20px;
	text-align: center;
	font-color: white;
}

.nav-link{
	font-size:30px;
}
.back-to-top {text-decoration: none; display: none; color:#fe912b;}


.back-to-top {
	text-decoration: none;
	display: none;
	color: #fe912b;
}

.back-to-top:hover {
	color: #818bb0
}
</style>
<script>
	$(function() {
		var offset = 200;   // 수직으로 어느정도 움직여야 버튼이 나올까?
		var duration = 600;   // top으로 이동할때까지의 animate 시간 (밀리세컨드, default는 400. 예제의 기본은 500)
		$(window).scroll(function() {
		    if ($(this).scrollTop() > offset) {
		        $('.back-to-top').fadeIn(duration);
		    } else {
		        $('.back-to-top').fadeOut(duration);
		    }
		});

		$('.back-to-top').click(function(event) {
		    event.preventDefault();
		    $('html, body').animate({scrollTop: 0}, duration);
		    return false;
		})	
		
		var socket = new SockJS("/gettime"); //불특정 다수의 브라우저일 경우를 위해 endpoint url 넣어야 한다
		var client = Stomp.over(socket);//연결 이후의 작업 지원 
		client.connect({}, function(resp) {
			client.subscribe("/response", function(list) {
				var result = JSON.parse(list.body);
				var z = 0;
					 			<c:forEach var="i" items="${auctionList}">
								$(".${i.no}").text("남은시간 : "+result[z++]);
								</c:forEach>
			});
		})
		setInterval(function() {//시간 보내 달라는 요청
			var list = new Array();
						<c:forEach var="i" items="${auctionList}">
							list.push("${i.end_date}");
						</c:forEach>
			client.send("/app/time", {}, JSON.stringify({
				end_dates : list
			}));
		}, 100);
		var list2 = new Array();
		<c:forEach var="i" items="${auctionList}">
		list2.push("${i.no}");
		</c:forEach>
		setInterval(function() {
			for(var z=0; z<list2.length ; z++){
				if(!list2[z])
					continue;
				if($("."+list2[z]).text()=='남은시간 : 종료'){
					$("."+list2[z]+"_re").before("<img class='onging-img' src=''../resources/img/banner/soldout.png'><button class='ongoing-btn'></button>");
					client.send("/app/end", {}, JSON.stringify({
						no : list2[z]
					}));
					delete list2[z];
				}
				
			}	
		}, 100);
		
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
	<div>
		<!-- start fixbutton -->
		<div class="d-none d-lg-block col-lg-1" style="padding-left: 90%;">
			<i class="fas fa-chevron-circle-up btn-fixed back-to-top fa-3x"></i>
		</div>
		<!-- end fixbutton -->
		<!-- Start Header Area -->
		<header class="header_area sticky-header">
			<div class="main_menu">
				<nav class="navbar navbar-expand-lg navbar-light main_box">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display logo_h -->
						<a class="navbar-brand logo_h" href="/"><img
							src="../resources/img/logo.png" width="60px" alt="">
							Kangaroo</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
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
								<li class="nav-item "><a class="nav-link"
									href="notice_main">공지사항</a></li>
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
												<li class="nav-item "><a class="nav-link"
													href="/goCart">찜목록</a></li>
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
												<li class="nav-item "><a class="nav-link"
													href="/goCart">찜목록</a></li>
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
												<li class="nav-item "><a class="nav-link"
													href="/goCart">찜목록</a></li>
												<li class="nav-item "><a class="nav-link"
													href="/goMyPage">마이페이지</a></li>
												<li class="nav-item "><a class="nav-link"
													href="/toPoint">포인트충전</a></li>
												<li class="nav-item "><a class="nav-link"
													href="/toPoint_exc">포인트환급</a></li>
												<li class="nav-item "><a class="nav-link"
													href="/logout">로그아웃</a></li>
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
				<div
					class="row fullscreen2 align-items-center justify-content-start"
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
								<h1>중고 직거래</h1>
								<p>판매자와 직접 빠른 거래를 해보세요!</p>
							</div>
						</div>
					</div>
					<div class="row">
						<!-- 직거래리스트 -->
						<c:forEach var="temp" items="${mainDirectList }">
							<!-- single product -->
							<div class="col-lg-3 col-md-6">
								<div class="single-product" style="margin-bottom: 15px;">
									<div class="card">
										<a href="/used_detailPage?no=${temp.no}"> <img
											class="img-fluid product-img-size"
											style="margin-bottom: 5px;"
											src="/img/title/${temp.title_img}" alt=""></a>
										<div class="card-body" style="padding: 12px;">
											<div class="row">
												<div class="d-none d-lg-block col-lg-12">[${temp.category}]</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
													<h4>${temp.title}</h4>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
													판매가 :
													<fmt:formatNumber value="${temp.price}" pattern="#,###" />
													원
												</div>
											</div>
											<div class="row">
												<div
													class="d-none d-sm-block col-xs-2 col-sm-2 col-md-2 col-lg-2 pr-0">
													<i class="far fa-clock fa-2x fontawesome"></i>
												</div>
												<div
													class="d-none d-sm-block col-xs-4 col-sm-4 col-md-4 col-lg-6 pr-0">
													<span class="joinDate">${temp.joinDate}</span>
												</div>
												<div
													class="d-none d-sm-block col-xs-2 col-sm-2 col-md-2 col-lg-2 m-0 pr-0">
													<i class="fas fa-eye fa-2x fontawesome"></i>
												</div>
												<div
													class="d-none d-sm-block col-xs-4 col-sm-4 col-md-4 col-lg-2 pr-0">
													<span class="view">${temp.viewCount}</span>
												</div>
											</div>

											<div class="row product-details" style="padding-left: 10px;">
												<div class="prd-bottom" style="margin-top: 5px;">
													<a
														href="boardGgym?no=${temp.no}&title_img=${temp.title_img}&title=${temp.title}&trade_type=${temp.trade_type }&category=${temp.category }&price=${temp.price}&id=${temp.id}"
														class="social-info ggym"> <span class="lnr lnr-heart"></span>
														<p class="hover-text">Wishlist</p>

													</a> <a href="/used_detailPage?no=${temp.no}"
														class="social-info"> <span class="lnr lnr-move"></span>
														<p class="hover-text">view more</p>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- single product slide -->
			<div class="single-product-slider">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-6 text-center">
							<div class="section-title">
								<h1>중고 안전거래</h1>
								<p>안전하게 중고 물품 거래를 해보세요!</p>
							</div>
						</div>
					</div>
					<div class="row">
						<!-- 안전거래 리스트 -->
						<c:forEach var="temp" items="${mainSafeList }">
							<!-- single product -->
							<div class="col-lg-3 col-md-6">
								<div class="single-product" style="margin-bottom: 15px;">
									<div class="card">
										<a href="/used_detailPage?no=${temp.no}"> <img
											class="img-fluid product-img-size"
											style="margin-bottom: 5px;"
											src="/img/title/${temp.title_img}" alt=""></a>
										<div class="card-body" style="padding: 12px;">
											<div class="row">
												<div class="d-none d-lg-block col-lg-12">[${temp.category}]</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
													<h4>${temp.title}</h4>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
													판매가 :
													<fmt:formatNumber value="${temp.price}" pattern="#,###" />
													원
												</div>
											</div>
											<div class="row">
												<div
													class="d-none d-sm-block col-xs-2 col-sm-2 col-md-2 col-lg-2 pr-0">
													<i class="far fa-clock fa-2x fontawesome"></i>
												</div>
												<div
													class="d-none d-sm-block col-xs-4 col-sm-4 col-md-4 col-lg-6 pr-0">
													<span class="joinDate">${temp.joinDate}</span>
												</div>
												<div
													class="d-none d-sm-block col-xs-2 col-sm-2 col-md-2 col-lg-2 m-0 pr-0">
													<i class="fas fa-eye fa-2x fontawesome"></i>
												</div>
												<div
													class="d-none d-sm-block col-xs-4 col-sm-4 col-md-4 col-lg-2 pr-0">
													<span class="view">${temp.viewCount}</span>
												</div>
											</div>

											<div class="row product-details" style="padding-left: 10px;">
												<div class="prd-bottom" style="margin-top: 5px;">
													<a
														href="boardGgymSafe?no=${temp.no}&title_img=${temp.title_img}&title=${temp.title}&trade_type=${temp.trade_type }&category=${temp.category }&price=${temp.price}&id=${temp.id}"
														class="social-info ggym"> <span class="lnr lnr-heart"></span>
														<p class="hover-text">Wishlist</p>

													</a> <a href="/used_detailPage?no=${temp.no}"
														class="social-info"> <span class="lnr lnr-move"></span>
														<p class="hover-text">view more</p>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
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
						<c:forEach var="temp" items="${auctionList}">
							<div class="col-lg-3 col-md-6">
								<div class="single-product" style="margin-bottom: 15px;">
									<div class="card">
										<input type="hidden" class="ongoing-href" value="${temp.no}">
										<a href="/auction_detailPage?no=${temp.no}"
											class="${temp.no}_re"> <img
											class="img-fluid product-img-size"
											style="margin-bottom: 5px;"
											src="../resources/img/title/${temp.title_img}" alt=""></a>
										<div class="card-body" style="padding: 12px;">
											<div class="row">
												<div class="d-none d-lg-block col-lg-12">[${temp.category}]</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
													<h4>${temp.title}</h4>
												</div>
											</div>
											<div class="row">
												<c:choose>
													<c:when test="${temp.present_price==0}">
														<div class="col-lg-12">
															현재가격 :
															<fmt:formatNumber value="${temp.starting_price}"
																pattern="#,###" />
															원
														</div>
													</c:when>

													<c:otherwise>
														<div class="col-lg-12">
															현재가격 :
															<fmt:formatNumber value="${temp.starting_price}"
																pattern="#,###" />
															원
														</div>
													</c:otherwise>
												</c:choose>
											</div>
											<div class="row">
												<div class="col-sm-12 col-md-10 col-lg-8 pr-0 ${temp.no}"></div>
												<div
													class="d-none d-sm-block col-xs-2 col-sm-2 col-md-2 col-lg-2 m-0 pr-0">
													<i class="fas fa-eye fa-2x fontawesome"></i>
												</div>
												<div
													class="d-none d-sm-block col-xs-4 col-sm-4 col-md-4 col-lg-2 pr-0">
													<span class="view">${temp.viewCount}</span>
												</div>
											</div>
											<div class="row product-details" style="padding-left: 10px;">
												<div class="prd-bottom" style="margin-top: 5px;">

													<a
														href="boardGgymAuction?no=${temp.no}&title_img=${temp.title_img}&title=${temp.title}&end_date=${temp.end_date }&category=${temp.category }&price=${temp.starting_price}&id=${temp.id}"
														class="social-info ggym"> <span class="lnr lnr-heart"></span>

														<p class="hover-text">ADD TO BAG</p>
													</a> <a href="/auction_detailPage?no=${temp.no}"
														class="social-info"> <span class="lnr lnr-move"></span>
														<p class="hover-text">view more</p>
													</a>
												</div>
											</div>
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
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
						<div class="">
							<dl>
								<dt>
									<h6>(주) &nbsp;&nbsp;Kangaroo</h6>
								</dt>
								<dd>서울특별시 중구 남대문로 120 대일빌딩 3층 (04540)</dd>
								<dd>대표이사: 홍길동 사업자등록번호 : 815-81-00000</dd>
								<dd>Tel: 1599-0000 Fax: 02-894-0000</dd>
								<dd>E-mail: custimerservice@aaaa.co.kr</dd>
							</dl>
						</div>
					</div>
					<div class="col-sm-4 col-md-4 col-lg-4 footerTitle">
						<div class="single-footer-widget">
							<h6><span>현재 활성화된 경매수</span></h6>
							&emsp;&emsp; <br> <h6><span><fmt:formatNumber
									value="${auctionActiveCount }" pattern="#,###" /> 건</span></h6>
						</div>
					</div>
					<div class="col-sm-4 col-md-4 col-lg-4 footerTitle">
						<div class="single-footer-widget mail-chimp">
							<h6><span style="font-size=50px;">현재 총 거래 량</span></h6>
							&emsp;&emsp; <br> <h6><span><fmt:formatNumber
									value="${totalCount }" pattern="#,###" /> 건 </span></h6>
						</div>
					</div>
				</div>
				<!-- 저작권 -->
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
							href="/" target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>
				</div>
			</div>
		</footer>
	</div>
	<!-- End footer Area -->
	<script>
		$(".ggym").on("click",function(){
			if(${email==null}){
				   alert("로그인 하세요.");
				   return false;
			   }
		})
	
	</script>

	<script src="https://use.fontawesome.com/releases/v5.0.0/js/all.js"></script>
	<script src="https://unpkg.com/popper.js"></script>
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