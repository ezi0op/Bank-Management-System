<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<style>
body {
	font-family: Arial, sans-serif;
	background: #f2f2f2;
}

.container {
	width: 400px;
	margin: 80px auto;
	background: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

input, select {
	width: 100%;
	padding: 8px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

.error {
	color: red;
	font-size: 13px;
}

.btn {
	width: 100%;
	padding: 10px;
	background: #007bff;
	border: none;
	color: white;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
}

.btn:hover {
	background: #0056b3;
}
</style>

<script type="text/javascript">
	function validationForm() {

		let user = document.getElementById("user").value.trim();
		let email = document.getElementById("email").value.trim();
		let pass = document.getElementById("pass").value.trim();
		let secQ = document.getElementById("securityQuestion").value;
		let ans = document.getElementById("answer").value.trim();

		document.getElementById("userr").innerHTML = "";
		document.getElementById("emailerr").innerHTML = "";
		document.getElementById("passerr").innerHTML = "";
		document.getElementById("secerr").innerHTML = "";
		document.getElementById("anserr").innerHTML = "";

		let valid = true;

		if (user === "") {
			document.getElementById("userr").innerHTML = "Username required";
			valid = false;
		}

		if (email === "") {
			document.getElementById("emailerr").innerHTML = "Email required";
			valid = false;
		} else if (!email.includes("@")) {
			document.getElementById("emailerr").innerHTML = "Invalid email format";
			valid = false;
		}

		if (pass === "") {
			document.getElementById("passerr").innerHTML = "Password required";
			valid = false;
		} else if (pass.length < 8) {
			document.getElementById("passerr").innerHTML = "Minimum 8 characters";
			valid = false;
		}

		if (secQ === "") {
			document.getElementById("secerr").innerHTML = "Select a question";
			valid = false;
		}

		if (ans === "") {
			document.getElementById("anserr").innerHTML = "Answer required";
			valid = false;
		}

		return valid;
	}
</script>

</head>

<body>

	<div class="container">

		<h2>User Registration</h2>

		<form action="loginServlet" method="post">

			<!-- Username -->
			<div class="form-group">
				<label>Username</label> <input type="text" name="user" id="user">
				<div class="error" id="userr"></div>
			</div>

			<!-- Email -->
			<div class="form-group">
				<label>Email</label> <input type="email" name="email" id="email">
				<div class="error" id="emailerr"></div>
			</div>

			<!-- Password -->
			<div class="form-group">
				<label>Password</label> <input type="password" name="pass" id="pass">
				<div class="error" id="passerr"></div>
			</div>

			<!-- Security Question -->
			<div class="form-group">
				<label>Security Question</label> <select name="securityQuestion"
					id="securityQuestion">
					<option value="">-- Select Question --</option>
					<option value="animal">Favourite Animal</option>
					<option value="color">Favourite Color</option>
					<option value="game">Favourite Game</option>
				</select>
				<div class="error" id="secerr"></div>
			</div>

			<!-- Answer -->
			<div class="form-group">
				<label>Answer</label> <input type="text" name="answer" id="answer">
				<div class="error" id="anserr"></div>
			</div>

			<input type="submit" class="btn" value="Register">

		</form>

	</div>

</body>
</html>