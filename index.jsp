<!DOCTYPE html>
<html lang="en">

<head>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="css/navbar-fixed-top.css">
	<link rel="stylesheet" href="css/styling.css">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
	<link href="css/styling.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>


</head>

<body>

	<div class="container-fluid ">
		<div class="row">
			<div class="col-md-12">

				<!-- Begin NavBar -->

				<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
					<div class="navbar-header">

						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
									 <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
								</button> <a class="navbar-brand" href="#">GAMAZON</a>
					</div>

					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-left">

						</ul>

						<ul class="nav navbar-nav navbar-right">
							<li class="active">
								<a href="#"> <i class="fa fa-lg fa-2x fa-home" aria-hidden="true"></i> Home</a>
							</li>
							<li>
								<a href="#"><i class="fa fa-lg fa-2x fa-info-circle"></i> About Us</a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-lg fa-2x fa-shopping-basket"></i> Products<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li>
										<a href="#">Action</a>
									</li>
									<li>
										<a href="#">Another action</a>
									</li>
									<li>
										<a href="#">Something else here</a>
									</li>
									<li class="divider">
									</li>
									<li>
										<a href="#">Separated link</a>
									</li>
									<li class="divider">
									</li>
									<li>
										<a href="#">One more separated link</a>
									</li>
								</ul>
							</li>
							<form class="navbar-form navbar-left" role="search">
								<div class="form-group">
									<input type="text" class="form-control">
									<button class="btn btn-primary" type="button">
														  <i class="fa fa-search"></i>
														</button>
								</div>
							</form>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-lg fa-2x fa-cart-plus" aria-hidden="true"></i><strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li>
										<a href="#"> Item 1</a>
									</li>
									<li>
										<a href="#"> Item 2</a>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-lg fa-2x fa-user-circle" aria-hidden="true"></i><strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li>
										<a href="#"><i class="fa fa-2x fa-lg fa-address-book "></i> Log In</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="#"><i class="fa fa-2x fa-lg fa-user-plus"></i> Register</a>
									</li>


								</ul>

							</li>
						</ul>
					</div>

				</nav>
				<!-- navbar End -->
			</div>
		</div>
	</div>

	<div class="container-fluid ">
		<!-- Begin JQuery Carousel -->

		<div id="carousel1" class="carousel slide" data-ride="carousel" data-interval="3000">
			<ol class="carousel-indicators">
				<li data-target="#carousel1" data-slide-to="0" class="active"> </li>
				<li data-target="#carousel1" data-slide-to="1"> </li>
				<li data-target="#carousel1" data-slide-to="2"> </li>
			</ol>
			<div class="carousel-inner">

				<div class="item active">
					<img alt="Gaming Collection" src="images/slider1.jpg" style="width: 100%">
					<div class="carousel-caption">
						<h3> GAMING COLLECTION</h3>
						<p>A Large variety of games available here!!!</p>
					</div>

				</div>
				<div class="item">
					<img src="images/slider2.jpg" alt="Gaming Hardwares" style="width: 100%">
					<div class="carousel-caption">
						<h3>GAMING HARDWARES</h3>
						<p>A large variety of Gaming Hardwares!!!!</p>
					</div>
				</div>
				<div class="item">
					<img src="images/slider3.jpg" alt="Gaming Peripherals" style="width: 100%">
					<div class="carousel-caption">
						<h3>COMPUTER PERIPHERALS </h3>
						<p> A large variety of Computer Accessories</p>
					</div>
				</div>
				<a class="left carousel-control" href="#carousel1" data-slide="prev">
										<span class="glyphicon glyphicon-chevron-left"></span>
										<span class="sr-only">Previous</span>
									</a>
				<a class="right carousel-control" href="#carousel1" data-slide="next">
										<span class="glyphicon glyphicon-chevron-right"></span>
										<span class="sr-only">Next</span>
									</a>
			</div>
			</div>
		</div>
		<!-- End Carousel -->

		<!-- Begin Thumbnails -->

	<div class="container-fluid ">
		<div class="row ">
			<div class="col-md-2">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="http://feelpainrelief.com/wp-content/uploads/2016/03/best-seller-badge-01.jpg">
					</div>
				</div>
				<div class="caption" style="text-align: center;">
					<h3>
						Best Selling Items
					</h3>

				</div>

			</div>
			<div class="col-md-2">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="http://images.performgroup.com/di/library/GOAL/79/c3/fifa-18-pack-shot_1wwbvp22h4qvb1qi01oijh784g.png?t=152792078">
					</div>
				</div>
				<div class="caption" style="text-align: center;">
					<h3>
						Games
					</h3>
				</div>

			</div>
			<div class="col-md-2">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="https://asia.playstation.com/content/dam/pscom/japan-asia/playstation4/top/ps4-top-navigation02-20161104.png">
					</div>
				</div>
				<div class="caption" style="text-align: center;">
					<h3>
						Consoles
					</h3>

				</div>
			</div>
			<div class="col-md-2">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="https://images-na.ssl-images-amazon.com/images/I/71oEkQkjutL._SX425_.jpg">
					</div>
				</div>
				<div class="caption" style="text-align: center;">
					<h3>
						Headsets
					</h3>
				</div>

			</div>
			<div class="col-md-2">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="http://media.4rgos.it/i/Argos/6017808_R_Z002A?$Web$&w=570&h=513">
					</div>
				</div>

				<div class="caption" style="text-align: center;">
					<h3>
						Console Accesories
					</h3>
				</div>

			</div>
			<div class="col-md-2">
				<div class="thumbnail">
					<div class="thumbnailStyling">
						<img alt="Bootstrap Thumbnail First" class="img-rounded thumbnailStyling" src="https://ae01.alicdn.com/kf/HTB14cecPFXXXXcMXXXXq6xXFXXXQ/Newest-USB-Wired-LED-Backlit-Laptop-Computer-Gamer-Keyboard-Mouse-Combo-Optical-Professional-7-Buttons-5500.jpg">
					</div>
				</div>
				<div class="caption" style="text-align: center;">
					<h3>
						Accesories
					</h3>
				</div>

			</div>
		</div>
	</div>


	<nav class="navbar ">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<div>
						<a href="#">
							<h1>GAMEZON</h1>
						</a>
						<div>
							<a href="#" "> About Us</A>
							</div>
							<div >
								<a href="# ""> Products</A>

						</div>
						<div>
							<a href="#" > Contact Us</A>
									</div>		 
								</div>
							</div>
							<div class="col-md-3 "></div>
							<div class="col-md-3 "></div>

							<div class="col-md-3 ">

								<form role="form " >
									<div class="form-group pull-right ">

										<label for="exampleInputEmail1 ">
											Enter your email address to stay updated on all our exciting offers!
										</label>
										<input type="email " class="form-control " id="exampleInputEmail1 " />

									</div>


									<button type="submit " class="btn btn-default pull-right ">
										Subscribe to Updates
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</nav>

			<nav class=" navbar-inverse ">
				<div class="container-fluid ">
					<div class="row ">
						<div class="col-md-3 ">
							<div class="pull-left "> Copyright © Gamezon 2017. </div>
						</div>
						<div class="col-md-3 ">
						</div>
						<div class="col-md-3 ">
						</div>
						<div class="col-md-3 ">
							<div class="container-fluid ">
								<div class="row ">
									<div class="col-md-1 pull-right ">
										<a href="# "> <i class=" fa fa-facebook ">   </i> </a>
									</div>
									<div class="col-md-1 pull-right ">
										<a href="# "> <i class=" fa fa-twitter ">   </i> </a>
									</div>
									<div class="col-md-1 pull-right ">
										<a href="# "> <i class=" fa fa-instagram ">   </i> </a>
									</div>
									<div class="col-md-1 pull-right ">
										<a href="# "> <i class=" fa fa-google-plus ">   </i> </a>
									</div>
									<div class="col-md-1 pull-right ">
										<a href="# "> <i class=" fa fa-linkedin ">   </i> </a>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</nav>

<!-- Loading Scripts in the End to Reduce Loadtime -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js "></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js "></script>


	</body>
	</html>