<?xml version="1.0" encoding="ISO-8859-1" ?>
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
<h4>Appoinment Details</h4>

<%
	DbConnection db=new DbConnection();
	try{
		String sql="SELECT tbl_docters.d_fname, tbl_docters.d_lname, tbl_special.sp_name, tbl_tables.date, tbl_tables.from, tbl_tables.to FROM tbl_docters Inner Join tbl_special ON tbl_special.sp_id = tbl_docters.d_special Inner Join tbl_tables ON tbl_docters.d_id = tbl_tables.d_id ";
		ResultSet rs=db.getData(sql);
		System.out.println("Sucess sql");
		
		while(rs.next()){
			String lname=rs.getString("tbl_docters.d_lname");
			String fname=rs.getString("tbl_docters.d_fname");
			String dFullName=fname+" "+lname;
			String special=rs.getString("tbl_special.sp_name");
			String date=rs.getString("tbl_tables.date");
			int fromTime=rs.getInt("tbl_tables.from")/60;
			int toTime=rs.getInt("tbl_tables.to")/60;
			
			%>
			<p><b>Dr.<%=dFullName.toUpperCase()%></b> Special in :<%=special %></p>
			<p>Comming on : <b><%=date %></b> From <b><%=fromTime %>:00 HH</b> To <b><%=toTime %>:00 HH</b></p>
			<table border="0">
				<tr>
					<th>Time</th>
					<th>Patient</th>
					<th>Description</th>
				</tr>
			<%
			try{
				//String sql2="SELECT tbl_appoinment.id,tbl_tables.tbl_id, tbl_appoinment.intervels, tbl_appoinment.patient, tbl_appoinment.dsp FROM tbl_appoinment Inner Join tbl_tables ON tbl_tables.tbl_id = tbl_appoinment.tbl_id where tbl_tables.date='"+date+"' ";
				String sql2="SELECT tbl_appoinment.id, tbl_tables.tbl_id, tbl_appoinment.intervels, tbl_appoinment.patient, tbl_appoinment.dsp, tbl_tables.`date`, tbl_tables.`from`, tbl_tables.`to` FROM tbl_appoinment Inner Join tbl_tables ON tbl_tables.tbl_id = tbl_appoinment.tbl_id where tbl_tables.date='"+date+"' ";
				ResultSet rs2=db.getData(sql2);
				while(rs2.next()){
					int id=rs2.getInt("tbl_appoinment.id");
					String tbl_id=rs2.getString("tbl_tables.tbl_id");
					String interval=rs2.getString("tbl_appoinment.intervels");
					int patient=rs2.getInt("tbl_appoinment.patient");
					
					String dsp=rs2.getString("tbl_appoinment.dsp");
					%>
					<tr>
						<td><%=interval %></td>
						<td><a href="/RCB_Medicle_Center/setDid?id=<%=id %>"><%=patient %></a></td>
						<td><%=dsp %></a></td>
					</tr>
					<%
					
				}
			}catch(Exception e){
				System.out.println("Error in DocterAppoinmentList.jsp load appoinment table error");
				e.printStackTrace();}
			%>	
			
				
			</table>
			<hr />
			
			<%		
			}
		
	}catch(Exception e){
		System.out.println("Error in DocterAppoinmentList.jsp");
		e.printStackTrace();}

%>


</body>
</html>