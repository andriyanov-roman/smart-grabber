<%@ taglib prefix="filetag" uri="/WEB-INF/filetag.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: dm
  Date: 13.12.15
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="file" class="tldpack.FileTag" scope="request">
    <jsp:setProperty name="file" property="filename"
                     value="value"/>
</jsp:useBean>

<?xml version="1.0" encoding="Utf-8" ?>

<html>
<head>
    <title>File tld</title>
</head>
<body>

<form name="file" method="POST" action="fileshow.jsp">
    <input type="hidden" name="command" value="file" />
    <input type="text" name="filename" value="file name"  />
    <input type="submit" value="get file" />
</form>

<%--${pageContext.getAttribute('filename')}--%>

<filetag:file filename="${pageContext.getAttribute('filename--')}"/>
<%--<div id="filetag">--%>
    <%--<filetag:file filename=""/>--%>
<%--</div>--%>


</body>
</html>