<!DOCTYPE html>
<%@page import="com.rcb.model.Patient"%>
<%@page import="com.rcb.service.PatientService"%>
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


<form action="appoinmentAdd" method="get">

<p>Docter  Dr.<%=session.getAttribute("dFName")%></p>
<p>Date <%=session.getAttribute("date")%></p>
<p>Time <%=session.getAttribute("comeTime")%></p>
<p><%=session.getAttribute("aId")%></p>





	<label>Patient </label>
	<select id="patient" name="patient">
	<%
		PatientService pS=new PatientService();
		ArrayList<Patient> patientList=pS.allPatient();
		for(int i=0;i<patientList.size();i++){
			%><option value="<%=patientList.get(i).getP_id()%>"><%=patientList.get(i).getP_fname() %> <%=patientList.get(i).getP_lname() %></option><% 	
		}
	%>
	
	</select>
	<br>
<button type="submit" name="btnSubmit" id="btnSubmit" value="scheduled">scheduled</button>
<button type="submit" name="btnSubmit" id="btnSubmit" value="Cancel">Cancel</button>

</form>

</body>
</html>