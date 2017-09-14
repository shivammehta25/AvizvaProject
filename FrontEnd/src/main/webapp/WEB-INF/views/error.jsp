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
			<div class="jumbotron well text-center">
				<h2>
					Error
					</h2>
					
				<p>
					There is Something Wrong, this is not supposed to happen , We will try our best to solve this issue for furthur . 
				</p>
						 <h3 class="text-center">Meanwhile Our Developer Team
			<p></p>
				<img alt="Error Gif" src="${rimages }/error.gif" class="center" width=500 />
			</h3>
									<p>	 <a href="contactus" class="btn btn-primary btn-large " >Contact Us</a>				</p>
										 
						 
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>


</body>
</html>