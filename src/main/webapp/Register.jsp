<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Created</title>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background: linear-gradient(135deg, #56ab2f, #a8e063);
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.box {
	background: white;
	padding: 40px;
	border-radius: 12px;
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
	text-align: center;
	width: 380px;
}

h2 {
	color: #2e7d32;
	margin-bottom: 15px;
}

p {
	color: #555;
	font-size: 15px;
	margin: 5px 0;
}

.details {
	margin-top: 15px;
	text-align: left;
	padding: 10px;
	background: #f4f7fc;
	border-radius: 8px;
}

.details b {
	color: #1e3c72;
}

.btn {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 20px;
	background: #56ab2f;
	color: white;
	text-decoration: none;
	border-radius: 8px;
	transition: 0.3s;
}

.btn:hover {
	background: #3d8b20;
	transform: scale(1.05);
}
</style>
</head>

<body>

	<div class="box">
		<h2>✔ Account Created Successfully</h2>

		<div class="details">
			<p>
				<b>Account No:</b>
				<%=request.getAttribute("accNo")%></p>
			<p>
				<b>Name:</b>
				<%=request.getAttribute("userName")%></p>
			<p>
				<b>Initial Balance:</b> ₹
				<%=request.getAttribute("balance")%></p>
			<p>
				<b>Account Type:</b>
				<%=request.getAttribute("category")%></p>
		</div>

		<a href="signin.jsp" class="btn">Go to Login</a>
	</div>

</body>
</html>