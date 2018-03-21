<!DOCTYPE html>
<%@page import="com.rcb.model.Docter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rcb.service.DocterService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.rcb.dbconnection.DbConnection"%>
<html>
<head>
	<title>Add Patient Details</title>
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


<p><%=session.getAttribute("dFName")%></p>
<p><%=session.getAttribute("date")%></p>
<p><%=session.getAttribute("comeTime")%></p>
<p><%=session.getAttribute("pid")%></p>

</body>
</html>