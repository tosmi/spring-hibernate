<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<form:form action="${pageContext.request.contextPath}/logout"
           method="post">
    <input type="submit" value="Logout"/>

</form:form>

</body>
</html>