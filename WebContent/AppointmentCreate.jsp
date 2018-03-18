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

<%int id=0; %>
<form action="createTimeIntervel" method="get">
<label>Docter :</label>
<select name="id">

<%
DocterService dc=new DocterService();
ArrayList<Docter> doctersNames=dc.getAllDocters();
 for(int i=0;i<doctersNames.size();i++){
%> 
<option value="<%=doctersNames.get(i).getD_id() %>" >DR.<%=doctersNames.get(i).getD_FName() %> <%=doctersNames.get(i).getD_LName() %></option>
	

<%}
%>

</select></br>
<label>Date:</label>
<input type="date" name="txtDate" > </br></br>
<label><b></>Time Slot:<b></label>
<select name="txtIntervel">
	<option>10</option>
	<option>15</option>
	<option>20</option>
	<option>25</option>
	<option>30</option>
</select>min </br>

<table border="0">
	<tr>
		<th>From Time</th>
		<th>To Time</th>
	</tr>
	<tr>
		<td><select name="txtFromTime">
				<option>00</option>
				<option>01</option>
				<option>02</option>
				<option>03</option>
				<option>04</option>
				<option>05</option>
				<option>06</option>
				<option>07</option>
				<option>08</option>
				<option>09</option>
				<option>10</option>
				<option>11</option>
				<option>12</option>
				<option>13</option>
				<option>14</option>
				<option>15</option>
				<option>16</option>
				<option>17</option>
				<option>18</option>
				<option>19</option>
				<option>20</option>
				<option>21</option>
				<option>22</option>
				<option>23</option>
				<option>24</option>
				
			</select>:00 hr </td>
		<td>
		<select name="txtToTime">
				<option>00</option>
				<option>01</option>
				<option>02</option>
				<option>03</option>
				<option>04</option>
				<option>05</option>
				<option>06</option>
				<option>07</option>
				<option>08</option>
				<option>09</option>
				<option>10</option>
				<option>11</option>
				<option>12</option>
				<option>13</option>
				<option>14</option>
				<option>15</option>
				<option>16</option>
				<option>17</option>
				<option>18</option>
				<option>19</option>
				<option>20</option>
				<option>21</option>
				<option>22</option>
				<option>23</option>
				<option>24</option>
				
			</select>:00 hr </td>
		
		
		
		
	</tr>
</table>
<input type="submit" value="Create Appoinment">



</form>

</body>
</html>