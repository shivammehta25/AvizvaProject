<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Order Confirmed</title>

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
			<div class="jumbotron well ">
				<h1 class="text-center">
				<i class="fa fa-check-circle" aria-hidden="true"></i>	Order Confirmed
				</h1>
				<p class="text-center">
					Your order will reach you within 2-4 working days, Thank You for shopping with us.
				</p>
				<p>
					<h2 class="text-center">Redirecting</h2>
					<div class="progress progress-striped active">
				<div class="progress-bar progress-success" style="width: 100%;">
				</div>
			</div>
				</p>
			</div>
			
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>
	
	
	
<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
<script>
$(document).ready(function() {  

	window.setTimeout(function() {
	    window.location.href = 'products';
	}, 3000);
});


</script>
</body>
</html>