<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.rcb.model.Table"%>
<%@page import="com.rcb.model.Appinment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rcb.service.CreateTimeIntervelService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="com.rcb.dbconnection.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Appointment List</title>
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
</br></br>
<h4>Appoinment Details TEst</h4>


		<%
		
		CreateTimeIntervelService cT=new CreateTimeIntervelService();
		
		ArrayList<Table> tableList = cT.getAllTable();

		for (int i = 0; i < tableList.size(); i++) {
			
		%>
	
		
		<p><b>Dr.<%=tableList.get(i).getD_fname().toUpperCase()%> <%=tableList.get(i).getD_lname().toUpperCase() %></b> Special in :<%=tableList.get(i).getSp_name() %></p>
		<p>Comming on : <b><%=tableList.get(i).getDate()%></b> From <b><%=tableList.get(i).getFrom() %>:00 HH</b> To <b><%=tableList.get(i).getTo()%>:00 HH</b></p>
		<table border="1">
		
			    <tr>
					<th>Time</th>
					<th>Patient</th>
					<th>Description</th>
				</tr>
				
				<%
				ArrayList<Appinment> appoinmentList=cT.getAllAppoinment(tableList.get(i).getTbl_id());
				for (int y = 0; y < appoinmentList.size(); y++) {
				%>
				
				<tr>
						<td><%=appoinmentList.get(y).getIntavel() %></td>
						<td><a href="/RCB_Medicle_Center/getPid?id=<%=appoinmentList.get(y).getId() %>&dFullname=<%=tableList.get(i).getD_fname()%> <%=tableList.get(i).getD_lname()%>&date=<%=tableList.get(i).getDate()%>&time=<%=tableList.get(i).getFrom()%>"><%=appoinmentList.get(y).getP_fname()%> <%=appoinmentList.get(y).getP_lname() %></a></td>
						<td><%=appoinmentList.get(y).getDsp() %></a></td>
				</tr>
				
				
				<% 
				}
				%>
		
		</table>	
	

		
		<% }%>









</body>
</html>