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
							<spring:message code='supplier.headingcaps'></spring:message> PANEL</h2>
					</div>
					<div class="panel-heading">
						<table class="  table table-bordered table-hover table-condensed">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Address</th>
									<th>Contact</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="supplier" items="${listSupplier}">
									<tr>
										<td><c:out value="${supplier.supplierId}"></c:out></td>
										<td><c:out value="${supplier.supplierName}"></c:out></td>
										<td><c:out value="${supplier.supplierAddress}"></c:out></td>
										<td><c:out value="${supplier.supplierContact}"></c:out></td>
										<td> <a style="cursor: pointer" onclick="populate(${supplier.supplierId} ,'${supplier.supplierName}' , '${supplier.supplierAddress }' , '${supplier.supplierContact}' )" >Edit</a></td>
										<td><a style="cursor: pointer" onclick = "deleteit(${supplier.supplierId})"> Delete</a>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Search for
							<spring:message code='supplier.heading'></spring:message></h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="searchSupplierForm" role="form">
							<div class="form-group">

								<label for="name" class="col-md-2 label-register control-label">
									<spring:message code="supplier.namesearch"></spring:message> </label>
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
						<h4 class="panel-title" style="text-align: left">Add <spring:message code='supplier.heading'></spring:message> </h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="addSupplierForm" role="form">
							<div class="form-group">
								<label for="supplierName"
									class="col-md-2 label-register control-label"> <spring:message code='supplier.name.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Supplier Name"
										name="supplierName" required="true" class="form-control"
										id="supplierName" />
								</div>
							</div>
							<div class="form-group">
								<label for="address" class="col-md-2 label-register control-label">
									<spring:message code='supplier.address.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Supplier Address"
										name="supplierAddress" required="true" class="form-control" id="address" />
								</div>
							</div>
							<div class="form-group">
								<label for="supplierContact"
									class="col-md-2 label-register control-label"> <spring:message code='supplier.contact.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Supplier Description"
										name="supplierContact" required="true" class="form-control"
										id="supplierContact" ></textarea>
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
						<h4 class="panel-title" style="text-align: left"><spring:message code='supplier.update'></spring:message> </h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="updateSupplierForm" role="form">
							<div class="form-group">
								<label for="supplierIdUpdate"
									class="col-md-2 label-register control-label"> <spring:message code='supplier.heading'></spring:message> 
									Id </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter supplier Id"
										name="supplierId" required="true" class="form-control"
										id="supplierIdUpdate" readonly="readonly" />
								</div>
							</div>
							<div class="form-group">
								<label for="supplierNameUpdate" class="col-md-2 label-register control-label">
									<spring:message code='supplier.heading'></spring:message>  Name </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Supplier Name"
										name="supplierName" required="true" class="form-control" id="supplierNameUpdate" />
								</div>
							</div>
							<div class="form-group">
								<label for="supplierAddressUpdate"
									class="col-md-2 label-register control-label"> <spring:message code='supplier.heading'></spring:message> 
									Address </label>
								<div class="col-md-8">
									<textarea placeholder="Enter Supplier Address"
										name="supplierAddress" required="true" class="form-control"
										id="supplierAddressUpdate" ></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="supplierContactUpdate"
									class="col-md-2 label-register control-label"> <spring:message code='supplier.heading'></spring:message> 
									Contact </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Supplier Contact Number"
										name="supplierContact" required="true" class="form-control"
										id="supplierContactUpdate">
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
							<spring:message code='supplier.heading'></spring:message> </h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="deleteSupplierForm" role="form">
							<div class="form-group">
								<label for="supplierIdDel" class="col-md-2 label-register control-label">
									<spring:message code='supplier.heading'></spring:message>  Id </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Supplier Id"
										name="supplierId" required="true" class="form-control" id="supplierIdDel" />
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


		
			
	
	<script>
	var populate = function(id , name , address , contact){
		document.getElementById("supplierIdUpdate").setAttribute("value" , id);
		document.getElementById("supplierNameUpdate").setAttribute("value" , name);
		document.getElementById("supplierAddressUpdate").value = address ;
//		window.scrollTo(0, $("#supplierAddressUpdate").offset().top);
		$("html, body").animate({ scrollTop: $("#supplierAddressUpdate").offset().top }, 1500);
		document.getElementById("supplierContactUpdate").setAttribute("value" , contact);
	}	
	var deleteit = function(id){
		document.getElementById("supplierIdDel").setAttribute("value" , id);
		$("html, body").animate({ scrollTop: $("#supplierIdDel").offset().top }, 1500);

	}
	</script>

	<!-- Insert Footer After Here -->
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>


</body>
</html>