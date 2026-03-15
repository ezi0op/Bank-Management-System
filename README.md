# 🏦 Bank Management System (Java Servlet + JSP)

A **Bank Management System Web Application** built using **Java Servlets, JSP, JDBC, and MySQL**.
This system allows users to create accounts, deposit money, withdraw money, and view transaction history.

The project follows a **MVC architecture** where:

* **Servlets → Controller**
* **JSP → View**
* **Service + DAO → Business Logic & Database Layer**

---

# 📌 Features

✔ User Login Authentication
✔ Create Bank Account
✔ Deposit Money
✔ Withdraw Money
✔ Check Account Balance
✔ View Transaction History
✔ Logout Functionality
✔ Session Management

---

# 🛠️ Technologies Used

| Technology    | Purpose             |
| ------------- | ------------------- |
| Java          | Backend Logic       |
| Servlet       | Controller Layer    |
| JSP           | View Layer          |
| JDBC          | Database Connection |
| MySQL         | Database            |
| Apache Tomcat | Web Server          |
| HTML/CSS      | Frontend            |

---

# 🏗️ Project Architecture (MVC)

```id="mxk8f3"
Client (Browser)
      ↓
JSP Pages (View)
      ↓
Servlets (Controller)
      ↓
Service Layer
      ↓
DAO Layer
      ↓
Database (MySQL)
```

---

# 📂 Project Structure

```id="u4muvd"
Bank-Management-System
│
├── src
│   ├── com.Servlet
│   │      LoginServlet.java
│   │      AccountServlet.java
│   │      LogoutServlet.java
│   │      TransServlet.java
│   │
│   ├── com.DAO
│   ├── com.Service
│   ├── com.Beans
│   └── com.Aspect
│
├── WebContent
│   ├── SignIn.jsp
│   ├── Bank.jsp
│   ├── openaccount.jsp
│   └── balance.jsp
│
└── web.xml
```

---

# 🔑 Important Servlets

### LoginServlet

Handles user login and session creation.
Example implementation:


---

### AccountServlet

Handles banking operations:

* Create account
* Deposit
* Withdraw
* Check balance

Example implementation:


---

### TransServlet

Displays user transaction history.

Example implementation:


---

### LogoutServlet

Handles session destruction and logout.

Example implementation:


---

# 🗄️ Database Design

### Account Table

```id="8tiqyj"
acc_no
user_name
balance
category_acc
```

### User Table

```id="0r3h7s"
user_id
username
password
acc_no
```

### Transaction Table

```id="0dcmv6"
trans_id
acc_no
amount
type
date
```

---

# ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```id="f6kh7y"
git clone https://github.com/ezi0op/Bank-Management-System.git
```

---

### 2️⃣ Import Project

Import as **Dynamic Web Project** into:

* Eclipse
* IntelliJ
* VS Code

---

### 3️⃣ Configure Database

Update database connection.

Example:

```id="z2rgo1"
jdbc:mysql://localhost:3306/bankdb
username=root
password=root
```

---

### 4️⃣ Deploy on Tomcat

Run the project using:

```id="q9yn1g"
Apache Tomcat Server
```

Open in browser:

```id="qsmzz2"
http://localhost:8080/Bank-Management-System
```

---

# 📸 Screenshots

Add screenshots of your JSP pages:

```id="65phh0"
SignIn.jsp
Bank.jsp
Transaction History
Account Dashboard
```

---

# 🚀 Future Improvements

* Spring Boot Migration
* REST API integration
* Secure password encryption
* Admin panel
* Money transfer between accounts
* Email notifications

---

# 👨‍💻 Author

**Amit Birajadar**

GitHub
https://github.com/ezi0op

---

# ⭐ Support

If you like this project:

⭐ Star the repository
🍴 Fork the project
📩 Create Pull Requests
