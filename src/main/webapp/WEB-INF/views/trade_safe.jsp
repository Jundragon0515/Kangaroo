
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>중고 안전거래</title>

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
<link rel="stylesheet" href="../resources/css/main.css">
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">

<style>
 
/*   * {
   box-sizing: border-box;
   border: 1px solid black;
   word-break:break-all;
} */    

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

.btn-navi : hover {
   background-color: #F2F2F2;
}

.header-nav {
   position: fixed;
   width: 100%;
}

.jumbo {
   height: 350px;
   position: relative;
   top: 100px;
}

.header-category {
   position: relative;
   top: 50%;
}

/* carousel 크기  */
.carousel-size {
   margin-top: 20px;
}

.list-group>ul>li {
   width: 14.2%;
   float: left;
}

.item-list>li {
   width: 10%;
   float: left;
}

.list-nav {
   background-color: #F2F2F2;
   margin-left: 1px;
   margin-right: 1px;
   margin-bottom: 10px;
}

/* 선택된 물건의 총 개수  */
.list-nav-total {
   font-size: 20px;
   position: relative;
   top: 10px;
}

/* 안전거래or직거래 표시  */
.type {
   position: absolute;
   width: 100px;
   height: 30px;
   padding-left: 10px;
   padding-top: 0px;
   background-color: #FFBF00;
}

.type>span {
   color: black;
}

.type:hover {
   cursor: pointer;
}

/* 등록상품 메인 이미지  */
.product-img-size {
   width: 330px;
   height: 230px;
}
/*카드리스트 마우스 오버*/
.card:hover {
   border: solid 1px #ffba00;
   margin: -1px;
}

/*텍스트 가운데 정렬  */
.text-center {
   text-align: center;
}

/* 게시판 페이징  */
.paging {
   position: relative;
   left: 45%;
}


/* 네비버튼 영역 */
.naviArea {
   margin-bottom: 30px;
}

/* 검색창 크기  */
.searchArea {
   position: relative;
   left: 10%;
   width: 70%;
}

/* 오른쪽 TOP 버튼 */
.btn-fixed {
   position: fixed;
   top: 540px;
   cursor:pointer;
}

/* 왼쪽 Category 영역  */
.category-area{
   position: relative;
   padding-top:100px;
}

/* 판매완료 표시 */
.ongoing-btn {
   position: absolute;
   width: 100%;
   height: 100%;
   margin-left:-1px;
   background-color: gray;
   opacity:0.5;
   z-index:4;
   cursor:pointer;
}

/* 판매완료 이미지  */
.onging-img {
    position: absolute;
    width: 100%;
    top: 30%;
    z-index:5;
    cursor:pointer;
}

.atag-text{
	position:relative;
	text-align:center;
	width:100%;
	left:20%;
}

.atag-category{
	position:relative;
	text-align:center;
	width:100%;
}

/* 폰트 이미지  */
.fontawesome{
	position:relative;
	top:6%;
}

/* 조회수  */
.view{
	position:relative;
	top:10%;
	text-align:center;
}

/* 입력날짜 */
.joinDate{
position:relative;
	top:10%;
	text-align:center;
}

.back-to-top {text-decoration: none; display: none; color:#fe912b;}

.back-to-top:hover {color: #818bb0}

/* 삭제버튼  */
#btn-delete{
	border: 1px solid #828bb3;
	background-color:#828bb3;
	color:white;
}

/* 삭제버튼 hover  */
#btn-delete:hover {
	cursor: pointer;
}
#checkAllTradeSafeBoard {
    left: 89%;
    position: relative;
}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

   $(function(){
       var offset = 50;   // 수직으로 어느정도 움직여야 버튼이 나올까?
       var duration = 600;   // top으로 이동할때까지의 animate 시간 (밀리세컨드, default는 400. 예제의 기본은 500)
       $(window).scroll(function() {
           if ($(this).scrollTop() > offset) {
               $('.back-to-top').fadeIn(duration);
           } else {
               $('.back-to-top').fadeOut(duration);
           }
       });
       
       /* 판매완료 -> 상세보기 */
       $(".onging-img").on("click", function(){
    	  	var href = $(".ongoing-href").val();
    	    $(location).attr("href", "/used_detailPage?no=" + href);
       });
       
       /* 판매완료 -> 상세보기 */
       $(".ongoing-btn").on("click", function(){
   	  		var href = $(".ongoing-href").val();
	    	$(location).attr("href", "/used_detailPage?no=" + href);
       });
       
       /* 위로가기 버튼  */
       $('.back-to-top').click(function(event) {
           event.preventDefault();
           $('html, body').animate({scrollTop: 0}, duration);
           return false;
       })
       
       /* 검색기능 */
      $("#btn-search").on("click", function(){
         var text_search =  $("#text-search").val();
         $(location).attr("href", "tradeOption_safe?search="+text_search);
      });
       
       /* 검색 엔터키 */
       $("#text-search").keydown(function(key){
    	   if(key.keyCode==13){
    		   var text_search = $("#text-search").val();
    		   $(location).attr("href", "/tradeOption_safe?search="+text_search);
    	   }
       });
       
       /* 삭제버튼 */
       $("#btn-delete").on("click", function(){
    	   $("#deleteForm").submit();
       });
      
      
      /* 페이지 정렬 개수 컨트롤  */
       $("#viewCount").on("change", function(){
         var view = $(this).val();
         $(location).attr("href","tradeOption_safe?view=" + view);
      });
       
      /*네이버 로그아웃  */
      $("#logout_na").on("click",function() {
               $.ajax({
                     url : "logout",
                     type : "get"
                     })
                     .done(function() {
                           var naver = open("https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/","_blank",
                                    "width=100,height=100");
                              setTimeout(function() {
                                 naver.close();
                                 location.reload(true);
                              }, 1000);
                  });
      }); 
      
      /*카카오 로그아웃  */
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
									<li class="nav-item"><a class="nav-link" href="/trade">중고
											직거래</a></li>
									<li class="nav-item active"><a class="nav-link" href="/trade_safe">중고
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
            <h1>중고안전거래</h1>
            <nav class="d-flex align-items-center"> <a href="/"><span
               class="lnr lnr-arrow-right">Home</span></a> <a href="trade_safe"><span
               class="lnr lnr-arrow-right">Shop</span></a> </nav>
         </div>
      </div>
   </div>
   </section>
   <!-- End Banner Area -->

<form action="boardWriteSafeDelete">

   <!-- start banner Area -->
   <div class="container-fluid">
      <div class="row">

         <!-- start menu -->
         <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
            <div class="sidebar-categories category-area">
               <div class="head">제품 카테고리</div>
               <ul class="main-categories">
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#" aria-expanded="false"
                     aria-controls="fruitsVegetable">
                     <span class="lnr lnr-arrow-right">
                        </span><a href="tradeOption_safe?category=all">전체보기</a></a>
                     </li>


                     
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="tradeOption_safe?category=art">미술품</a></a>
                  </li>
                     
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="tradeOption_safe?category=book">도서</a></a>
                  </li>
                  
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="tradeOption_safe?category=electric">가전제품</a></a>
                  </li>
                  
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="tradeOption_safe?category=hobby">취미/수집</a></a>
                  </li>
                  

                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="tradeOption_safe?category=life">생활용품</a></a>
                  </li>
                  
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="tradeOption_safe?category=sports">스포츠/레저</a></a>
                  </li>

                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="tradeOption_safe?category=etc">기타</a></a>
                  </li>
               </ul>
               <c:choose>
               	<c:when test="${logintype=='admin'}">
               		<div class="head "><button id="btn-delete" type="button" value="삭제하기">삭제하기</button></div>
               	</c:when>
               	
               <c:when test="${logintype!='admin' }">
               <div class="head "><a href="tradeGoodsWrite?type=an" style="color: white">제품등록</a></div>
               </c:when>
               </c:choose>
            </div>
         </div>
         <!-- end menu  -->

         <!-- start center  -->
         <div class="col-xs-12 col-sm-12 col-md-10 col-lg-9">
            <!--Start search  -->
            <br>
            <div class="input-group mb-3 searchArea">
               <input type="text" class="form-control" id="text-search" placeholder="검색어를 입력해주세요"
                  aria-label="Recipient's username" aria-describedby="button-addon2">
               <div class="input-group-append">
                  <button class="btn btn-outline-secondary" id="btn-search"><i class="fas fa-search"></i>
               </div>
            </div>
            <!--End search  -->
            
            <section class="owl-carousel active-product-area section_gap" style=padding:20px>
            <div class="single-product-slider">
            <!-- Start boardInfo  -->
               <div class="row list-nav">
                  <div class="col-sm-12 col-md-11 col-lg-8 atag-category mt-2"></div>
                  <div class="d-none d-lg-block col-sm-6 col-md-4 col-lg-2 col-xl-1 p-0">
                        <a class="nav-link p-0 mt-2 mr-0" href="tradeOption?price=low"><span class="atag-text">낮은가격순</span></a> 
                   </div>
                   <div class="d-none d-lg-block col-sm-4 col-md-4 col-lg-2 col-xl-1 p-0">
                       <a class="nav-link p-0 mt-2" href="tradeOption?price=high"><span class="atag-text">높은가격순</span></a>
                    </div>
                     <div class="d-none d-xl-block col-sm-3 col-md-3 col-lg-2">
                                <select id="viewCount" name="viewCount" onchange="viewCount()">
                                    <option value="12">12개씩 보기</option>
                                    <option value="16">16개씩 보기</option>
                                    <option value="20">20개씩 보기</option></select>
                     </div>
               </div>
               <!-- End boardInfo  -->
               ${rsearch_result_null }
              <form id="deleteForm" action="boardWriteDelete">
               <div class="row list-nav">
                  <c:forEach var="temp" items="${list }">
                     <div class="col-lg-3 col-md-6">
						<c:choose>
               				<c:when test="${logintype=='admin'}">
               					<input type="checkbox" name="checkDelete" value="${temp.no }" class="tradeSafeCheck" id="chk">
               				</c:when>
               			</c:choose>	
                		<c:choose>
               			<c:when test="${temp.onGoing=='n'}">
               			<div class="single-product" style="margin-bottom: 15px;">
                           <div class="card">
                           	<img class="onging-img" src="../resources/img/banner/soldout.png">
                             <input type="button" class="ongoing-btn">
                             <input type="hidden" class="ongoing-href" value=${temp.no}>
                              <img class="img-fluid product-img-size" style="margin-bottom: 5px;"
                                 src="/img/title/${temp.title_img}" alt="">
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
                                    <div class="col-lg-12">판매가 : <fmt:formatNumber value="${temp.price}" pattern="#,###" />원</div>
                                 </div>
                                 <div class="row">
                                    <div class="d-none d-sm-block col-xs-2 col-sm-2 col-md-2 col-lg-2 pr-0"><i class="far fa-clock fa-2x fontawesome"></i></div>
                                    <div class="d-none d-sm-block col-xs-4 col-sm-4 col-md-4 col-lg-6 pr-0"><span class="joinDate">${temp.joinDate}</span></div> 
                                    <div class="d-none d-sm-block col-xs-2 col-sm-2 col-md-2 col-lg-2 m-0 pr-0"><i class="fas fa-eye fa-2x fontawesome"></i></div>
                                    <div class="d-none d-sm-block col-xs-4 col-sm-4 col-md-4 col-lg-2 pr-0"><span class="view">${temp.viewCount}</span></div>
                                 </div>

                                 <div class="row product-details" style="padding-left: 15px;">
                                    <div class="prd-bottom" style="margin-top: 10px;">
                                       <a href="boardGgymSafe?no=${temp.no}&title_img=${temp.title_img}&title=${temp.title}&trade_type=${temp.trade_type }&category=${temp.category }&price=${temp.price}&id=${temp.id}" class="social-info ggym"> <span class="lnr lnr-heart"></span>
                                          <p class="hover-text">Wishlist</p>
										</a>
										
                                        <a href="/used_detailPage?no=${temp.no}" class="social-info">
                                        <span class="lnr lnr-move"></span>
                                          <p class="hover-text">view more</p>
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
               		</c:when>
               		<c:otherwise>
               			<div class="single-product" style="margin-bottom: 15px;">
                           <div class="card">
                              <a href="/used_detailPage?no=${temp.no}">
                              <img class="img-fluid product-img-size" style="margin-bottom: 5px;"
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
                                    <div class="col-lg-12">판매가 : <fmt:formatNumber value="${temp.price}" pattern="#,###" />원</div>
                                 </div>
                                 <div class="row">
                                    <div class="d-none d-sm-block col-xs-2 col-sm-2 col-md-2 col-lg-2 pr-0"><i class="far fa-clock fa-2x fontawesome"></i></div>
                                    <div class="d-none d-sm-block col-xs-4 col-sm-4 col-md-4 col-lg-6 pr-0"><span class="joinDate">${temp.joinDate}</span></div> 
                                    <div class="d-none d-sm-block col-xs-2 col-sm-2 col-md-2 col-lg-2 m-0 pr-0"><i class="fas fa-eye fa-2x fontawesome"></i></div>
                                    <div class="d-none d-sm-block col-xs-4 col-sm-4 col-md-4 col-lg-2 pr-0"><span class="view">${temp.viewCount}</span></div>
                                 </div>

                                 <div class="row product-details" style="padding-left: 15px;">
                                    <div class="prd-bottom" style="margin-top: 10px;">
                                       <a href="boardGgymSafe?no=${temp.no}&title_img=${temp.title_img}&title=${temp.title}&trade_type=${temp.trade_type }&category=${temp.category }&price=${temp.price}&id=${temp.id}" class="social-info ggym"> <span class="lnr lnr-heart"></span>
                                          <p class="hover-text">Wishlist</p>

                                       </a> <a href="/used_detailPage?no=${temp.no}" class="social-info">
                                        <span class="lnr lnr-move"></span>
                                          <p class="hover-text">view more</p>
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
               		</c:otherwise>
               		</c:choose>
               		</div>
                  </c:forEach>
               </div>
              </form> 
            </div>
            <c:choose>
               	<c:when test="${logintype=='admin'}">
            		<input type="button" id="checkAllTradeSafeBoard" value="전체선택" name="checkAll" class="genric-btn primary radius">
            	</c:when>
            </c:choose>	
            </section>
            <div class="row">
               <div class="col-12 naviArea">
                  <b class="paging">${navi }</b>
               </div>
            </div>

         </div>
         <!-- end center  -->

         <!-- start fixbutton -->
         <div class="d-none d-lg-block col-lg-1">
            <i class="fas fa-chevron-circle-up btn-fixed back-to-top fa-3x"></i>
         </div>
         <!-- end fixbutton -->
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
               <h6>Newsletter</h6>
               <p>Stay update with our latest</p>
               <div class="" id="mc_embed_signup">

                  <form target="_blank" novalidate="true"
                     action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                     method="get" class="form-inline">

                     <div class="d-flex flex-row">

                        <input class="form-control" name="EMAIL"
                           placeholder="Enter Email" onfocus="this.placeholder = ''"
                           onblur="this.placeholder = 'Enter Email '" required=""
                           type="email">


                        <button class="click-btn btn btn-default">
                           <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                        </button>
                        <div style="position: absolute; left: -5000px;">
                           <input name="b_36c4fd991d266f23781ded980_aefe40901a"
                              tabindex="-1" value="" type="text">
                        </div>
                     </div>
                     <div class="info"></div>
                  </form>
               </div>
            </div>
         </div>
         <div class="col-lg-3  col-md-6 col-sm-6">
            <div class="single-footer-widget mail-chimp">
               <h6 class="mb-20">Instragram Feed</h6>
               <ul class="instafeed d-flex flex-wrap">
                  <li><img src="/../resources/img/i1.jpg" alt=""></li>
                  <li><img src="/../resources/img/i2.jpg" alt=""></li>
                  <li><img src="/../resources/img/i3.jpg" alt=""></li>
                  <li><img src="/../resources/img/i4.jpg" alt=""></li>
                  <li><img src="/../resources/img/i5.jpg" alt=""></li>
                  <li><img src="/../resources/img/i6.jpg" alt=""></li>
                  <li><img src="/../resources/img/i7.jpg" alt=""></li>
                  <li><img src="/../resources/img/i8.jpg" alt=""></li>
               </ul>
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
		$(".ggym").on("click",function(){
			if(${email==null}){
				   alert("로그인 하세요.");
				   return false;
			   }
		})
		
		$("#checkAllTradeSafeBoard").on("click",function(){
			if($("input:checkbox[id=chk]").is(":checked")==true){
				 $("input[id=chk]:checkbox").prop("checked", false);				
			}else{
				$("input[id=chk]:checkbox").prop("checked", true);
			}
		})
	</script>
   
   <script src="https://use.fontawesome.com/releases/v5.0.0/js/all.js"></script>
   <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
   <script src="../resources/js/vendor/bootstrap.min.js"></script>
   <script src="../resources/js/jquery.ajaxchimp.min.js"></script>
   <script src="../resources/js/jquery.nice-select.min.js"></script>
   <script src="../resources/js/jquery.sticky.js"></script>
   <script src="../resources/js/nouislider.min.js"></script>
   <!-- <script src="../resources/js/countdown.js"></script> -->
   <script src="../resources/js/jquery.magnific-popup.min.js"></script>
   <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
   <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

   <!--gmaps Js-->
   <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
   <script src="../resources/js/gmaps.min.js"></script>
   <script src="../resources/js/main.js"></script>
</body>
</html>