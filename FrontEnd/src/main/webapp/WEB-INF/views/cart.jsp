<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Contact Us</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-10">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">
						Panel title
					</h3>
				</div>
				<div class="panel-body">
					Panel content
				</div>
				<div class="panel-footer">
					Panel footer
				</div>
			</div>
		</div>
	</div>
</div>


	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>



</body>
</html>