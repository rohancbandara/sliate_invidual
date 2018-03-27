<%@page import="java.sql.ResultSet"%>
<%@page import="com.rcb.dbconnection.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/showImage.js" type="text/javascript"></script>
     
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
 <form action="addDocter" method="post" enctype="multipart/form-data">
    
        <h3>Welcome :${username }        <a href="login">logout</a></h3><br>
            <h3>Basic Info</h3>
		 <label >Upload Image </label> <br>
		   <img id="blah" src="#" alt="your image" /> 
           <input type="file" name="file" onchange="readURL(this);" /><br>
            
		 <label >Email </label>
            <input name="txtEmail" type="text" id="txtEmail"  placeholder="Email" /><br>
		 <label >First Name </label>
            <input name="txtFname" type="text" id="txtFname"  placeholder="First Name" /><br>
         <label >Last Name </label>
            <input name="txtLname" type="text" id="txtLname"  placeholder="Last Name" /><br>
         <label >Special </label>
            <select name="special" id="special" >
				
				
				<%
				DbConnection db=new DbConnection();
				String sql="SELECT * FROM tbl_special";
				try{
					ResultSet rs=db.getData(sql);
					while(rs.next()){
						String special=rs.getString("sp_name");
						int v=rs.getInt("sp_id");
						%>
						<option value="<%=v%>"><%=special %></option>
						<%
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				%>
				

			</select><br>
         
         <button type="submit" name="btnSubmit" id="btnSubmit" value="save">Register</button>   
          <button type="submit" name="btnSubmit" id="btnSubmit" value="list">Show Docters</button>     
               
               
          
</form>
</body>
</html>