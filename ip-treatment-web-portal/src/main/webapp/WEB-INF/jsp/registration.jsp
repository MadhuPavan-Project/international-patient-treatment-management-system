<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<title>patient registration page</title>
<link rel="icon" href="download.png" type="image/x-icon">
<%@ include file="headlink.jsp"%>
<link href="css/basic.css" rel="stylesheet" type="text/css">
<script src="js/basic.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.getElementsByClassName('needs-validation');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>

<style>
.invalid-feedback {
	color: yellow;
	font-weight: bold;
}

.valid-feedback {
	color: yellow;
	font-weight: bold;
}
</style>
</head>

<body>
<%@ include file="header.jsp"%>
	<div class="container-fluid">
		
		<div class="row">
			<div class="offset-md-4 col-md-4 offset-lg-4 col-lg-4 text-center">
				<form:form id="contact" action="/registerSubmit" method="post"
					class="needs-validation" novalidate="novalidate"
					style="background: -webkit-linear-gradient(left, #3931af, #00c6ff); color: white; font-family: Verdana, Geneva, Tahoma, sans-serif;">
					<h3 style="font-weight: bold; font-style: italic;">Patient
						Registration Form</h3>
					<h4>(Register to get the treatment schedule)</h4>
					<fieldset>
						<div class="form-group">
							<input class="form-control" pattern="[A-Za-z ]+"
								placeholder="Your name" name="name" type="text" tabindex="1"
								required>
							<div class="invalid-feedback">Please enter name</div>
							<div class="valid-feedback">valid name</div>
						</div>
					</fieldset>
					<fieldset>
						<div class="form-group">
							<input class="form-control" min="1" max="100" name="age"
								placeholder="Age" type="number" tabindex="2" required>
							<div class="valid-feedback">valid age</div>
							<div class="invalid-feedback">Please enter valid age
								between 1 to 100</div>
						</div>
					</fieldset>
					<fieldset>
						<div class="form-row">
							<div class="col">
								<label for="treatmentPackageName">Package Name:</label>
							</div>
							<div class="col">
								<div class="form-group">
									<input class="form-control" placeholder="Your name"
										value="${ pack }" name="treatmentPackageName" type="text"
										tabindex="1" required="true" readonly>
								</div>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<div class="form-row">
							<div class="col">
								<label for="treatmentPackageName">Ailment:</label>
							</div>
							<div class="col">
								<div class="form-group">

									<input class="form-control" placeholder="Your name"
										value="${ ailment }" name="ailment" type="text" tabindex="1"
										required="true" readonly>
								</div>
							</div>
						</div>
					</fieldset>
					<div class="form-row">
						<div class="col">
							<label for="treatmentPackageName">Cost:</label>
						</div>
						<div class="col">
							<div class="form-group">
								<input class="form control" type="text" id="cost" name="cost"
									value="${cost}" readonly>
							</div>
						</div>
					</div>
					<fieldset>
						<button name="submit" type="submit" id="contact-submit"
							onclick="demo()" data-submit="...Sending">Submit</button>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>