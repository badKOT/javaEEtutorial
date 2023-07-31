<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Testing JSP</h1>
<%--<%@ page import="java.util.Date" %>--%>
<%--<p><%= new Date() %></p>--%>
<a href="hello-world">Hello Servlet</a>

<p>
    <%
        String name = request.getParameter("name");
    %>
    <%= "Hello, " + name %>
</p>
</body>
</html>