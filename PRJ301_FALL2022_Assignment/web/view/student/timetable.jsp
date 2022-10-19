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
        <p>ID: ${requestScope.student.id}</p>
        <p>Name: ${requestScope.student.name}</p>
        <p>Role: Student</p>
        <p>Week:
        <form action="timetable" method="GET">
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
                <tr>
                    <td>
                        Slot 1
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(0)}">
                                    <c:if test="${s.t.id eq 1}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(1)}">
                                    <c:if test="${s.t.id eq 1}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(2)}">
                                    <c:if test="${s.t.id eq 1}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(3)}">
                                    <c:if test="${s.t.id eq 1}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(4)}">
                                    <c:if test="${s.t.id eq 1}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(5)}">
                                    <c:if test="${s.t.id eq 1}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(6)}">
                                    <c:if test="${s.t.id eq 1}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td>
                        Slot 2
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(0)}">
                                    <c:if test="${s.t.id eq 2}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(1)}">
                                    <c:if test="${s.t.id eq 2}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(2)}">
                                    <c:if test="${s.t.id eq 2}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(3)}">
                                    <c:if test="${s.t.id eq 2}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(4)}">
                                    <c:if test="${s.t.id eq 2}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(5)}">
                                    <c:if test="${s.t.id eq 2}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(6)}">
                                    <c:if test="${s.t.id eq 2}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td>
                        Slot 3
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(0)}">
                                    <c:if test="${s.t.id eq 3}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(1)}">
                                    <c:if test="${s.t.id eq 3}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(2)}">
                                    <c:if test="${s.t.id eq 3}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(3)}">
                                    <c:if test="${s.t.id eq 3}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(4)}">
                                    <c:if test="${s.t.id eq 3}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(5)}">
                                    <c:if test="${s.t.id eq 3}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(6)}">
                                    <c:if test="${s.t.id eq 3}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td>
                        Slot 4
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(0)}">
                                    <c:if test="${s.t.id eq 4}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(1)}">
                                    <c:if test="${s.t.id eq 4}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(2)}">
                                    <c:if test="${s.t.id eq 4}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(3)}">
                                    <c:if test="${s.t.id eq 4}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(4)}">
                                    <c:if test="${s.t.id eq 4}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(5)}">
                                    <c:if test="${s.t.id eq 4}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(6)}">
                                    <c:if test="${s.t.id eq 4}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td>
                        Slot 5
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(0)}">
                                    <c:if test="${s.t.id eq 5}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(1)}">
                                    <c:if test="${s.t.id eq 5}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(2)}">
                                    <c:if test="${s.t.id eq 5}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(3)}">
                                    <c:if test="${s.t.id eq 5}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(4)}">
                                    <c:if test="${s.t.id eq 5}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(5)}">
                                    <c:if test="${s.t.id eq 5}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(6)}">
                                    <c:if test="${s.t.id eq 5}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td>
                        Slot 6
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(0)}">
                                    <c:if test="${s.t.id eq 6}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(1)}">
                                    <c:if test="${s.t.id eq 6}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(2)}">
                                    <c:if test="${s.t.id eq 6}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(3)}">
                                    <c:if test="${s.t.id eq 6}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(4)}">
                                    <c:if test="${s.t.id eq 6}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(5)}">
                                    <c:if test="${s.t.id eq 6}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${requestScope.student.group}" var="g">
                            <c:forEach items="${g.sessions}" var="s">
                                <c:if test="${s.date eq requestScope.day.get(6)}">
                                    <c:if test="${s.t.id eq 6}">
                                        <a href="#">${g.subject.name} at ${s.room.name}</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
