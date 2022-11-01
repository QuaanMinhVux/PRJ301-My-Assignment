 <%-- 
    Document   : timetable
    Created on : Oct 16, 2022, 11:46:51 PM
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
        <p>ID: ${requestScope.lecture.id}</p>
        <p>Name: ${requestScope.lecture.name}</p>
        <p>Role: Lecture</p>
        <p>Week:
        <form action="timetable" method="POST">
            <input type="hidden" name="id" value="${param.id}"/>
            <select name="week">
                <c:forEach items="${requestScope.week}" var="w">
                    <option value="${w.id}" <c:if test="${requestScope.now eq w.week}">selected="selected"</c:if>>${w.from} to ${w.to}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Submit"/>
        </form>
            
        <table border="1px">
            <thead>
                <tr>
                    <th rowspan="2">Slot</th>
                    <th>Monday</th>
                    <th>Tuesday</th>
                    <th>Wednesday</th>
                    <th>Thursday</th>
                    <th>Friday</th>
                    <th>Saturday</th>
                    <th>Sunday</th>
                </tr>
                <tr>
                    <c:forEach items="${requestScope.day}" var="d">
                        <th>${d}</th>
                        </c:forEach>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" begin="1" end="7">
                    <tr>
                        <td>Slot ${i}</td>
                        <c:forEach items="${requestScope.day}" var="d">
                            <td>
                                <c:forEach items="${requestScope.lecture.group}" var="g">
                                    <c:forEach items="${g.sessions}" var="s">
                                        <c:if test="${s.date eq d}">
                                            <c:if test="${s.t.id eq i}">
                                                <a href="../student/attendance?id=${g.id}">${g.subject.name} at ${s.room.name}</a>     
                                            </c:if>
                                        </c:if>	 
                                    </c:forEach>
                                </c:forEach>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="../logout">Log Out</a>
    </body>
</html>
