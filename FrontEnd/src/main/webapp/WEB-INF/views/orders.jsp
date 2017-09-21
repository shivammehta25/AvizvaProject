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
<title>GAMAZON | Orders</title>
<style>
.panel-body {
	color: black;
	height: 150px;
}

.panel-info>.panel-heading:HOVER {
	background-color: #27A967 !important;
	color: white !important;
}

.panel-info>.panel-heading {
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
	margin-bottom: 20px;
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

.radhead {
	color: black;
}

.headerez {
	color: #2e2f31 !important;
	-webkit-text-shadow: 1px 2px 10px #FFFFFF !important;
	-moz-text-shadow: 1px 2px 10px #FFFFFF !important;
	text-shadow: 1px 2px 10px #FFFFFF !important;
}

.panel.panel-primary {
	margin-top: 120px;
}
.thumbnailStyling {
height : 110px !important;
width : 110px !important;
}
</style>


</head>
<body ng-app="myApp" ng-controller="orderController">
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="row">
					<div class="col-md-12">
						<div class="page-header">
							<h1 class="headerez">
								<i class="fa fa-shopping-cart fa-lg" aria-hidden="true"></i>
								Your Orders
							</h1>
						</div>
					</div>
				</div>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Order Number: {{order.orderNumber}}
							</h3>
						</div>
						<div ng-repeat="(i,order) in orderList">
						
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3"><img src="download?productName={{order.productName}}" class="img-thumbnail thumbnailStyling">{{order.productName}}</div>
								<div class="col-md-3">
									Product Id
									<hr>
									<small>{{order.productId}}</small>
								</div>
								<div class="col-md-3">
									Status
									<hr>
									<small>{{order.orderStatus}}</small>
								</div>
								<div class="col-md-3">
									Payment Details
									<hr>
									<small>{{order.orderPaymentDetails }}</small>
								</div>
							</div>
						</div>
						<hr>
					</div>
				</div>
			</div>
		</div>

	</div>
	</div>

	</div>
	</div>
	${prevUrl }




	<script>
var app = angular.module('myApp', []);

app.controller('orderController',function($scope){
	$scope.orderList = ${orderList};
	$scope.productName = ${productName};
	for(i = 0 ; i < $scope.orderList.length ; i++){
		$scope.orderList[i].productName=$scope.productName[i];
	}
});

</script>


	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>



</body>
</html>