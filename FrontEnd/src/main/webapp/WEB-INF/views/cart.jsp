<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>

<link rel="stylesheet" href="resources/css/admin.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Contact Us</title>
</head>
<body ng-app="myApp" ng-controller="cartController">
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
					<h3 class="radhead">Search By Categories</h3>
					<ul class="nav nav-pills nav-stacked">
					<li><a href="products?categoryName=all">All Products</a>
						<c:forEach var="category"
							items="${applicationScope['listCategory']}">
							<li><a
								href="products?categoryName=${category.categoryName }">${category.categoryName }</a></li>
						</c:forEach>

					</ul>
				</div>
		<div class="col-md-10">
		<div ng-repeat="product in cartList">
		
		
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">
								{{product.productId}}
							</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3">
									Hello
								</div>
								<div class="col-md-3">
									World
								</div>
								<div class="col-md-3">
									Sup
								</div>
								<div class="col-md-3">
									huahahha
								</div>
							
							</div>
							
							
							
						</div>
						<div class="panel-footer">
							Panel footer
						</div>
					</div>
		</div>
		</div>
	</div>
</div>

{{cartList}}
{{quantity}}

<script>
var app = angular.module('myApp', []);

app.controller('cartController',function($scope){

$scope.cartList = ${cartList};
$scope.quantity = ${quantity};
$scope.quantityfun = function(productId){
	
}

});


</script>


	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>



</body>
</html>