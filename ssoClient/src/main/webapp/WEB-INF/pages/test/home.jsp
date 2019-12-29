<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2018/1/1
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homeJsp</title>
</head>
<body>
spring com.mvc successful
<br/>
<form>
    <table>
        <c:forEach var="dept" items="${depts}">
            <tr>
                <td>${dept.deptNo}</td>
                <td>${dept.deptName}</td>
                <td>${dept.location}</td>
            </tr>
        </c:forEach>

    </table>
</form>
<br/>
<a href="${ctx}/login/checkin">test</a>
</body>
</html>
