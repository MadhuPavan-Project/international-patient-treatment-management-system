<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="style1.css">
<title>Admin Dash board</title>
<link rel="icon" href="download.png" type="image/x-icon">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.topnav-right {
	float: right;
	padding-top: 20px;
	padding-right: 20px;
}

#header-container {
	background-color: black;
}

#navigation {
	background-color: #ffb3ff;
}

header {
	background-color: gray;
}

body {
	background-color: #ffb3ff;
}

.logo {
	padding-top: 5px;
	padding-left: 5px;
	padding-bottom: 5px;
}

#navigation {
	margin-top: 20px;
	width: 33pc;
	float: left;
}

html {
	font-family: cursive;
}

header {
	height: 100px;
}

.navbarbg-light {
	width: 600px;
}

#main-container {
	padding-top: 5px;
	height: auto;
	width: 100%;
	float: left;
	height: auto;
}

#footer-container {
	height: 3050px;
}

.bg-2 {
	color: black;
	padding-bottom: 20px;
}

.bg-3 {
	background-color: #99e699;
	color: white;
	padding-bottom: 15px;
}

#top-section-main {
	height: 400xpx;
	width: 50%;
	border: none;
	background-repeat: no-repeat;
	float: left;
}

#top-section-content {
	padding-top: 10px;
	padding-right: 40px;
	height: 500px;
	width: 35%;
	padding-left: 10px;
	float: left;
	height: 350px;
}

.nav-item {
	padding-inline-end: 5px;
	padding-bottom: 30px;
}

.card {
	height: 350px;
	width: 25%;
	float: left;
	background-color: greenyellow
}

.btn {
	width: 230px;
	padding-top: 20px;
	padding-bottom: 10px;
	position: static;
}

.card-title {
	text-align: center;
}

.bcontent {
	margin-top: 10px;
}

.list-group-item {
	
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



</head>
<body
	style="background-image: url('/backgroundimg.jpg'); background-repeat: no-repeat; background-size: 100%;">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<div id="name">
			<img src="download.png" height="80px" width="70px"> <strong
				style="color: white; font-size: 25px">International Patient
				Treatment Management System</strong>
		</div>
		<div id="navigation"></div>
		<div class="topnav-right">
			<ul class="navbar-nav navbar-light">
				<li><a class="nav-link" href="/logout" class="btn btn-default">Logout</a></li>
			</ul>
		</div>



	</nav>
	<div style="text-align: center;">
		<h2
			style="font-family: 'Merriweather', serif; font-size: 50px; font-weight: bold">WELCOME</h2>
	</div>


	<div id="main-container">
		<div id="top-section-main" class="container-fluid">

			<img class="card-img-top" src="image.jpg" height="400px"
				style="opacity: 10;">
		</div>
		<div id="top-section-content">
			<div class="row">
				<div class="col-2">
					<nav class="navbarbg-light">
						<ul class="list-group list-group-flush">
							<li class="list-group-item" style="background-color: lavender;"><span><b>Make
										your query</b></span></li>
							<li class="list-group-item" style="background-color: lavender;"><a
								href="/specialists"
								style="color: black; font-size: 25px; font-family: Helvetica, Arial, sans-serif"><span
									class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;
									View Specialists </a></li>
							<li class="list-group-item" style="background-color: lavender;"><a
								href="/allpackages"
								style="color: black; font-size: 25px; font-family: Helvetica, Arial, sans-serif"><span
									class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;&nbsp;View
									Packages</a></li>
							<li class="list-group-item" style="background-color: lavender;"><a
								href="/insurer"
								style="color: black; font-size: 25px; font-family: Helvetica, Arial, sans-serif"><span
									class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;&nbsp;View
									Insurers</a></li>
							<li class="list-group-item" style="background-color: lavender;"><a
								href="/packages"
								style="color: black; font-size: 25px; font-family: Helvetica, Arial, sans-serif"><span
									class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;&nbsp;Register</a></li>
							<li class="list-group-item" style="background-color: lavender;"><a
								href="/ongoingTreatments"
								style="color: black; font-size: 25px; font-family: Helvetica, Arial, sans-serif"><span
									class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;&nbsp;Edit
									Treatments</a></li>
							<li class="list-group-item" style="background-color: lavender;"><a
								href="/patients"
								style="color: black; font-size: 25px; font-family: Helvetica, Arial, sans-serif"><span
									class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;&nbsp;View
									All Patients</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

	</div>
	<div class="container-fluid bg-2 text-center"></div>

</body>


</html>