<%-- 
    Document   : list.jsp
    Created on : Nov 3, 2022, 10:50:30 AM
    Author     : MSI_GF63
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px">
            <tr>
                <td>did</td>
                <td>dname</td>
            </tr>
            <c:forEach items="${sessionScope.dummy}" var="d">
                <tr>
                    <td>${d.did}</td>
                    <td>${d.dname}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
