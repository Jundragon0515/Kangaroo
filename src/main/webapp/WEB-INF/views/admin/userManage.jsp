<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
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
<link rel="stylesheet" href="../resources/css/magnific-popup.css">
<link rel="stylesheet" href="../resources/css/main.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src=https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js></script>
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
</style>
</head>
<body>	
<div class="container mt-4 mb-4">
	<div class="row">
		<div class="col-12">
			<div class="card text-center">
				<div class="card-header" style=font-size:30px;line-height:40px;>
					회 원 관 리
				</div>
				<div class="card-body">
					<table class="table table-bordered" style=font-size:20px;>
						<tbody>
							<tr>
								<th scope="row">ID</th>
								<td colspan="2">${mdto.id }</td>
							</tr>								
							<tr>
								<th scope="row">이름</th>
								<td colspan="2">${mdto.name }</td>
							</tr>
							<tr>
								<th scope="row">전화번호</th>
								<td colspan="2">${mdto.phone }</td>
							</tr>
							<tr>
								<th scope="row">보유 포인트</th>
								<td colspan="2"><fmt:formatNumber value="${mdto.point }" pattern="#,###"/></td>
							</tr>
							<tr>
								<th scope="row">우편번호</th>
								<td colspan="2">${mdto.zipcode }</td>
							</tr>
							<tr>
								<th scope="row">주소(배송지)</th>
								<td >${mdto.address1 }</td>
								<td >${mdto.address2 }</td>
							</tr>
							<tr>
								<th scope="row">회원등급</th>
								<td colspan="2">${mdto.member_class}</td>
							</tr>
							<tr>
								<th scope="row">회원관리</th>
								<th scope="row" colspan="2" style=fort-size:50px;>
									<input type="button" id="addBlackList" class="genric-btn danger" value="블랙리스트 등록" style=margin-right:20px;font-size:15px;>
									<input type="button" id="releaseBlackList" class="genric-btn primary" value="블랙리스트 해제" style=margin-right:20px;font-size:15px;>
									<input type="button" id="closePage" class="genric-btn primary" value="닫기" style=font-size:15px;>
								</th>								
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$("#closePage").on("click", function(){
		window.close();
	})
	$("#addBlackList").on("click", function(){
		$.ajax({
			url : "blackList",
			type : "post",
			data : {
				id : "${mdto.id }"
			}
		}).done(function(resp){
		   alert("블랙 리스트에 등록되었습니다.")
		})
	})
	$("#releaseBlackList").on("click", function(){
		$.ajax({
			url : "releaseBlackList",
			type : "post",
			data : {
				id : "${mdto.id }"
			}
		}).done(function(resp){
		   alert("블랙 리스트가 해제 되었습니다.")
		})
	})
</script>
<script src="../resources/js/vendor/jquery-2.2.4.min.js"></script>
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