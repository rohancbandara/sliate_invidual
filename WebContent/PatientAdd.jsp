<!DOCTYPE html>
<html>
<head>
	<title>Patient Update</title>
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




	<form action="RegisterPatient" method="get">
		 <h4>Patient Account</h4>
		 
		 <h3>Basic Info</h3>
		 <label >First Name </label>
            <input name="txtFname" type="text" id="txtFname"  placeholder="First Name" /><br>
         <label >Last Name </label>
            <input name="txtLname" type="text" id="txtLname"  placeholder="Last Name" /><br>
         <label >NIC </label>
            <input name="txtNic" type="text" id="txtNic"  placeholder="NIC" /><br>
         <label >Email </label>
            <input name="txtEmail" type="email" id="txtEmail"  placeholder="Email" /><br>


         <h3>Personal Info</h3>
         <label >Gender </label>
            <select name="gender" id="gender" >
				<option >-Select Gender-</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				<option value="Others">Others</option>

			</select><br>

	     <label>Birth Date</label>
	     <input name="dob" type="date"  id="dob" /><br>

		<label>Age</label>
		<input name="txtAge" type="text" readonly="readonly" id="txtAge" /><br>

		<label>Occupation</label>
		<input name="txtJob" type="text"  id="txtJob" /><br>

		<label >Blood Group </label>
		<select name="bloodGroup" id="bloodGroup">
		<option >-Blood Group-</option>
		<option value="O Positive">O Positive</option>
		<option value="O Negative">O Negative</option>
		<option value="A Positive">A Positive</option>
		<option value="A Negative">A Negative</option>
		<option value="B Positive">B Positive</option>
		<option value="B Negative">B Negative</option>
		<option value="AB Positive">AB Positive</option>
		<option value="AB Negative">AB Negative</option>

	</select><br>

	   <label>Marital Status</label>
	   	<select name="status" id="status">
			<option >-Select Marital Status-</option>
			<option value="Single">Single</option>
			<option value="Married">Married</option>
			<option value="Divorced">Divorced</option>
			<option value="Widowed">Widowed</option>

	    </select>


	 <h3>Contact Details</h3>
	 	<label >Home Address </label>
            <textarea name="homeAdd" rows="2" cols="20" id="homeAdd" ></textarea><br>

    <label >Contact Number  </label>    
	<input name="number" type="text" id="number" /><br>


	<button type="submit" name="btnSubmit" id="btnSubmit" value="save">Save</button>
	</form>
	<form action="RegisterPatient" method="post">
	 <button type="submit" name="btnSubmit" id="btnSubmit" value="cancle">Cancle</button>
	
	</form>

	

</body>
</html>