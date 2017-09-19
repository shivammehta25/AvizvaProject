<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="resources/css/admin.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.col-md-4 {
	padding-left: 40px !important;
	padding-top: 20px;
	padding-bottom: 20px;
	border-radius: 20px;
}
/* .col-md-3 {
	background-color: #2e2f31;
	padding: 10px;
	padding-left: 40px !important;
	padding-right: 0px !important;
	margin-right: 0px !important;
	border-radius: 20px;
}
 */
.col-md-4:HOVER {
	color: black;
}

.input-group-addon {
	border: 10px;
}

div#searchbutton {
	width: 300px;
	transition: width 0.4s ease-in-out;
}

div#searchbutton:hover {
	width: 100%;
}

.img-thumbnail {
	width: 300px;
}

.block { //
	display: block; //
	position: relative; //
	width: 295px; //
	border-radius: 5px;
	background: #fff;
	box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
}

.product {
	display: block;
	position: relative;
}

.product img {
	width: 100%;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.info {
	display: block;
	position: relative;
	padding: 20px;
}

.details {
	border-top: 1px solid #e5e5e5;
	padding: 18px 20px;
}

.buttons {
	display: block;
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
	background: rgba(255, 255, 255, .5);
	opacity: 0;
	-webkit-transition: opacity .25s ease-in;
	-ms-transition: opacity .25s ease-in;
	-moz-transition: opacity .25s ease-in;
	-o-transition: opacity .25s ease-in;
	transition: opacity .25s ease-in;
}

.product:hover .buttons, .product:hover a {
	opacity: 1;
}

.buttons a {
	display: block;
	position: absolute;
	left: 50px;
	width: 155px;
	border-radius: 2px; //
	padding: 15px 10px 15px 65px; //
	font-family: Helvetica, sans-serif;
	text-transform: uppercase;
	color: #fff;
	text-decoration: none;
	opacity: 0;
}

a.buy {
	top: 20%;
}

a.preview {
	bottom: 20%;
}

.info::after {
	display: block;
	position: absolute;
	top: -8px;
	left: 23px;
	content: "";
	width: 15px;
	height: 15px;
	background: #fff;
	-webkit-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	-moz-transform: rotate(45deg);
	-o-transform: rotate(45deg);
	transform: rotate(45deg);
}

.info h4 {
	position: relative;
	padding: 0 0 20px 0;
	margin: 0 0 20px 0;
	font-family: "Open Sans", sans-serif;
	font-weight: 700;
	font-size: 19px;
	line-height: 25px;
	color: #372f2b;
	letter-spacing: -1px;
}

.info h4::after {
	display: block;
	position: absolute;
	bottom: 0px;
	content: "";
	width: 40px;
	height: 2px;
	background: #3b86c4;
}

.info .description {
	display: block;
	padding-bottom: 20px;
	font-family: "Open Sans", sans-serif;
	font-size: 14px;
	font-weight: 600;
	color: #5f5f5f;
}

.info .price {
	font-family: "Open Sans", Helvetica, Arial, sans-serif;
	font-size: 24px;
	font-weight: 700;
	color: #372f2b;
	line-height: 26px;
}

.pull-right .fa {
	width: 30px;
	text-align: center;
	text-decoration: none;
	padding: 5px !important;
	font-size: 27px !important;
}

.block {
	padding-bottom: 20px;
	-webkit-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1);
	-moz-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1);
	box-shadow: 4px 7px 38px -2px rgba(0, 0, 0 0, 1);
	border-radius: 20px !important;
	background-color: #dceff5;
	margin-bottom: 20px;
}

a.buy.btn.btn-large.btn-info {
	left: 25%;
}

a.preview {
	bottom: 20%;
	left: 25%;
}

p.category.ng-binding {
	font-size: 13px;
	color: rgba(52, 123, 183, 0.58);
	text-decoration: none;
}

select.ng-valid.ng-not-empty.ng-dirty.ng-valid-parse.ng-touched {
	color: black;
}

option {
	color: black;
}

.radhead {
	color: black;
}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<div class="container-fluid col-md-offset-2">

		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron well">
					<h2>PRODUCT NAME</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<img src="download?productName=${product.productName}" alt="Thumbnail Not Available" class="img img-rounded img-responsive " >

			</div>
			<div class="col-md-8 ">
				<div class="list-group ">
					<div class="list-group-item active product ">
						<h4 style="color: black">Manufactured by
							${product.productBrand}</h4>
					</div>
					<div class="list-group-item active product ">
						<h4 style="color: black">${product.productDesc}</h4>
					</div>
					<div class="list-group-item active product ">
						<h4 style="color: black">Sold by ${product.productSuppName}</h4>
					</div>
					<div class="list-group-item active product ">

						<c:if test="${product.productQuantity > 1}">
							<h4 style="color: black">
								Item In Stock
							</h4>
						</c:if>
					</div>
					<div class="list-group-item active product ">

						<h4 style="color: black">Rs. ${product.productPrice}</h4>
					</div>
					<div class="list-group-item active product ">
						<form class="form-horizontal" method="post" action="addtocart" role="form">
							<input type="hidden" value="${product.productId}" name="productId">
							<div class="form-group">
								<div class="col-md-3">

									<h4 style="color: black">Enter Item Quantity</h4>

								</div>
								<div class="col-md-3">
									<input type="number" name="productQuantity" id="productQuantity"
										style="color: black" min="1" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-2 col-md-4">
									<button type="submit" class="btn btn-success btn-lg btn-block">
										Add To Cart</button>
								</div>
							</div>
						</form>
					</div>
				</div>


			</div>
		</div>
	</div>
	<div class="container-fluid col-md-offset-2 ">
		<div class="row well">
			<div class="col-md-12 ">
				<dl class="dl" style="color: black">
					<dt class="panel-heading">Product Description</dt>
					<dd>A description list is perfect for defining terms.</dd>
				</dl>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
</body>
</html>