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
<title>중고경매 게시판</title>

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
<script
	src=https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js></script>
<!-- 모든 브라우저 호완성을 위해 추가  -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<style>

/*    * {
   box-sizing: border-box;
   border: 1px solid black;
}     */

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
   margin: 1px;
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
   top: 100px;
}

.back-to-top {text-decoration: none; display: none; color:#fe912b;}

.back-to-top:hover {color: #818bb0}

#send{
	border: 1px solid #828bb3;
	background-color:#828bb3;
	color:white;
}
#send:hover {
	cursor: pointer;
}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>

function viewCount(){
   var viewSelect = document.getElementById("viewCount");
    // select element에서 선택된 option의 value가 저장된다.
    var selectValue = viewSelect.value;
    location.href="auctionOption?view=" + selectValue;

}


   $(function(){
	   var socket = new SockJS("/gettime"); //불특정 다수의 브라우저일 경우를 위해 endpoint url 넣어야 한다
		var client = Stomp.over(socket);//연결 이후의 작업 지원 
		client.connect({}, function(resp) {
			client.subscribe("/response", function(list) {
				var result = JSON.parse(list.body);
				var z = 0;
					 			<c:forEach var="i" items="${list}">
								$("."+"${i.no}").text("남은시간 : "+result[z++]);
								</c:forEach>
			});
		})
		setInterval(function() {//시간 보내 달라는 요청
			var list = new Array();
			var z = 0;
						<c:forEach var="i" items="${list}">
							list.push("${i.end_date}");
						</c:forEach>
			client.send("/app/time", {}, JSON.stringify({
				end_dates : list
			}));
		}, 900);
/*       $("#category").on("click", function(){
         var category = $(this).text();
         console.log(category);
          $(location).attr("href", "auctionOption");
         
      }); */
   
      
/*       위로가기 버튼  
       var speed = 600; // 스크롤속도
       $(".gotop").css("cursor", "pointer").click(function()
       {
           $('body, html').animate({scrollTop:0}, speed);
       }); */
       
       
       var offset = 50;   // 수직으로 어느정도 움직여야 버튼이 나올까?
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
       
       
       
       /* 검색기능 */
      $("#btn-search").on("click", function(){
         var text_search =  $("#text-search").val();
         $(location).attr("href", "auctionOption?search="+text_search);
      });
      
      /* 페이지 정렬 개수 */
      $("select option[value=" + '${view}' + "]").attr("selected", true);
      
      /* 페이지 정렬 개수 컨트롤  */
/*       $("#viewCount").on("click", function(){
         var view = $(this).val();
         alert(view);
      });
       */
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
									<li class="nav-item"><a class="nav-link" href="/trade_safe">중고
											안전거래</a></li>
									<li class="nav-item"><a class="nav-link" href="/auction">중고
											경매</a></li>
							<li class="nav-item "><a class="nav-link" href="/">공지사항</a></li>
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
            <h1>중고경매</h1>
            <nav class="d-flex align-items-center"> <a href="index.html"><span
               class="lnr lnr-arrow-right">Home</span></a> <a href="#"><span
               class="lnr lnr-arrow-right">Shop</span></a> </nav>
         </div>
      </div>
   </div>
   </section>
   <!-- End Banner Area -->
	<form action="auctionBoardDelete">
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
                        </span><a href="auctionOption?category=all">전체보기</a></a>
                     </li>


                     
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="auctionOption?category=art">미술품</a></a>
                  </li>
                     
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="auctionOption?category=book">도서</a></a>
                  </li>
                  
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="auctionOption?category=electric">가전제품</a></a>
                  </li>
                  
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="auctionOption?category=hobby">취미/수집</a></a>
                  </li>
                  

                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="auctionOption?category=life">생활용품</a></a>
                  </li>
                  
                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="auctionOption?category=sports">스포츠/레저</a></a>
                  </li>

                  <li class="main-nav-list"><a data-toggle="collapse"
                     href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
                        class="lnr lnr-arrow-right">
                        </span><a href="auctionOption?category=etc">기타</a></a>
                  </li>
               </ul>
              <c:choose>
               	<c:when test="${logintype=='admin'}">
               		<div class="head "><input type="submit" value="삭제하기" id="send"></div>
               	</c:when>
               <c:when test="${logintype!='admin' }">
               <div class="head "><a href="auctionWrite" style="color: white">경매등록</a></div>
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
                  <button class="btn btn-outline-secondary" id="btn-search" type="button"
                     id="button-addon2"><i class="fas fa-search"></i></button>
               </div>
            </div>
            <!--End search  -->
            
            <section class="owl-carousel active-product-area section_gap" style=padding:20px>
            <div class="single-product-slider">
            <!-- Start boardInfo  -->
               <div class="row list-nav">
                  <div class="col-lg-7 col-md-5 col-sm-5">
                     <%-- <span class="list-nav-total">모두 ${recordTotalCount}개의 물품이 검색 되었습니다.</span> --%>
                  </div>

                  <div class="col-lg-5 col-md-7 col-sm-7">
                     <div class="row">
                        <div class="col-lg-8 col-md-8 col-sm-8">
                           <div class="row">
                              <div class="col-lg-6 col-md-6 col-sm-6 pl-5">
                                 <a class="nav-link" href="auctionOption?price=low">낮은가격순</a> 
                              </div>
                              <div class="col-lg-6 col-md-6 col-sm-6 pl-5">      
                                 <a class="nav-link" href="auctionOption?price=high">높은가격순</a> 
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4">
                           <div class="row">
                              <div class="col-lg-12 col-md-12 col-sm-12">
                                 <select id="viewCount" name="viewCount" onchange="viewCount()">
                                    <option value="16">16개씩 보기</option>
                                    <option value="24">24개씩 보기</option>
                                    <option value="32">32개씩 보기</option>
                                 </select>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- End boardInfo  -->
               <div class="row list-nav">
                  <c:forEach var="temp" items="${list }">
                     <div class="col-lg-3 col-md-6">
						<c:choose>
               				<c:when test="${logintype=='admin'}">
               					<input type="checkbox" name="checkDelete" value="${temp.no }">
               				</c:when>
               			</c:choose>
                        <div class="single-product" style="margin-bottom: 15px;">
                           <div class="card">
                              <a href="/auction_detailPage?no=${temp.no}"><img class="img-fluid product-img-size"
                                 style="margin-bottom: 5px;"
                                 src="../resources/img/title/${temp.getTitle_img()}" alt=""></a>
                              <div class="card-body" style="padding: 12px;">
                                 <div class="row">
                                    <div class="d-none d-lg-block col-lg-12">[${temp.category}]</div>
                                 </div>
                                 <div class="row">
                                    <div class="col-lg-12">
                                       <h4>${temp.getTitle()}</h4>
                                    </div>
                                 </div>
                                 <div class="row">
                                    <div class="col-lg-12">현재가격:${temp.present_price}</div>
                                 </div>
                                 <div class="row">
                                    <div class="col-sm-12 col-md-10 col-lg-8 ${temp.no}"></div>
                                    <div class="d-none d-xl-block col-lg-2"><i class="fas fa-eye fa-2x"></i></div>
                                    <div class="col-sm-12 col-md-2 col-lg-2">${temp.viewCount}</div>
                                 </div>
                                 <div class="row product-details" style="padding-left: 10px;">
                                    <div class="prd-bottom" style="margin-top: 5px;">
                                       <a href="" class="social-info"> <span class="ti-bag"></span>
                                          <p class="hover-text">add to bag</p>
                                       </a> <a href="/auction_detailPage?no=${temp.no}" class="social-info">
                                        <span class="lnr lnr-move"></span>
                                          <p class="hover-text">view more</p>
                                       </a>
                                    </div>
                                 </div>


                                 <!-- <div class="col-3">[1]</div>
                                    <div class="col-9">[이름]</div> -->

                              </div>
                           </div>
                        </div>
                     </div>
                  </c:forEach>
               </div>
               </form>
            </div>
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