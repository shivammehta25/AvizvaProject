<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Reset Password </title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<div class="col-sm-12 text-center" >
	<span id="message"></span>
</div>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>



	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center">
							<spring:message code='resetpass.header'></spring:message>
						</h2>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post" action="resetpassform" role="form" onsubmit="return(check())">
							
							<div class="form-group">

								<label for="email"
									class="col-sm-2 label-register control-label"> <spring:message
										code='resetpass.email'></spring:message>
								</label>
								<div class="col-sm-10">
									<input type="email" class="form-control"
										placeholder="Enter Your Email" required="true" name="email"
										 />
								</div>
							</div>
							
							<div class="form-group">

								<label for="otp"
									class="col-sm-2 label-register control-label">  <spring:message code='resetpass.onetimepass'></spring:message> </label>
								<div class="col-sm-10">
									<input type="text" placeholder="Enter Your OTP" name="otp"
										required="true" class="form-control"  />
								</div>
							</div>
							
							<div class="form-group">

								<label for="password"
									class="col-sm-2 label-register control-label"> <spring:message code='resetpass.password'></spring:message></label>
								<div class="col-sm-10">
									<input type="password" class="form-control"
										placeholder="Enter Your New Password" required="true"
										name="password" id="password" />
								</div>
							</div>

							<div class="form-group">

								<label for="confirmpassword"
									class="col-sm-2 label-register control-label"> <spring:message code='resetpass.cpassword'></spring:message>
								</label>
								<div class="col-sm-10">
									<input type="password" class="form-control"
										placeholder="Confirm Your New Password " required="true"
										name="cpassword" id="confirmpassword" />
								</div>
							</div>

							
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-2">

									<button type="submit" class="btn btn-success">
										<i class="fa fa-address-book fa-lg fa-2x"></i> &nbsp; <spring:message
										code='resetpass.submit'></spring:message>
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
  if (document.getElementById('password').value == document.getElementById('confirmpassword').value) {
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