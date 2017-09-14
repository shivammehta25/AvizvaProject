<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

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
		<div class="alert col-md-offset-3 col-md-6 alert-danger text-center">
			<form:errors path="user.*"></form:errors>
		</div>
	</c:if>

	
	<div class="container-fluid">
		<div class="row">
			<!-- UpdateProfile Form -->
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center">My Profile
						</h2>
					</div>
					<div class="panel-body">
						<form:form class="form-horizontal" role="form" method="post" action="profileupdateform" onsubmit="return(check())">
							<form:hidden path="username" />
							<form:hidden path="password" />
							<div class="form-group">
								<label for="newName"
									class="col-sm-2 label-register control-label">  <spring:message code='label.name'></spring:message> </label>
								<div class="col-sm-10">
									<form:input placeholder="Enter New Name" path="name" required="true" class="form-control" id="newName" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="newEmail"
									class="col-sm-2 label-register control-label"> <spring:message code='label.email'></spring:message> </label>
								<div class="col-sm-10">
									<form:input placeholder="Enter New Email" path="email" required="true" class="form-control" id="newEmail" />
								</div>
							</div>
							

							<div class="form-group">

								<label for="newContact"
									class="col-sm-2 label-register control-label"> <spring:message code='label.contact'></spring:message>
								</label>
								<div class="col-sm-10">
									<form:input placeholder="Enter New Contact" pattern="[7-9]{1}[0-9]{9}" path="contact" required="true" class="form-control" id="newContact" />									
								</div>
							</div>


							<div class="form-group">
								<label for="newDob"
									class="col-sm-2 label-register control-label">
									<spring:message code='label.dob'></spring:message>
									 </label>
								<div class="col-sm-10">
									<form:input placeholder="Enter New Date of Birth" path="dob" required="true" class="form-control" id="newDob" />									
								</div>
							</div>
							<div class="form-group">
								<label for="newAddress"
									class="col-sm-2 label-register control-label">  <spring:message code='label.address'></spring:message> </label>
								<div class="col-sm-10">
									<form:input placeholder="Enter New Address" path="address.address" required="true" class="form-control" id="newAddress" />									
								</div>
							</div>
							
							<div class="form-group">
								<label for="newCity"
									class="col-sm-2 label-register control-label">  <spring:message code='label.address.city'></spring:message> </label>
								<div class="col-sm-10">
									<form:input placeholder="Enter New City" path="address.city" required="true" class="form-control" id="newCity" />									
								</div>
							</div>
							<div class="newCountry">
								<label for="inputEmail3"
									class="col-sm-2 label-register control-label">   <spring:message code='label.address.country'></spring:message>  </label>
								<div class="col-sm-10">
									<form:input placeholder="Enter New Country" path="address.country" required="true" class="form-control" id="newCountry" />									
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-2">
									<input type="submit" class="btn btn-success" value="Update">
										
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center">Deactivate Account
						</h2>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post" action="deactivate"
							role="form"
							onsubmit="return(window.confirm('Are you sure you want to deactive you account ?'))">
							<div class="form-group">

								<label for="inputEmail3"
									class="col-sm-8 label-register control-label"> Click
									Deactivate to Temporarily Deactivate Your Account </label>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-2">

									<button type="submit" class="btn btn-danger">
										<i class="fa fa-address-book fa-lg fa-2x"></i> &nbsp;
										Deactivate
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
	<script>
	var check = function() {
  if (document.getElementById('newPassword').value == document.getElementById('newcPassword').value) {
  document.getElementById('message').style.color = 'green';
  document.getElementById('message').innerHTML = 'Passwords Matched';
    return true;
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'Password Not matching';
    return false;
  }
}
	</script>
</body>
</html>