<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歡迎使用105人力公司網站</title>
</head>
<body>
	<div>
		<p>
			<strong>歡迎來到105人力公司，請輸入您的資料來登入</strong><br>
			<strong>${message}</strong>
		</p>
		<form action="Login" method="post" >
			名稱:<input type="text" name="accountName" id="accountName"><br>
			密碼:<input type="password" name="password" id="passwordd"><br><br>
			自動登入:<input type="checkbox" name="auto" value="checked">
			<a href="addUserPage.jsp">新使用者?</a>
		<input type="submit" name="submit" value="送出">
		</form>
	</div>

</body>
</html>