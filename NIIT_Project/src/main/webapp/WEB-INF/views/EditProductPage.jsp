<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT PRODUCT</title>
</head>
<body bgcolor="#dcf7f4">
<div align="center">
<h1>EDIT YOUR PRODUCT HERE...</h1>
<form:form action="Product" method="post" enctype="multipart/form-data" modelAttribute="user" style="width:30%; height:50%; border:5px solid black; background-color:#c8f7be; padding: 2% 3% 2% 3%; margin-top: 4%; margin-bottom:4%;border-radius: 5%">
<form:hidden path="id"/>
<table>
<spring:bind path="name">
<tr><td><form:label path="name">PROUCT NAME</form:label></td><td>:</td>
    <td><form:input path="name" id="name"/></td></tr>
</spring:bind>
<spring:bind path="des">
<tr><td><form:label path="des">DESCRIPTION</form:label></td><td>:</td>
    <td><form:input path="des" id="des"/></td></tr>
</spring:bind> 
<spring:bind path="cat">   
<tr><td><form:label path="cat">CATEGORY</form:label></td><td>:</td>
    <td><form:select path="cat" id="cat">
     <form:option value="------select------"></form:option>
     <form:option value="TOYS"></form:option>
     <form:option value="BOOKS"></form:option>
     <form:option value="ALL"></form:option>
     </form:select></td></tr>
</spring:bind>
<spring:bind path="price">
<tr><td><form:label path="price">PRICE</form:label></td><td>:</td>
    <td><form:input path="price" id="price"/></td></tr>
</spring:bind>
<spring:bind path="units">
<tr><td><form:label path="units">NUMBER OF UNITS</form:label></td><td>:</td>
    <td><form:input path="units" id="units"/></td></tr>
</spring:bind>
</table>
<table>
 <tr><td></td><td></td><td></td><td></td><td>Upload Image</td><td>:</td><td><input type="file" name="image" size="100%" /></td></tr>
</table>
<table>
<tr><td><input type="submit" onclick="alert('PRODUCT SUCCESSFULLY UPDATED')" value="SUBMIT" /></td><td><input type="reset" value="CANCEL" /></td></tr>
</table>
</form:form>
</div>
</body>
</html>