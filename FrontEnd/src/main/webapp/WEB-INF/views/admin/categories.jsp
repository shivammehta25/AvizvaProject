<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories</title>
<link rel="stylesheet" href="resources/css/admin.css" >

</head>
<body>
	
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>
	<!-- Insert Header Before Here -->
	
	<div class="container-fluid">
		<div class="row" >
			<div class="col-md-2">
				<jsp:include page="/WEB-INF/views/admin/admininc/adminnav.jsp"></jsp:include>
			</div>
			<div class="col-md-10 text-center ">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center">
							CATEGORIES PANEL</h2>
					</div>
					<div class="panel-heading">
						<table class="  table table-bordered table-hover table-condensed">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Description</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="category" items="${listCategory}">
									<tr>
										<td><c:out value="${category.categoryId}"></c:out></td>
										<td><c:out value="${category.categoryName}"></c:out></td>
										<td><c:out value="${category.categoryDescription}"></c:out></td>
										<td><a style="cursor: pointer" onclick="populate(${category.categoryId} ,'${category.categoryName}' , '${category.categoryDescription }')" >Edit </a></td>
										<td><a style="cursor: pointer" onclick="deleteit(${category.categoryId})" >Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Search for
							Category</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="searchCategoryForm" role="form">
							<div class="form-group">

								<label for="name" class="col-md-2 label-register control-label">
									Category Name </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Category Name"
										name="name" required="true" class="form-control" id="name" />
								</div>
								<div class="col-md-2">

									<button type="submit" class="btn btn-success">Search</button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Add Category</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post"
							action="addCategoryForm" role="form">
							
							<div class="form-group">
								<label for="categoryName" class="col-md-2 label-register control-label">
									Category Name </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Category Name"
										name="categoryName" required="true" class="form-control" id="categoryName" />
								</div>
							</div>
							<div class="form-group">
								<label for="categoryDescription"
									class="col-md-2 label-register control-label"> Category
									Description </label>
								<div class="col-md-8">
									<textarea placeholder="Enter Category Description"
										name="categoryDescription" required="true" class="form-control"
										id="categoryDescription" ></textarea>
								</div>
							</div>

							<div class="form-group">
								<div class=" col-md-2 col-md-offset-2">

									<button type="submit" class="btn btn-success">Add</button>
								</div>
							</div>

						</form>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Update
							Category</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="updateCategoryForm" role="form">
							<div class="form-group">
								<label for="categoryIdUpdate"
									class="col-md-2 label-register control-label"> Category
									Id </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Category Id"
										name="categoryId" required="true" class="form-control"
										id="categoryIdUpdate" readonly="readonly" />
								</div>
							</div>
							<div class="form-group">
								<label for="categoryNameUpdate" class="col-md-2 label-register control-label">
									Category Name </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Category Name"
										name="categoryName" required="true" class="form-control" id="categoryNameUpdate" />
								</div>
							</div>
							<div class="form-group">
								<label for="categoryDescriptionUpdate"
									class="col-md-2 label-register control-label"> Category
									Description </label>
								<div class="col-md-8">
									<textarea placeholder="Enter Category Description"
										name="categoryDescription" required="true" class="form-control"
										id="categoryDescriptionUpdate" ></textarea>
								</div>
							</div>

							<div class="form-group">
								<div class=" col-md-2 col-md-offset-2">

									<button type="submit" class="btn btn-success">Update</button>
								</div>
							</div>

						</form>
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Deactivate
							Category</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="deactivateCategoryForm" role="form">
							<div class="form-group">
								<label for="categoryIdDel" class="col-md-2 label-register control-label">
									Category Id </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Category Name"
										name="categoryId" required="true" class="form-control" id="categoryIdDel" />
								</div>
							</div>
							<div class="form-group">
								<div class=" col-md-2 col-md-offset-2">

									<button type="submit" class="btn btn-success">Deactivate</button>
								</div>
							</div>

						</form>
					</div>
				</div>

			</div>
		</div>
	</div>


<script>
var populate = function(id , name , description){
	document.getElementById("categoryIdUpdate").setAttribute("value" , id);
	document.getElementById("categoryNameUpdate").setAttribute("value" , name);
	document.getElementById("categoryDescriptionUpdate").value = description ;
	$("html, body").animate({ scrollTop: $("#categoryNameUpdate").offset().top }, 1500);
}	
var deleteit = function(id){
	document.getElementById("categoryIdDel").setAttribute("value" , id);
	$("html, body").animate({ scrollTop: $("#categoryIdDel").offset().top }, 1500);

}
</script>
	<!-- Insert Footer After Here -->
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>


</body>
</html>