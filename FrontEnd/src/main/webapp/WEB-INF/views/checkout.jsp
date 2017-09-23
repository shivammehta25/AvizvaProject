<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>GAMAZON | Checkout</title>
		<style>
		h3.text-center {
			margin-top: 0px;
		}
		.panel-default>.panel-heading+.panel-collapse>.panel-body {
			color: black;
		}
		.panel-default>.panel-heading {
			color: #fff !important;
			background-color: #2e2f31 !important;
			border-color: #5ed091 !important;
		}
		.headerez {
			color: #2e2f31 !important;
			-webkit-text-shadow: 1px 2px 10px #FFFFFF !important;
			-moz-text-shadow: 1px 2px 10px #FFFFFF !important;
			text-shadow: 1px 2px 10px #FFFFFF !important;
		}
		.panel {
			-webkit-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
			-moz-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
			box-shadow: 4px 7px 38px -2px rgba(0, 0, 0 0, 1) !important;
		}
		.progress-bar {
			background-color: rgb(46, 47, 49) !important;
		}
		.progress.progress-striped {
			-webkit-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
			-moz-box-shadow: 4px 7px 38px -2px rgba(0, 0, 0, 1) !important;
			box-shadow: 4px 7px 38px -2px rgba(0, 0, 0 0, 1) !important;
		}
		.panel-body {
			color: black;
		}
		a {
			text-decoration: none !important;
		}
		h3 {
			-webkit-text-shadow: 1px 2px 10px #FFFFFF !important;
			-moz-text-shadow: 1px 2px 10px #FFFFFF !important;
			text-shadow: 1px 2px 10px #FFFFFF !important;
		}
		</style>
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<c:url var="rcss" value="resources/css"></c:url>
		<c:url var="rimages" value="resources/images"></c:url>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="progress progress-striped active">
						<div class="progress-bar" style="width: 22%;"></div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<h3 class="text-center text-success"
							onclick="location.href='cart'" style="cursor: pointer;">
							<i class="fa fa-2x fa-lg fa-arrow-up" aria-hidden="true"></i>
							Items Added to Cart <i class="fa fa-check-square-o"
							aria-hidden="true"></i>
							</h3>
						</div>
						<div class="col-md-4">
							<h3 class="text-center text-primary" id="shippinghead">
							<i class="fa fa-2x fa-lg fa-arrow-up" aria-hidden="true"></i>
							Shipping Details and Billing Details <i id="detailTick"
							aria-hidden="true"></i>
							</h3>
						</div>
						<div class="col-md-4">
							<h3 class="text-center text-danger" id="paymenthead">
							<i class="fa fa-2x fa-lg fa-arrow-up" aria-hidden="true"></i>
							Payment Options <i id="paymentTick"
							aria-hidden="true"></i>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<hr>
					<h1 class="headerez" style="color: black;">
					<span class="pull-left">Shipment Details</span>
					</h1>
				</div>
			</div>
			<form class="form-horizontal" action="adduserproduct" method="post">
				<div class="row">
					<div class="col-md-10">
						
					
						<div class="panel-group" id="panel-849692">
							<div class="panel panel-default">
								<div class="panel-heading" data-toggle="collapse"
									data-parent="#panel-849692" href="#panelDetails"
									style="cursor: pointer;" id="panelDetailz">
									<a class="panel-title" style="text-decoration: none">Enter
									User Details</a>
								</div>
								<div id="panelDetails" class="panel-collapse collapse in">
									<div class="panel-body">
										<div class="form-group">
											<label class="control-label col-sm-2" for="email">Order
											Number</label>
											<div class="col-sm-10">
												<input type="email" class="form-control" id="orderNumber"
												placeholder="OrderNumber" value="#${orderNumber}" 
												disabled>
												<input type="hidden" name="orderNumber" value="${orderNumber }">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Name</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"
												value="${user.getName() }" name="username" id="username"
												placeholder="Enter password">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Billing
											Address</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"
												value="${user.getAddress().getAddress() }"
												id="billingAddress" name="billingAddress"
												placeholder="Enter Billing Address" disabled>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Billing
											City</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"
												value="${user.getAddress().getCity() }" id="billingCity"
												name="billingCity" placeholder="Enter Billing Address" disabled>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Billing
											Country</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"
												value="${user.getAddress().getCountry() }"
												id="billingCountry" name="billingCountry"
												placeholder="Enter Billing Address" disabled>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Billing
											Pin</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"
												value="${user.getAddress().getPin() }" id="billingPin"
												name="billingPin" placeholder="Enter Billing Address" disabled>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd"></label>
											<div class="col-sm-10">
												<div class="copybutton btn btn-success" id="copyAddr">
												Ship to same Address</div>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Shipping
											Address</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" required="true"
												id="shippingAddress" name="shippingAddress"
												placeholder="Enter Shipping Address">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Shipping
											Country</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" required="true"
												id="shippingCountry" name="shippingCountry"
												placeholder="Enter Shipping Country">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Shipping
											City</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" required="true"
												id="shippingCity" name="shippingCity"
												placeholder="Enter Shipping City">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Shipping
											Pin</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" required="true"
												id="shippingPin" name="shippingPin"
												placeholder="Enter Shipping Pin">
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" data-toggle="collapse"
									data-parent="#panel-849692" href="#panelPayment"
									style="cursor: pointer;" id="paymentPanel">
									<a class="panel-title collapsed">Payment Options</a>
								</div>
								<div id="panelPayment" class="panel-collapse collapse">
									<div class="panel-body">
										<!--  Starting Card Code -->
										<div class="row">
											<div class="col-md-12">
												<label class="radio-inline" style="color: black;"><input
													type="radio" name="orderPaymentDetails"
													value="Cash On Delivery" id="cashOnDelivery">Cash On
												Delivery</label> <label class="radio-inline" style="color: black;"><input
												type="radio" name="orderPaymentDetails" value="Card Payment"
											id="creditCart">Credit/Debit Card</label>
										</div>
									</div>
									<div class="panel panel-default" id="creditCartPanel">
										<div class="panel-body">
											<div class="row">
												<div class="col-xs-12">
													<div class="form-group">
														<label for="cardNumber">CARD NUMBER</label>
														<div class="input-group">
															<input type="tel" class="form-control"
															placeholder="Valid Card Number" autocomplete="cc-number"
															 autofocus /> <span class="input-group-addon"><i
															class="fa fa-credit-card"></i></span>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class=" col-md-7">
													<div class="form-group">
														<label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span
													class="visible-xs-inline">EXP</span> DATE</label> <input
													type="tel" class="form-control"
													placeholder="MM / YY" autocomplete="cc-exp"  />
												</div>
											</div>
											<div class="col-md-5 pull-right">
												<div class="form-group">
													<label for="cardCVC">CVV CODE</label> <input type="number"
													class="form-control" id="cvv" placeholder="CVV"
													 />
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- Ending Card Code -->
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<input type="submit" class="btn btn-success col-md-offset-5" id="paybutton" value="Pay and Place Order">
				</div>
				
				
			</div>
		</form>
		<div class="col-md-2">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Order Summary</h3>
				</div>
				<div class="panel-body">
					<a href="cart">Total Items in Cart : <span class="pull-right">${prodList.size() }</span></a>
					<hr>
					Total Price : <span class="pull-right"> <i
						class="fa fa-inr"></i> ${totalPrice }
					</span>
				</div>
				<div style="cursor: pointer;" class="panel-footer text-center">
					<i class="fa fa-2x fa-lg fa-credit-card" aria-hidden="true"></i>
					Check Details
				</div>
			</div>
		</div>
	</div>
<script>
	$(document).ready(
			function() {
				$("#copyAddr").click(
						function() {
							$("#shippingAddress").attr("value",
									'${user.getAddress().getAddress()}');
							$("#shippingCountry").attr("value",
									'${user.getAddress().getCountry()}');
							$("#shippingCity").attr("value",
									'${user.getAddress().getCity()}');
							$("#shippingPin").attr("value",
									'${user.getAddress().getPin()}');
						});
				$("#paymentPanel").click(function() {
					$('.progress-bar').attr("style", "width: 50%;");
					$("#detailTick").attr("class", "fa fa-check-square-o")
					$("#shippinghead").attr("class" , "text-center text-success");
					$("#paymenthead").attr("class" , "text-center text-danger");
					$("#paymentTick").attr("class" , "");


				});
				
				
				$("#panelDetailz").click(function() {
					$('.progress-bar').attr("style", "width: 22%");
					$("#detailTick").attr("class", "");
					$("#shippinghead").attr("class" , "text-center text-primary");
					$("#paymenthead").attr("class" , "text-center text-danger");
					$("#paymentTick").attr("class" , "");


				});
				$("#creditCartPanel").hide();
				$("#paybutton").hide();
				$("#creditCart").click(function() {
					$("#creditCartPanel").show(1000);
					$("#paybutton").hide(500);
					$(".progress-bar").attr("style" , "width : 50%");
					$("#paymentTick").attr("class" , "");
					$("#cvv").keyup(function(){
						$(".progress-bar").attr("style" , "width : 100%");
						$("#paymentTick").attr("class" , "fa fa-check-square-o");
						$("#paybutton").show(500);
						$("#paymenthead").attr("class" , "text-center text-success");

					});
					
				});
				
				
				
				$("#cashOnDelivery").click(function() {
					$("#creditCartPanel").hide(1000);
					$(".progress-bar").attr("style" , "width : 100%");
					$("#paymentTick").attr("class" , "fa fa-check-square-o");
					$("#paybutton").show(500);
					$("#paymenthead").attr("class" , "text-center text-success");

					
				});
			});
</script>
<hr style="visibility: hidden;">
<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
</body>
</html>
