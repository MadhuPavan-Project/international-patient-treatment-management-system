<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>treatments plan</title>
<link rel="icon" href="download.png" type="image/x-icon">
<%@ include file="headlink.jsp"%>
<link href="css/basic.css" rel="stylesheet" type="text/css">
<script src="js/basic.js"></script>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container-fluid">

		<hr></hr>
		<h1 style="background-color: #00111; color: #1111111;"
			class="text-center">Treatment Plan</h1>
		<hr></hr>
		<div>
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th scope="col">S.No.</th>
						<th scope="col">Name</th>
						<th scope="col">Test Details</th>
						<th scope="col">Package</th>
						<th scope="col">Specialist</th>
						<th scope="col">Cost</th>
						<th scope="col">Start date</th>
						<th scope="col">End date</th>
						<th scope="col">Status</th>
					</tr>
				</thead>
				<tbody>

					<c:set var="count" value="${count + 1}" scope="page" />
					<tr>
						<th scope="row">${count}</th>
						<td>${patient.ptDetail.name}</td>
						<td>${patient.testDetails}</td>
						<td>${patient.packageName}</td>
						<td>${patient.specialist}</td>
						<td>${patient.cost}</td>
						<td>${patient.treatmentCommencementDate}</td>
						<td>${patient.treatmentEndDate}</td>
						<td>${patient.status}</td>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>