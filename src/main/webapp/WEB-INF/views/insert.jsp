<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Mobile Specific Meta -->
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="../resources/img/fav.png">
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
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link
   href="https://fonts.googleapis.com/css?family=Do+Hyeon|Noto+Sans+KR|Acme|Nanum+Pen+Script&display=swap"
   rel="stylesheet">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style>
* {
   font-family: 'Noto Sans KR', sans-serif;
}

body {
   -webkit-background-size: cover;
   -moz-background-size: cover;
   background-size: cover;
   -o-background-size: cover;
}

#span1 {
   color: blue;
}

#span2 {
   color: red;
}

#div {
   background-color: #ffffff95;
   text-align: center;
   width: 90%;
   height: 100%;
   border-radius: 10px;
}

label {
   color: #8e7540;
}

#header {
   width: 108.5%;
   height: 25%;
}

#img {
   margin-top: 1%;
   width: 100%;
   height: auto;
}

loge {
   float: left;
   height: 75%;
}

.text_label {
   text-align: left;
   width: 100%;
   height: 100%;
}

select {
   padding: 0px;
}

.btn-warning {
   margin-top: 30px;
   cursor: pointer;
}

.ui-datepicker-trigger {
   cursor: pointer;
}

.hasDatepicker {
   cursor: pointer;
}

#email, #adress {
   margin: 0px;
   padding: 0px;
}

#email>.btn {
   margin: 0px;
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

$(function() {
   
   <c:choose>
      <c:when test="${logintype!=null}">
         alert("로그아웃후 이용 가능합니다");
         $(location).attr("href","/");
      </c:when>
   </c:choose>
   $("#emailAuth_btn").hide();
   $("#email_auth_badge").hide();

   $("#id").on("focusout", function() {
      if ($("#emailAuth_btn").attr("flag") == "true") {//이메일 인증완료
         $("#emailAuth_btn").attr("flag", "false");
         $("#idrealcheck").attr("flag", "false");
      } else if ($("#idrealcheck").attr("flag") == "true") {//id 중복체크 완료
         $("#idrealcheck").attr("flag", "false");
         $("#emailAuth_btn").toggle();
         $("#idrealcheck").toggle();
      }
   });
   $("#id").on("input", function() {
      if ($("#emailAuth_btn").attr("flag") == "true") {
            $("#emailAuth_btn").attr("flag", "false");
            $("#idrealcheck").attr("flag", "false");
            $("#idrealcheck").toggle();
            $("#email_auth_badge").toggle();
            $("#idcheckvar").val("");
      } else if($("#idrealcheck").attr("flag") == "true") {//id 중복체크 완료
            $("#idrealcheck").attr("flag", "false");
            $("#emailAuth_btn").toggle();
            $("#idrealcheck").toggle();
      }
      $("#idcheck").text("");
   });

   $("#idrealcheck")
         .on(
               "click",
               function() {
                  $
                        .ajax({
                           url : "idcheck",
                           type : "post",
                           dataType : "json",
                           data : {
                              id : $("#id").val()
                           }
                        })
                        .done(
                              function(resp) {
                                 var result = JSON
                                       .stringify(resp);
                                 var idtext = $("#id").val();
                                 var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/g // 영어 숫자  6자리에서 12자리
                                 if (regex.exec(idtext) != null) {
                                    if (result == 1) {
                                       $("#idcheck")
                                             .text(
                                                   "이미 가입된 아이디 입니다.");
                                       $("#idcheck").css(
                                             "color", "red");
                                       $("#idcheckvar")
                                             .val("");
                                       $("#id").val("");
                                    } else if (result == 0) {
                                       $("#idcheck")
                                             .text(
                                                   "사용 가능한 아이디 입니다.");
                                       $("#idcheck").css(
                                             "color",
                                             "green")
                                       $("#idcheckvar")
                                             .val(
                                                   "");
                                       $("#idrealcheck").attr(
                                             "flag", "true");
                                       $("#emailAuth_btn")
                                             .toggle();
                                       $("#idrealcheck")
                                             .toggle();
                                    } else if (result == -1) {
                                       $("#idcheck")
                                             .text(
                                                   "아이디를 입력해 주세요.");
                                       $("#idcheck").css(
                                             "color", "red");
                                       $("#idcheckvar")
                                             .val("");
                                       $("#id").val("");
                                    }
                                 } else {
                                    $("#idcheck").text(
                                          "올바른 형식으로 입력하세요.");
                                    $("#idcheck").css("color",
                                          "red");
                                    $("#idcheckvar").val("");
                                    $("#id").val("");
                                 }
                              })
               })
   $("#emailAuth_btn").on(
         "click",
         function() {//이메일 인증
            var email = $("#id").val();
            window.open("emailAuth.login?email=" + email, "",
                  "width=600px,height=500px");
         });

   $("#pw2").on("focusout", function() {
      $("#pwcheckvar").val("");
      var regex = /^[A-Za-z0-9]{6,12}$/g // 영어 숫자 6자리에서 12자리            
      var pw1 = $("#pw1").val();
      var pw2 = $("#pw2").val();
      if (regex.exec(pw2) != null) {
         if (pw1 == pw2) {
            $("#pwcheck1").text("사용가능 합니다.");
            $("#pwcheck1").css("color", "green");
            $("#pwcheckvar").val("사용가능 합니다.");
         } else {
            $("#pwcheck1").text("비밀번호가 일치하지 않습니다.");
            $("#pwcheck1").css("color", "red");
            $("#pwcheck1").css("font-size", "15px");
            $("#pw2").val("");
            $("#pwcheckvar").val("");
         }
      } else {
         $("#pwcheck1").text("사용불가능 합니다.");
         $("#pwcheck1").css("color", "red");
         $("#pw2").val("");
         $("#pwcheckvar").val("");
      }
   })

   $("#phone").on("focusout", function() {
      $("phonecheckvar").val("");
      var phonetext = $("#phone").val();
      var regex = /^01([0|1|6|7|8|9]?)-([0-9]{3,4})-([0-9]{4})$/g
      if (regex.exec(phonetext) != null) {
         $("#phonecheck").text("사용가능한 핸드폰 번호입니다.");
         $("#phonecheck").css("color", "blue");
         $("#phonecheckvar").val("올바른 양식 입니다.");
      } else {
         $("#phonecheck").text("양식에 맞지 않습니다.");
         $("#phonecheck").css("color", "red");
         $("#phone").val("");
         $("#phonecheckvar").val("");
      }
   })

   $("#name").on("focusout", function() {// 이름 형식이 맞는지 구별 regex
      $("#namecheckvar").val("");
      var nicknametext = $("#name").val();
      var regex = /^.{1,6}$/g
      if (regex.exec(nicknametext) != null) {
         $("#namecheck").text("올바른 양식 입니다.");
         $("#namecheck").css("color", "blue");
         $("#namecheckvar").val("올바른 양식 입니다.");
      } else {
         $("#namecheck").text("양식에 맞지 않습니다.");
         $("#namecheck").css("color", "red");
         $("#nametext").val("");
         $("#namecheckvar").val("");
      }
   })


   $(document).keyup(function(e) {
      if (e.keyCode == 13) {
         $("#ok").click();
      }
   });
   $("#ok")
         .on(
               "click",
               function() {
                  if ($("#idrealcheck").attr("flag") == "false") {
                     alert("id중복확인을 해주세요.");
                     $("#id").focus();
                     return;
                  } else if ($("#emailAuth_btn").attr("flag") == "false") { //email인증
                     alert("email인증을 해주세요.");
                     $("#id").focus();
                     return;
                  }else if (
                        ($("#pwcheckvar").val() == "사용가능 합니다.") && 
                       ($("#namecheckvar").val() == "올바른 양식 입니다.") && 
                       ($("#phonecheckvar").val() == "올바른 양식 입니다.") &&
                       ($("#idcheckvar").val() == "사용 가능한 아이디 입니다.")
                        ) 
                      {
                     $("#login").submit();
                  } else {
                     alert("값을 입력해주세요.");
                     return false;
                  }
               });

   $("#back_btn").on("click", function() {
      var back = confirm("메인화면으로 돌아갑니다.");
      if (back) {
         location.href = "login_main";
      }
   });

   $(document).submit(function() {
      if ($("#id").val() == "") {
         alert("값을 입력해 주세요.");
         return false;
      } else if ($("#pw1").val() == "") {
         alert("비밀번호 를 정확히 입력해 주세요.");
         return false;
      } else if ($("#name").val() == "") {
         alert("이름을 정확히 입력해 주세요.");
         return false;
      } else if ($("#pw1").val() != $("#pw2").val()) {
         alert("패스워드 조건이 맞는지 확인해주세요.");
         return false;
      } else if ($("#zipcode").val() == "") {
         alert("우편번호를 입력해 주세요.");
         return false;
      } else if ($("#address1").val() == "") {
         alert("주소를 입력해 주세요.");
         return false;
      } else if ($("#address2").val() == "") {
         alert("상세주소를 입력해 주세요.");
         return false;
      } else {
        if(confirm("회원가입을 하시겠습니까?") == true){
           return true;   
        }else{
            return false;
        }
      }
   })
});
</script>



<script>
      function noSpaceForm(obj) { // 공백사용못하게
         var str_space = /\s/; // 공백체크
         if (str_space.exec(obj.value)) { //공백 체크
            alert("해당 항목에는 공백을 사용할수 없습니다.\n\n공백은 자동적으로 제거 됩니다.");
            obj.focus();
            obj.value = obj.value.replace(' ', ''); // 공백제거
            return false;
         }
         // onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"
      }
   </script>
<script>
   function sample6_execDaumPostcode() {
      new daum.Postcode({
         oncomplete : function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
               addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
               addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if (data.userSelectedType === 'R') {
               // 법정동명이 있을 경우 추가한다. (법정리는 제외)
               // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
               if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                  extraAddr += data.bname;
               }
               // 건물명이 있고, 공동주택일 경우 추가한다.
               if (data.buildingName !== '' && data.apartment === 'Y') {
                  extraAddr += (extraAddr !== '' ? ', '
                        + data.buildingName : data.buildingName);
               }
               // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
               if (extraAddr !== '') {
                  extraAddr = ' (' + extraAddr + ')';
               }
               // 조합된 참고항목을 해당 필드에 넣는다.

            } else {

            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("address1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("address2").focus();
         }
      }).open();
   }
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
            <h1>회원가입</h1>
            <nav class="d-flex align-items-center"> <a href="/">메인페이지<span
               class="lnr lnr-arrow-right"></span></a> <a href="/insert">회원가입<span
               class="lnr "></span></a> </nav>
         </div>
      </div>
   </div>
   </section>
   <form id="login" action="insertProc" method="post">
      <div class="row mb-2" id="mid">
         <div class="container col-md-6 mt-6 mb-6" id="div">
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-10 col-md-10 col-sm-10 text_label">
                  <label for="" class="mt-3 mb-1 mr-3"><strong>아이디</strong></label><span
                     id="idcheck" name="idcheck"></span> <input type="hidden"
                     id="idcheckvar" name="idcheckvar">
               </div>
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <input type="text" class="form-control"
                     placeholder="ex)moonblack_@naver.com" name="id" id="id" required
                     onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);">
               </div>
               <div id="email" class="col-lg-2 col-md-2 col-sm-2 pr-5">
                  <input id="idrealcheck" class="btn btn-warning" type="button"
                     value="중복확인"> <input id="emailAuth_btn" flag="false"
                     class="btn btn-warning" type="button" value="이메일인증">
                  <h5>
                     <span id="email_auth_badge" class="badge badge-info mt-2 mr-2">아이디
                        인증성공!</span>
                  </h5>
               </div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label ">
                  <label for="" class="mt-2 mb-1 mr-3"><strong>비밀번호</strong></label><span
                     id="pwcheck1" name="pwcheck1"></span><input type="hidden"
                     id="pwcheckvar" name="pwcheckvar">
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <input type="password" class="form-control"
                     placeholder="영문&숫자 6자리  ~ 12자리" name="pw" id="pw1" required
                     onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);">
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label ">
                  <label for="" class="mt-2 mb-1"><strong>비밀번호 확인</strong></label>
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <input type="password" class="form-control"
                     placeholder="비밀번호를 입력하세요." name="pw2" id="pw2" required
                     onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);">
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label ">
                  <label for="" class="mt-2 mb-1 mr-3"><strong>이 름</strong></label><span
                     id="namecheck"></span><input type="hidden" id="namecheckvar"
                     name="namecheckvar">
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <input type="text" class="form-control" placeholder="6자 이내"
                     name="name" id="name" required onkeyup="noSpaceForm(this);"
                     onchange="noSpaceForm(this);">
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-1"></div>

               <div class="col-3"></div>
            </div>

            <div class="row" id="main">
               <div class="col-1"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <label for="" class="mt-2 mb-1 mr-3"><strong>휴대폰</strong></label><span
                     id="phonecheck"></span><input type="hidden" id="phonecheckvar"
                     name="phonecheckvar">
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <input type="text" class="form-control"
                     placeholder="ex)010-9890-2814" name="phone" id="phone" required
                     onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);">
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>

            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <label for="" class="mt-2 mb-1 mr-3"><strong>우편번호</strong></label>
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <input type="text" class="form-control" placeholder="우편번호"
                     name="zipcode" id="zipcode" required onkeyup="noSpaceForm(this);"
                     onchange="noSpaceForm(this);" readonly>
               </div>
               <div id="email" class="col-lg-2 col-md-2 col-sm-2 pr-5">
                  <input type="button" class="btn btn-warning"
                     onclick="sample6_execDaumPostcode()" value="주소 검색">
               </div>
            </div>

            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <label for="" class="mt-2 mb-1 mr-3"><strong>주소</strong></label>
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <input type="text" class="form-control" placeholder="주소"
                     name="address1" id="address1" required
                     onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"
                     readonly>
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>

            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <label for="" class="mt-2 mb-1 mr-3"><strong>상세주소</strong></label>
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
            <div class="row" id="main">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 text_label">
                  <input type="text" class="form-control" placeholder="상세주소"
                     id="address2" name="address2" required
                     onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);">
               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>


            <div class="row" id="main mb-2">
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-9 col-md-9 col-sm-9 input_text">
                  <button type="button" class="btn btn-warning" id="ok" name="ok">가입하기</button>
                  <button type="button" class="btn btn-warning ml-4" id="back_btn">메인으로</button>

               </div>
               <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>
         </div>
      </div>
   </form>

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
            <script>document.write(new Date().getFullYear());</script>
            All rights reserved | This template is made with <i
               class="fa fa-heart-o" aria-hidden="true"></i> by <a
               href="https://colorlib.com" target="_blank">Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
         </p>
      </div>
   </div>
   </footer>
   <!-- End footer Area -->
   <!-- End footer Area -->

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