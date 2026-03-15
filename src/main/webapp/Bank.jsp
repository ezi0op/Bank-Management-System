<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.Beans.TransactionPojo"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MyBank Dashboard</title>

<!-- Google Fonts - modern & clean -->
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Font Awesome for icons (optional but highly recommended) -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
:root {
	--primary: #1e40af; /* deeper blue */
	--primary-dark: #1e3a8a;
	--secondary: #3b82f6;
	--accent: #10b981; /* green for success/deposit */
	--danger: #ef4444; /* red for withdraw */
	--bg: #f8fafc;
	--card-bg: rgba(255, 255, 255, 0.75);
	--text: #1e293b;
	--text-light: #64748b;
	--border: rgba(226, 232, 240, 0.8);
	--shadow-sm: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px
		rgba(0, 0, 0, 0.06);
	--shadow-md: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px
		rgba(0, 0, 0, 0.05);
	--radius-lg: 16px;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Inter', system-ui, sans-serif;
	background: linear-gradient(135deg, #f1f5f9, #e2e8f0);
	color: var(--text);
	min-height: 100vh;
	display: flex;
}

/* Sidebar - improved gradient + glass feel */
.sidebar {
	width: 260px;
	height: 100vh;
	background: linear-gradient(180deg, var(--primary), var(--primary-dark));
	color: white;
	padding: 2rem 1.5rem;
	position: sticky;
	top: 0;
	overflow-y: auto;
	box-shadow: 4px 0 20px rgba(0, 0, 0, 0.15);
}

.sidebar h2 {
	text-align: center;
	font-size: 1.8rem;
	margin-bottom: 2.5rem;
	letter-spacing: 1px;
}

.sidebar a {
	display: flex;
	align-items: center;
	gap: 12px;
	padding: 14px 16px;
	margin: 8px 0;
	color: white;
	text-decoration: none;
	border-radius: 12px;
	transition: all 0.3s ease;
	font-weight: 500;
}

.sidebar a:hover, .sidebar a.active {
	background: rgba(255, 255, 255, 0.18);
	transform: translateX(6px);
}

/* Main content */
.main {
	flex: 1;
	padding: 2.5rem 3rem;
	overflow-y: auto;
}

.header {
	background: white;
	padding: 1.5rem 2rem;
	border-radius: var(--radius-lg);
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 2rem;
	box-shadow: var(--shadow-md);
}

.header h2 {
	color: var(--primary);
	font-size: 1.8rem;
	font-weight: 600;
}

.user-badge {
	background: #eff6ff;
	padding: 12px 18px;
	border-radius: 12px;
	font-size: 0.95rem;
	line-height: 1.5;
	border: 1px solid #bfdbfe;
}

/* Cards - Glassmorphism style */
.cards {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
	gap: 1.5rem;
	margin-bottom: 2.5rem;
}

.card {
	background: var(--card-bg);
	backdrop-filter: blur(12px);
	-webkit-backdrop-filter: blur(12px);
	border: 1px solid var(--border);
	border-radius: var(--radius-lg);
	padding: 1.8rem;
	box-shadow: var(--shadow-md);
	transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.card:hover {
	transform: translateY(-6px);
	box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px
		rgba(0, 0, 0, 0.04);
}

.card h3 {
	color: var(--primary);
	font-size: 1.25rem;
	margin-bottom: 1rem;
	font-weight: 600;
}

.balance {
	font-size: 2.5rem;
	font-weight: 700;
	color: var(--text);
	margin: 0.5rem 0 1rem;
}

.btn {
	display: inline-flex;
	align-items: center;
	gap: 8px;
	padding: 10px 20px;
	background: var(--primary);
	color: white;
	text-decoration: none;
	border-radius: 10px;
	font-weight: 500;
	transition: all 0.3s ease;
	border: none;
	cursor: pointer;
}

.btn:hover {
	background: var(--secondary);
	transform: translateY(-2px);
}

.btn-outline {
	background: transparent;
	border: 2px solid var(--primary);
	color: var(--primary);
}

.btn-outline:hover {
	background: var(--primary);
	color: white;
}

/* Quick actions */
.actions {
	display: flex;
	flex-wrap: wrap;
	gap: 1rem;
	margin-top: 1.2rem;
}

/* Table - modern look */
.table-container {
	background: white;
	border-radius: var(--radius-lg);
	padding: 1.8rem;
	box-shadow: var(--shadow-md);
	overflow-x: auto;
}

table {
	width: 100%;
	border-collapse: separate;
	border-spacing: 0;
}

th {
	background: var(--primary);
	color: white;
	padding: 14px 16px;
	text-align: left;
	font-weight: 600;
}

td {
	padding: 14px 16px;
	border-bottom: 1px solid #e2e8f0;
	color: var(--text-light);
}

tr:last-child td {
	border-bottom: none;
}

tr:hover {
	background: #f8fafc;
}

.status-deposit {
	color: var(--accent);
	font-weight: 600;
}

.status-withdraw {
	color: var(--danger);
	font-weight: 600;
}

/* Message */
.msg {
	text-align: center;
	padding: 1rem;
	margin: 1.5rem auto;
	max-width: 600px;
	border-radius: 12px;
	background: #ecfdf5;
	color: #065f46;
	font-weight: 500;
}
</style>
</head>
<body>

	<!-- Sidebar -->
	<div class="sidebar">
		<h2>
			<i class="fas fa-landmark"></i> MyBank
		</h2>
		<a href="AccountServlet"><i class="fas fa-home"></i> Dashboard</a> <a
			href="openaccount.jsp"><i class="fas fa-plus-circle"></i> Open
			Account</a> <a href="deposit.jsp"><i class="fas fa-arrow-down"></i>
			Deposit</a> <a href="withdraw.jsp"><i class="fas fa-arrow-up"></i>
			Withdraw</a> <a href="logout"><i class="fas fa-sign-out-alt"></i>
			Logout</a>
	</div>

	<!-- Main -->
	<div class="main">

		<!-- Header -->
		<div class="header">
			<h2>
				Welcome,
				<%=request.getAttribute("name") != null ? request.getAttribute("name") : "User"%></h2>
			<div class="user-badge">
				Acc No: <b><%=request.getAttribute("accNo")%></b><br> Type: <b><%=request.getAttribute("categoryAcc")%></b>
			</div>
		</div>

		<!-- Cards -->
		<div class="cards">

			<div class="card">
				<h3>Current Balance</h3>
				<div class="balance">
					₹
					<%=request.getAttribute("balance")%></div>
				<a href="AccountServlet?action=balance" class="btn"><i
					class="fas fa-sync-alt"></i> Refresh</a>
			</div>

			<div class="card">
				<h3>Quick Actions</h3>
				<div class="actions">
					<a href="openaccount.jsp" class="btn btn-outline"><i
						class="fas fa-plus"></i> Open Account</a> <a href="deposit.jsp"
						class="btn"><i class="fas fa-arrow-down"></i> Deposit</a> <a
						href="withdraw.jsp" class="btn"><i class="fas fa-arrow-up"></i>
						Withdraw</a>
				</div>
			</div>

		</div>

		<!-- Transactions -->
		<div class="table-container">
			<h3>Recent Transactions</h3>
			<table>
				<tr>
					<th>ID</th>
					<th>Type</th>
					<th>Amount (₹)</th>
					<th>Date</th>
				</tr>
				<%
				List<TransactionPojo> list = (List<TransactionPojo>) request.getAttribute("transactions");
				if (list != null && !list.isEmpty()) {
					for (TransactionPojo t : list) {
				%>
				<tr>
					<td><%=t.getTransId()%></td>
					<td
						class="<%=t.getTransType().equalsIgnoreCase("Deposit") ? "status-deposit" : "status-withdraw"%>">
						<%=t.getTransType()%>
					</td>
					<td><%=t.getAmount()%></td>
					<td><%=t.getTransDate()%></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="4"
						style="text-align: center; color: var(--text-light);">No
						transactions found</td>
				</tr>
				<%
				}
				%>
			</table>
		</div>

	</div>

	<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
	%>
	<div class="msg"><%=msg%></div>
	<%
	session.removeAttribute("msg");
	}
	%>

</body>
</html>