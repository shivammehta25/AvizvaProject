<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Forgot Password</title>
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

	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center">
							<spring:message code='forgotpass.header'></spring:message>
						</h2>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post" action="forgotpassform" role="form">
							
							<div class="form-group">

								<label for="inputPassword3"
									class="col-sm-2 label-register control-label"> <spring:message
										code='forgotpass.email'></spring:message>
								</label>
								<div class="col-sm-10">
									<input type="email" class="form-control"
										placeholder="Enter Your Email" required="true" name="email"
										id="inputPassword3" />
								</div>
							</div>


							
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-2">

									<button type="submit" class="btn btn-success">
										<i class="fa fa-address-book fa-lg fa-2x"></i> &nbsp; <spring:message
										code='forgotpass.submit'></spring:message>
									</button>
								</div>


							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>



</body>
</html>