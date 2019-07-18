<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="CodePixar">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- 웹 소켓 cdn -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<title>상세 페이지</title>
<!-- CSS ============================================= -->
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
<link rel="stylesheet" href="../resources/css/main.css">

<style>
.detail-info {
	text-align: right;
}

#dotted_line {
	border-bottom: 1.3px dotted gray;
	padding-top: 10px;
	padding-bottom: 10px;
}

.selector img {
	width: 50%;
	height: 50%;
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
</script>
</head>
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

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Product Details Page</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Shop<span class="lnr lnr-arrow-right"></span></a> <a
							href="single-product.html">product-details</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
				<!--이미지 미리보기 -->
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleIndicators" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src=${a_i_dto.title_img } class="d-block w-100" onerror="this.style.display='none'" alt=''>
							</div>
							<div class="carousel-item">
								<img src=${a_i_dto.middle1_img } class="d-block w-100" onerror="this.style.display='none'" alt=''>
							</div>
							<div class="carousel-item">
								<img src=${a_i_dto.middle2_img } class="d-block w-100" onerror="this.style.display='none'" alt=''>
							</div>
							<div class="carousel-item">
								<img src=${a_i_dto.middle3_img } class="d-block w-100" onerror="this.style.display='none'" alt=''>
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleIndicators"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next"
							href="#carouselExampleIndicators" role="button" data-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>

				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text1">


						<div class="container">
							<table class="table">
								<tr>
									<h3 style="text-align: right; padding-right: 30px;">${a_dto.title }</h3>
								</tr>
								<tbody>
									<tr>
										<td id=pt>현재가</td>
										<th><h2 id=pp class=detail-info>
												<fmt:formatNumber value="${a_dto.present_price }"
													pattern="#,###" />
												원
											</h2></th>
									</tr>
									<tr>
										<td>남은 시간</td>
										<th id=rt class=detail-info></th>
									</tr>
									<tr>
										<td>물품번호</td>
										<td colspan=2 class=detail-info><fmt:formatNumber
												value="${a_dto.no }" pattern="#,###" /></td>
									</tr>
									<tr>
										<td>물품 카테고리</td>
										<td colspan=2 class=detail-info>${a_dto.category }</td>
									</tr>
									<tr>
										<td>경매기간</td>
										<td colspan=2 class=detail-info>${a_dto.start_date }~
											${a_dto.end_date }</td>
									</tr>
									<tr>
										<td>시작가</td>
										<td colspan=2 class=detail-info><fmt:formatNumber
												value="${a_dto.starting_price }" pattern="#,###" />원</td>
									</tr>
									<tr>
										<td>최소 입찰 단위</td>
										<td colspan=2 class=detail-info><fmt:formatNumber
												value="${a_dto.min_price }" pattern="#,###" />원</td>
									</tr>
									<tr>
										<td>입찰 수</td>
										<td colspan=2 class=detail-info><fmt:formatNumber
												value="${a_dto.bid_count }" pattern="#,###" /></td>
									</tr>
									<tr>
										<td>배송방법</td>
										<td colspan=2 class=detail-info>${a_dto.delivery_type }</td>
									</tr>
									<tr>
										<td>배송비용</td>
										<td colspan=2 class=detail-info><fmt:formatNumber
												value="${a_dto.delivery_cost }" pattern="#,###" />원</td>
									</tr>
								</tbody>
							</table>
						</div>

						<div class="card_area d-flex align-items-center">
							<a class="primary-btn" href="#">Add to Cart</a> <a
								class="icon_btn" href="#"><i class="lnr lnr lnr-diamond"></i></a>
							<a class="icon_btn" href="#"><i class="lnr lnr lnr-heart"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->

	<!--================Product Description Area =================-->
	<section class="product_description_area">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link" id="home-tab"
					data-toggle="tab" href="#home" role="tab" aria-controls="home"
					aria-selected="true">물품정보</a></li>
				<li class="nav-item"><a class="nav-link" id="profile-tab"
					data-toggle="tab" href="#profile" role="tab"
					aria-controls="profile" aria-selected="false">판매자 정보</a></li>
				<li class="nav-item"><a class="nav-link" id="contact-tab"
					data-toggle="tab" href="#contact" role="tab"
					aria-controls="contact" aria-selected="false">배송/반품</a></li>
				<li class="nav-item"><a class="nav-link active" id="review-tab"
					data-toggle="tab" href="#review" role="tab" aria-controls="review"
					aria-selected="false">Reviews</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade" id="home" role="tabpanel"
					aria-labelledby="home-tab" style="text-align: center;">
					<!-- 상세 이미지  -->
					<div class="selector">
						<img src=${a_i_dto.title_img } onerror="this.style.display='none'"
							alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle1_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle2_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle3_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle4_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle5_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle6_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle7_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle8_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle9_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
					<div class="selector">
						<img src=${a_i_dto.middle10_img }
							onerror="this.style.display='none'" alt=''>
					</div>
					<br>
				</div>
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">
					<div class="table-responsive">
						<table class="table">
							<tbody>
								<tr>
									<td>
										<h5>판매자 아이디</h5>
									</td>
									<td>
										<h5>${a_dto.id }</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>판매자 회원등급</h5>
									</td>
									<td>
										<h5>${a_dto.member_class }</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>판매자 연락처</h5>
									</td>
									<td>
										<h5>${a_dto.phone }</h5>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="section-top-border" style="padding-top: 50px;">
						<h3 class="mb-30" style="padding-left: 25px;">판매자 정보</h3>
						<div class="row">
							<div class="col-lg-12">
								<blockquote class="generic-blockquote">
									(주)캥거루에 등록된 상품과 상품 내용은 개별 판매자가 등록한 것으로써, (주)캥거루는 중개 시스템만 제공하며
									해당 등록 내용에 대하여 일체의 책임을 지지 않습니다. <br>판매자가 사업자 회원이 아닌 개인 회원의
									경우 판매자 정보는 [캥거루 결제처리] 이후 판매자의 연락처 등을 구매한 소비자에게 즉시 제공하게 됩니다.
									<h2 id=dotted_line></h2>
									구매 안정 서비스 (KCP) 가입 업체 : A111233434784 (주)캥거루는 구매 안전 서비스(KCP)에
									가입하였으며, 캥거루에 등록된 모든 입점 판매자는 자동적으로 해당 서비스에 가입됩니다.
								</blockquote>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="contact" role="tabpanel"
					aria-labelledby="contact-tab">
					<div class="row">
						<div class="col-lg-6">
							<div class="comment_list">
								<div class="review_item">
									<div class="media">
										<div class="d-flex">
											<img src="img/product/review-1.png" alt="">
										</div>
										<div class="media-body">
											<h4>Blake Ruiz</h4>
											<h5>12th Feb, 2018 at 05:56 pm</h5>
											<a class="reply_btn" href="#">Reply</a>
										</div>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit, sed do eiusmod tempor incididunt ut labore et dolore
										magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation ullamco laboris nisi ut aliquip ex ea commodo</p>
								</div>
								<div class="review_item reply">
									<div class="media">
										<div class="d-flex">
											<img src="img/product/review-2.png" alt="">
										</div>
										<div class="media-body">
											<h4>Blake Ruiz</h4>
											<h5>12th Feb, 2018 at 05:56 pm</h5>
											<a class="reply_btn" href="#">Reply</a>
										</div>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit, sed do eiusmod tempor incididunt ut labore et dolore
										magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation ullamco laboris nisi ut aliquip ex ea commodo</p>
								</div>
								<div class="review_item">
									<div class="media">
										<div class="d-flex">
											<img src="img/product/review-3.png" alt="">
										</div>
										<div class="media-body">
											<h4>Blake Ruiz</h4>
											<h5>12th Feb, 2018 at 05:56 pm</h5>
											<a class="reply_btn" href="#">Reply</a>
										</div>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit, sed do eiusmod tempor incididunt ut labore et dolore
										magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation ullamco laboris nisi ut aliquip ex ea commodo</p>
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="review_box">
								<h4>Post a comment</h4>
								<form class="row contact_form" action="contact_process.php"
									method="post" id="contactForm" novalidate="novalidate">
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" id="name" name="name"
												placeholder="Your Full name">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="email" class="form-control" id="email"
												name="email" placeholder="Email Address">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" id="number"
												name="number" placeholder="Phone Number">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<textarea class="form-control" name="message" id="message"
												rows="1" placeholder="Message"></textarea>
										</div>
									</div>
									<div class="col-md-12 text-right">
										<button type="submit" value="submit" class="btn primary-btn">Submit
											Now</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade show active" id="review" role="tabpanel"
					aria-labelledby="review-tab">
					<div class="row">
						<div class="col-lg-6">
							<div class="row total_rate">
								<div class="col-6">
									<div class="box_total">
										<h5>Overall</h5>
										<h4>4.0</h4>
										<h6>(03 Reviews)</h6>
									</div>
								</div>
								<div class="col-6">
									<div class="rating_list">
										<h3>Based on 3 Reviews</h3>
										<ul class="list">
											<li><a href="#">5 Star <i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i> 01
											</a></li>
											<li><a href="#">4 Star <i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i> 01
											</a></li>
											<li><a href="#">3 Star <i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i> 01
											</a></li>
											<li><a href="#">2 Star <i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i> 01
											</a></li>
											<li><a href="#">1 Star <i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i> 01
											</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="review_list">
								<div class="review_item">
									<div class="media">
										<div class="d-flex">
											<img src="img/product/review-1.png" alt="">
										</div>
										<div class="media-body">
											<h4>Blake Ruiz</h4>
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit, sed do eiusmod tempor incididunt ut labore et dolore
										magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation ullamco laboris nisi ut aliquip ex ea commodo</p>
								</div>
								<div class="review_item">
									<div class="media">
										<div class="d-flex">
											<img src="img/product/review-2.png" alt="">
										</div>
										<div class="media-body">
											<h4>Blake Ruiz</h4>
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit, sed do eiusmod tempor incididunt ut labore et dolore
										magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation ullamco laboris nisi ut aliquip ex ea commodo</p>
								</div>
								<div class="review_item">
									<div class="media">
										<div class="d-flex">
											<img src="img/product/review-3.png" alt="">
										</div>
										<div class="media-body">
											<h4>Blake Ruiz</h4>
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit, sed do eiusmod tempor incididunt ut labore et dolore
										magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation ullamco laboris nisi ut aliquip ex ea commodo</p>
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="review_box">
								<h4>Add a Review</h4>
								<p>Your Rating:</p>
								<ul class="list">
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
								</ul>
								<p>Outstanding</p>
								<form class="row contact_form" action="contact_process.php"
									method="post" id="contactForm" novalidate="novalidate">
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" id="name" name="name"
												placeholder="Your Full name" onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Your Full name'">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="email" class="form-control" id="email"
												name="email" placeholder="Email Address"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Email Address'">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" id="number"
												name="number" placeholder="Phone Number"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Phone Number'">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<textarea class="form-control" name="message" id="message"
												rows="1" placeholder="Review"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Review'"></textarea>
											</textarea>
										</div>
									</div>
									<div class="col-md-12 text-right">
										<button type="submit" value="submit" class="primary-btn">Submit
											Now</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Product Description Area =================-->

	<!-- Start related-product Area -->
	<section class="related-product-area section_gap_bottom">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6 text-center">
					<div class="section-title">
						<h1>Deals of the Week</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-9">
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="img/r1.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="img/r2.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="img/r3.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="img/r5.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="img/r6.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="img/r7.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<div class="single-related-product d-flex">
								<a href="#"><img src="img/r9.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<div class="single-related-product d-flex">
								<a href="#"><img src="img/r10.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<div class="single-related-product d-flex">
								<a href="#"><img src="img/r11.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="ctg-right">
						<a href="#" target="_blank"> <img
							class="img-fluid d-block mx-auto" src="img/category/c5.jpg"
							alt="">
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End related-product Area -->

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
						<!--                   <h6>Newsletter</h6> -->
						<!--                   <p>Stay update with our latest</p> -->
						<!--                   <div class="" id="mc_embed_signup"> -->

						<!--                      <form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" -->
						<!--                       method="get" class="form-inline"> -->

						<!--                         <div class="d-flex flex-row"> -->

						<!--                            <input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '" -->
						<!--                             required="" type="email"> -->


						<!--                            <button class="click-btn btn btn-default"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button> -->
						<!--                            <div style="position: absolute; left: -5000px;"> -->
						<!--                               <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text"> -->
						<!--                            </div> -->

						<!--                            <div class="col-lg-4 col-md-4"> -->
						<!--                                     <button class="bb-btn btn"><span class="lnr lnr-arrow-right"></span></button> -->
						<!--                                  </div>   -->
						<!--                         </div> -->
						<!--                         <div class="info"></div> -->
						<!--                      </form> -->
						<!--                   </div> -->
					</div>
				</div>
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget mail-chimp">
						현재 총 거래 량
						<!--                   <h6 class="mb-20">Instragram Feed</h6> -->
						<!--                   <ul class="instafeed d-flex flex-wrap"> -->
						<!--                      <li><img src="../resources/img/i1.jpg" alt=""></li> -->
						<!--                      <li><img src="../resources/img/i2.jpg" alt=""></li> -->
						<!--                      <li><img src="../resources/img/i3.jpg" alt=""></li> -->
						<!--                      <li><img src="../resources/img/i4.jpg" alt=""></li> -->
						<!--                      <li><img src="../resources/img/i5.jpg" alt=""></li> -->
						<!--                      <li><img src="../resources/img/i6.jpg" alt=""></li> -->
						<!--                      <li><img src="../resources/img/i7.jpg" alt=""></li> -->
						<!--                      <li><img src="../resources/img/i8.jpg" alt=""></li> -->
						<!--                   </ul> -->
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.../resources/js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
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