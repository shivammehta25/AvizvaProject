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
<style>
.panel-body{
	color:black;
	height: 150px;
}

.panel-info>.panel-heading:HOVER{
	background-color: #27A967 !important;
	color:white !important;
}

.panel-info>.panel-heading{
	background-color: #2e2f31 !important;
	color: #27A967 !important;
}

.panel-footer {
    background-color: rgba(194, 220, 243, 0.63) !important;
    color: black !important;
    height: 50px;
}

.totalBar {
    background: #2e2f31 !important;
    padding: 20px;
    -webkit-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
	-moz-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
	box-shadow: 4px 7px 38px -2px rgba(0, 0, 0 0, 1) !important;
	border-radius: 20px;
}
.totprice {
	padding-top: 20px;
		
	
}
.panel {
-webkit-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
	-moz-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
	box-shadow: 4px 7px 38px -2px rgba(0, 0, 0 0, 1) !important;
}

.nav-stacked {
-webkit-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
	-moz-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
	box-shadow: 4px 7px 38px -2px rgba(0, 0, 0 0, 1) !important;

}

.radhead{
	color:black;

}
.headerez {
    color: #2e2f31 !important;
    -webkit-text-shadow: 1px 2px 10px #FFFFFF !important;
	-moz-text-shadow: 1px 2px 10px #FFFFFF !important;
	text-shadow: 1px 2px 10px #FFFFFF !important;
  
}
h1:hover {
}
</style>


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
			<div class="row">
				<div class="col-md-12">
					<div class="page-header">
						<h1 class="headerez">
							<i class="fa fa-shopping-cart fa-lg" aria-hidden="true"></i>
							Your Cart <small> </small>
						</h1>
					</div>
				</div>
			</div>
		
		
		<div ng-repeat="(i,product) in cartList">
					
		
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">
								Product Id: #{{product.productId}}
							</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3">
									Hello {{product.productName}}
								</div>
								<div class="col-md-3">
									{{product.productDesc}}
									<hr>
									<small>Category: <a style="text-decoration: none !important" href="products?categoryName={{product.productCatName}}">{{product.productCatName}} </a></small>
								</div>
								<div class="col-md-3">
									<input type="number" ng-value="{{product.quantity}}" ng-model="quant[i]" >
								</div>
								<div class="col-md-3">
									<i class="fa fa-inr" ></i> {{product.productPrice * quant[i]}}
								</div>
							
							</div>
							
							
							
						</div>
						<div class="panel-footer">
							<div class="col-md-3 col-md-offset-9">
								<a href="updateCart?productId={{product.productId}}&cartQuantity={{quant[i]}}" ><button class="btn btn-success">Update</button> </a>
								<a href="removefromcart?productId={{product.productId}}"><button class="btn btn-danger">Remove</button></a>
							</div>
						</div>
					</div>
		</div>
		<div class="totalBar">
			<div class="row">
				<div class="col-md-3 col-md-offset-9">
				<span class="totprice">{{totalPrice}} </span> <span class="pull-right"><button class="btn btn-success">Checkout</button></span> 
				</div>
				
			</div>
		</div>
		</div>
	
	</div>
</div>
${prevUrl }



<script>
var app = angular.module('myApp', []);

app.controller('cartController',function($scope){

$scope.cartList = ${cartList};
$scope.quantity = ${quantity};
$scope.quant = $scope.quantity;
for(i=0;i<$scope.cartList.length;i++){
	$scope.cartList[i].quantity=$scope.quantity[i];
}
$scope.totalPrice = ${totalPrice};



});


</script>


	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>



</body>
</html>