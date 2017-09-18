<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/admin.css">
<body>

	<!--  Started Sidebar -->


	<!--  Ended Sidebar -->




	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<jsp:include page="/WEB-INF/views/admin/admininc/adminnav.jsp"></jsp:include>
			</div>
			<div class="col-md-10 ">
				<h2 class="text-center adminpanelhead">Admin Panel Home</h2>
	    
	    <div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4">
					    <div id="donutchart"></div>
				
				</div>
				<div class="col-md-4">
									    <div id="donutchartSupp"></div>
				
				</div>
				<div class="col-md-4">
				</div>
			</div>
		</div>
	</div>
	
				<div class="row">
					<div class="col-md-4">
						<div class="jumbotron well">
							<h2>Products</h2>
							<p>Total Number of Products :
							<p>
								<a class="btn btn-primary btn-large" href="adminmanageprod">Manage
									Products</a>
							</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="jumbotron well">
							<h2>Suppliers</h2>
							<p>Total Number of Suppliers : ${totalsupp }</p>
							<p>
								<a class="btn btn-primary btn-large" href="adminmanagesupp">Manage
									Suppliers</a>
							</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="jumbotron well">
							<h2>Categories</h2>
							<p>Total Categories : ${totalcat }</p>
							<p>
								<a class="btn btn-primary btn-large" href="adminmanagecat">Manage
									Categories</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Name', 'Sold'],
          ['Phone',     11],
          ['Mouse',      2],
          ['Some More things',  2],
          ['Lot More things', 2],
          ['Eazy things',    7]
        ]);
 
        
        

        var options = {
          title: 'Trending Products',
          pieHole: 0.4,
          backgroundColor: 'transparent'
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
      
      
      google.charts.setOnLoadCallback(drawChartSupp);
      function drawChartSupp() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Phone',     11],
          ['Mouse',      2],
          ['Some More things',  2],
          ['Lot More things', 2],
          ['Eazy things',    7]
        ]);

        var options = {
          title: 'Top Suppliers',
          pieHole: 0.4,
          backgroundColor: 'transparent'
        };

        var chartSupp = new google.visualization.PieChart(document.getElementById('donutchartSupp'));
        chartSupp.draw(data, options);
      }

      </script>
      
      <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.0/Chart.min.js"></script>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
</html>