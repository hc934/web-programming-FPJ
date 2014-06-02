<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User ,model. AccountCheck , java.util.ArrayList;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>105人力網站管理系統</title>
</head>
<body>
	<table>
		<tr><td>帳號</td><td>姓名</td><td> 住址</td><td>電話</td><td>學歷</td><td>修改</td><td>刪除</td></tr>
		
<% 
		ArrayList <User> users =  (ArrayList<User>) request.getAttribute("users"); 
		for (User user : users){
%>
		<tr>
			<td><%=user.getAccountName() %></td>
			<td><%=user.getName() %></td>
			<td><%=user.getAddress() %></td>
			<td><%=user.getPhoneNumber() %></td>
			<td><%=user.getEducation() %></td>
			<td><form action = "Modify" method = "post""><input type= "submit" value="<%=user.getAccountName() %>" name="accountName"></form></td>
			<td><form action = "Delete" method = "post""><input type= "submit" value="<%=user.getAccountName() %>" name="accountName"></form></td>

		</tr>
<%
		}
%>		
	</table>


	<a href = "Logout">登出</a>
</body>
</html>