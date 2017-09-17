<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/admin.css">
<body>

	<!--  Started Sidebar -->


	<!--  Ended Sidebar -->




	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<jsp:include page="/WEB-INF/views/admin/admininc/adminnav.jsp"></jsp:include>
			</div>
			<div class="col-md-10 ">
				<h2 class="text-center adminpanelhead" >Admin Panel Home</h2>
				
				<div class="row">
					<div class="col-md-4">
						<div class="jumbotron well">
							<h2>Products</h2>
							<p>Total Number of Products : 
							<p>
								<a class="btn btn-primary btn-large" href="adminproduct">Manage Products</a>
							</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="jumbotron well">
							<h2>Suppliers</h2>
							<p>Total Number of Suppliers : ${totalsupp } 
							</p>
							<p>
								<a class="btn btn-primary btn-large" href="adminmanagesupp">Manage Suppliers</a>
							</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="jumbotron well">
							<h2>Categories</h2>
							<p>Total Categories : ${totalcat }</p>
							<p>
								<a class="btn btn-primary btn-large" href="adminmanagecat">Manage Categories</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
</html>