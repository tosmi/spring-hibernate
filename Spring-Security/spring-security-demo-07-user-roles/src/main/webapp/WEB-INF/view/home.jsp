<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="us">

<head>
    <title>
        stderr.at Company Home Page
    </title>
</head>

<body>
<h2>stderr.at Company Home Page</h2>

<p>Welcome to the stderr.at Company Homepage!</p>

<hr>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>

<hr>

<p>
    <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
    (Only for Manager peeps)
</p>

<hr>

<form:form action="${pageContext.request.contextPath}/logout"
           method="post">
    <input type="submit" value="Logout"/>

</form:form>
</body>
</html>