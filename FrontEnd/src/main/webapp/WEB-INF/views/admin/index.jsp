<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/admin.css" >
<body>

	<!--  Started Sidebar -->


	<!--  Ended Sidebar -->




	<div class="container-fluid">
		<div class="row" >
			<div class="col-md-2">
				<jsp:include page="/WEB-INF/views/admin/admininc/adminnav.jsp"></jsp:include>
			</div>
			<div class="col-md-10 " style="background-color: white">
				<h2 class="text-center">Admin Panel Home </h2>
			</div>
		</div>
	</div>







</body>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
</html>