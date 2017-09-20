<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMAZON | Orders</title>

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
							ORDERS PANEL</h2>
					</div>
					<div class="panel-heading">
						<table class="  table table-bordered table-hover table-condensed">
							<thead>
								<tr>
									<th>Order Number</th>
									<th>Order Date</th>
									<th>User Name</th>
									<th>Product Id</th>
									<th>Order Quantity</th>
									<th>Payment Details</th>
									<th>Shipping Address</th>
									<th>City</th>
									<th>Country</th>
									<th>Pin</th>
									<th>Order Status</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="order" items="${listOrder}">
									<tr>
										<td><c:out value="${order.orderNumber}"></c:out></td>
										<td><c:out value="${order.orderDate}"></c:out></td>
										<td><c:out value="${order.username}"></c:out></td>
										<td><c:out value="${order.orderQuantity}"></c:out></td>	
										<td><c:out value="${order.orderPaymentDetails}"></c:out></td>
										<td><c:out value="${order.shippingAddress}"></c:out></td>
										<td><c:out value="${order.shippingCity}"></c:out></td>
										<td><c:out value="${order.shippingCountry}"></c:out></td>
										<td><c:out value="${order.shippingPin}"></c:out></td>
										<td><c:out value="${order.orderStatus}"></c:out></td>
										<td> <a style="cursor: pointer" data-toggle="collapse" href="#updatePanel"
										onclick="populate('${order.orderNumber}','${order.orderStatus}','${order.orderDate}',
										'${order.orderQuantity}','${order.orderPaymentDetails}','${order.username}',
										'${order.productId}','${order.shippingAddress}','${order.shippingCity}',
										'${order.shippingCountry}','${order.shippingPin}',)">
												Edit
											</a>
										</td>
										<td><a style="cursor: pointer" onclick = "deleteit(${order.orderId})"
										data-toggle="collapse" href="#deletePanel"> Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="panel panel-default">
					<a data-toggle="collapse" href="#searchPanel" style="text-decoration: none;"
						class="collapsed" aria-expanded="false">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Search for 
						<spring:message code='order.heading'></spring:message></h4>
					</div>
					</a>
					<div class="panel-collapse collapse" id="searchPanel" aria-expanded="false" style="height: 0px;">
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="searchOrderForm" role="form">
							<div class="form-group">

								<label for="name" class="col-md-2 label-register control-label">
									<spring:message code="order.namesearch"></spring:message> </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Order Name"
										name="name" required="true" class="form-control" id="name" />
								</div>
								<div class="col-md-2">

									<button type="submit" class="btn btn-success">Search</button>
								</div>
							</div>
						</form>
					</div>
					</div>
				</div>

				<div class="panel panel-default">
					<a data-toggle="collapse" href="#addPanel" style="text-decoration: none;"
						class="collapsed" aria-expanded="false">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Add 
						<spring:message code='order.heading'></spring:message> </h4>
					</div>
					</a>
					<div class="panel-collapse collapse" id="addPanel" aria-expanded="false" style="height: 0px;">
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="addOrderForm" role="form">
							<form:hidden path="orderId"/>
							<div class="form-group">
								<label for="orderNumber"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.orderNumber.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Order Number"
										name="orderNumber" required="true" class="form-control"
										id="orderNumber" />
								</div>
							</div>
							<div class="form-group">
								<label for="orderStatus" class="col-md-2 label-register control-label">
									<spring:message code='order.orderStatus.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Order Status"
										name="orderStatus" required="true" class="form-control" id="orderStatus" />
								</div>
							</div>
							<div class="form-group">
								<label for="orderDate"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.orderDate.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="date" class="form-control" required="true"
										name="orderDate" id="orderDate" />
								</div>
							</div>
							<div class="form-group">
								<label for="orderQuantity"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.orderQuantity.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="number" name="orderQuantity" required="true" 
									class="form-control" id="orderQuantity" />
								</div>
							</div>
							<div class="form-group">
								<label for="orderPaymentDetails"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.orderPaymentDetails.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Payment Details"
										name="orderPaymentDetails" required="true" class="form-control"
										id="orderPaymentDetails" />
								</div>
							</div>
							<div class="form-group">
								<label for="username"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.username.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Customer Name"
										name="username" required="true" class="form-control"
										id="username" />
								</div>
							</div>
							<div class="form-group">
								<label for="productId"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.productId.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="number" name="productId" required="true" 
									class="form-control" id="productId" />
								</div>
							</div>
							<div class="form-group">
								<label for="shippingAddress"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.shippingAddress.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Shipping Address"
										name="shippingAddress" required="true" class="form-control"
										id="shippingAddress" />
								</div>
							</div>
							<div class="form-group">
								<label for=shippingCity
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.shippingCity.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter City"
										name="shippingCity" required="true" class="form-control"
										id="shippingCity" />
								</div>
							</div>
							<div class="form-group">
								<label for="shippingCountry"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.shippingCountry.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Country"
										name="shippingCountry" required="true" class="form-control"
										id="shippingCountry" />
								</div>
							</div>
							<div class="form-group">
								<label for="shippingPin"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.shippingPin.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="number" name="shippingPin" required="true" 
									class="form-control" id="shippingPin" />
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
				</div>

				<div class="panel panel-default">
					<a data-toggle="collapse" href="#updatePanel" style="text-decoration: none;"
						class="collapsed" aria-expanded="false">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Update 
						<spring:message code='order.heading'></spring:message> </h4>
					</div>
					</a>
					<div class="panel-collapse collapse" id="updatePanel" aria-expanded="false" style="height: 0px;">
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="updateOrderForm" role="form">
							<form:hidden path="orderId"/>
							<div class="form-group">
								<label for="orderNumber"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.orderNumber.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Order Number"
										name="orderNumber" required="true" class="form-control"
										id="orderNumber" />
								</div>
							</div>
							<div class="form-group">
								<label for="orderStatus" class="col-md-2 label-register control-label">
									<spring:message code='order.orderStatus.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Order Status"
										name="orderStatus" required="true" class="form-control" id="orderStatus" />
								</div>
							</div>
							<div class="form-group">
								<label for="orderDate"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.orderDate.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="date" class="form-control" required="true"
										name="orderDate" id="orderDate" />
								</div>
							</div>
							<div class="form-group">
								<label for="orderQuantity"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.orderQuantity.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="number" name="orderQuantity" required="true" 
									class="form-control" id="orderQuantity" />
								</div>
							</div>
							<div class="form-group">
								<label for="orderPaymentDetails"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.orderPaymentDetails.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Payment Details"
										name="orderPaymentDetails" required="true" class="form-control"
										id="orderPaymentDetails" />
								</div>
							</div>
							<div class="form-group">
								<label for="username"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.username.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Customer Name"
										name="username" required="true" class="form-control"
										id="username" />
								</div>
							</div>
							<div class="form-group">
								<label for="productId"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.productId.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="number" name="productId" required="true" 
									class="form-control" id="productId" />
								</div>
							</div>
							<div class="form-group">
								<label for="shippingAddress"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.shippingAddress.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Shipping Address"
										name="shippingAddress" required="true" class="form-control"
										id="shippingAddress" />
								</div>
							</div>
							<div class="form-group">
								<label for=shippingCity
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.shippingCity.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter City"
										name="shippingCity" required="true" class="form-control"
										id="shippingCity" />
								</div>
							</div>
							<div class="form-group">
								<label for="shippingCountry"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.shippingCountry.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Country"
										name="shippingCountry" required="true" class="form-control"
										id="shippingCountry" />
								</div>
							</div>
							<div class="form-group">
								<label for="shippingPin"
									class="col-md-2 label-register control-label"> 
									<spring:message code='order.shippingPin.input'></spring:message>  </label>
								<div class="col-md-8">
									<input type="number" name="shippingPin" required="true" 
									class="form-control" id="shippingPin" />
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
				</div>
				
				<div class="panel panel-default">
					<a data-toggle="collapse" href="#deletePanel" style="text-decoration: none;"
						class="collapsed" aria-expanded="false">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: left">Delete
							<spring:message code='order.heading'></spring:message> </h4>
					</div>
					</a>
					<div class="panel-collapse collapse" id="deletePanel" aria-expanded="false" style="height: 0px;">
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="deleteOrderForm" role="form">
							<div class="form-group">
								<label for="orderId" class="col-md-2 label-register control-label">
									<spring:message code='order.heading'></spring:message> Id </label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Order Id"
										name="orderId" required="true" class="form-control" id="orderId" />
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
		</div>


		
			
	
	<script>
	var populate = function(orderNumber , orderStatus , orderDate , orderQuantity, 
			orderPaymentDetails, username, productId, shippingAddress, shippingCity,
			shippingCountry, shippingPin)
	{
		document.getElementById("orderNumber").setAttribute("value" , orderNumber);
		document.getElementById("orderStatus").setAttribute("value" , orderStatus);
		document.getElementById("orderDate").setAttribute("value" , orderDate);
		document.getElementById("orderQuantity").setAttribute("value" , orderQuantity);
		document.getElementById("orderPaymentDetails").setAttribute("value" , orderPaymentDetails);
		document.getElementById("username").setAttribute("value" , username);
		document.getElementById("productId").setAttribute("value" , productId);
		document.getElementById("shippingAddress").setAttribute("value" , shippingAddress);
		document.getElementById("shippingCity").setAttribute("value" , shippingCity);
		document.getElementById("shippingCountry").setAttribute("value" , shippingCountry);
		document.getElementById("shippingPin").setAttribute("value" , shippingPin);
		$("html, body").animate({ scrollTop: $("#updatePanel").offset().top }, 1500);
	}	
	var deleteit = function(id){
		document.getElementById("orderId").setAttribute("value" , id);
		$("html, body").animate({ scrollTop: $("#deletePanel").offset().top }, 1500);

	}
	</script>

	<!-- Insert Footer After Here -->
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>


</body>
</html>