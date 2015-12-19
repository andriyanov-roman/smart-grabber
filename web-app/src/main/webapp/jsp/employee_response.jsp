<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
    <title>Result</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/company_base"
                   user="root"  password=""/>

<sql:query dataSource="${snapshot}" var="result">
    SELECT * FROM `Employee` WHERE `name` = "<%= pageContext.getRequest().getParameter("name_for_search")%>"
</sql:query>

<table border="1" width="100%">
    <tr>
        <th>Emp ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Salary</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.surname}"/></td>
            <td><c:out value="${row.salary}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>