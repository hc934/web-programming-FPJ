<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>105人力公司 管理頁面</title>
</head>
<body>
<body>
	<div>
		<p>
			<strong>修改資料</strong>
		</p>
		<form  action='Modify' method="post">
			<table width="600" border="0">
				<tr>
					<td width="150"><div align="left">姓名:</div></td>
					<td width="450"><div align="left">
							<input name="name" type="text" value="${user.name }" required>
						</div></td>
				</tr>
				<tr>
					<td><div align="left">住址:</div></td>
					<td><div align="left">
							<input name="address" type="text" size="45" value = "${user.address }"required>
						</div></td>
				</tr>
				<tr>
					<td><div align="left">電話:</div></td>
					<td><div align="left">
							<input name="phoneNumber" type="text" value = "${user.phoneNumber }" required>
						</div></td>
				</tr>
				<tr>
					<td><div align="left">學歷:</div></td>
					<td><div align="left">
							<input type = 'radio' name='education' value='${user.education }' checked='true'> ${user.education }
							<input type="radio" name="education" value="高中職">高中職 
							<input type="radio" name="education" value="五專">五專
							<input type="radio" name="education" value="四技二專">四技二專
							<input type="radio" name="education" value="大學">大學
							<input type="radio" name="education" value="研究所"> 研究所
						</div></td>
				</tr>
			</table>		
			<br>
			帳號：<input type='text' name='accountName' value = "${user.accountName }">
			密碼：<input type='password' name='password' value = "${user.password }">
			<br>
			<input type="reset" name="reset" value="重設">
			<input type="submit"  value="mod" name="mod">

		</form>

	</div>
</body>
</html>