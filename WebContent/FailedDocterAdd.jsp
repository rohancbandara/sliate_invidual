<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.rcb.dbconnection.DbConnection"%>
<html>
<head>
	<title>Add Docter</title>
	
      
</head>
<body>

<h3>Welcome :${username }        <a href="login">logout</a></h3>

<form action="addDocter" method="post">


<img src="Docter_IMG/DSC06689.JPG"
    >


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
		 <button type="submit" name="btnSubmit" id="btnSubmit" value="back">Back</button>


</form>




</body>
</html>