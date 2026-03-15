<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit Money</title>

<style>
body {
	font-family: Arial;
	background: linear-gradient(to right, #4facfe, #00f2fe);
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
	background: #1e3c72;
	color: white;
	border: none;
	border-radius: 5px;
}

.msg {
	margin-top: 10px;
	color: green;
	font-weight: bold;
}
</style>
</head>

<body>

	<div class="box">
		<h2>Deposit Money</h2>

		<form action="AccountServlet" method="post">
			<input type="hidden" name="action" value="deposit"> <input
				type="number" name="accNo" placeholder="Account Number" required>

			<input type="number" step="0.01" name="amount"
				placeholder="Enter Amount" required>

			<button type="submit">Deposit</button>
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