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
<script
	src="https://unpkg.com/popper.js"></script>
	<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
</head>
<style>
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
#qm:hover {
	cursor:pointer;
}
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
</style>
<script>
	$(function() {

		<c:choose>
		<c:when test="${logintype==null}">
		alert("로그인후 이용 가능합니다");
		$(location).attr("href", "/login_main");
		</c:when>
		</c:choose>
		$('[data-toggle="tooltip"]').tooltip();
		$("#on").hide();
		$("#logout_na").on("click",function() {
							$.ajax({
										url : "logout",
										type : "get"
									}).done(
											function() {
												var naver = open(
														"https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/",
														"_blank",
														"width=100,height=100");
												setTimeout(function() {
													naver.close();
													location.reload(true);
												}, 1000);
											});
						});
		$("#logout_ka").on("click", function() {
					$.ajax({
						url : "logout",
						type : "get"
					}).done(
							function() {
								var kakao = open(
										"https://developers.kakao.com/logout",
										"_blank", "width=100,height=100");
								setTimeout(function() {
									kakao.close();
									location.reload(true);
								}, 1000);
							});
				});
		$("#pwT").on("click",function(){
			$("#off").hide();
			$("#on").toggle();	
		});
		$("#infoInsert").on("click",function(){
			$(location).attr("href","/infoInsert");
		});
		$("#pwCk").on("click",function(){
			var pw = $("#pw").val();
			$.ajax({
				url:"pwCk",
				data: {
					pw:pw
				}
			}).done(function(resp){
				if(resp=='1'){
					alert("인증완료");
					open("/change_Pw","_blank", "width=500,height=500");
				}else {
					alert("비밀번호가 틀렸습니다");
					$("#pw").val("");
					$("#on").hide();
					$("#off").toggle();
				}
			})
		});
		$("#withdrawal").on("click",function(){
			var logintype="${logintype}";
			if(logintype=="email"){
				var pw=prompt("비밀번호를 입력해 주세요");
				$.ajax({
					url:"pwCk",
					data:{
						pw:pw
					}
				}).done(function(resp){
					if(resp=='1'){
						$.ajax({
							url:"withdrawal"
						}).done(function(resp2){
							if(resp2=="fa"){
								alert("탈퇴 실패");
								location.reload();
							}else{
								alert("탈퇴가 완료되었습니다");
								location.reload();
							}
						})
					}else{
						alert("pw가 틀렸습니다");
					}
				});
			}else if(logintype=="naver"){
				var ans=confirm("정말 탈퇴 하시겠습니까?");
				if(ans==true){
					$.ajax({
						url:"withdrawal_na"
					}).done(function(resp2){
						if(resp2=="fa"){
							alert("탈퇴 실패");
							location.reload();
						}else{
							alert("탈퇴가 완료되었습니다");
							location.reload();
						}
					})
				}
				
			}else if(logintype=="kakao"){
				var ans=confirm("정말 탈퇴 하시겠습니까?");
				if(ans==true){
					$.ajax({
						url:"withdrawal_ka"
					}).done(function(resp2){
						if(resp2=="fa"){
							alert("탈퇴 실패");
							location.reload();
						}else{
							alert("탈퇴가 완료되었습니다");
							location.reload();
						}
					})
				}
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
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>내 정보</h1>
					<nav class="d-flex align-items-center">
						<a href="/">메인페이지<span class="lnr lnr-arrow-right"></span></a> <a
							href="/goMyPage">마이페이지<span class="lnr lnr-arrow-right"></span></a>
						<a href="/goMyPage">내 정보<span class="lnr"></span></a>
				</div>
			</div>
		</div>
	</section>
	<div class="container mt-4 mb-4">
		<div class="row">
			<div class="col-12">
				<div class="card text-center">
					<div class="card-header">
						<ul class="nav nav-tabs card-header-tabs">
							<li class="nav-item"><a class="nav-link active"
								href="/goMyPage"><b>내 정보</b></a></li>
							<li class="nav-item"><a class="nav-link" href="/goMyPage_delivery?or_currentPage=1&te_currentPage=1"><b>주문 조회</b></a></li>
							<li class="nav-item"><a class="nav-link " href="/goMyPage_sold?or2_currentPage=1&used_currentPage=1&auc_currentPage=1"><b>판매 조회</b></a></li>
						</ul>
					</div>
					<div class="card-body">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<th scope="row">ID</th>
									<td colspan="2">${email }</td>
								</tr>
								<c:choose>
									<c:when test="${logintype=='email'}">
										<tr id="off">
											<th scope="row">PW</th>
											<td colspan="2"><input type="button" id="pwT" class="genric-btn primary-border circle" value="비밀번호 변경하기"></td>
										</tr >
										<tr id="on">
											<th scope="row">PW</th>
											<td ><input type="password" id ="pw" placeholder="비밀번호를 입력하세요"></td>
											<td ><input type="button" id="pwCk" class="genric-btn primary-border circle" value="입력"></td>
										</tr>
										
									</c:when>
								</c:choose>
								<tr>
									<th scope="row">성함</th>
									<td colspan="2">${name }</td>
								</tr>
								<tr>
									<th scope="row">전화번호</th>
									<td colspan="2">${phone }</td>
								</tr>
								<tr>
									<th scope="row">보유 포인트</th>
									<td colspan="2"><fmt:formatNumber value="${point}" pattern="#,###" /></td>
								</tr>
								<tr>
									<th scope="row">우편번호</th>
									<td colspan="2">${zipcode }</td>
								</tr>
								<tr>
									<th scope="row">주소(배송지)</th>
									<td >${address1 }</td>
									<td >${address2 }</td>
								</tr>
								<tr>
									<th scope="row">회원등급<img
											src="../resources/img/qm.png" width="30px" id="qm" data-toggle="tooltip"  data-html="true" data-placement="right" title="<p>브론즈=기본  <br> 실버=댓글 1,판매 1 <br> 골드=댓글 5,판매 5 <br> 플래티넘=댓글 10,판매 10 <br> 다이아=댓글 50,판매 50 <br> 마스터=댓글 100,판매 100 </p>"></th>
									<td colspan="2">${member_class}</td>
								</tr>
								<tr>
									<th scope="row" colspan="3"><input type="button" id="infoInsert" class="genric-btn primary circle mr-3" value="정보 수정 하기">
									<input type="button" id="withdrawal" class="genric-btn danger circle " value="탈퇴하기"></th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				
			</div>
		</div>
	</div>

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
						현재 활성화된 경매수 <br>             
						&emsp;&emsp; : <fmt:formatNumber value="${auctionActiveCount }" pattern="#,###"/> 건 
					</div>
				</div>
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget mail-chimp">
						현재 총 거래 량<br>
						&emsp;&emsp; : <fmt:formatNumber value="${totalCount }" pattern="#,###"/> 건 
					</div>
				</div>
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Follow Us</h6>
						<p>Let us be social</p>
						<div class="footer-social d-flex align-items-center">
							<a href="#"><i class="fa fa-facebook"></i></a>
							<a href="#"><i class="fa fa-twitter"></i></a>
							<a href="#"><i class="fa fa-dribbble"></i></a>
							<a href="#"><i class="fa fa-behance"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
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
	</div>
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