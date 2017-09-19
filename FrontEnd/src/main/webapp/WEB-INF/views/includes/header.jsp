<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
	


<meta name="viewport" content="width=device-width, initial-scale=1">
<c:url var="rcss" value="resources/css"></c:url>
<c:url var="rimages" value="resources/images"></c:url>

<link rel="stylesheet" href="${rcss}/navbar-fixed-top.css">


<style>
#demo_box{
    width: 480px;
}
.fa-bars{
            color: #3498db;
        }
 pre{
            font-family: Consolas,Liberation Mono,Courier,monospace;
            font-size: 13px;
        }
        @media screen and (orientation: portrait){
            pre{
                overflow-x: scroll;
            }
        }       
</style>

<!-- Begin NavBar -->
<div class="container-fluid ">
	<div class="row">
		<div class="col-md-12">

			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">


				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-left">
						<li><a href="./"> <img src="${rimages }/logo.png"
								height="75">
						</a></li>
						<li><h1>
								<a class="navbar-brand" href="./">GAMAZON</a>
							</h1></li>


					</ul>

					<ul class="nav navbar-nav navbar-right">
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search" name="search">
								<button class="btn btn-primary " type="button">
									<i class="fa fa-search fa-large"></i>
								</button>
							</div>
						</form>
						
						<li class="${homeactive } "><a href="./"> <i
								class="fa fa-lg fa-2x fa-home" aria-hidden="true"></i> Home
						</a></li>
						<li class="${aboutusactive } "><a href="aboutus"><i
								class="fa fa-lg fa-2x fa-info-circle" aria-hidden="true"></i>
								About Us</a></li>
						<li class="dropdown" id="drop1"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i
								class="fa fa-lg fa-2x fa-shopping-basket" aria-hidden="true"></i>
								Products<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="products" > All Products </a></li>
							 <c:forEach var="category" items="${applicationScope['listCategory']}">
								<li><a href="products?categoryName=${category.categoryName }">${category.categoryName }</a></li>
							</c:forEach>	
							</ul></li>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="fa fa-lg fa-2x fa-cart-plus"
								aria-hidden="true"></i> Cart<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="#"> Item 1</a></li>
								<li><a href="#"> Item 2</a></li>
							</ul></li>
						
						<c:if test="${username == null }">

							<li class="dropdown ${myaccountactive}"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown"><i
									class="fa fa-lg fa-2x fa-user-circle" aria-hidden="true"></i>
									My Account<strong class="caret"></strong></a>

								<ul class="dropdown-menu">
									<li><a href="login"><i
											class="fa fa-2x fa-lg fa-address-book"></i> Log In</a></li>
									<li class="divider"></li>
									<li><a href="registeration"><i
											class="fa fa-2x fa-lg fa-user-plus"></i> Register</a></li>
								</ul></li>
						</c:if>
						<c:if test="${username != null }">

							
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"><i
									class="fa fa-lg fa-2x fa-user-circle" aria-hidden="true"></i>
									${user.name}<strong class="caret"></strong></a>
							
								<ul class="dropdown-menu">
									<li><a href="#">My Orders</a></li>
									<li class="divider"></li>
									<c:if test="${user.role=='ROLE_ADMIN' }"><li><a href="admin">Admin Panel</a></li> </c:if>
									<li><a href="profile">Profile</a></li>
									<li><a href="logout">Logout</a></li>
									
									
								</ul></li>

						</c:if>

					</ul>
				</div>

			</nav>

		</div>
	</div>
</div>
<!-- Navbar End -->
<c:if test="${msg !=null }">

		<div class="alert alert-info alert-dismissable" id="success-alert">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<div class="text-center"><strong > ${msg }</strong></div>
		</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
<script>	


	
$(document).ready (function(){

        $
        setTimeout(function showAlert() {
            $("#success-alert").slideUp(500, function(){
           $("#success-alert").slideUp(500);
           $("#success-alert").remove();
            });   
        }, 2000);
        
        	
});


	</script>
</c:if>
