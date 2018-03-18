<!DOCTYPE html>
<html>
<head>
	<title>Sing In</title>
</head>
<body>

<form action="login" method="post">
	
		
		<ul>
            <li ><a href="index.jsp">Sign In</li>
            <li><a href="Registration.jsp">Register</a></li>
            
        </ul>


		<h2 class="log-in-title">Please Sign In</h2>
		<h4><font color="red">${massage }</font></h4>

		<label>Email</label>
			<input name="txtName" type="text" id="txtEmail"  /><br>
		<label>Password</label>
			<input name="txtPassword" type="Password" id="txtPassword"  /><br>
		<a href="ForgetPassword.jsp">Forgot Your Password?</a><br>
		<input type="submit" name="btnLogin" id="btnLogin" value="Sign In">





	</form>

</body>
</html>