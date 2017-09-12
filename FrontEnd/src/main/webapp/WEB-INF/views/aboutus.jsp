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
				<h3 class="text-center text-muted">About Us</h3>
				<div class="jumbotron">
					<h2>GAMAZON!</h2>
					<p>This is a template for a simple marketing or informational
						website. It includes a large callout called the hero unit and
						three supporting pieces of content. Use it as a starting point to
						create something more unique.</p>
					<p>
						<a class="btn btn-primary btn-large" href="#">Learn more</a>
					</p>
				</div>
				<div class="progress progress-striped active" >
					<div class="progress-bar progress-success" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<img alt="Bootstrap Image Preview"
							src="http://lorempixel.com/140/140/" class="img-circle" />
					</div>
					<div class="col-md-10">
						<blockquote class="pull-right">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Integer posuere erat a ante.</p>
							<small>Someone famous <cite>Source Title</cite></small>
						</blockquote>
					</div>
				</div>
				<div class="progress active progress-striped">
					<div class="progress-bar progress-success"></div>
				</div>
				<div class="row">
					<div class="col-md-10">
						<blockquote>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Integer posuere erat a ante.</p>
							<small>Someone famous <cite>Source Title</cite></small>
						</blockquote>
					</div>
					<div class="col-md-2">
						<img alt="Bootstrap Image Preview"
							src="http://lorempixel.com/140/140/" class="img-circle" />
					</div>
				</div>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-success"></div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<img alt="Bootstrap Image Preview"
							src="http://lorempixel.com/140/140/" class="img-circle" />
					</div>
					<div class="col-md-10">
						<blockquote>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Integer posuere erat a ante.</p>
							<small>Someone famous <cite>Source Title</cite></small>
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