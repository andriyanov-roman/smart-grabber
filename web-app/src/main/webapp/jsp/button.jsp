<%--
  Created by IntelliJ IDEA.
  User: alisa
  Date: 13/12/15
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password</title>
</head>
<body>
<form action="/jsp/randompassgen.jsp" method="post">
    <label for="password-field">Your password</label>
    <input type="password" name="password" id="password-field">
    <input type="submit" value="Generate">
    </form>
</body>
</html>
