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
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
<script
	src=https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js></script>
<!-- 모든 브라우저 호완성을 위해 추가  -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
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
a{
	font-size: 18px;
	color: black;
}
.cart_inner .table tbody tr td {
    padding-top: 20px;
    padding-bottom: 20px;
    vertical-align: middle;
    align-self: center;
}
.btn{
	font-size: 15px;
    font-weight: bold;
    border : 1px solid;
}
.page-link{
	color:black;
}
@media only screen and (max-width: 1200px) {
	.order table td:nth-child(4),
	.order table th:nth-child(4),
	.order table td:nth-child(6), 
	.order table th:nth-child(6){display: none;}
}
 
@media only screen and (max-width: 1000px) {
	.order table td:nth-child(1),
	.order table th:nth-child(1),
	.order table td:nth-child(3),
	.order table th:nth-child(3),
	.order table td:nth-child(5),
	.order table th:nth-child(5),
	.order table td:nth-child(7),
	.order table th:nth-child(7){display: none;}
}

.footerTitle {
	font-size: 20px;
	text-align: center;
	font-color: white;
}
</style>
<script>
	$(function() {
		<c:choose>
		<c:when test="${logintype==null}">
		alert("로그인후 이용 가능합니다");
		$(location).attr("href", "/login_main");
		</c:when>
		</c:choose>
		$("#logout_na")
				.on("click",function() {
							$.ajax({
										url : "logout",
										type : "get"
									})
									.done(function() {
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
		$("#logout_ka").on("click",function() {
					$.ajax({
						url : "logout",
						type : "get"
					}).done(function() {
								var kakao = open(
										"https://developers.kakao.com/logout",
										"_blank", "width=100,height=100");
								setTimeout(function() {
									kakao.close();
									location.reload(true);
								}, 1000);
							});
				});
		$(".confirme").on("click",function(){
			var anwser=confirm("정말 구매 확정 하시겠습니까?");
			if(anwser==true){
				var seq = $(this).attr("seq");
				$(location).attr("href","/confirme?seq="+seq);
			}
		})
		$(".refund").on("click",function(){
			var anwser=confirm("정말 환불 요청 하시겠습니까?");
			if(anwser==true){
				var seq = $(this).attr("seq");
				open("/goRefund?seq="+seq, "_blank", "width=500,height=500");
			}
		})
		$(".lookup").on("click",function(){
			$.ajax({
				url:"lookup",
				data:{
					seq:$(this).attr("seq")
				}
			}).done(function(resp){
				open(
						"/golookup?resp="+resp,
						"_blank", "width=1000,height=600");
			});
			//대기
		});
		$(".start").on("click",function(){
			var seq =$(this).attr("seq");
			var reci=$(this).attr("buyer");
			open(
					"/delivert_insert?seq="+seq+"&reci="+reci,
					"_blank", "width=500,height=500");
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
					<h1>주몬 조회</h1>
					<nav class="d-flex align-items-center">
						<a href="/">메인페이지<span class="lnr lnr-arrow-right"></span></a> <a
							href="/goMyPage">마이페이지<span class="lnr lnr-arrow-right"></span></a>
						<a href="/goMyPage_delivery?or_currentPage=1&te_currentPage=1">주문 조회<span class="lnr"></span></a>
						</nav>
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
							<li class="nav-item"><a class="nav-link " href="/goMyPage"><b>내
										정보</b></a></li>
							<li class="nav-item"><a class="nav-link active"
								href="/goMyPage_delivery?or_currentPage=1&te_currentPage=1"><b>주문 조회</b></a></li>
							<li class="nav-item"><a class="nav-link " href="/goMyPage_sold?or2_currentPage=1&used_currentPage=1&auc_currentPage=1"><b>판매
										조회</b></a></li>
						</ul>
					</div>
					<div class="card-body">
        <div class="container">
            <div class="cart_inner">
                <div >
                <h1>배송 조회</h1>
                <hr>
                <div class="order">
                    <table class="table" >
                        <thead>
                            <tr>
                                <th scope="col">주문번호</th>
                                <th scope="col">물품</th>
                                <th scope="col">가격</th>
                                <th scope="col">판매자</th>
                                <th scope="col">거래종류</th>
                                <th scope="col">구입(낙찰)일</th>
                                <th scope="col">주문상태</th>
                                <th scope="col">구매확정</th>
                            </tr>
                        </thead>
                        <tbody>
                           <c:choose>
                           <c:when test="${order_list==null}">
                           <tr>
                           <td colspan="8">
                           <div class="media">
                                        <div class="media-body">
                                            <p>구매 하신 물품이 없습니다.</p>
                                        </div>
                                    </div>
                           </td>
                           </tr>
                           </c:when>
                           <c:otherwise>
                           		<c:forEach items="${order_list}" var="i">
                           			<tr>
                           			<td>
                           			<h5>${i.seq }</h5>
                           			</td>
                           			<td>
                           			<div class="media">
                           			<c:choose>
                           			<c:when test="${i.type=='거래' }">
                                        <div class="d-flex">
                                        	<a href="/used_detailPage?no=${i.product_num }">
                                            	<img src="/img/title/${i.product_img}" width="150px" height="100px"  alt="">
                                            </a>
                                        </div>
                                        <div class="media-body">
                                        	<a href="/used_detailPage?no=${i.product_num }">
                                            <p>${i.product_title }</p>
                                            </a>
                                        </div>
                                        </c:when>
                                        <c:when test="${i.type=='경매' }">
                                        <div class="d-flex">
                                        	<a href="#">
                                            	<img src="/img/title/${i.product_img}" width="150px" height="100px"  alt="">
                                            </a>
                                        </div>
                                        <div class="media-body">
                                        	<a href="#">
                                            <p>${i.product_title }</p>
                                            </a>
                                        </div>
                                        </c:when>
                                        </c:choose>
                                    </div>
                                    </td>
                                    <td>
                                    <h5><fmt:formatNumber value="${i.price}" pattern="#,###" /></h5>
                                    </td>
                                    <td>
                                    <h5>${i.seller }</h5>
                                    </td>
                                    <td>
                                    <h5>${i.type}</h5>
                                    </td>
                                    <td>
                                    <h5>${i.join_date }</h5>
                                    </td>
                                    <td>
                                    <h5>${i.situation }</h5>
                                    </td>
                                    <td>
                                    <c:choose>
                                    <c:when test="${i.situation=='배송중'}">
                                     <h5><input type=button class="lookup btn btn-light" seq="${i.seq }" value="배송조회"></h5>
                                    </c:when>
                                    <c:when test="${i.situation=='배송완료'}">
                                    <h5><input type=button class="confirme btn btn-light" seq="${i.seq }" value="구매확정"></h5>
                                    <h5><input type=button class="refund btn btn-light" seq="${i.seq }" value="환불요청"></h5>
                                    </c:when>
                                     <c:when test="${i.situation=='구매확정'}">
                                    <h5>구매확정</h5>
                                    </c:when>
                                     <c:when test="${i.situation=='환불요청'}">
                                    <h5>환불처리 중</h5>
                                    </c:when>
                                    <c:when test="${i.situation=='환불처리완료'}">
                                    <h5>환불처리 완료</h5>
                                    </c:when>
                                    </c:choose>
                                    </td>
                           			</tr>
                           		</c:forEach>
                           </c:otherwise>
                           </c:choose>
                       </tbody>
                     </table>
                     </div>
                      <div class="media">
                                        <div class="media-body">
                                            <p>${order_navi}</p>
                                        </div>
                                    </div>
                     <h1 class="mt-5">내가 입찰 중인 상품</h1><hr>
                     <div class="order">
                     <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">번호</th>
                                <th scope="col">물품</th>
                                <th scope="col">현재 입찰가</th>
                                <th scope="col">현재 입찰자</th>
                                <th scope="col">입찰</th>
                                <th scope="col">경매 진행 상황</th>
                            </tr>
                        </thead>
                        <tbody>
                         <c:choose>
                           <c:when test="${tender_list==null}">
                            <tr>
                           <td colspan="6">
                           <div class="media">
                                        <div class="media-body">
                                            <p>입찰 하신 물품이 없습니다.</p>
                                        </div>
                                    </div>
                           </td>
                           </tr>
                           </c:when>
                           <c:otherwise>
                           <c:forEach items="${tender_list}" var="i">
                           <tr>
                           			<td>
                           			<h5>${i.seq }</h5>
                           			</td>
                           			<td>
                           			<div class="media">
                                        <div class="d-flex">
                                        	<a href="/auction_detailPage?no=${i.board_num }">
                                            	<img src="/img/title/${i.board_img}" width="150px" height="100px"  alt="">
                                            </a>
                                        </div>
                                        <div class="media-body">
                                        	<a href="/auction_detailPage?no=${i.board_num }">
                                            <p>${i.board_title }</p>
                                            </a>
                                        </div>
                                    </div>
                                    </td>
                                    <td>
                                    <h5><fmt:formatNumber value="${i.point}" pattern="#,###" /></h5>
                                    </td>
                                    <td>
                                    <h5>${i.id }</h5>
                                    </td>
                                    <td>
                                    <c:choose>
                                    <c:when test="${i.id!=email}">
                                    <h5><a href="/auction_detailPage?no=${i.board_num }"><input type=button class="tender btn btn-light" value="입찰 하러가기"></a></h5>
                                    </c:when>
                                    </c:choose>
                                    </td>
                                    <td>
                                    <c:choose>
                                    <c:when test="${i.onGoing=='y' }">
                                   	경매 진행 중
                                    </c:when>
                                    <c:otherwise>
                                    	판매완료
                                    </c:otherwise>
                                    </c:choose>
                                    </td>
                           			</tr>
                           </c:forEach>
                           </c:otherwise>
                           </c:choose>
                        </tbody>
					</table> 
					</div>
					</div>
					<div class="media">
                                        <div class="media-body ">
                                            <p>${tender_navi }</p>
                                        </div>
                                    </div>                       
                   </div>
                 </div>
               </div>
					</div>
				</div>
			</div>
		</div>

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