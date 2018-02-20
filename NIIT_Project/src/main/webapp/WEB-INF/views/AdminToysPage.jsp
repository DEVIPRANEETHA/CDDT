<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f7eaee}

th {
    background-color: maroon;
    color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="AdminHome">NIIT E-COMMERCE</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="AdminHome">HOME</a></li>
      <li><a href="Add">ADD PRODUCTS</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">CATEGORIES<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="AdminToyslist">TOYS</a></li>
          <li><a href="AdminBookslist">BOOKS</a></li>
          <li><a href="AdminAllProducts">ALL</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="AdminAboutUs">ABOUT US</a></li>
      <li><a href="AdminContactUs">CONTACT US</a></li>
    </ul>
  </div>
</nav>
   <div class="container">
         <div ng-app="myApp" ng-controller="ProductsList">
               <table border="1" class="g table-hover table-bordered">
                 <tr>
                 <th><h3><b><u>NAME</u></b></h3></th>
                 <th><h3><b><u>CATEGORY</u></b></h3></th>
                 <th><h3><b><u>DESCRIPTION</u></b></h3></th>
                 <th><h3><b><u>PRICE</u></b></h3></th>
                 <th><h3><b><u>NUMBER OF UNITS</u></b></h3></th>
                 <th><h3><b><u>IMAGE</u></b></h3></th>
                 </tr>
                 <tr ng-repeat="x in products">
                 <td>{{x.name}}</td>
                 <td>{{x.cat}}</td>
                 <td>{{x.des}}</td>
                 <td>{{x.price}}</td>
                 <td>{{x.units}}</td>
                 <td><img src="<c:url value="/resources/images/{{x.id}}.jpg"/>"height="100" width="100"></td>
                 <td><a class="btn btn-info" onclick="alert('PRESS OK TO EDIT')" href="Edit?id={{x.id}}" >EDIT</a></td>
                 <td><a class="btn btn-info" onclick="alert('PRODUCT SUCCESSFULLY DELETED')" href="Delete?id={{x.id}}" >DELETE</a></td>
                 </tr>
                 
               
               </table>
         </div>
  </div>
 <script>
var app = angular.module('myApp', []);
app.controller('ProductsList', function($scope, $http) {
    $http.get("AdminToys")
    .then(function (response) {$scope.products = response.data;});
});
</script>
</body>
</html>