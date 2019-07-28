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
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- 웹 소켓 cdn -->
<script	
   src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

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
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
<style>
.blinking{
	-webkit-animation:blink 2.0s ease-in-out infinite alternate;
    -moz-animation:blink 2.0s ease-in-out infinite alternate;
    animation:blink 2.0s ease-in-out infinite alternate;
}
@-webkit-keyframes blink{
    0% {opacity:0;}
    100% {opacity:1;}
}
@-moz-keyframes blink{
    0% {opacity:0;}
    100% {opacity:1;}
}
@keyframes blink{
    0% {opacity:0;}
    100% {opacity:1;}
}
.level{
	width: 45px;
	height: 45px;
	margin-right: 0.5em;
	margin-bottom: 0.8em;
}
#commentGo{
font-size: 15px;
}
#report{
	height: 38px;
	line-height: 30px;
	font-size: 13px;
}
#tender{
	position: relative;
	left: 250px;
	width: 200px;
}
#buy{
	font-size: 15px;
	line-height: 40px;
}
#cart{
	font-size: 20px;
	padding-left: 0.5em;
	padding-right: 0.5em;
	margin-right: 0.2em;
	position: relative;
	top: 2px;
}
#soldOut{
   font-size: 15px;
   margin-right: 0.5em;
}
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

/* 오른쪽 TOP 버튼 */
.btn-fixed {
   position: fixed;
   top: 540px;
   cursor:pointer;
}

.back-to-top {text-decoration: none; display: none; color:#fe912b; }

.back-to-top:hover {color: #818bb0}

</style>
<script>
$(function(){
    var offset = 500;   // 수직으로 어느정도 움직여야 버튼이 나올까?
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

$("#logout_na").on("click", function() {
	console.log("asd");
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
</head>
<body>
<div>
<!-- start fixbutton -->
     <div class="d-none d-lg-block col-lg-1" style=padding-left:90%;>
        <i class="fas fa-chevron-circle-up btn-fixed back-to-top fa-3x"></i>
     </div>
<!-- end fixbutton -->
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
            <div class="col-lg-6" style="margin: auto;">
            <!--이미지 미리보기 -->
               <div id="carouselExampleIndicators" class="carousel slide"
                  data-ride="carousel">
                  <ol class="carousel-indicators">
                     <li data-target="#carouselExampleIndicators" data-slide-to="0"
                        class="active"></li>
                     <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
<!--                      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li> -->
                  </ol>
                  <div class="carousel-inner">
                     <div class="carousel-item active">
                        <img src="img/title/${i_dto.title_img }" class="d-block w-100" onerror="this.style.display='none'" alt='' height=450px; width=auto;>
                     </div>
                     <div class="carousel-item">
                        <img src="img/middle/${i_dto.middle1_img }" class="d-block w-100" onerror="this.style.display='none'" alt='' height=450px; width=auto;>
                     </div>
<!--                      <div class="carousel-item"> -->
<%--                         <img src="img/middle/${i_dto.middle2_img }" class="d-block w-100" onerror="this.style.display='none'" alt='' height=350px; width=auto;> --%>
<!--                      </div> -->
<!--                      <div class="carousel-item"> -->
<%--                         <img src="img/middle/${i_dto.middle3_img }" class="d-block w-100" onerror="this.style.display='none'" alt='' height=350px; width=auto;> --%>
<!--                      </div> -->
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
            <div class="col-lg-5 offset-lg-1" style="margin-left: 0px;margin-right: 20px;">
               <div class="s_product_text1">


                  <div class="container">
                     <table class="table">
                        <tr>
                           <h3 style="text-align: right; padding-right: 12px;">${dto.title }</h3>
                        </tr>
                        <tbody>
                           <tr>
                              <td id=pt>판매가</td>
                              <td colspan=2 class=detail-info style=font-size:25px;font-weight:700;color:#ffba00;>
                                 <fmt:formatNumber value="${dto.price }" pattern="#,###"/>원
                              </td>
                           </tr>
                           <tr>
                              <td>물품번호</td>
                              <td colspan=2 class=detail-info><fmt:formatNumber
                                    value="${dto.no }" pattern="#,###" /></td>
                           </tr>
                           <tr>
                              <td>물품 카테고리</td>
                              <td colspan=2 class=detail-info>${dto.category }</td>
                           </tr>
                           <tr>
                              <td>배송방법</td>
                              <td colspan=2 class=detail-info>${dto.delivery_type }</td>
                           </tr>
                           <tr>
                              <td>배송비용</td>
                              <td colspan=2 class=detail-info><fmt:formatNumber
                                    value="${dto.delivery_cost }" pattern="#,###" />원</td>
                           </tr>
                        </tbody>                  
                     </table>
                     
                   
                  </div>
                  <div style=text-align:right;padding-right:10px;>

                  <c:choose>

                  <c:when test="${dto.onGoing=='y' }">
                  
                  	<c:choose>
                  			<c:when test="${dto.id==email}">
                  				<input type="button" id="cancle" value="삭제하기" class="genric-btn primary radius">
                  			</c:when>
                  	
                  			<c:otherwise>
                     				<input type="button" class="genric-btn primary radius" id="buy" value="구매 하기"/>
                     				<input type="button" id="cart" class="genric-btn primary radius" value="♡">
							</c:otherwise>
							
					</c:choose>
							
                     </c:when>
                     
                     <c:when test="${dto.onGoing=='n' }">
                     <input type="button" class="genric-btn danger radius" id="soldOut" value="판매 완료"/>
                     </c:when>
                     
                     </c:choose>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   
<!--   	구매 script -->
   <script>
   
   
   $("#soldOut").on("click",function(){
	 
	   alert("판매 완료된 상품 입니다.");
   })
   
   $("#cancle").on("click",function(){
	   var result = confirm("정말로 삭제하시겠습니까?");
	   
	   if(result==true){
		   	alert("삭제 되었습니다.");
	   		var no = "${dto.no}";
	   		$(location).attr("href","cancleTrade?no=${dto.no}");
	   }
	   
   })
   
   $("#buy").on("click",function(){
	  
	   if(${email==null}){
		   alert("로그인 하세요.");
		   return false;
	   }
	   
	   var result = confirm("정말로 구매하시겠습니까?");
	   
	   if(result==false){
		   return false;
	   }
	     	   
	   
	   var boardNum = "${dto.no }";
	   var price = Number(${dto.price });
	   var d_price = Number(${dto.delivery_cost });
	   var img = "${i_dto.title_img }";
	   var title = "${dto.title }";
	   var s_id = "${dto.id }";
	   var b_id = "${email}";
	   
	   var myMoney = Number(${myMoney});
	   var price_p = price+d_price;
	   
	   if(myMoney<price_p){
		   alert("보유 잔액이 부족합니다.");
		   return false;
	   }
	   console.log(boardNum + " : " + price + " : " + d_price + " : " + img + " :"  + title + " : " + s_id + " : " + b_id);
	   
	   $.ajax({
		  
		   url:"/buy",
		   data:{
			   "boardNum":boardNum,
			   "price":price+d_price,
			   "img":img,
			   "title":title,
			   "s_id":s_id,
			   "b_id":b_id
		   },
	   }).done(function(resp){
		   
		   if(resp==1){
			   alert("구매 성공!");
			   location.reload();
			   
		   }else{
			   alert("구매 실패!");
			   location.reload();
		   }
		   
	   });
   
   });
   
   </script>
   <!--================End Single Product Area =================-->

   <!--================Product Description Area =================-->
	<section class="product_description_area mb-0 pb-0">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="home-tab"
					data-toggle="tab" href="#home" role="tab" aria-controls="home"
					aria-selected="true">물품정보</a></li>
				<li class="nav-item"><a class="nav-link" id="profile-tab"
					data-toggle="tab" href="#profile" role="tab"
					aria-controls="profile" aria-selected="false">판매자 정보</a></li>
				<li class="nav-item"><a class="nav-link" id="contact-tab"
					data-toggle="tab" href="#contact" role="tab"
					aria-controls="contact" aria-selected="false">배송/반품</a></li>
				<li class="nav-item"><a class="nav-link" id="review-tab"
					data-toggle="tab" href="#review" role="tab" aria-controls="review"
					aria-selected="false" onclick="fnMove()">문의 및 댓글</a></li>
					<input type="button" id="report" class="genric-btn danger radius" value="신고" onclick="showPopup();"/>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade active show" id="home" role="tabpanel"
					aria-labelledby="home-tab" style="text-align: center;">
				
				<!-- 물품정보 -->                                      

               <div class="col-md-62">
                     <p style=text-align:left;font-size:25px;line-height:40px;padding-left:60px;padding-right:60px;padding-top:30px;>
                        ${dto.contents }   
                     </p>
               </div><br><br><br>               
                                                       
               <!-- 상세 이미지  -->
               <div class="selector">
                  <img src="img/title/${i_dto.title_img }"" onerror="this.style.display='none'"
                     alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle1_img }"
                     onerror="this.style.display='none'" alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle2_img }"
                     onerror="this.style.display='none'" alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle3_img }"
                     onerror="this.style.display='none'" alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle4_img }"
                     onerror="this.style.display='none'" alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle5_img }"
                     onerror="this.style.display='none'" alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle6_img }"
                     onerror="this.style.display='none'" alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle7_img }"
                     onerror="this.style.display='none'" alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle8_img }"
                     onerror="this.style.display='none'" alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle9_img }"
                     onerror="this.style.display='none'" alt=''>
               </div>
               <br>
               <div class="selector">
                  <img src="img/middle/${i_dto.middle10_img }"
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
                              <h5>${dto.id }</h5>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <h5>판매자 회원등급</h5>
                           </td>
                           <td>
                              <h5>${dto.member_class }</h5>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <h5>판매자 연락처</h5>
                           </td>
                           <td>
                              <h5>${dto.phone }</h5>
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
                  <div class="input-group flex-nowrap" style=padding-left:16px;>
                        <span class="input-group-text" id="addon-wrapping" style=font-size:15px;line-height:30px;>
                           <img src="img/volume_2.png" alt="" style=width:30px;height:30px;> &nbsp 전자상거래등에서 소비자 보호에 관한 법률에 의한 반품 규정이 판매자가 지정한 반품 조건보다 우선합니다.
                        </span>
                  </div>
                  <div class="container" style=padding-top:30px;>           
                       <table class="table table-striped">                     
                            <tr><tr>   
                                  <td>배송지역</td>
                                <td>전국※제주권 및 도서산간 지역은 배송비가 추가될 수 있습니다.</td>
                             </tr>
                            <tr>
                               <td>배송방법</td>
                                <td>택배, 선불/착불 [2,500원]</td>
                            </tr>
                             <tr>
                                <td>반품기간</td>
                                <td>수령일로부터 7일 이내에 반품을 신청하실 수 있습니다.</td>
                             </tr>
                             <tr>
                                <td>반품비용</td>
                                <td>원인 제공자 부담을 원칙으로 합니다.</td>
                             </tr>
                            <tr><td><td>
                      </table>
                     </div>
                  <div>
                     <div style=padding-left:40px;>
                        ※반품시 주의사항<br>
                        아래 각 호의 경우에는 반품이 되지 않습니다.<br>
                        1)소비자의 책임 있는 사유로 상품 등이 멸실/훼손된 경우(단지 확인을 위한 포장 훼손 제외)<br>
                        2)소비자의 사용/소비에 의해 상품 등의 가치가 현저히 감소한 경우<br>
                        3)시간의 경과에 의해 재판매가 곤란할 정도로 상품 등의 가치가 현저히 감소한 경우<br>
                        4)복제가 가능한 상품 등의 포장을 훼손한 경우<br>
                        5)판매/생산 방식의 특성상, 반품시 판매자에게 회복할 수 없는 손해가 발생하는 경우(주문 접수 후 개별 생산, 맞춤 제작 등)<br><br>
                        
                        ※파손 물품 반품시 주의사항<br>
                        물품 수령시 택배기사와 함께 물품의 파손 여부를 확인하신 후,<br>
                        반품 신청시 파손 이미지를 등록해 주시면 안전하고 신속하게 환불 처리를 해드리고 있습니다.<br><br>
                     </div>
                     <div style=padding-left:30px;font-size:12px;>
                        <blockquote class="generic-blockquote">
                           ※전자상거래 등에서의 소비자 보호에 관한 법률<br>
                           제15조 (재화등의 공급 등) <br>
                           ①통신판매업자는 소비자가 청약을 한 날부터 7일 이내에 재화등의 공급에 필요한 조치를 하여야 하고, 소비자가 재화등을 공급받기 전에 미리 재화등의 대금의 전부 또는 일부를 지급하는 경우(이하 "선불식 통신판매"라 한다)에는 소비자가 그 대금의 전부 또는 일부를 지급한 날부터 3영업일 이내에 재화등의 공급을 위하여 필요한 조치를 하여야 한다. 다만, 소비자와 통신판매업자간에 재화등의 공급시기에 관하여 별도의 약정이 있는 경우에는 그러하지 아니하다. <br>
                           ②통신판매업자는 청약을 받은 재화등을 공급하기 곤란하다는 것을 알았을 때에는 그 사유를 소비자에게 지체 없이 알려야 하고, 선불식 통신판매의 경우에는 소비자가 그 대금의 전부 또는 일부를 지급한 날부터 3영업일 이내에 환급하거나 환급에 필요한 조치를 하여야 한다.<br>
                           ③통신판매업자는 소비자가 재화등의 공급 절차 및 진행 상황을 확인할 수 있도록 적절한 조치를 하여야 한다. 이 경우 공정거래위원회는 그 조치에 필요한 사항을 정하여 고시할 수 있다. <br>
                           ④제18조제1항 내지 제5항의 규정은 제2항의 선불식 통신판매에 있어서 환급하거나 환급에 필요한 조치를 하여야 하는 경우에 이를 준용한다.<br>   <br>
                           제17조(청약철회등) <br>
                           ①통신판매업자와 재화등의 구매에 관한 계약을 체결한 소비자는 다음 각호의 기간(거래당사자가 다음 각호의 기간보다 긴 기간으로 약정한 경우에는 그 기간을 말한다) 이내에 당해 계약에 관한 청약철회등을 할 수있다. <br>
                           1. 제13조제2항의 규정에 의한 계약내용에 관한 서면을 교부받은 날부터 7일. 다만, 그 서면을 교부 받은 때보다 재화등의 공급이 늦게 이루어진 경우에는 재화등의 공급을 받거나 공급이 개시된 날부터 7일 <br>
                           2. 제13조제2항의 규정에 의한 계약내용에 관한 서면을 교부 받지 아니한 경우, 통신판매업자의 주소 등이 기재되지 아니한 서면을 교부 받은 경우 또는 통신판매업자의 주소변경 등의 사유로 제1호의 기간 이내에 청약철회등을 할 수 없는 경우에는 그 주소를 안 날 또는 알 수 있었던 날부터 7일 <br>
                           ②소비자는 다음 각호의 1에 해당하는 경우에는 통신판매업자의 의사에 반하여 제1항의 규정에 의한 청약철회등을 할 수 없다. 다만, 통신판매업자가 제6항의 규정에 따른 조치를 하지 아니하는 때에는 제2호 내지 제4호에 해당하는 경우에도 청약철회등을 할 수 있다. <br>
                           1. 소비자에게 책임 있는 사유로 재화등이 멸실 또는 훼손된 경우. 다만, 재화등의 내용을 확인하기 위하여 포장 등을 훼손한 경우를 제외한다. <br>
                           2. 소비자의 사용 또는 일부 소비에 의하여 재화등의 가치가 현저히 감소한 경우<br>
                           3. 시간의 경과에 의하여 재판매가 곤란할 정도로 재화등의 가치가 현저히 감소한 경우 <br>
                           4. 복제가 가능한 재화 등의 포장을 훼손한 경우 <br>
                           5. 그 밖에 거래의 안전을 위하여 대통령령이 정하는 경우 <br>
                           ③소비자는 제1항 및 제2항의 규정에 불구하고 재화등의 내용이 표시·광고 내용과 다르거나 계약내용과 다르게 이행된 경우에는 당해 재화등을 공급받은 날부터 3월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내에 청약철회등을 할 수 있다.<br><br>
                           제18조(청약철회등의 효과)<br>
                           ①소비자는 제17조제1항 또는 제3항의 규정에 의하여 청약철회등을 행한 경우에는 이미 공급받은 재화등을 반환하여야 한다.<br>
                           ②통신판매업자(소비자로부터 재화등의 대금을 지급 받은 자 또는 소비자와 통신판매에 관한 계약을 체결한 자를 포함한다. 이하 제2항 내지 제10항에서 같다)는 재화등을 반환 받은 날부터 3영업일 이내에 이미 지급 받은 재화등의 대금을 환급하여야 한다. 이 경우 통신판매업자가 소비자에게 재화등의 대금의 환급을 지연한 때에는 그 지연기간에 대하여 공정거래위원회가 정하여 고시하는 지연이자율을 곱하여 산정한 지연이자(이하 "지연배상금"이라 한다)를 지급하여야 한다.<br>
                           ⑨제17조제1항의 규정에 의한 청약철회등의 경우 공급받은 재화등의 반환에 필요한 비용은 소비자가 이를 부담하며 통신판매업자는 소비자에게 청약철회등을 이유로 위약금 또는 손해배상을 청구할 수 없다.<br>
                           ⑩제17조제3항의 규정에 의한 청약철회등의 경우 재화등의 반환에 필요한 비용은 통신판매업자가 이를 부담한다.<br>
                        </blockquote>
                     </div>
                  </div>      
               </div>
            </div>
         </div>
      </div>
   </section>
   
   	<script>
	  function fnMove(){
	        var offset = $("#MovingPoint").offset();
	        $('html, body').animate({scrollTop : offset.top}, 500);
	    }
   </script>
   
   <!-- 댓글 area -->

	<!--================Blog Area =================-->
	<section class="blog_area single-post-area section_gap pt-0 mt-0">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 posts-list">
				
				<br>
				
					<div id="comments">
						<c:forEach var="arr" items="${list }">
							<div class="comments-area comments m-3 p-4">
								<div class="comment-list">
									<div class="single-comment justify-content-between d-flex">
										<div class="user justify-content-between d-flex">
											<div class="desc">
											<c:choose>
											<c:when test="${arr.member_class=='브론즈' }">
											<img alt="" src="/resources/img/브론즈.PNG" class="level">
											</c:when>
											<c:when test="${arr.member_class=='실버' }">
											<img alt="" src="/resources/img/실버.PNG" class="level">
											</c:when>
											<c:when test="${arr.member_class=='골드' }">
											<img alt="" src="/resources/img/골드.PNG" class="level">
											</c:when>
											<c:when test="${arr.member_class=='플래티넘' }">
											<img alt="" src="/resources/img/플래.PNG" class="level">
											</c:when>
											<c:when test="${arr.member_class=='다이아몬드' }">
											<img alt="" src="/resources/img/골드.PNG" class="level">
											</c:when>
											<c:when test="${arr.member_class=='마스터' }">
											<img alt="" src="/resources/img/마스터.png" class="level">
											</c:when>
											</c:choose>
												<h5 style="display: inline">
													<a href="javascript:void(0)">${arr.id }</a>
												</h5>
												<p class="date" style="display:inline;margin-left: 1em">${arr.time }</p>
												<br><br>
												<p class="comment" style="margin-left: 4em">${arr.contents }</p>
											</div>
										</div>
										<c:choose>
											<c:when test="${email==arr.id }">
												<div class="reply-btn">
													<!-- 											<a href="" class="m-1 btn-reply text-uppercase">수정</a>  -->
													<input type="button" seq="${arr.seq }" name="${arr.id }"
														class="m-1 btn-reply text-uppercase commentDelete"
														value="삭제" />
												</div>
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					
					   <div id=MovingPoint></div>	<!-- 댓글 이동 탭 -->
					   
					<div class="row p-0 m-0 numBox">
						<div class="col-12 d-flex justify-content-center navi mt-1">
							<nav aria-label="Page navigation example">
								<ul class="pagination pagination-sm" id="commentNavi">${getNavi}</ul>
							</nav>
						</div>
					</div>
					<div class="comment-form m-3 p-4">
						<form>
							<div class="form-group">
								<textarea class="form-control mb-10" rows="5" id="message"
									name="message" placeholder="메세지를 입력해 주세요."
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '메세지를 입력해 주세요.'" required=""></textarea>
							</div>
							<input type="button" class="genric-btn success circle"
								id="commentGo" value="글 쓰기" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

<!-- 댓글 스크 -->

	<script>
	$(".commentDelete").on("click",function(){
		
		
		
		var seq = $(this).attr("seq");
		var name = $(this).attr("name");
		
		var result = confirm("댓글을 삭제하시겠습니까?");
		if(result==false){
			return false;
		}else{
			$.ajax({
				
				url:"/deleteComment",
				data:{"seq":seq,"name":name}
				
			}).done(function(resp){
				
				$.ajax({
					url:"/commentsTop5",
					data:{"boardNum":${dto.no }},
					dataType:"JSON"
				}).done(function(resp){
					
					alert("삭제되었습니다.");
					location.reload();
	                
			});
				
			}).fail(function(resp){
				
				alert("댓글 삭제 실패요");
			});
		}
	});
		
		
	
		$("#commentGo").on("click", function() {
			
			if(${email==null}){
				alert("로그인 하세요.");
				return false;
			}
			

			var msg = $("#message").val();
			
			if(msg==""){
				alert("내용을 입력해 주세요.");
			}else{
			var result = confirm("댓글을 작성하시겠습니까?");
			
			if(result){
			

			//댓글 작성
			$.ajax({
				url : "/comments",
				data : {"msg":msg,"boardNum":${dto.no }}
			}).done(function(resp) {
				
				$.ajax({
					url:"/commentsTop5",
					data:{"boardNum":${dto.no }},
					dataType:"JSON"
				}).done(function(resp){
					
					$("#message").val("");
					location.reload();
					
// 					AJAX 버림
// 	                var r ="";
	                
// 	                if(resp[4]!=null){
// 		                   r+='<div class="comments-area comments m-3 p-4">';
// 		                   r+='<div class="comment-list">';
// 		                   r+='<div class="single-comment justify-content-between d-flex">'
// 		                   r+='<div class="user justify-content-between d-flex">'
// 		                   r+='<div class="desc">'
// 		                   r+='<h5>'
// 		                   r+='<a href="#">'+resp[4].id+'</a>'
// 		                   r+='</h5>'
// 		                   r+='<p class="date">'+resp[4].time+'</p>'
// 		                   r+='<p class="comment">'+resp[4].contents+'</p>'
// 		                   r+='</div>'
// 		                   r+='</div>'
// 		               	   r+='<div class="reply-btn">'
// 		                   r+='<input type="button" seq='+resp[4].seq+' name='+resp[4].id+' class="m-1 btn-reply text-uppercase commentDelete" value="삭제"/>'
// 		                   r+='</div></div></div></div>'
		                   
		                
		                   
// 		                }
// 		                if(resp[3]!=null){
// 		                	r+='<div class="comments-area comments m-3 p-4">';
// 		                    r+='<div class="comment-list">';
// 		                    r+='<div class="single-comment justify-content-between d-flex">'
// 		                    r+='<div class="user justify-content-between d-flex">'
// 		                    r+='<div class="desc">'
// 		                    r+='<h5>'
// 		                    r+='<a href="#">'+resp[3].id+'</a>'
// 		                    r+='</h5>'
// 		                    r+='<p class="date">'+resp[3].time+'</p>'
// 		                    r+='<p class="comment">'+resp[3].contents+'</p>'
// 		                    r+='</div>'
// 		                    r+='</div>'
// 		                	   r+='<div class="reply-btn">'
// 		                    r+='<input type="button" seq='+resp[3].seq+' name='+resp[3].id+' class="m-1 btn-reply text-uppercase commentDelete" value="삭제"/>'
// 		                    r+='</div></div></div></div>'
// 		                }
// 		                if(resp[2]!=null){
// 		                	r+='<div class="comments-area comments m-3 p-4">';
// 		                    r+='<div class="comment-list">';
// 		                    r+='<div class="single-comment justify-content-between d-flex">'
// 		                    r+='<div class="user justify-content-between d-flex">'
// 		                    r+='<div class="desc">'
// 		                    r+='<h5>'
// 		                    r+='<a href="#">'+resp[2].id+'</a>'
// 		                    r+='</h5>'
// 		                    r+='<p class="date">'+resp[2].time+'</p>'
// 		                    r+='<p class="comment">'+resp[2].contents+'</p>'
// 		                    r+='</div>'
// 		                    r+='</div>'
// 		                	   r+='<div class="reply-btn">'
// 		                    r+='<input type="button" seq='+resp[2].seq+' name='+resp[2].id+' class="m-1 btn-reply text-uppercase commentDelete" value="삭제"/>'
// 		                    r+='</div></div></div></div>'
// 		                }
// 		                if(resp[1]!=null){
// 		                	r+='<div class="comments-area comments m-3 p-4">';
// 		                    r+='<div class="comment-list">';
// 		                    r+='<div class="single-comment justify-content-between d-flex">'
// 		                    r+='<div class="user justify-content-between d-flex">'
// 		                    r+='<div class="desc">'
// 		                    r+='<h5>'
// 		                    r+='<a href="#">'+resp[1].id+'</a>'
// 		                    r+='</h5>'
// 		                    r+='<p class="date">'+resp[1].time+'</p>'
// 		                    r+='<p class="comment">'+resp[1].contents+'</p>'
// 		                    r+='</div>'
// 		                    r+='</div>'
// 		                	   r+='<div class="reply-btn">'
// 		                    r+='<input type="button" seq='+resp[1].seq+' name='+resp[1].id+' class="m-1 btn-reply text-uppercase commentDelete" value="삭제"/>'
// 		                    r+='</div></div></div></div>'
// 		                }
// 		                if(resp[0]!=null){
// 		                	r+='<div class="comments-area comments m-3 p-4">';
// 		                    r+='<div class="comment-list">';
// 		                    r+='<div class="single-comment justify-content-between d-flex">'
// 		                    r+='<div class="user justify-content-between d-flex">'
// 		                    r+='<div class="desc">'
// 		                    r+='<h5>'
// 		                    r+='<a href="#">'+resp[0].id+'</a>'
// 		                    r+='</h5>'
// 		                    r+='<p class="date">'+resp[0].time+'</p>'
// 		                    r+='<p class="comment">'+resp[0].contents+'</p>'
// 		                    r+='</div>'
// 		                    r+='</div>'
// 		                	   r+='<div class="reply-btn">'
// 		                    r+='<input type="button" seq='+resp[0].seq+' name='+resp[0].id+' class="m-1 btn-reply text-uppercase commentDelete" value="삭제"/>'
// 		                    r+='</div></div></div></div>'
// 		                }
	                
// 	                $("#comments").html(r);
				

	    			//댓글 최근5개 가져오기
	    			
	                
			});
				
			});
			
			}
			}
		});		
	</script>
   
   <!--================End Product Description Area =================-->

   <!-- Start related-product Area -->
   <section class="related-product-area section_gap_bottom">
      <div class="container">
         <div class="row justify-content-center">
            <div class="col-lg-6 text-center">
               <div class="section-title">
                  <p class="image blinking">새로 올라온 안전거래 게시글들을 확인해 보세요.</p>
               </div>
            </div>
         </div>
         <br><br>
         <div class="row" style="margin-left: 3.5em">
            <div class="col-lg-12">
               <div class="row">
              	<c:forEach var="arr" items="${d_list }">
                  <div class="col-lg-4 col-md-4 col-sm-6 mb-3" style="">
                     <div class="single-related-product d-flex">
                        <a href="/used_detailPage?no=${arr.no}"><img id="f_img" src="../resources/img/title/${arr.title_img}" alt="" style="width: 130px;display: inline;"></a>
                        <div class="desc">
                           <a href="/used_detailPage?no=${arr.no}" class="title">${arr.title }</a>
                           <div class="price">
                      			<h6>현재가격 : <fmt:formatNumber value="${arr.price}" pattern="#,###" />원</h6>
                           </div>
                        </div>
                     </div>
                  </div>
                  </c:forEach>
                  
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
	
	<script>
	
	$("#cart").on("click",function(){
		if(${email==null}){
			   alert("로그인 하세요.");
			   return false;
		   }
		$.ajax({
			url : "/steamingTrade",
			data : {"no":"${dto.no}","title_img":"${i_dto.title_img}",
				"title":"${dto.title}","trade_type":"${dto.trade_type}",
				"category":"${dto.category}","price":"${dto.price}","id":"${dto.id}"}
		}).done(function(resp){
			alert(resp);
		})
	});

	$("#report").on("click",function(){
		if(${email==null}){
			   alert("로그인 하세요.");
			   return false;
		   }else{
			   $.ajax({
				   url:"/go",
				   data:{"no":"${dto.no}","type":"중고거래"}
			   }).done(function(resp){
				   window.open("resources/index.html", "a", "width=550, height=500, left=450, top=300");
				   
			   })
			   }

		   
	}) 
		
	</script>
	
   <script src="https://use.fontawesome.com/releases/v5.0.0/js/all.js"></script>
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
   </div>
   </body>
   </html>
