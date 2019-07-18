
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="/../resources/img/fav.png">
<!-- Author Meta -->
<meta name="author" content="CodePixar">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>중고거래 게시판</title>

<!--
      CSS
      ============================================= -->
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/linearicons.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/themify-icons.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/owl.carousel.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/nice-select.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/nouislider.min.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/ion.rangeSlider.css" />
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/ion.rangeSlider.skinFlat.css" />
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/magnific-popup.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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

<style>
/* * {
   box-sizing: border-box;
   border: 1px solid black;
} */
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
   height: 250px;
   margin-bottom: 20px;
}
/*카드리스트 마우스 오버*/
.card:hover {
   cursor: pointer;
   border: solid 1px #ffba00;
   margin: -1px;
}

.text-center {
   text-align: center;
}

/* 게시판 페이징  */
.paging {
   position: relative;
   left: 50%;
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

.btn-navi : hover{
   background-color: #F2F2F2;
}
</style>

</head>

<body>
   <div class="container">
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
      <div class="bd-example">
         <div id="carouselExampleCaptions"
            class="carousel slide carousel-size" data-ride="carousel">
            <ol class="carousel-indicators">
               <li data-target="#carouselExampleCaptions" data-slide-to="0"
                  class="active"></li>
               <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
               <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
               <div class="carousel-item active">
                  <img src="/../resources/img/sample/buy-3692440_1920.jpg"
                     class="d-block w-100 jumbo" alt="...">
                  <div class="carousel-caption d-none d-md-block">
                     <p>당신의 애장품을 등록해주세요.</p>
                     <button type="button" class="btn">
                        <h5>물품등록하기</h5>
                     </button>
                  </div>
               </div>
               <div class="carousel-item">
                  <img src="/../resources/img/sample/sample2.jpg"
                     class="d-block w-100 jumbo" alt="...">
                  <div class="carousel-caption d-none d-md-block">
                     <h5>Second slide label</h5>
                     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                  </div>
               </div>
               <div class="carousel-item">
                  <img src="/../resources/img/sample/sample1.jpg"
                     class="d-block w-100 jumbo" alt="...">
                  <div class="carousel-caption d-none d-md-block">
                     <h5>Third slide label</h5>
                     <p>Praesent commodo cursus magna, vel scelerisque nisl
                        consectetur.</p>
                  </div>
               </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions"
               role="button" data-slide="prev"> </a> <a
               class="carousel-control-next" href="#carouselExampleCaptions"
               role="button" data-slide="next"> </a>
         </div>
      </div>
      <!-- End banner Area -->
      <!--Start search  -->
      <br>
      <div class="input-group mb-3">
         <input type="text" class="form-control"
            placeholder="검색어를 입력해주세요" aria-label="Recipient's username"
            aria-describedby="button-addon2">
         <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button"
               id="button-addon2">Search</button>
         </div>
      </div>
      <!--End search  -->
      
      <!-- Start category -->
      <br>
      <hr>
      <nav>
      <div class="nav nav-tabs" id="nav-tab" role="tablist">
         <a class="nav-item nav-link active" id="nav-home-tab"
            data-toggle="tab" href="#nav-home" role="tab"
            aria-controls="nav-home" aria-selected="true">전체거래</a> <a
            class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
            href="#nav-profile" role="tab" aria-controls="nav-profile"
            aria-selected="false">안전거래</a> <a class="nav-item nav-link"
            id="nav-contact-tab" data-toggle="tab" href="#nav-contact"
            role="tab" aria-controls="nav-contact" aria-selected="false">직거래</a>
      </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
         <div class="tab-pane fade show active" id="nav-home" role="tabpanel"
            aria-labelledby="nav-home-tab">
            <br>
            <div class="list-group">
               <ul>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">미술품</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">도서</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">가전제품</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">취미/수집</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">생활용품</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">스포츠/레저</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">기타</a></li>
               </ul>
            </div>
         </div>
         <div class="tab-pane fade" id="nav-profile" role="tabpanel"
            aria-labelledby="nav-profile-tab">
            <br>
            <div class="list-group">
               <ul>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">미술품</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">도서</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">가전제품</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">취미/수집</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">생활용품</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">스포츠/레저</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">기타</a></li>
               </ul>
            </div>
         </div>
         <div class="tab-pane fade" id="nav-contact" role="tabpanel"
            aria-labelledby="nav-contact-tab">
            <br>
            <div class="list-group">
               <ul>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">미술품</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">도서</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">가전제품</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">취미/수집</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">생활용품</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">스포츠/레저</a></li>
                  <li><a href="#"
                     class="list-group-item list-group-item-action list-group-item-light">기타</a></li>
               </ul>
            </div>
         </div>
      </div>
      <!-- End category -->

      <!-- start product Area -->
      <section class="owl-carousel active-product-area section_gap">
      <!-- single product slide -->
      <div class="single-product-slider">
         <div class="row list-nav">
            <div class="col-lg-5 col-md-5">
               <span class="list-nav-total">모두 ${recordTotalCount}개의 물품이 검색
                  되었습니다.</span>
            </div>
            <div class="col-lg-2 col-md-2"></div>
            <div class="col-lg-5 col-md-5">
               <nav class="nav"> <a class="nav-link" href="trade?price=low">낮은가격순</a>
               <a class="nav-link" href="trade?price=high">높은가격순</a> <select
                  id="viewCount" name="viewCount">
                  <option value="16">16개씩 보기</option>
                  <option value="24">24개씩 보기</option>
                  <option value="36">36개씩 보기</option>
               </select> </nav>
            </div>
         </div>

         <div class="row">
            <c:forEach var="temp" items="${list }">
               <div class="col-lg-3 col-md-6">
                  <div class="single-product">
                     <div class="card" style="width: 15rem;">
                        <img class="img-fluid product-img-size"
                           src="../resources/img/product/p5.jpg" alt="">
                        <div class="card-body">
                           <div class="row">
                              <div class="col-12">[${temp.getCategory()}]</div>
                           </div>
                           <div class="row">
                              <div class="col-12">
                                 <h5 class="card-title">${temp.getTitle()}</h5>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col-12">
                                 <p class="card-text">${temp.getPrice()}</p>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col-6">${temp.getJoindate()}</div>
                              <div class="col-6">${temp.getViewcount()}</div>
                           </div>
                           <div class="row">
                              <div class="col-5">${temp.getMember_class()}</div>
                              <div class="col-7">${temp.getId()}</div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </c:forEach>
         </div>
         <div class="row">
            <div class="col-10">
               <b class="paging">${navi }</b>
            </div>
            <div class="col-2">
               <button type="button"  class="btn btn-outline-warning" id="goodsRegister">제품등록</button>
            </div>
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
      $(document).ready(function() {
         $("select option[value=" + '${view}' + "]").attr("selected", true);
      });

      $("#viewCount").on(
            "change",
            function() {
               var view = $(this).val();
               $(location).attr('href',
                     'tradeList?view=' + view + "&currentPage=1");
            });
      $("#logout_na")
            .on(
                  "click",
                  function() {
                     $
                           .ajax({
                              url : "logout",
                              type : "get"
                           })
                           .done(
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

      $("#logout_ka").on(
            "click",
            function() {
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
      $("#goodsRegister").on("click",function(){
    	 $(location).attr("href","/tradeGoodsWrite") ;
      });
   </script>

</body>
</html>