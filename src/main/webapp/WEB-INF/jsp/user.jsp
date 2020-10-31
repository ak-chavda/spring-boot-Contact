<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${sessionScope.uname}</title>
</head>



<body>
	<a href="/logout">Logout</a>
	<br/>
	<br/>
	<br/>
	<a href="/all_contacts">View Contact</a>

	<br/>
	<br/>
	<br/>
	<div>Welcome ${sessionScope.uname}</div>
</body>

</html>