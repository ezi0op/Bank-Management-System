<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background: linear-gradient(135deg, #36d1dc, #5b86e5);
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container {
	background: white;
	padding: 40px;
	border-radius: 12px;
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
	width: 360px;
	text-align: center;
}

h2 {
	margin-bottom: 20px;
	color: #333;
}

input, select {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
	border-radius: 8px;
	border: 1px solid #ccc;
	font-size: 14px;
}

input:focus, select:focus {
	outline: none;
	border-color: #5b86e5;
	box-shadow: 0 0 5px rgba(91, 134, 229, 0.5);
}

.btn {
	background: #5b86e5;
	color: white;
	padding: 12px;
	border: none;
	width: 100%;
	border-radius: 8px;
	font-size: 16px;
	cursor: pointer;
	margin-top: 10px;
	transition: 0.3s;
}

.btn:hover {
	background: #3f63d3;
	transform: scale(1.05);
}

.msg {
	margin-top: 10px;
	color: green;
	font-weight: bold;
}

.error {
	color: red;
}
</style>
</head>

<body>

	<div class="container">
		<h2>Create Account</h2>

		<form action="AccountServlet" method="post">

			<!-- ACTION TYPE -->
			<input type="hidden" name="action" value="create"> <input
				type="number" name="accNo" placeholder="Account Number" required>

			<input type="text" name="userName" placeholder="User Name" required>

			<input type="number" step="0.01" name="balance"
				placeholder="Balance Amount" required> <select
				name="categoryAcc" required>
				<option value="">-- Select Account Type --</option>
				<option value="Saving">Saving Account</option>
				<option value="Salary">Salary Account</option>
				<option value="Loan">Loan Account</option>
			</select>

			<button type="submit" class="btn">Save Account</button>

		</form>

		<!-- SUCCESS / ERROR MESSAGE -->
		<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
		%>
		<div class="msg"><%=msg%></div>
		<%
		}
		%>

	</div>

</body>
</html>