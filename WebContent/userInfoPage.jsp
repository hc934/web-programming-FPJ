<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歡迎使用105人力公司網站</title>
</head>
<body>

	<div>
		<p>
			<strong>歡迎使用105人力公司網站來登錄您的個人資料-Page 3</strong>
		</p>
		<p>
			<strong>新增資料完成</strong>
		</p>
		<table width="600" border="0">
			<tr>
				<td width="100"><div align="left">帳戶名稱:</div></td>
				<td width="500"><div align="left">${param.accountName}</div></td>
			</tr>
			<tr>
				<td width="100"><div align="left">帳戶密碼:</div></td>
				<td width="500"><div align="left">${param.password}</div></td>
			</tr>
			<tr>
				<td width="100"><div align="left">姓名:</div></td>
				<td width="500"><div align="left">${user.name}</div></td>
			</tr>
			<tr>
				<td><div align="left">住址:</div></td>
				<td><div align="left">${user.address}</div></td>
			</tr>
			<tr>
				<td><div align="left">電話:</div></td>
				<td><div align="left">${user.phoneNumber}</div></td>
			</tr>
			<tr>
				<td><div align="left">學歷:</div></td>
				<td><div align="left">${user.education}</div></td>
			</tr>
		</table>
		<p>
			<label> <a href='Login'>請回到首頁進行登入動作!</a>
			</label>
		</p>
	</div>


</body>
</html>