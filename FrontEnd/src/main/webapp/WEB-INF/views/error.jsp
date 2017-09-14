<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Error </title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>




	<c:if test="${msg != null}">
		<div class="alert col-md-offset-3 col-md-6 alert-info text-center">
			<c:out value="${msg }"></c:out>
		</div>

	</c:if>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron well">
				<h2>
					Hello, world!
				</h2>
				<p>
					This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="#">Learn more</a>
				</p>
			</div><img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-rounded" />
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>


</body>
</html>