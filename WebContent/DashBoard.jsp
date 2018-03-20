<!DOCTYPE html>
<html>
<head>
	<title></title>
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



<ul class="navbar">
    <li><a href="DashBoard.jsp"><span>Dashboard</span></a></li>
	<li><a href="#"><span>Patient</span></a></li>
		<ul class="drpPatient">
			
			<li><a href="PatientAdd.jsp">Add Patient</a></li>
			<li><a href="PatientList.jsp">Patient List</a></li>
			
		</ul>	

	<li><a href="Report.jsp"><span>Report</span></a>
	<li><a href="MedicleHistory.jsp"><span>Medicle History</span></a>
	<li><a href="#"><span>Appointment</span></a></li>
		<ul class="drpAppointment">
			
			<li><a href="AppointmentCreate.jsp">Create Appointment Shedule</a></li>
			<li><a href="AppointmentList.jsp">Appointments Shedule</a></li>
			<li><a href="AppointmentList2.jsp">Test</a></li>
			
		</ul>	
	<li><a href="#"><span>Docter</span></a></li>
		<ul class="drpPatient">
			
			<li><a href="DocterAdd.jsp">Add Docter</a></li>
			<li><a href="DocterList.jsp">Docter List</a></li>
			
		</ul>
		
	</li>
	<li><a href="Setting.jsp"><span>Setting</span></a>
	
</ul>


</body>
</html>