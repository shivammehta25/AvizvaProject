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


<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<div class="text-center">
				<img alt="User" src="${rimages }/logo.png" class="img-circle" width="100" />
				<h1>GAMAZON</h1>
				<h2>Log In</h2>
			</div>
			<form role="form" method="post" action="loginform">
				<div class="form-group">
					 
					<label for="exampleInputEmail1">
						Username
					</label>
					<input type="text"  name="username" class="form-control" id="exampleInputEmail1" />
				</div>
				<div class="form-group">
					 
					<label for="exampleInputPassword1">
						Password
					</label>
					<input type="password" name="password" class="form-control" id="exampleInputPassword1" />
				</div>
				
				<div class="checkbox">
					 
					<label>
						<input type="checkbox" /> Remember Me
					</label>
				</div> 
				
				<button type="submit" class="btn btn-success">
					Submit
				</button> 
				<div class="pull-right">  <a href="forgotpass" style="text-decoration: none;">Forgot Password ?</a></div>
			</form>
			
			
		</div>
		<div class="col-md-4">
		</div>
	
	</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<h3 class="text-center text-info">
				<a href="registeration" style="text-decoration: none">Dont have an Account? Register </a>
			</h3>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>

</body>
</html>