<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN SIGNUP</title>
</head>
<body bgcolor="#d8fcd0">
<div align="center">
<h2>SIGN UP HERE !!...</h2>
<form:form action="AdminPage" method="post" modelAttribute="user" style="width:28%; height:50%; border:5px solid black; background-color:#d1f6fc; padding: 5% 5% 5% 5%; margin-top: 4%; margin-bottom:4%;border-radius: 5%">
<table>
<tr><td><form:label path="name">NAME</form:label></td><td>:</td>
    <td><form:input path="name"/></td></tr>
<tr><td><form:label path="phno">PHONE NUMBER</form:label></td><td>:</td>
    <td><form:input path="phno"/></td></tr>
<tr><td><form:label path="dob">DATE OF BIRTH</form:label></td><td>:</td>
    <td><form:input path="dob"/></td></tr>
<tr><td><form:label path="mail">E-MAIL ID</form:label></td><td>:</td>
    <td><form:input path="mail"/></td></tr>
<tr><td><form:label path="pwd">PASSWORD</form:label></td><td>:</td>
    <td><form:password path="pwd" /></td></tr>
<tr><td><form:label path="gender">GENDER</form:label></td><td>:</td>
    <td><form:radiobutton path = "gender" value = "M" label = "Male" />
    <form:radiobutton path = "gender" value = "F" label = "Female" /></td></tr>
</table>
<table>
<tr><td><input type="submit" value="LOGIN" /></td><td><input type="reset" value="CANCEL" /></td></tr>
</table>
</form:form>
</div>
</body>
</html>