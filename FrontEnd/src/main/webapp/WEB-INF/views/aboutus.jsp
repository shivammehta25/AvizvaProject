<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

<meta name="viewport" content="width=device-width, initial-scale=1">
<c:url var="rcss" value="resources/css"></c:url>
<c:url var="rimages" value="resources/images"></c:url>

<link rel="stylesheet" href="${rcss}/navbar-fixed-top.css">
<link rel="stylesheet" href="${rcss}/styling.css">
<link rel="stylesheet" href="${rcss}/footerstyle.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | About Us</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center" style="color: black;">About Us</h2>
				<div class="jumbotron">
					<h2>GAMAZON!</h2>
					<p>We are a company filled with IT Geeks for IT Geeks</p>
					
				</div>
						<div class="progress progress-striped active">
		<div class="progress-bar" style="width: 100%;">
			<span class="sr-only">100% Complete</span>
		</div>
	</div>
				<div class="row">
					<div class="col-md-2">
						<img alt="Bootstrap Image Preview"
							src="http://lorempixel.com/140/140/" class="img-circle" />
					</div>
					<div class="col-md-10">
						<blockquote class="pull-right">
							<p>Web Application Developer and A Gamer.</p>
							<small> <cite>SHIVAM MEHTA</cite></small>
						</blockquote>
					</div>
				</div>
				<div class="progress progress-striped active">
		<div class="progress-bar" style="width: 100%;">
			<span class="sr-only">100% Complete</span>
		</div>
	</div>
				<div class="row">
					<div class="col-md-10">
						<blockquote>
							<p>Football Lover and an Application Developer</p>
							<small> <cite>SAURABH MIGHLANI</cite></small>
						</blockquote>
					</div>
					<div class="col-md-2">
						<img alt="Bootstrap Image Preview"
							src="http://lorempixel.com/140/140/" class="img-circle" />
					</div>
				</div>
					<div class="progress progress-striped active">
		<div class="progress-bar" style="width: 100%;">
			<span class="sr-only">100% Complete</span>
		</div>
	</div>
				<div class="row">
					<div class="col-md-2">
						<img alt="Bootstrap Image Preview"
							src="http://lorempixel.com/140/140/" class="img-circle" />
					</div>
					<div class="col-md-10">
						<blockquote  class="pull-right">
							<p>Web Application Developer </p>
							<small><cite>AKSHAY CHOURASIA</cite></small>
						</blockquote>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>

	<!-- Loading Scripts in the End to Reduce Loadtime -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js "></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js "></script>

</body>
</html>