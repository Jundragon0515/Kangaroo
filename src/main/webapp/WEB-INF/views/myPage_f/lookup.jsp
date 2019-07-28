<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" href="../resources/img/fav.png">
<meta name="author" content="CodePixar">
<meta name="description" content="">
<meta name="keywords" content="">
<meta charset="UTF-8">
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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	*{
		text-align:center;
	}
</style>
</head>
<body>
<div class="container-fluid">
    <div class="panel-body">
        <div class="col-md-12 header-title mt-3 mb-3"><h1>스마트택배 배송조회</h1></div>
        <div class="col-md-12">
        <table class ="table table-borderless">
        <tbody>
        <tr>
        <td>운송장 번호</td>
        <td>${invoiceNo }</td>
        </tr>
        <tr>
        <td>받는 사람</td>
        <td>${receiverName }</td>
        </tr>
        <tr>
        <td>보낸 사람</td>
        <td>${senderName }</td>
        </tr>
        <tr>
        <td>수령 주소</td>
        <td>${receiverAddr}</td>
        </tr>
        </tbody>
        </table>
        </div>
    </div>

    <div class="col-sm-12 mt-2">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>시간</th>
                <th>현재 위치</th>
                <th>배송 상태</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
            <c:when test="${ja==null }">
            <tr>
                <td colspan=3>배송 조회 결과가 없습니다.</td>
            </tr>
            </c:when>
            <c:otherwise>
            <c:forEach items="${ja }" var="i"> 
            <tr>
                <td>${i.timeString }</td>
                <td>${i.where }</td>
                <td>${i.code }</td>
            </tr>
            </c:forEach>
            </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
</div>
<script src="../resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="../resources/js/jquery.nice-select.min.js"></script>
	<script src="../resources/js/jquery.sticky.js"></script>
	<script src="../resources/js/nouislider.min.js"></script>
	<script src="../resources/js/jquery.magnific-popup.min.js"></script>
	<script src="../resources/js/owl.carousel.min.js"></script>
	<script src="../resources/js/main.js"></script>
</body>
</html>