<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
%>

<jsp:useBean id="p" class="com.Beans.UserPojo" scope="session" />

<%
if ("signin".equals(id)) {
%>
<jsp:setProperty name="p" property="*" />
<%
} 
%>



<jsp:forward page="/loginServlet" />