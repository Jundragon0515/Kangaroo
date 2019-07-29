<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
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
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->


<style>
.table-responsive{
	overflow-x:hidden;
	box-sizing: border-box;
}
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

.tImg{
	height: 100px;
	width: 100px;
}

.tradeCheck,.auctionCheck{
    top: 42px;
    position: relative;
}
.ccc{
	text-align: right;
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
	   <c:choose>
		<c:when test="${logintype==null}">
		alert("로그인후 이용 가능합니다");
		$(location).attr("href", "/login_main");
		</c:when>
		</c:choose>
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
            <h1>찜 목록</h1>
            <nav class="d-flex align-items-center"> <a href="/#">
            <span class="lnr lnr-arrow-right">Home</span></a> <a href="#">
               <span class="lnr lnr-arrow-right">찜목록</span></a> </nav>
         </div>
      </div>
   </div>
   </section>
   <!-- End Banner Area -->
	<!--================Cart Area =================-->
    <section class="cart_area">
	   <div class="container">
            <div class="cart_inner">
                <div class="table-responsive">  
                <form action="ggymDelete">          
                    <table class="table">
                    <h1 id="ggym">찜 목록(중고거래)</h1>                   
                        <thead>
                            <tr>
                                <th scope="col">Product</th>
                                <th scope="col">Type</th>
                                <th scope="col">category</th>
                                <th scope="col">Price</th>
                            </tr>
                        </thead>
                        <tbody>                       
                           <c:forEach items="${tList }" var="trade">
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                        	<input type="checkbox" class="tradeCheck" name="checkDelete" value="${trade.no}" id="chkTrade">
                                            <img src="img/title/${trade.title_img }" class="tImg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <p><a href="/used_detailPage?no=${trade.no}">${trade.title}</a></p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>${trade.trade_type}</h5>
                                </td>
                                <td>
                                    <h5>${trade.category}</h5>
                                </td>
                                <td>
                                    <h5><fmt:formatNumber value="${trade.price}" pattern="#,###"/></h5>
                                </td>
                            </tr>                        
                          </c:forEach>                        
                        </tbody>                                                                 
                    </table>
                    <div class="row ccc">
                    	<div class="col-lg-12 col-md-12 col-sm-12">
                    		<input type="button" value="전체선택" id="allCheckTrade" class="genric-btn primary radius">              
                    		<input type="submit" value="삭제" id="delete" class="genric-btn primary radius">      
                   		</div>
                    </div> 
                    <div class="row">
               					<div class="col-12 naviArea">
                 				<b class="paging">${navi}</b>
               					</div>
            			   </div>
                    </form>
                    <br>
                    <form action="ggymDeleteAuction">
                     <table class="table">
                     	<h1 id="ggym">찜 목록(경매거래)</h1>
                        <thead>
                            <tr>
                                <th scope="col">Product</th>
                                <th scope="col">End Date</th>
                                <th scope="col">category</th>
                                <th scope="col">Price</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cList}" var="auction">
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                        <input type="checkbox" class="auctionCheck" name="checkDeleteAuction" value="${auction.no}" id="chkAuction">
                                            <img src="img/title/${auction.title_img}" class="tImg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <a href="/auction_detailPage?no=${auction.no}"><p>${auction.title}</p></a>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>${auction.end_date}</h5>
                                </td>
                                                               
                                <td>
                                    <h5>${auction.category}</h5>
                                </td>
                                <td>
                                    <h5><fmt:formatNumber value="${auction.price}" pattern="#,###"/></h5>
                                </td>
                            </tr>
                          </c:forEach>                         
                          
                        </tbody>
                    </table>   
                    <div class="row ccc">
                    	<div class="col-lg-12 col-md-12 col-sm-12">
                   	 		<input type="button" value="전체선택" id="allCheckAuction" class="genric-btn primary radius">
                     		<input type="submit" value="삭제" id="deleteAuction" class="genric-btn primary radius">  
                     	</div>
                     </div>               		
                    		<div class="row">
               					<div class="col-12 naviArea">
                 				<b class="paging">${navi1}</b>
               				</div>
            		</div>
            		</form>
                    
                </div>
            </div>
        </div>
    </section>
    <!--================End Cart Area =================-->
   </footer>
   
   <script>
   $("#allCheckTrade").on("click",function(){
		if($("input:checkbox[id=chkTrade]").is(":checked")==true){
			 $("input[id=chkTrade]:checkbox").prop("checked", false);				
		}else{
			$("input[id=chkTrade]:checkbox").prop("checked", true);
		}
	})
	
	$("#allCheckAuction").on("click",function(){
			if($("input:checkbox[id=chkAuction]").is(":checked")==true){
				 $("input[id=chkAuction]:checkbox").prop("checked", false);				
			}else{
				$("input[id=chkAuction]:checkbox").prop("checked", true);
			}
		})

   </script>

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
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

   <!--gmaps Js-->
   <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
   <script src="../resources/js/gmaps.min.js"></script>
   <script src="../resources/js/main.js"></script>
</body>
</html>