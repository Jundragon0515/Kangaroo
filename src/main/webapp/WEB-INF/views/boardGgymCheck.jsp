<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="../resources/img/logo.png">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		var type = '${type}';
		var msg = '${msg}';	
		alert(msg);
		if(type=="trade"){
			document.location.href = "trade"; 
		}else if(type=="safe"){
			document.location.href = "trade_safe"; 
		}else{
			document.location.href = "auction"; 
		}
	</script>
</body>
</html>