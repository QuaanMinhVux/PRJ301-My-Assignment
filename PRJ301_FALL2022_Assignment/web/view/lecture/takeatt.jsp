<%-- 
    Document   : takeatt
    Created on : Nov 2, 2022, 10:43:39 PM
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
        <p>Session id: ${sessionScope.session.id}</p>
        <p>Subject: ${sessionScope.session.group.subject.name}</p>
        <p>Group: ${sessionScope.session.group.name}</p>
        <p>Lecture: ${sessionScope.session.group.lecture.name}</p>
        <p>Room: ${sessionScope.session.room.name}</p>
        <p>Date: ${sessionScope.session.date}</p>
        <p>Click <a href="attreport?id=${sessionScope.session.group.id}">here</a> to show attendence report</p>
        <form action="takeatt" method="POST">
            <table border="1px">
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>Student Name</th>
                        <th>Present</th>
                        <th>Absent</th>
                        <th>Comment</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sessionScope.session.att}" var="a">
                        <tr>
                            <td>${a.student.id}</td>
                            <td>${a.student.name}</td>
                            <td>
                                <input type="radio" <c:if test="${a.present}">checked="checked"</c:if> name="present${a.student.id}" value="present"/>
                            </td>
                            <td>
                                <input type="radio" <c:if test="${!a.present}">checked="checked"</c:if> name="present${a.student.id}" value="absent"/>
                            </td>
                            <td>
                                <input type="text" name="comment${a.student.id}" value="${a.description}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
