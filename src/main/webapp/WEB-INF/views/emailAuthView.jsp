<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증 페이지</title>
<link rel="icon" type="image/png" sizes="32x32"
   href="/favicon-32x32.png">
<link rel="shortcut icon" href="../resources/img/logo.png">
<script src="https://code.jquery.com/jquery-3.4.0.min.js">
</script>
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script>
   $(function() {
      var authStr = "yet";
      var result = "false";
      var email_send_count = 0;
      var count = 0;
      $("#auth_num_btn").on("click", function() {
         result = "false";
         count = 0;
         if(email_send_count==2){
            alert("이메일발송은 세번까지만 가능합니다.");
         }
         if(email_send_count==3){
            alert("이메일발송버튼을 세번이상 누르셨습니다. 메인화면으로 돌아갑니다.");
            opener.document.getElementById("logo").click();
            close();
         }
         email_send_count++;
         $.ajax({
            url : "sendAuthNum.login",
            type : "post",
            data : {
               email : "${email}"
            }
         }).done(function(resp) {
            alert("이메일이 발송되었습니다. 인증번호를 입력해주세요.");
            //alert("확인용! 발표시에는 삭제하기 " + resp);
            authStr = resp;
         })
      });

      $("#auth_btn").on("click", function() {
         if(authStr == "yet"){
            alert("이메일인증버튼을 눌러주세요.");
            return;
         }
         var inputAuthNum = $("#input_auth").val();
         if (authStr == inputAuthNum) {
            alert("인증성공");
            $("#email_auth_badge", opener.document).toggle();
            $("#emailAuth_btn", opener.document).toggle();
            $("#emailAuth_btn", opener.document).attr("flag", "true");
            $("#idcheckin", opener.document).text("");
            $("#id", opener.document).attr("readonly","true");
            $("#idcheckvar", opener.document).val("사용 가능한 아이디 입니다.");
            close();
         } else {
            alert("인증실패 : " + (++count) + "회실패/3회");
         }
         if (count == 3) {
            alert("인증입력이 3회 틀렸습니다. 메인화면으로 돌아갑니다.");
            opener.document.getElementById("logo").click();
            close();
         }
      });
   })
</script>

<style>
#wrapper {
   width: 480px;
   margin: auto;
}
#logoWrapper{
   width: 100%;
   margin: auto;
   text-align:center;
}
#logo {
   width: 150px;
}
#wrapper>div{
   margin: 10px 0px;
}
.btn {
   margin-left: 10px;
}
#input_auth{
   width: 276px !important;
   border-radius: 5px;
   border : 1px solid #ffba00;
}
.banner{
	text-align:center;
}
</style>
</head>
<body>
   <div id="wrapper">
      <div id="logoWrapper">
         <img src="../resources/img/logo.png" id="img" width="150px">
      </div>
      <div class="input-group mb-3">
         <input id="email" type="text" class="form-control" value="${email }" readonly>
         <div class="input-group-append">
            <button id="auth_num_btn" class="btn btn-outline-warning"
               type="button">이메일로 인증번호 받기</button>
         </div>
      </div>
      <div class="input-group mb-3">
         <input id="input_auth" type="text"
            placeholder="인증번호 입력">
         <div class="input-group-append">
            <button id="auth_btn" class="btn btn-outline-warning" type="button"
               id="button-addon2">인증번호 확인</button>
         </div>
      </div>
   </div>
</body>

</html>