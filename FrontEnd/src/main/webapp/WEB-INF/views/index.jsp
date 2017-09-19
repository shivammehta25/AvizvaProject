<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Home</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
<c:url var="rcss" value="resources/css"></c:url>
<c:url var="rimages" value="resources/images"></c:url>

<div class="container-fluid ">
		<div id="carousel1" class="carousel slide" data-ride="carousel" data-interval="3000">
			<ol class="carousel-indicators">
				<li data-target="#carousel1" data-slide-to="0" class="active"> </li>
				<li data-target="#carousel1" data-slide-to="1"> </li>
				<li data-target="#carousel1" data-slide-to="2"> </li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img alt="Gaming Collection" src="${rimages}/slider1.jpg" style="width: 100%">
					<div class="carousel-caption">
						<h3> GAMING COLLECTION</h3>
						<p>A Large variety of games available here!!!</p>
					</div>

				</div>
				<div class="item">
					<img src="${rimages}/slider2.jpg" alt="Gaming Hardwares" style="width: 100%">
					<div class="carousel-caption">
						<h3>GAMING HARDWARES</h3>
						<p>A large variety of Gaming Hardwares!!!!</p>
					</div>
				</div>
				<div class="item">
					<img src="${rimages}/slider3.jpg" alt="Gaming Peripherals" style="width: 100%">
					<div class="carousel-caption">
						<h3>COMPUTER PERIPHERALS </h3>
						<p> A large variety of Computer Accessories</p>
					</div>
				</div>
				<a class="left carousel-control" href="#carousel1" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel1" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<!-- End Carousel -->

	<!-- Begin Thumbnails -->

	<div class="container-fluid ">
		<div class="row ">
			<div class="col-md-2">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="http://feelpainrelief.com/wp-content/uploads/2016/03/best-seller-badge-01.jpg">
					</div>
				</div>
				<div class="caption" style="text-align: center;">
					<h3>
						Best Selling Items
					</h3>
				</div>
			</div>
			
			<div class="col-md-2">
				<a href="products?categoryName=Games" style="text-decoration: none">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="http://images.performgroup.com/di/library/GOAL/79/c3/fifa-18-pack-shot_1wwbvp22h4qvb1qi01oijh784g.png?t=152792078">
					</div>
				</div>
				<div class="overlay" style="text-align: center;">
					<h3 class="text">
						Games
					</h3>
				</div>
				</a>
			</div>
			
			<div class="col-md-2">
				<a href="products?categoryName=Consoles" style="text-decoration: none">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="https://asia.playstation.com/content/dam/pscom/japan-asia/playstation4/top/ps4-top-navigation02-20161104.png">
					</div>
				</div>
				<div class="caption" style="text-align: center;">
					<h3>
						Consoles
					</h3>
				</div>
				</a>
			</div>
			<div class="col-md-2">
				<a href="products?categoryName=Headsets" style="text-decoration: none">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="https://images-na.ssl-images-amazon.com/images/I/71oEkQkjutL._SX425_.jpg">
					</div>
				</div>
				<div class="caption" style="text-align: center;">
					<h3>
						Headsets
					</h3>
				</div>
				</a>
			</div>
			<div class="col-md-2">
				<a href="products?categoryName=Console Accesories" style="text-decoration: none">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="http://media.4rgos.it/i/Argos/6017808_R_Z002A?$Web$&w=570&h=513">
					</div>
				</div>

				<div class="caption" style="text-align: center;">
					<h3>
						Console Accesories
					</h3>
				</div>
				</a>
			</div>
			<div class="col-md-2">
				<a href="products?categoryName=Accesories" style="text-decoration: none">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="https://ae01.alicdn.com/kf/HTB14cecPFXXXXcMXXXXq6xXFXXXQ/Newest-USB-Wired-LED-Backlit-Laptop-Computer-Gamer-Keyboard-Mouse-Combo-Optical-Professional-7-Buttons-5500.jpg">
					</div>
				</div>
				<div class="caption" style="text-align: center;">
					<h3>
						Accessories
					</h3>
				</div>
				</a>
			</div>
		</div>
	</div>


	
<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>


</body>
</html>