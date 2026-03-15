<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Balance</title>

<style>
body {
	font-family: Arial;
	background: linear-gradient(to right, #43cea2, #185a9d);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.box {
	background: white;
	padding: 40px;
	border-radius: 10px;
	text-align: center;
	width: 300px;
}

.balance {
	font-size: 26px;
	color: #1e3c72;
	margin-top: 15px;
}
</style>
</head>

<body>

	<div class="box">
		<h2>Current Balance</h2>

		<div class="balance">
			₹
			<%=request.getAttribute("balance")%>
		</div>

		<br> <a href="AccountServlet">⬅ Back to Dashboard</a>
	</div>

</body>
</html>