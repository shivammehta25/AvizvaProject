<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Suppliers</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>
	<!-- Insert Header Before Here -->
	
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center">
							SUPPLIER PANEL</h2>
					</div>
					<div class="panel-heading">
						<table class="  table table-bordered table-hover table-condensed">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="category" items="${listSuppliers}">
									<tr>
										<td><c:out value="${supplier.supplierId}"></c:out></td>
										<td><c:out value="${supplier.supplierAddress}"></c:out></td>
										<td><c:out value="${supplier.supplierDescription}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Search for
							Suppliers</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="searchCategoryForm" role="form">
							<div class="form-group">

								<label for="name" class="col-md-2 label-register control-label">
									Supplier Name </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Supplier Name"
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
						<h4 class="panel-title" style="text-align: left">Add Supplier</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="addSupplierForm" role="form">
							<div class="form-group">
								<label for="supplierId"
									class="col-md-2 label-register control-label"> Supplier
									Id </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Supplier Id"
										name="supplierId" required="true" class="form-control"
										id="supplierId" />
								</div>
							</div>
							<div class="form-group">
								<label for="name" class="col-md-2 label-register control-label">
									Supplier Name </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Supplier Name"
										name="supplierName" required="true" class="form-control" id="name" />
								</div>
							</div>
							<div class="form-group">
								<label for="description"
									class="col-md-2 label-register control-label"> Category
									Description </label>
								<div class="col-md-8">
									<textarea placeholder="Enter Category Description"
										name="description" required="true" class="form-control"
										id="description" ></textarea>
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
								<label for="categoryId"
									class="col-md-2 label-register control-label"> Category
									Id </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Category Id"
										name="categoryId" required="true" class="form-control"
										id="categoryId" />
								</div>
							</div>
							<div class="form-group">
								<label for="name" class="col-md-2 label-register control-label">
									Category Name </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Category Name"
										name="name" required="true" class="form-control" id="name" />
								</div>
							</div>
							<div class="form-group">
								<label for="description"
									class="col-md-2 label-register control-label"> Category
									Description </label>
								<div class="col-md-8">
									<textarea placeholder="Enter Category Description"
										name="description" required="true" class="form-control"
										id="description" ></textarea>
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
						<h4 class="panel-title" style="text-align: left">Delete
							Category</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="deleteCategoryForm" role="form">
							<div class="form-group">
								<label for="name" class="col-md-2 label-register control-label">
									Category Name </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Category Name"
										name="name" required="true" class="form-control" id="name" />
								</div>
							</div>
							<div class="form-group">
								<div class=" col-md-2 col-md-offset-2">

									<button type="submit" class="btn btn-success">Delete</button>
								</div>
							</div>

						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- Insert Footer After Here -->
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>


</body>
</html>