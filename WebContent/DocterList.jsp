<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rcb.service.DocterService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.rcb.dbconnection.DbConnection"%>
<%@page import="com.rcb.model.Docter"%>
<html>
<head>
	<title>Docter List</title>
</head>
<body>
<% if(session.getAttribute("username")==null){
	response.sendRedirect("index.jsp");
}

%>
<h3>Welcome :${username }        <a href="login">logout</a></h3>




	<form action="AddDocter.jsp" method="get">
		<label>Patient:</label>
		<input type="text" name="patient" id="patient">
		<input type="submit" name="btnSearch" id="btnAddNewPatient" value="Add New Docter" >

	
		
		<!-- Docter Lists... -->
		<table border="1">
				<th scope="col">DID</th><th scope="col">Docter Name</th><th scope="col">Date of Birth</th><th scope="col">Email</th><th scope="col">Special</th><th scope="col">Created Date</th><th colspan="2" scope="col">Action</th>
				
		<%
		
		DocterService dc = new DocterService();
		
		ArrayList<Docter> doctersList = dc.getAllDocters();

		for (int i = 0; i < doctersList.size(); i++) {
			System.out.println(doctersList.get(i));
		%>
		<tr>
		
		<td><%=doctersList.get(i).getD_id()%></td>
		<td><%=doctersList.get(i).getD_FName() %> <%=doctersList.get(i).getD_LName() %></td>
		
		<td><%=doctersList.get(i).getD_dob() %></td>
		<td><%=doctersList.get(i).getD_email() %></td>
		<td><%=doctersList.get(i).getD_specileName() %></td>
		<td><%=doctersList.get(i).getCreate_date() %></td>
		<td><a href="/Medicle_Record_System/docterEdit?id=<%=doctersList.get(i).getD_id() %>">Edit</a></td>
		<td><a href="/Medicle_Record_System/docterDelete?id=<%=doctersList.get(i).getD_id() %>">Delete</a></td>
		
	
	</tr><% }%>
		
        
		</table>
			


	</form>


</body>
</html>