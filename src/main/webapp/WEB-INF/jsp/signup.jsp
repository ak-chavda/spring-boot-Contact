<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
  <title>Signup Form</title>
  <style>
    .error {
      color: red;
    }
  </style>
</head>

<body>
  <form:form action="process_signup" modelAttribute="signup">
    
	<form:errors path="" cssClass="error" />
    
	<h3>Sign Up Form</h3>

    User name:
    <form:input path="username" id="username" />

    Email id:
    <form:input path="emailid" id="emailid" />
	
    Phone No:
    <form:input path="phoneno" id="phone" />
    
	Password:
    <form:input path="password" id="password" />

    <input type="submit" value="submit" />
  </form:form>

  <a href="/show_signin">Signin</a>
</body>

</html>