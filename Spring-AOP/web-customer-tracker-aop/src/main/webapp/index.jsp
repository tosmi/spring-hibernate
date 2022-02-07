<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="TestDbServlet">TestDb Servlet</a>

<!-- Disable this if you want the links above to be visible -->
<% response.sendRedirect("customer/list"); %>
</body>
</html>