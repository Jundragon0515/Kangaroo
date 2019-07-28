<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js">
</script>
<link rel="shortcut icon" href="../resources/img/logo.png">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Noto+Sans+KR|Acme|Nanum+Pen+Script&display=swap"
	rel="stylesheet">
	<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<style>
	* {
	font-family: 'Noto Sans KR', sans-serif;
	margin :0 auto;
	text-alien:center;
}
body {
	-webkit-background-size: cover;
	-moz-background-size: cover;
	background-size: cover;
	-o-background-size: cover;
}
#wrapper {
	margin-top: 5%;
	background-color: #ffffff95;
	margin-right: auto;
	margin-left: auto;
	overflow: hidden;
	text-align: center;
	width: 400px;
	height: 500px;
	border-radius: 10px;
	position: relative;
}
#header {
	width: 100%;
}
#part1, #part3_id {
	margin-top: 50px;
	font-size: 20px;
}
.btn-warning {
	color: white;
}
#img {
	width: 150px;
}
#email {
	border: 1px solid rgba(0, 0, 0, 0.32);
	padding: 0px 3px;
}
.a{
	text-align:center;
}
</style>
<script >
$(function(){
	$("#changePw").on("click", function() {
		var email = "${email}";
	    var pw1 = $("#newPw1").val();
	    var pw2 = $("#newPw2").val();
	    var regex = /^[A-Za-z0-9]{6,12}$/;
	    var pwRegexResult = regex.exec(pw1);
	    if (pwRegexResult == null) {
	       alert("비밀번호조건 :  영문&숫자 6자리  ~ 12자리");
	       $("#newPw1").focus();
	       return;
	    } else if (pw2 != pw1) {
	       alert("비밀번호 확인을 정확히 입력해주세요.");
	       $("#newPw2").focus();
	       return;
	    }else{
	    $("#part3_pw").toggle();
	    $("#findResult").text("PW변경중입니다.");
	    $("#part3_id").toggle();
	    $.ajax({
	       url : "changePw",
	       type : "post",
	       data : {
	          id : email,
	          pw : pw1
	       }
	    }).done(function(resp) {
	       console.log(resp);
	       if (resp == "1") {
	          alert("비밀번호가 변경 되었습니다.");
	          opener.location.reload(true);
	          close();
	       } else {
	    	   alert("비밀번호 변경 실패");
	    	   close();
	       }
	    })
	    }
	 });
})

</script>
</head>
<body>
<div class="container">
	<div id="header">
			<div class="row  justify-content-center">
				<div class="col-12 a">
					<img src="../resources/img/logo.png" id="img" width="150px">
				</div>
				<div class="col-12 a">
					<h3>Kangaroo</h3>
				</div>
			</div>
		</div>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">변경할 비밀번호</span>
		</div>
		<input id="newPw1" type="password" class="form-control"
			placeholder="영문&숫자 6자리  ~ 12자리">
	</div>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">비밀번호 확인</span>
		</div>
		<input id="newPw2" type="password" class="form-control"
			placeholder="비밀번호를 다시한번 입력하세요">
	</div>
	<div class="row justify-content-md-center">
		<div class="col-12 a">
			<button id="changePw" type="button" class="btn btn-warning">비밀번호변경하기</button>
		</div>
	</div>
	</div>
</body>
</html>