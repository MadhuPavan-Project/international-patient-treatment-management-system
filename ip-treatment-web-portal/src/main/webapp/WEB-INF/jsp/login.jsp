<html>
<head>
<link rel="stylesheet" href="css/login.css">

<title>Login page</title>
<link rel="icon" href="/download.png" type="image/x-icon">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">
.container {
	padding-left: 100px;
}
</style>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body>
	<h1 align="center" id="title">INTERNATIONAL PATIENT TREATMENT
		MANAGEMENT SYSTEM</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-6">


				<form class="box form needs-validation  mx-5" id="demo"
					method="post" action="/login" model="user" novalidate="novalidate">

					<h1 id="login">Login</h1>
					<p  style="color: Orange">Please enter your
						login user name and password!</p>
					<div class="form-group">
						<input type="text" name="userid" class="form-control"
							minlength="6" placeholder="Username" required="required">
						<div class="valid-feedback">Valid</div>
						<div class="invalid-feedback">Username minimum length should
							be 6.</div>
					</div>
					<div class="form-group">
						<input type="password" name="upassword" class="form-control"
							minlength="6" placeholder="Password" required="required">
						<div class="valid-feedback">Valid</div>
						<div class="invalid-feedback">Password minimum length should
							be 6.</div>
					</div>
					<input type="submit" name="submit"> <span
						style="color: red">${error1}</span>
				</form>


			</div>
		</div>
	</div>
	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Fetch all the forms we want to apply custom Bootstrap validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');
						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
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
</body>
</html>