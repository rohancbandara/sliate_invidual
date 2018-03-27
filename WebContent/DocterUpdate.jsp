<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Docter Details</title>
</head>
<body>
<% if(session.getAttribute("username")==null){
	response.sendRedirect("index.jsp");
}

%>
<h3>Welcome :${username }        <a href="login">logout</a></h3>
<%=session.getAttribute("dID")%>

<h3>Basic Info</h3>
		 <label >Email </label>
            <input name="txtEmail" type="text" id="txtEmail"  placeholder="Email" /><br>
		 <label >First Name </label>
            <input name="txtFname" type="text" id="txtFname"  placeholder="First Name" /><br>
         <label >Last Name </label>
            <input name="txtLname" type="text" id="txtLname"  placeholder="Last Name" /><br>
         <label >Special </label>
            <select name="special" id="special" >
				<option value="">sss</option>
			</select><br>


</body>
</html>