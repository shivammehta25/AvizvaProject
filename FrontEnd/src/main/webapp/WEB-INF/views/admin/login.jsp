<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Login</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>




	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				
				<div class="text-center">
					<img alt="User" src="${rimages }/logo.png"
						width="100" />
					<h1>GAMAZON</h1>
				</div>


				<div class="col-md-8 col-md-offset-2">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2 class="panel-title" style="text-align: center">ADMIN LOG IN</h2>
						</div>
						<div class="panel-body">
							<form role="form" method="post" action="perform_login">
								<div class="form-group">

									<label for="exampleInputEmail1"> Username </label> <input
										type="text" name="username" class="form-control"
										id="exampleInputEmail1" />
								</div>
								<div class="form-group">

									<label for="exampleInputPassword1"> Password </label> <input
										type="password" name="password" class="form-control"
										id="exampleInputPassword1" />
								</div>

								<!-- <div class="checkbox">

									<label> <input type="checkbox" /> Remember Me
									</label>
								</div> -->

								<button type="submit" class="btn btn-success">Submit</button>
								<div class="pull-right">
									<a href="forgotpass" style="text-decoration: none;">Forgot
										Password ?</a>
								</div>
							</form>
						</div>
						<div class="panel-heading">
							<h4 class="" style="text-align: center"><a href="registeration" style="text-decoration: none">Haven't Registered Yet? </a></h4>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>

</body>
</html>