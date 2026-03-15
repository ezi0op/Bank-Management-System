<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw Money</title>

<style>
body {
	font-family: Arial;
	background: linear-gradient(to right, #ff9966, #ff5e62);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.box {
	background: white;
	padding: 30px;
	border-radius: 10px;
	width: 300px;
	text-align: center;
}

input {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
	border-radius: 5px;
	border: 1px solid #ccc;
}

button {
	width: 100%;
	padding: 10px;
	background: #c0392b;
	color: white;
	border: none;
	border-radius: 5px;
}

.msg {
	margin-top: 10px;
	font-weight: bold;
	color: red;
}
</style>
</head>

<body>

	<div class="box">
		<h2>Withdraw Money</h2>

		<form action="AccountServlet" method="post">
			<input type="hidden" name="action" value="withdraw"> <input
				type="number" name="accNo" placeholder="Account Number" required>

			<input type="number" step="0.01" name="amount"
				placeholder="Enter Amount" required>

			<button type="submit">Withdraw</button>
		</form>

		<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
		%>
		<div class="msg"><%=msg%></div>
		<%
		}
		%>

		<br> <a href="AccountServlet">⬅ Back to Dashboard</a>
	</div>

</body>
</html>