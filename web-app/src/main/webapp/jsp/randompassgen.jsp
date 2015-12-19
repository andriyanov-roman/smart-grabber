<%@ page import="tldpack.RandomPassGenerator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="random-pass" uri="/WEB-INF/randompasspen.tld"%>
<html>
<head>
  <title>A sample custom tag</title>
</head>
<body>
<form>
<label for="password-field">Your password</label>
<input type="text" name="password" id="password-field" value="<random-pass:pass/>">
  </form>
</body>
</html>
