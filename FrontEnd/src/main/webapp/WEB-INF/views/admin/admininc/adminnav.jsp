<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] name = request.getRequestURI().split("/");
	int last = name.length;
	String newFile = name[last-1];
	String filename = newFile.replace(".jsp", "");
	//out.println(filename);
	String homeactive;
	if(filename.equals("index")){
		%> <c:set var="homeactive" value="active"></c:set>
		<%
		}
	if(filename.equals("suppliers")){
		%> 	<c:set var="suppactive" value="active"></c:set>
		<%
	}
	if(filename.equals("categories")){
		%> <c:set var="catactive" value="active" ></c:set> <%
	}
%>

<ul class="nav nav-pills nav-stacked">
					<h5 class="text-center"><i class="fa fa-bars fa-2x fa-lg" aria-hidden="true"></i >&nbsp;  Admin Navigation</h5>
					<li class="${homeactive }"><a href="admin">Home</a></li>
					<li class="${suppactive}"><a href="adminmanagesupp">Manage Suppliers</a></li>
					<li class=${catactive }><a href="adminmanagecat">Manage Categories</a></li>
					<!-- <li class="dropdown pull-right"><a href="#"
						data-toggle="dropdown" class="dropdown-toggle">Dropdown<strong
							class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li> -->
				</ul>
</body>
</html>