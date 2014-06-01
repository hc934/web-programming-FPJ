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
			<strong>歡迎使用105人力公司網站來登錄您的個人資料 -Page 2</strong>
		</p>
		<form name="form2" method="post" action="AddNewUser">
			<table width="600" border="0">
				<tr>
					<td width="150"><div align="left">新增帳戶名稱:</div></td>
					<td width="450"><div align="left">
							<input name="accountName" type="text" id="accountName">
						</div></td>
				</tr>
				<tr>
					<td><div align="left">新增帳戶密碼:</div></td>
					<td><div align="left">
							<input name="password" type="password" id="password">
						</div></td>
				</tr>
			</table>
			<p>
				<label> <input type="reset" name="reset" value="重設">
					<input type="submit" name="submit" value="送出">
				</label>
			</p>
		</form>
	</div>
</body>
</html>