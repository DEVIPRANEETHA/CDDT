<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body bgcolor="#c6c6c4">
<div align="center">
<h2> USER LOGIN </h2>
<form action="<c:url value='/j_spring_security_check' />" method="post" style="width:20%; height:50%; border:5px solid black; background-color:#f9dbd9; padding: 5% 5% 5% 5%; margin-top: 4%; margin-bottom:4%;border-radius: 5%">
<table>
<tr><td>NAME</td><td>:</td><td><input type="text" plceholder="Enter your Name" name="name" /></td></tr>
<tr><td>PASSWORD</td><td>:</td><td><input type="password" plceholder="Enter your password" name="pwd" /></td></tr>
</table>
<table>
<tr><td><input type="submit" value="LOGIN" /></td><td><input type="RESET" value="CANCEL" /></td></tr>
</table>
<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
</form>
</div>
</body>
</html>