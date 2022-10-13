<%-- 
    Document   : attendance
    Created on : Oct 13, 2022, 3:01:52 AM
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
        <h3>View Attendance for ${requestScope.student.name}(ID: ${requestScope.student.id})</h3>
        <form action="attendance" method="GET">
            <input type="hidden" name="id" value="${requestScope.student.id}"/>
            Select a group:<select name="subject">
                <c:forEach items="${requestScope.group}" var="g">
                    <option value="${g.group_id}">${g.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Submit"/>
            <c:if test="${!requestScope.session.isEmpty()}">
                <table border="1px">
                    <thead>
                    <th>Date</th>
                    <th>Slot</th>
                    <th>Room</th>
                    <th>Lecture</th>
                    <th>Group Name</th>
                    <th>Attendance Status</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.session}" var="s">
                        <tr>
                            <td>${s.date}</td>
                            <td>${s.slot}</td>
                            <td>${s.room}</td>
                            <td>${s.group.lecture.id}</td>
                            <td>${s.group.name}</td>
                            <td>${s.attendance.status}</td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table><br/>
                You have ${requestScope.absent}% absent so far
                
            </c:if>
        </form>
    </body>
</html>
