<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="resources/css/admin.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Products</title>
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
	background-color:#dceff5;
}
a.buy.btn.btn-large.btn-info{
	left : 25%;
}
a.preview {
    bottom: 20%;
    left: 25%;
}
</style>


</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>
	<div class="container-fluid">
		<div class="row">
			<div class="navcontainer">
				<div class="col-md-2">
					<h3>Search By Categories</h3>
					<ul class="nav nav-pills nav-stacked">
						<c:forEach var="category"
							items="${applicationScope['listCategory']}">
							<li><a
								href="products?categoryName=${category.categoryName }">${category.categoryName }</a></li>
						</c:forEach>

					</ul>
				</div>
			</div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-12" id="searchbutton">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="fa fa-search fa-lg" aria-hidden="true"></i></span> <input
								type="text" class="form-control input" name="searchit"
								placeholder="Search ...">
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<ul class="pagination">
							<li><a href="#">Prev</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">Next</a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="block span3">
							<div class="product">
								<img src="http://placehold.it/295x190/333333/FFFFFF" class="img-hover">
								<div class="buttons">
									<a class="buy btn btn-large btn-info" href="#"><i
										class="fa fa-2x fa-lg fa-shopping-cart"></i> Add to Cart</a> <a
										class="preview btn btn-large btn-info" href="#"><i
										class="icon-eye-open"></i> View item</a>
								</div>
							</div>

							<div class="info">
								<h4>Armillaria luteobubalina is a species of mushroom</h4>
								<span class="description"> Rwanda is a country in central
									and eastern Africa located a few degrees south of the Ecuator.
								</span> <span class="price">$62.97</span> <a
									class="btn btn-info pull-right" href="#"><i
									class="fa fa-lg fa-shopping-cart" style="size: 8px;"></i> Buy Now</a>
							</div>

						</div>
					</div>
					<div class="col-md-3">

						<div class="block span3">
							<div class="product">
								<img src="http://placehold.it/295x190/333333/FFFFFF">
								<div class="buttons">
									<a class="buy btn btn-large btn-info" href="#"><i
										class="fa fa-2x fa-lg fa-shopping-cart"></i> Add to Cart</a> <a
										class="preview btn btn-large btn-info" href="#"><i
										class="icon-eye-open"></i> View item</a>
								</div>
							</div>

							<div class="info">
								<h4>Armillaria luteobubalina is a species of mushroom</h4>
								<span class="description"> Rwanda is a country in central
									and eastern Africa located a few degrees south of the Ecuator.
								</span> <span class="price">$62.97</span> <a
									class="btn btn-info pull-right" href="#"><i
									class="fa fa-lg fa-shopping-cart" style="size: 8px;"></i> Buy Now</a>
							</div>

						</div>

					</div>
					<div class="col-md-3">
												<div class="block span3">
							<div class="product">
								<img src="http://placehold.it/295x190/333333/FFFFFF" class="img-hover">
								<div class="buttons">
									<a class="buy btn btn-large btn-info" href="#"><i
										class="fa fa-2x fa-lg fa-shopping-cart"></i> Add to Cart</a> <a
										class="preview btn btn-large btn-info" href="#"><i
										class="icon-eye-open"></i> View item</a>
								</div>
							</div>

							<div class="info">
								<h4>Armillaria luteobubalina is a species of mushroom</h4>
								<span class="description"> Rwanda is a country in central
									and eastern Africa located a few degrees south of the Ecuator.
								</span> <span class="price">$62.97</span> <a
									class="btn btn-info pull-right" href="#"><i
									class="fa fa-lg fa-shopping-cart" style="size: 8px;"></i> Buy Now</a>
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
</body>
</html>