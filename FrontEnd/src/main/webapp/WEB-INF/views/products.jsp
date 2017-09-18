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

.jumbotron {
	-webkit-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1);
	-moz-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1);
	box-shadow: 4px 7px 38px -2px rgba(0, 0, 0 0, 1);
	border-radius: 20px !important; 
	text-align: center;
	
}

.jumbotron:Hover {
	background-color: rgba(83, 81, 194, 0.78);
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
					<div class="col-md-4">
						<div class="jumbotron">
							<img alt="Product Image Preview"
								src="http://lorempixel.com/140/140/" class="img-thumbnail" />
							<h3>Product Name</h3>
							<h4>Category</h4>
							<h5>$Price</h5>

							<div class="btn-group">
								<button type="button" class="btn btn-warning">
									<i class="fa fa-check fa-2x fa-lg" aria-hidden="true"></i> View
									Product
								</button>
								<button type="button" class="btn btn-warning">
									<i class="fa fa-2x fa-lg fa-shopping-cart"></i>Add to Cart
								</button>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="jumbotron">
							<img alt="Product Image Preview"
								src="http://lorempixel.com/140/140/" class="img-thumbnail" />
							<h3>Product Name</h3>
							<h4>Category</h4>
							<h5>$Price</h5>

							<div class="btn-group">
								<button type="button" class="btn btn-warning">
									<i class="fa fa-check fa-2x fa-lg" aria-hidden="true"></i> View
									Product
								</button>
								<button type="button" class="btn btn-warning">
									<i class="fa fa-2x fa-lg fa-shopping-cart"></i>Add to Cart
								</button>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="jumbotron">
							<img alt="Product Image Preview"
								src="http://lorempixel.com/140/140/" class="img-thumbnail" />
							<h3>Product Name</h3>
							<h4>Category</h4>
							<h5>$Price</h5>

							<div class="btn-group">
								<button type="button" class="btn btn-warning">
									<i class="fa fa-check fa-2x fa-lg" aria-hidden="true"></i> View
									Product
								</button>
								<button type="button" class="btn btn-warning">
									<i class="fa fa-2x fa-lg fa-shopping-cart"></i>Add to Cart
								</button>
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