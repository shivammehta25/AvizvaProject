<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<div class="navcontainer">
				<div class="col-md-2">
					<h3 class="radhead">Search By Categories</h3>
					<ul class="nav nav-pills nav-stacked">
					<li><a href="products?categoryName=all">All Products</a>
						<c:forEach var="category"
							items="${applicationScope['listCategory']}">
							<li><a
								href="products?categoryName=${category.categoryName }">${category.categoryName }</a></li>
						</c:forEach>

					</ul>
				</div>
			</div>

</body>
</html>