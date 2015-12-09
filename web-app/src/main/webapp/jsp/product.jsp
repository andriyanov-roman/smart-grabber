<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.net.*" %>
<%@page import="java.util.Date" %>
<html>
<head>
    <title>Product Page</title>
</head>
<body>

<%  InetAddress localHost = InetAddress.getLocalHost();
    Date localTime = new Date();  %>

<h1>Who Am I</h1>

I am colled <%= localHost.getHostName()%> (<%= localHost.getHostAddress()%>).
<br> This page last executed at <%= localTime.toString()%>
</body>
</html>
