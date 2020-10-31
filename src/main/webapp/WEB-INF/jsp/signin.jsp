<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
    <title>Sigin Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>

<body>
    <form:form action="process_login" modelAttribute="signin">
        <h3>Sign In</h3>
        <div class="error">${error}</div>
        <form:input path="userName" />
        <form:password path="password" />
        <input type="submit" value="submit" />
    </form:form>

    <a href="/show_signup">Signup</a>
</body>

</html>