<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<<<<<<< HEAD
<link rel="shortcut icon" href="../resources/img/fav.png">
=======
<link rel="shortcut icon" href="../resources/img/logo.png">
>>>>>>> c938872d2f440fb7c185291352b16ebcdd0faa8b
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
<script src="https://unpkg.com/popper.js"></script>
<<<<<<< HEAD
=======
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
>>>>>>> c938872d2f440fb7c185291352b16ebcdd0faa8b
<script>

var rgx1 = /\D/g;  // /[^0-9]/g 와 같은 표현
var rgx2 = /(\d+)(\d{3})/; 
var regAccount = /^[\d]{9,20}$/g;
function getNumber(obj){
    var num01;
    var num02;
    num01 = obj.value;
    num02 = num01.replace(rgx1,"");
    num01 = setComma(num02);
    obj.value =  num01;
}
function getNumber2(obj){
    var num01;
    var num02;
    num01 = obj.value;
    num02 = num01.replace(rgx1,"");
    obj.value =  num02;
}
function setComma(inNum){
    var outNum;
    outNum = inNum; 
    while (rgx2.test(outNum)) {
         outNum = outNum.replace(rgx2, '$1' + ',' + '$2');
     }
    return outNum;
}
$(function(){
	<c:choose>
	<c:when test="${logintype==null}">
		alert("로그인이 필요합니다");
		$(location).attr("href","login_main");
	</c:when>
	</c:choose>
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
	$('[data-toggle="tooltip"]').tooltip();
	
    if("${id==null}"==true){
    	alert("로그인이 필요 합니다.");
    	$(location).attr("href","/");
    }else{
    	var email="${email}";
    }
	$("#btn").on("click",function(){
		var  money = Number($("#money").val().replace(/,/gi,""));
		if($("#money").val()=="" || $("#account").val()=="" ){
			alert("입력 되지 않은 값이 있습니다");
		}else{
			if(money > 999999999 || 1000 > money){
				alert("금액이 너무 크거나 작습니다");
			}else{
				$.ajax({
					url:"p_exc",
					data:{
						money:money
					},
				}).done(function(resp){
					alert(resp);
					$(location).attr("href","/toPoint_exc");
				});
			}
		}
	});
	$("#account").on("focusout",function(){
		var account=$("#account").val();
		if(!regAccount.test(account)){
			alert('잘못된 계좌 번호입니다.(9자 이상)');
            $("#account").val("");
		}
	})

});
</script>
<style>
.h1 {
	text-align: center;
}

.payment {
	text-align: center;
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
.nice-select .list{
	overflow-y:scroll;
	height:200px;
}

.footerTitle {
	font-size: 20px;
	text-align: center;
	font-color: white;
}
</style>
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
<<<<<<< HEAD
							<li class="nav-item "><a class="nav-link" href="/">공지사항</a></li>
=======
							<li class="nav-item "><a class="nav-link" href="notice_main">공지사항</a></li>
>>>>>>> c938872d2f440fb7c185291352b16ebcdd0faa8b
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
				<h1>포인트 충전</h1>
				<nav class="d-flex align-items-center"> <a href="/">메인페이지<span
					class="lnr lnr-arrow-right"></span></a> <a href="/topoint_exc">포인트환급<span
					class="lnr "></span></a> </nav>
			</div>
		</div>
	</div>
	</section>
	<c:choose>
		<c:when test="${logintype==''}">
			<div class="card text-center">
				<div class="card-header">실패!</div>
				<div class="card-body">
					<h5 class="card-title">해당 서비스는 로그인이 필요합니다!</h5>
					<p class="card-text">로그인 이후 포인트 환급을 이용 해주시기 바랍니다!</p>
					<a href="/login_main" class="btn btn-primary">로그인 하러 가기</a>
				</div>
				<div class="card-footer text-muted"></div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="header mt-5">
				<div class="row ">
					<div class="header col-lg-12 ">
						<h1 style="color: #f7b825;" class="h1">환급하기</h1>
					</div>
				</div>
			</div>
			<div class="container mt-5">
				<div class=" main2 row mt-5">
					<div class=" col-lg-4 col-md-4 col-sm-4">
						<h3>현재 보유 포인트</h3>
					</div>
					<div class=" col-lg-8 col-md-8 col-sm-8">
						<input type="text" class="form-control" 
							 value="<fmt:formatNumber value="${point}" pattern="#,###" />" readonly>
					</div>

				</div>
				<div class="main1 row pt-3 mt-4">
					<div class="  col-lg-4 col-md-4 col-sm-4 ">
						<h3 style="margin-top: 8px;">은행</h3>
					</div>
					<div class="col-lg-8 col-md-8 col-sm-8 float-left">
						<select id="bank">
							<option value="001">한국은행</option>
							<option value="004">KB국민은행</option>
							<option value="088">신한은행</option>
							<option value="020">우리은행</option>
							<option value="081">KEB하나은행</option>
							<option value="089">케이뱅크</option>
							<option value="090">카카오뱅크</option>
							<option value="002">KDB산업은행</option>
							<option value="003">IBK기업은행</option>
							<option value="008">한국수출입은행</option>
							<option value="011">NH농협은행</option>
							<option value="023">SC제일은행</option>
							<option value="027">한국시티은행</option>
							<option value="045">새마을금고</option>
							<option value="088">신한은행</option>
							<option value="000">기타</option>
						</select>
					</div>
				</div>
				<div class=" main2 row mt-5">
					<div class=" col-lg-4 col-md-4 col-sm-4">
						<h3>계좌번호</h3>
					</div>
					<div class=" col-lg-8 col-md-8 col-sm-8">
						<input type="text" class="form-control" 
							id="account" placeholder="환급하실 은행의 계좌번호를 (-)를 제외하고 입력해 주세요." onchange="getNumber2(this);" onkeyup="getNumber2(this);">
					</div>
					
				</div>
				<div class=" main2 row mt-5">
					<div class=" col-lg-4 col-md-4 col-sm-4">
						<h3>환급 금액</h3>
					</div>
					<div class=" col-lg-8 col-md-8 col-sm-8">
						<input type="text" class="form-control" 
							id="money" placeholder="환급하실 금액을 입력해 주세요." requierd onchange="getNumber(this);" onkeyup="getNumber(this);" data-toggle="tooltip" data-placement="top" title="1 Point = 1 원 ">
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12 mt-5 payment mb-5">
						<input type="button" class="genric-btn primary-border circle"
							id="btn" style="font-size: 1.5em" value="환급 하기" requierd>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
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