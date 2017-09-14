<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Login</title>
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

			
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center">
							My Profile
						</h2>
					</div>
					<div class="panel-body">
									<!-- Insert UpdateProfile Form Here -->
						
						<form class="form-horizontal" method="post" action="deactivate"
							role="form" onsubmit="return(window.confirm('Are you sure you want to deactive you account ?'))">
							<div class="form-group">

								<label for="inputEmail3"
									class="col-sm-8 label-register control-label"> 
									Click Deactivate to Temporarily Deactivate Your Account
								</label>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-2">

									<button type="submit" class="btn btn-danger">
										<i class="fa fa-address-book fa-lg fa-2x"></i> &nbsp; Deactivate
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