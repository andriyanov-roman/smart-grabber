<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: dm
  Date: 13.12.15
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="filetag" uri="/WEB-INF/filetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="file" class="tldpack.FileTag" scope="request">
    <jsp:setProperty name="file" property="filename"
                     value="value"/>
</jsp:useBean>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File show</title>




</head>
<body>
<%
    Enumeration paramNames = request.getParameterNames();

    while(paramNames.hasMoreElements()) {
        String paramName = (String)paramNames.nextElement();
        out.print("<tr><td>" + paramName + "</td>\n");
        String paramValue = request.getParameter(paramName);
        out.println("<td> " + paramValue + "</td></tr>\n");
    }

    String fileName = request.getParameter("filename");
%>
<%--<c:set var="fname" scope="session" value="${fileName}"/>--%>
<div id="el">
    ${pageContext.getAttribute('filename')}
</div>
<div id="filetag">
    <filetag:file filename="${fileName}"/>
</div>
</body>
</html>
