<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>GAMAZON | Products</title>
	
	<link rel="stylesheet" href="resources/css/admin.css">

</head>
<body>

	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<c:url var="rcss" value="resources/css"></c:url>
	<c:url var="rimages" value="resources/images"></c:url>

	<!--  Header Above Here -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<jsp:include page="/WEB-INF/views/admin/admininc/adminnav.jsp"></jsp:include>
			</div>
			<div class="col-md-10 text-center ">


				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 class="panel-title" style="text-align: center">
							PRODUCTS PANEL
						</h2>
					</div>
					<div class="panel-heading">
						<table class="  table table-bordered table-hover table-condensed">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Desc</th>
									<th>Quantity</th>
									<th>Category</th>
									<th>Supplier</th>
									<th>Edit</th>
									<th>Delete</th>
									<th>Image</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="product" items="${listProduct}">
									<tr>
										<td><c:out value="${product.productId}"></c:out></td>
										<td><c:out value="${product.productName}"></c:out></td>
										<td><c:out value="${product.productBrand}"></c:out></td>
										<td><c:out value="${product.productPrice}"></c:out></td>
										<td><c:out value="${product.productDesc}"></c:out></td>
										<td><c:out value="${product.productQuantity}"></c:out></td>
										<td><c:out value="${product.productCatName}"></c:out></td>
										<td><c:out value="${product.productSuppName}"></c:out></td>
										
										<td><a style="cursor: pointer"
											onclick="populate(${product.productId} ,'${product.productName}' , '${product.productBrand}' ,
											 '${product.productPrice}', '${product.productDesc}', '${product.productQuantity}',
											 '${product.productCatName}', '${product.productSuppName}')"
											 data-toggle="collapse" href="#updatePanel">Edit</a></td>
										<td><a style="cursor: pointer" data-toggle="collapse" href="#deletePanel"
											onclick="deleteit(${product.productId})"> Delete</a></td>
										<td>
											<img
												src="<c:url value="download?productName=${product.productName}"/>"
												class="thumbnailIconStyling" alt="Error Loading Thumbnail"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<a data-toggle="collapse" href="#searchPanel" style="text-decoration: none;"
						class="collapsed" aria-expanded="false">
							<h4 class="panel-title" style="text-align: left">
								Search for Product
							</h4>
						</a>
					</div>
					<div class="panel-collapse collapse" id="searchPanel" aria-expanded="false" style="height: 0px;">
						<div class="panel-body">
							<form class="form-horizontal" method="post "
								action="searchProductForm" role="form">
								<div class="form-group">
	
									<label for="name" class="col-md-2 label-register control-label">
										Enter Product Name
									</label>
									<div class="col-md-8">
										<input type="text" placeholder="Enter Product Name"
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
					<div class="panel-heading">
						<a data-toggle="collapse" href="#addPanel" style="text-decoration: none;"
						class="collapsed" aria-expanded="false">
							<h4 class="panel-title" style="text-align: left">
								Add Product
							</h4>
						</a>	
					</div>
					<div class="panel-collapse collapse" id="addPanel" aria-expanded="false" style="height: 0px;">	
						<div class="panel-body">
							<form class="form-horizontal" method="post"
								action="addProductForm" role="form" enctype="multipart/form-data">
								
								<div class="form-group">
									<label for="productName"
										class="col-md-2 label-register control-label">
										Enter Product's Name
									</label>
									<div class="col-md-8">
										<input type="text" placeholder="Enter Product's Name"
											name="productName" required="true" class="form-control"
											id="productName" />
									</div>
								</div>
								<div class="form-group">
									<label for="productBrand"
										class="col-md-2 label-register control-label">
										Enter Product's Brand 
									</label>
									<div class="col-md-8">
										<input type="text" placeholder="Enter Product's Brand"
											name="productBrand" required="true" class="form-control"
											id="productBrand" />
									</div>
								</div>
								<div class="form-group">
									<label for="productPrice"
										class="col-md-2 label-register control-label">
										Enter Product's Price
									</label>
									<div class="col-md-8">
										<input type="number" placeholder="Enter Product's Price"
											name="productPrice" required="true" class="form-control"
											id="productPrice" />
									</div>
								</div>
								<div class="form-group">
									<label for="productDesc"
										class="col-md-2 label-register control-label"> 
										Enter a Short Description </label>
									<div class="col-md-8">
										<textarea placeholder="Enter Product's Description"
											name="productDesc" required="true" class="form-control"
											id="productDesc" ></textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="productQuantity"
										class="col-md-2 label-register control-label">
										Enter Product's Quantity
									</label>
									<div class="col-md-8">
										<input type="number" placeholder="Enter Product's Quantity"
											name="productQuantity" required="true" class="form-control"
											id="productQuantity" />
									</div>
								</div>
								<div class="form-group">
									<label for="productCatName"
										class="col-md-2 label-register control-label">
										Choose Product's Category
									</label>
									<div class="col-md-8">
										<select id="productCatName" name="productCatName">
											<option value="" disabled selected>Select Categories</option>
											<c:forEach var="category" items="${listCategory}">
												<option value="${category.categoryName}">${category.categoryName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="productSuppName"
										class="col-md-2 label-register control-label">
										Choose Product's Supplier
									</label>
									<div class="col-md-8">
										<select id="productSuppName" name="productSuppName" >
											<option value="" disabled selected>Select Categories</option>
											<c:forEach var="supplier" items="${listSupplier}">
												<option value="${supplier.supplierName}">${supplier.supplierName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
									
									<!-- Prodcut Image Upload -->
								<div class="form-group">
									<label for="file" class="col-md-2 label-register control-label">Upload Product Image</label> 
									<input type="file" class="form-control-file" id="file" aria-describedby="fileHelp" name="file"> 
									<p id="fileHelp" class="form-text "></p>
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
					<div class="panel-heading">
						<a data-toggle="collapse" href="#updatePanel" style="text-decoration: none;"
						class="collapsed" aria-expanded="false">	
							<h4 class="panel-title" style="text-align: left">
								Update Product
							</h4>
						</a>	
					</div>
					<div class="panel-collapse collapse" id="updatePanel" aria-expanded="false" style="height: 0px;">
					<div class="panel-body">
						<form class="form-horizontal" method="post"
							action="updateProductForm" role="form" enctype="multipart/form-data">
							<div class="form-group">
								<label for="productIdUpdate"
									class="col-md-2 label-register control-label"> Product
									Id </label>
								<div class="col-md-8">
									<input type="text" placeholder="Product's Id"
										name="productId" required="true" class="form-control"
										id="productIdUpdate" readonly="readonly" />
								</div>
							</div>
							<div class="form-group">
								<label for="productNameUpdate"
									class="col-md-2 label-register control-label">
									Enter Product's Name
								</label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Product's Name"
										name="productName" required="true" class="form-control"
										id="productNameUpdate" />
								</div>
							</div>
							<div class="form-group">
								<label for="productBrandUpdate"
									class="col-md-2 label-register control-label">
									Enter Product's Brand 
								</label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Product's Brand"
										name="productBrand" required="true" class="form-control"
										id="productBrandUpdate" />
								</div>
							</div>
							<div class="form-group">
								<label for="productPriceUpdate"
									class="col-md-2 label-register control-label">
									Enter Product's Price
								</label>
								<div class="col-md-8">
									<input type="number" placeholder="Enter Product's Price"
										name="productPrice" required="true" class="form-control"
										id="productPriceUpdate" />
								</div>
							</div>
							<div class="form-group">
								<label for="productDescUpdate"
									class="col-md-2 label-register control-label"> 
									Enter a Short Description </label>
								<div class="col-md-8">
									<textarea placeholder="Enter Product's Description"
										name="productDesc" required="true" class="form-control"
										id="productDescUpdate" ></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="productQuantityUpdate"
									class="col-md-2 label-register control-label">
									Enter Product's Quantity
								</label>
								<div class="col-md-8">
									<input type="number" placeholder="Enter Product's Quantity"
										name="productQuantity" required="true" class="form-control"
										id="productQuantityUpdate" />
								</div>
							</div>
							<div class="form-group">
								<label for="productCatNameUpdate"
									class="col-md-2 label-register control-label">
									Choose Product's Category
								</label>
								<div class="col-md-8">
									<select id="productCatNameUpdate" name="productCatName">
										<c:forEach var="category" items="${listCategory}">
											<option value="${category.categoryName}">${category.categoryName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="productSuppNameUpdate"
									class="col-md-2 label-register control-label">
									Choose Product's Supplier
								</label>
								<div class="col-md-8">
									<select id="productSuppNameUpdate" name="productSuppName" >
										<c:forEach var="supplier" items="${listSupplier}">
											<option value="${supplier.supplierName}">${supplier.supplierName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
								<!-- Prodcut Image Upload -->
							<div class="form-group">
								<label for="fileUpdate" class="col-md-2 label-register control-label">Upload Product Image</label> 
								<input type="file" class="form-control-file" id="fileUpdate" aria-describedby="fileHelp" name="file" required> 
								<p id="fileHelp" class="form-text "></p>
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
					<div class="panel-heading">
						<a data-toggle="collapse" href="#deletePanel" style="text-decoration: none;"
						class="collapsed" aria-expanded="false">
							<h4 class="panel-title" style="text-align: left">
								Delete Product
							</h4>
						</a>	
					</div>
					<div class="panel-collapse collapse " id="deletePanel" aria-expanded="false" style="height: 0px;">
					<div class="panel-body">
						<form class="form-horizontal" method="post "
							action="deleteProductForm" role="form">
							<div class="form-group">
								<label for="productIdDel"
									class="col-md-2 label-register control-label">
									Product Id
								</label>
								<div class="col-md-8">
									<input type="text" placeholder="Enter Product Id"
										name="productId" required="true" class="form-control"
										id="productIdDel" />
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
	var populate = function(id , name , brand , price, desc, quantity, catName, suppName){
		document.getElementById("productIdUpdate").setAttribute("value" , id);
		document.getElementById("productNameUpdate").setAttribute("value" , name);
		document.getElementById("productBrandUpdate").value = brand ;
		document.getElementById("productPriceUpdate").setAttribute("value" , price);
		document.getElementById("productDescUpdate").value=desc;
		document.getElementById("productQuantityUpdate").setAttribute("value" , quantity);
		document.getElementById("productCatNameUpdate").setAttribute("value" , catName);
		$("html, body").animate({ scrollTop: $("#productCatNameUpdate").offset().top }, 0);
		document.getElementById("productSuppNameUpdate").setAttribute("value" , suppName);
		
	}	
	var deleteit = function(id){
		document.getElementById("productIdDel").setAttribute("value" , id);
		$("html, body").animate({ scrollTop: $("#productIdDel").offset().top }, 1500);

	}
	</script>

	<!-- Insert Footer After Here -->
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>


</body>
</html>