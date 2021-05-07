<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="headlink.jsp"%>

<script src="js/basic.js"></script>
<title>ERROR</title>
<link rel="icon" href="download.png" type="image/x-icon">
</head>
<style>
body {
	background-image: url('/error.jpg');
	background-repeat: no-repeat;
	background-color: #f2f2f2;
	background-size: cover;
}
</style>
<body>
	<div style="margin: 10px 0px 0px 20px">
		<!-- <h1 >Something went wrong! </h1>
<h4>Looks like this page is missing. Don't worry though. Our Best man is on the case.</h4>  -->
		<div class="container" style="padding-top: 15%;padding-left:15%">
			<h3 style="color:red">Session expired or you haven't logged in</h3>
		</div>
		<div class="container" style="padding-top: 15px;padding-left:30%">
			<a href="/logout"><button type="button" class="btn btn-success">Login</button>
			</a>
		</div>
	</div>
</body>
</html>