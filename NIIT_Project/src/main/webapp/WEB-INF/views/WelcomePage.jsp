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
<title>WELCOME</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body bgcolor="#efefef">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="UserHome">NIIT E-COMMERCE</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="UserHome">HOME</a></li> 
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">CATEGORIES<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="Toyslist">TOYS</a></li>
          <li><a href="Bookslist">BOOKS</a></li>
          <li><a href="AllProducts">ALL</a></li>
        </ul>
      </li>
      <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> CART</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="UserAboutUs">ABOUT US</a></li>
      <li><a href="UserContactUs">CONTACT US</a></li>
    </ul>
  </div>
</nav>

   <div class="container">
         <div ng-app="myApp" ng-controller="ProductsList">
               <table class="g table-hover table-bordered">
                 <tr>
                 <th><h3><b><u>NAME</u><b></h3></th>
                 <th><h3><b><u>CATEGORY</u></b></h3></th>
                 <th><h3><b><u>DESCRIPTION</u></b></h3></th>
                 <th><h3><b><u>PRICE</u></b></h3></th>
                 <th><h3><b><u>IMAGE</u></b></h3></th>
                 </tr>
                 <tr ng-repeat="x in products">
                 <td>{{x.name}}</td>
                 <td>{{x.cat}}</td>
                 <td>{{x.des}}</td>
                 <td>{{x.price}}</td>
                 <td><img src="<c:url value="/resources/images/{{x.id}}.jpg"/>"height="100" width="100"></td>
                 <td><a class="btn btn-info" onclick="alert('PRODUCTSUCCESSFULY ADDED TO CART')" href="AddToCart?id={{x.id}}" >ADD TO CART</a></td>
                 <td><a class="btn btn-info" href="Buy?id={{x.id}}" >BUY</a></td>
                 </tr>
                 
               
               </table>
         </div>
  </div>
 <script>
var app = angular.module('myApp', []);
app.controller('ProductsList', function($scope, $http) {
    $http.get("All")
    .then(function (response) {$scope.products = response.data;});
});
</script>
</body>
</html>