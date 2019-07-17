<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<!-- Mobile Specific Meta -->

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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

	<title>Karma Shop</title>

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

	<link rel="stylesheet" href="../resources/css/ion.rangeSlider.skinFlat.css" />

	<link rel="stylesheet" href="../resources/css/main.css">

  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

</head>
<style>

    .category,.dropdown-menu{

        background-color: #ffba00;

        color: white;

    } /*카테고리 색 주황색*/

    

    /*여기부터*/

    [type="radio"]:checked,

[type="radio"]:not(:checked) {

    position: absolute;

    left: -9999px;

}

[type="radio"]:checked + label,

[type="radio"]:not(:checked) + label

{

    position: relative;

    padding-left: 28px;

    cursor: pointer;

    line-height: 20px;

    display: inline-block;

    color: #666;

}

[type="radio"]:checked + label:before,

[type="radio"]:not(:checked) + label:before {

    content: '';

    position: absolute;

    left: 0;

    top: 0;

    width: 18px;

    height: 18px;

    border: 1px solid #ddd;

    border-radius: 100%;

    background: #fff;

}

[type="radio"]:checked + label:after,

[type="radio"]:not(:checked) + label:after {

    content: '';

    width: 10px;

    height: 10px;

    background: #ffba00;

    position: absolute;

    top: 4px;

    left: 4px;

    border-radius: 100%;

    -webkit-transition: all 0.2s ease;

    transition: all 0.2s ease;

}

[type="radio"]:not(:checked) + label:after {

    opacity: 0;

    -webkit-transform: scale(0);

    transform: scale(0);

}

[type="radio"]:checked + label:after {

    opacity: 1;

    -webkit-transform: scale(1);

    transform: scale(1);

}/*여기까지 라디오 버튼 색*/ 

    #titleName{

        position: relative;

        top: 85px;

    }

    #titleImg{

        border: 1px solid #ffba00;

        border-radius: 30px 30px 30px 30px;

        position: relative;

        top: 85px;

        width: 557px;

        height: 502px;

    }

    #middle{

    	width: 555px;

        height: 498px;

        border-radius: 30px 30px 30px 30px;

    }

 

    #contents{

        border: 1px solid black;

        width: 450px;

        height: 300px;

    }

    #writtingContents{
        position: relative;
        top: 85px;
    }
    #writting{
        border: 1px solid #ffba00;
        position: relative;
        top: 85px;
        padding-left: 6px;
        margin: auto;
        width: 103%;
        height: 300px;
        resize: none;
        overflow:auto;
    }
    .input{
        color: #ffba00;
    }
    .product_image_area{
        position: relative;
        bottom:70px;
    }
    .name{
        text-align: center;
        font-size: 50px;
        color: #ffba00;
    }
    .txc-textbox{
    	width:100px;
    	height:50px;
    }
    .nice-select{
    	color : white;
    	background-color: #ffba00;  	
    }
    .nice-select .list{
    	color: #ffba00;
    	background-color : white;
    }
	#preview{
    	border:1px solid #ffba00;
    	width: 460px;
    	height: 185px;
    	overflow:auto;
    	
    }
    .thumbnail{
    	width: 100px;
    	height: 100px;
    
    }/* 상세이미지 크기 */
    .preview-box{    	
    	width: 200px;
    	height: 100px;
    	display: inline;
    }
    #detailImg{
    	background-color:#ffba00;
    	color:white;
    }
    #detailImg:hover {
		cursor: pointer;
	}
	#register{
		position:relative;
		top:10px;
		left:20px;
	}
	#sel,#sel1,#sel2,#sel3{
		float: left;
	}
	.trade{
		position: relative;
		top:10px;
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
											<li class="nav-item"><a class="nav-link" href="/">마이페이지</a></li>
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
											<li class="nav-item"><a class="nav-link" href="/">마이페이지</a></li>
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
											<li class="nav-item"><a class="nav-link" href="/">마이페이지</a></li>
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
				<h1>경매물품 글쓰기</h1>
				<nav class="d-flex align-items-center"> <a href="/">메인페이지<span
					class="lnr lnr-arrow-right"></span></a> <a href="/#">경매거래
					<span class="lnr lnr-arrow-right"></span>
				</a> <a href="/auctionWrite">경매 물품 등록<span class="lnr "></span></a></nav>
			</div>
		</div>
	</div>
	</section>
 

<form action="auctionWriteComplete" method="post" enctype="multipart/form-data" id="send">
	<div class="product_image_area">
		<div class="container">
		    <div class="name">경매 물품 등록</div>
			<div class="row s_product_inner">
				<div class="col-lg-6">
                    <div id="titleName">타이틀 이미지</div>
				        <div id="titleImg" contenteditable="false"></div>						
						<div id="writtingContents">물품 설명</div>
							<textarea class="form-control" id="writting" rows="3" placeholder="물품설명" name="contents"></textarea>	
				</div>

				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<ul class="list">
                        <br>                        
						    <li><a class="active"><span>물품제목</span></a><input type="text" class="form-control goodsContents" id="goodsTitle" name="title" placeholder="물품제목을 입력하세요."></li>
							<li><a><span>시작가</span></a><input type="text" priceOnly  class="form-control goodsContents" id="goodsPrice" name="starting_price" placeholder="시작가 입력하세요." onkeydown="javascript: return event.keyCode == 69 ? false : true"></li>
							<li><a><span>핸드폰번호</span></a><input type="text" phoneOnly  class="form-control goodsContents" id="phone" name="phone" placeholder="-없이 핸드폰 번호를 입력해주세요." onkeydown="javascript: return event.keyCode == 69 ? false : true"></li>
							<li><a><span>계좌번호</span></a><input type="text" acountOnly  class="form-control goodsContents" id="account" name="account" placeholder="반드시 본인의 계좌번호를 입력해주세요." onkeydown="javascript: return event.keyCode == 69 ? false : true"></li>	
							
							
						<div id="sel">
							<div id="sel1">	
							<li><a><span>최소입찰단위</span></a>
							<div class="txc-textbox"> 
								<select id="minMoney" name="min_price">
 									 <option value="1000">1000원</option>
  									 <option value="2000">2000원</option>
 									 <option value="3000">3000원</option>
  									 <option value="5000">5000원</option>
								</select>
							</div>
							</li>												
							</div>
							
							<div id="sel2">				
							<li><a><span>카테고리</span></a>

							<div class="txc-textbox">
								<select id="category" name="category">
 									 <option value="volvo">Volvo</option>
  									 <option value="saab">Saab</option>
 									 <option value="mercedes">Mercedes</option>
  									 <option value="audi">Audi</option>
								</select>
							</div>
							</li>
							</div>
							
							<div id="sel3">
							<li><a><span>경매기간</span></a>
							<div class="txc-textbox">
								<select id="time" name="period">
 									 <option value="1" name="end_date">1일</option>
  									 <option value="2" name="end_date">2일</option>
 									 <option value="30" name="end_date">30일</option>
								</select>
							</div>
							</li>								
							</div>
						</div>	
						
							<li>
								<div>거래유형</div>
                                <input type="radio" id="test1" class="trade" name="trade_type" value="직거래" checked>
                                <label for="test1" class="trade">직거래</label>
                                <input type="radio" id="test2" class="trade" name="trade_type" value="안전거래">
                                <label for="test2" class="trade">안전거래</label>
							</li>
							
							
						<div>
							<li>						
								<div>택배</div>
                                <input type="radio" id="test3" class="delivery_type" name="delivery_type" value="선불" disabled="disabled">
                                <label for="test3" class="trade" id="payInside">선불(구매자 부담)</label>
                                <input type="radio" id="test4" class="delivery_type" name="delivery_type" value="착불" disabled="disabled">
                                <label for="test4" class="trade">착불(구매자 부담)</label>
                                <input type="radio" id="test5" class="delivery_type" name="delivery_type" value="무료배송" disabled="disabled">
                                <label for="test5" class="trade">무료배송(판매자 부담)</label>
							</li>
						</div>
							<br>
							<div>메인 이미지</div>
                            <input type="file" id="image" class="imgRegister1" accept=".jpg, .png">
							<input type="hidden" id="imgTitle" name="title_img">
                         
				<div id="a">		  
<br>
                          <div>상세 이미지</div>
									<div class="body">
										<!-- 첨부 버튼 -->
										<div id="attach">
											<label class="waves-effect waves-teal btn-flat"
												for="uploadInputBox" id="detailImg">파일선택</label> 
												<input
												id="uploadInputBox" accept=".jpg, .png"
												style="display: none" type="file" name="file" multiple
												class="z" /> 
												<input type="hidden" name="middle1_img" id="d">
										</div>
										<!-- 미리보기 영역 -->
										<div id="preview" class="content"></div>
										<!-- multipart 업로드시 영역 -->
									</div>
								</div>      

  

                          <div class="col-md-12 text-right">
								<button type="button" id="register" class="primary-btn">등록하기</button>								
				        </div>                 
						</ul>
						<br>		
                        <br>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

 

<br><br><br><br>

 

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

	<script>
	$("#test1").on("click",function(){
 		$("#test3").attr("checked",false);
 		$("#test4").attr("checked",false);
 		$("#test5").attr("checked",false);
 		$("#test3").attr("disabled",true);
 		$("#test4").attr("disabled",true);
 		$("#test5").attr("disabled",true);
 		$("#pay").remove();
 		$("#collectible").remove();
 		$("#free").remove();
 	})	
 
 	$("#test2").on("click",function(){
 		$("#test3").attr("disabled",false);
 		$("#test4").attr("disabled",false);
 		$("#test5").attr("disabled",false);
 		$("#pay").remove();
 		$("#collectible").remove();
 		$("#free").remove();
 	})
 	$("#test3").on("click",function(){
 		$("#pay").remove();
 		$("#collectible").remove();
 		$("#free").remove();
 		$("#payInside").append('<input type="text" id="pay" value="2500" name="delivery_cost">');
 		$("pay").attr("disabled",true);
 	})
 	$("#test4").on("click",function(){
 		$("#pay").remove();
 		$("#collectible").remove();
 		$("#free").remove();
 		$("#payInside").append("<input type='hidden' id='collectible'value='2500' name='delivery_cost'>");
 	})
 	$("#test5").on("click",function(){
 		$("#sun").remove();
 		$("#collectible").remove();
 		$("#free").remove();
 		$("#payInside").append("<input type='hidden' id='free' value='0' name='delivery_cost'>");
 	})
	
	
		$("input:text[priceOnly]").on("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/g, ""));
		});
		$("input:text[phoneOnly]").on("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/g, ""));
		});
		$("input:text[acountOnly]").on("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/g, ""));
		});
		//핸드폰 가격 계좌 숫자만 입력받게하기
		$('#example .dropdown-menu li > a').bind(
				'click',
				function(e) {
					var html = $(this).html();
					$('#example button.dropdown-toggle').html(
							html + ' <span class="caret"></span>');
				});

		
		$("#image").on("input",function() {
							var formData = new FormData();
							formData.append("formData", $(this)[0].files[0]);
							$.ajax({
										url : "imageUpdate",
										type : "post",
										processData : false,
										contentType : false,
										data : formData
									})
									.done(function(resp) {
												//var time = new Date().getTime();
												$("#image").attr("disabled",true);
												$("#titleImg")
														.append("<img src='/image/title/"+resp+"' id='middle'>");
												$("#imgTitle").val(resp);		
												
											})
						})//메인 이미지 바로 띄우는 것

		//임의의 file object영역
		var files = {};
		var previewIndex = 0;

		// image preview 기능 구현
		// input = file object[]               
		function addPreview(input) {
			if (input[0].files) {
				//파일 선택이 여러개였을 시의 대응
				if(input[0].files.length<11){
				for (var fileIndex = 0; fileIndex < input[0].files.length; fileIndex++) {
					var file = input[0].files[fileIndex];

					if (validation(file.name))
						continue;

					var reader = new FileReader();
					reader.onload = function(img) {

						//div id="preview" 내에 동적코드추가.
						//이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
						var imgNum = ++previewIndex;
						$("#preview")
								.append(
										"<div class=\"preview-box\" value=\"" + imgNum +"\">"
												+ "<img name='middle"+imgNum+"_img' class=\"thumbnail\" src=\"" + img.target.result + "\"\/>"
												//+ file.name
												+ "<a href=\"#\" value=\""
												+ imgNum
												+ "\" onclick=\"deletePreview(this)\">"
												+ "삭제" + "</a>" + "</div>");

						files[imgNum] = file;

					};
					reader.readAsDataURL(file);
				}
				$(".preview-box").remove();
				}else{
	            	alert("상세 이미지는 10개 까지 됩니다.");
	            }
			} else
				alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.

		}
		//preview 영역에서 삭제 버튼 클릭시 해당 미리보기이미지 영역 삭제
		function deletePreview(obj) {
			var imgNum = obj.attributes['value'].value;
			delete files[imgNum];
			$("#preview .preview-box[value=" + imgNum + "]").remove();
			resizeHeight();
		}

		//client-side validation
		//always server-side validation required
		function validation(fileName) {
			fileName = fileName + "";
			var fileNameExtensionIndex = fileName.lastIndexOf('.') + 1;
			var fileNameExtension = fileName.toLowerCase().substring(
					fileNameExtensionIndex, fileName.length);
			if (!((fileNameExtension === 'jpg')
					|| (fileNameExtension === 'gif') || (fileNameExtension === 'png'))) {
				alert('jpg, gif, png 확장자만 업로드 가능합니다.');
				return true;
			} else {
				return false;
			}
		}

		$(document)
				.ready(
						function() {
							//submit 등록. 실제로 submit type은 아니다.
							$('.submit a')
									.on(
											'click',
											function() {
												var form = $('#uploadForm')[0];
												var formData = new FormData(
														form);

												for (var index = 0; index < Object
														.keys(files).length; index++) {
													//formData 공간에 files라는 이름으로 파일을 추가한다.
													//동일명으로 계속 추가할 수 있다.
													formData.append('files',
															files[index]);
												}

												//ajax 통신으로 multipart form을 전송한다.
												$
														.ajax({
															type : 'POST',
															enctype : 'multipart/form-data',
															processData : false,
															contentType : false,
															cache : false,
															timeout : 600000,
															url : '/imageupload',
															dataType : 'JSON',
															data : formData,
															success : function(
																	result) {
																//이 부분을 수정해서 다양한 행동을 할 수 있으며,
																//여기서는 데이터를 전송받았다면 순수하게 OK 만을 보내기로 하였다.
																//-1 = 잘못된 확장자 업로드, -2 = 용량초과, 그외 = 성공(1)
																if (result === -1) {
																	alert('jpg, gif, png, bmp 확장자만 업로드 가능합니다.');
																	// 이후 동작 ...
																} else if (result === -2) {
																	alert('파일이 10MB를 초과하였습니다.');
																	// 이후 동작 ...
																} else {
																	alert('이미지 업로드 성공');
																	// 이후 동작 ...
																}
															}
														//전송실패에대한 핸들링은 고려하지 않음
														});
											});
							// <input type=file> 태그 기능 구현
							$('#attach input[type=file]').change(function() {
								addPreview($(this)); //preview form 추가하기
							});
						});


		function autoHypenPhone(str){
			str = str.replace(/[^0-9]/g, '');
			var tmp = '';
			if (str.length < 4) {
				return str;
			} else if (str.length < 7) {
				tmp += str.substr(0, 3);
				tmp += '-';
				tmp += str.substr(3);
				return tmp;
			} else if (str.length < 11) {
				tmp += str.substr(0, 3);
				tmp += '-';
				tmp += str.substr(3, 3);
				tmp += '-';
				tmp += str.substr(6);
				return tmp;
			} else {
				tmp += str.substr(0, 3);
				tmp += '-';
				tmp += str.substr(3, 4);
				tmp += '-';
				tmp += str.substr(7);
				return tmp;
			}
			return str;
		}
    var cellPhone = document.getElementById('phone');
	cellPhone.onkeyup = function(event){
	    event = event || window.event;
	    var _val = this.value.trim();
	    this.value = autoHypenPhone(_val) ;
	}
				
	$("#register").on("click", function() {
		if ($("#writting").val() == "") {
			alert("물품 설명을 입력해주세요.");
		} else if ($("#goodsTitle").val() == "") {
			alert("제목을 입력하세요.");
		} else if ($("#goodsPrice").val() == "") {
			alert("가격을 입력하세요.");
		} else if ($("#phone").val() == "") {
			alert("핸드폰 번호를 입력하세요.");
		} else if ($("#account").val() == "") {
			alert("계좌를 입력하세요.");
		} else if ($("#titleImg").html() == "") {
			alert("메인 이미지를 입력하세요.");
		} else if ($("#preview").text() == "") {
			alert("상세 이미지 1개 이상 입력하세요.");
		} else {
			//var contents = $("#writting").val();
			//contents = contents.replace(/(&nbsp;)+/ig, "");// 맨 앞 공백, 공백연속으로 쳤을때 &nbsp;
			//contents = contents.replace(/^[ ]+/ig, "");	// &nbsp;자르고나서 또 맨앞에 오는 공백 자르기
			//contents = contents.replace(/(<div><br><\/div>)+/ig, "");// 내용없이 엔터쳤을때
			//contents = contents.replace("/(<div>[ ]*?<\/div>)/ig", "");// 공백만 넣고 엔터쳤을때
			var contentsText = $("#writting").val();
			var regContents = /^[가-힣 .,:;()!^?~0-9]{5,150}$/g;	 //레직스 바꾸기		
			var titleText = $("#goodsTitle").val();
			var regTitle = /^[가-힣 .,:;()!^?~0-9]{5,22}$/g;
			var price = parseInt($("#goodsPrice").val());
			var phoneText = $("#phone").val();			
			var regPhone = /(01[0|1|6|9|7])[-](\d{3}|\d{4})[-](\d{4}$)/g;	
			var accountText = $("#account").val();
			var regAccount = /^[\d]{12,15}$/g;
			
			if(!regContents.test(contentsText)){
				alert('잘못된 내용 입니다.');
	            $('#writting').val("");
			}else if(!regTitle.test(titleText)){
				alert('잘못된 제목 입니다.');
	            $('#goodsTitle').val("");
			}else if(!regPhone.test(phoneText)){
				alert('잘못된 휴대폰 번호입니다.');
	            $('#phone').val("");	
			}else if(!regAccount.test(accountText)){
				alert('잘못된 계좌 번호입니다.');
	            $('#account').val("");
			}else if(price !=0){
				if(price<1000){
					alert("1000원 이상 가격을 입력하세요.");
					$("#goodsPrice").val("");
					}else if(price>1000000){
						alert("1,000,000원 이하 가격을 입력하세요.");
						$("#goodsPrice").val("");
					}else{
						$("#send").submit();
				}
			}
		}
	})
	
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
 

	<script src="../resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.../resources/js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="../resources/js/jquery.nice-select.min.js"></script>
	<script src="../resources/js/jquery.sticky.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.magnific-popup.min.js"></script>
	<script src="../resources/js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="../resources/js/gmaps.min.js"></script>
	<script src="../resources/js/main.js"></script>
    
</body>
</html>