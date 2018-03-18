<!DOCTYPE html>
<%@page import="com.rcb.model.Docter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rcb.service.DocterService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.rcb.dbconnection.DbConnection"%>
<html>
<head>
	<title>Create Appointment</title>
</head>
<body>
<%
//hadaling back -----
response.setHeader("Cache-Control", "no-Cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");


if(session.getAttribute("username")==null){
	response.sendRedirect("index.jsp");
}

%>
<h3>Welcome :${username }        <a href="login">logout</a></h3>

<%=session.getAttribute("apId")%>
</body>
</html>