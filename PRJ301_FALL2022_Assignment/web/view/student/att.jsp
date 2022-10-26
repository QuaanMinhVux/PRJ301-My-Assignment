<%-- 
    Document   : att
    Created on : Oct 27, 2022, 12:59:49 AM
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
        <p>Attendance report</p>
        <p>Student: ${sessionScope.account.student.name}</p>
        <p>Subject:  ${requestScope.group.subject.name}</p>
        <p>Group: ${requestScope.group.name}</p>
        <p>Lecture: ${requestScope.group.lecture.name}</p>
        <table border="1px">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Slot</th>
                    <th>Room</th>
                    <th>Attendance status</th>
                    <th>Comment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.group.sessions}" var="s">
                    <tr>
                        <td>${s.date}</td>
                        <td>${s.t.from}-${s.t.to}</td>
                        <td>${s.room.name}</td>
                        <c:if test="${s.attended}">
                            <c:if test="${s.att.get(0).present}">
                                <td>Present</td>
                            </c:if>
                            <c:if test="${!s.att.get(0).present}">
                                <td>Absent</td>
                            </c:if>
                        </c:if>
                        <c:if test="${!s.attended}">
                            <td>Future</td>
                        </c:if>
                        <c:if test="${s.att.get(0).description ne null}">
                            <td>${s.att.get(0).description}</td>
                        </c:if>
                        <c:if test="${s.att.get(0).description eq null}">
                            <td></td>
                        </c:if>    
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>Absent: ${Math.round((requestScope.absent / requestScope.group.subject.slot * 100))}% so far (${requestScope.absent} on ${requestScope.group.subject.slot} total) </p>
    </body>
</html>
