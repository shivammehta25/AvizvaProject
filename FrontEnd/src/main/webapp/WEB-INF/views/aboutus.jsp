<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | About Us</title>

<style type="text/css">
	.row{
	margin-bottom : 20px;
	}
	.progress-bar {
	    background-color: #2e2f31 !important;
	}
	.jumbotron {
	background-color : #3e4649 !important;
	}
	.linesaid {
	    color: #55b7a2 ;
	
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>



	<div class="container-fluid">
		<div class="row">
			
				<div class="col-md-2">
				</div>
			
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center">ABOUT US
						</h2>
					</div>
					<div class="panel-body">
					
					
					<div class="col-md-12">
				<div class="jumbotron">
					<h2>GAMAZON!</h2>
					<p class="linesaid">We are a company filled with IT Geeks for IT Geeks</p>

				</div>
				<div class="progress progress-striped active">
					<div class="progress-bar" style="width: 100%;">
						<span class="sr-only">100% Complete</span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<img alt="Bootstrap Image Preview"
							src="${rimages }/Shivam.jpg" width="150px"  class="img-circle" />
					</div>
					<div class="col-md-10">
						<blockquote class="pull-right">
							<p class="linesaid">If Something is worth doing , Its worth doing <b>RIGHT!! </b></p>
							<small> A coder , a gamer , an entertainer <cite>SHIVAM MEHTA</cite></small>
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
							<p class="linesaid">Football Lover and an Application Developer</p>
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
						<blockquote class="pull-right">
							<p class="linesaid">Web Application Developer</p>
							<small><cite>AKSHAY CHOURASIA</cite></small>
						</blockquote>
					</div>
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