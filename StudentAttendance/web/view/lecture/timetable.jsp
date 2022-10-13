<%-- 
    Document   : timetable
    Created on : Oct 13, 2022, 5:50:11 AM
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
        ID: ${requestScope.lecture.id}<br/>
        Role: ${requestScope.role}<br/>
        <form action="timetable" method="GET">
            <input type="hidden" name="flag" value="1"/>
            <input type="hidden" name="id" value="${requestScope.lecture.id}"/>
            <input type="hidden" name="role" value="${requestScope.role}"/>
            Year: <select name="year">
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022" selected="selected">2022</option>
            </select>
            Week: <select name="week">
                <c:forEach items="${requestScope.week}" var="w">
                    <option value="${w.week}" <c:if test="${requestScope.now eq w.week}">selected="selected"</c:if>>${w.from} - ${w.to}</option>
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
                    <td>Slot 1</td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(0)}">
                                <c:if test="${s.slot eq 1}">
                                    ${s.name} at ${s.room} 
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(1)}">
                                <c:if test="${s.slot eq 1}">
                                    ${s.name} at ${s.room}
                                   <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(2)}">
                                <c:if test="${s.slot eq 1}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(3)}">
                                <c:if test="${s.slot eq 1}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(4)}">
                                <c:if test="${s.slot eq 1}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(5)}">
                                <c:if test="${s.slot eq 1}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(6)}">
                                <c:if test="${s.slot eq 1}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>Slot 2</td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(0)}">
                                <c:if test="${s.slot eq 2}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(1)}">
                                <c:if test="${s.slot eq 2}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(2)}">
                                <c:if test="${s.slot eq 2}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(3)}">
                                <c:if test="${s.slot eq 2}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(4)}">
                                <c:if test="${s.slot eq 2}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(5)}">
                                <c:if test="${s.slot eq 2}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(6)}">
                                <c:if test="${s.slot eq 2}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>Slot 3</td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(0)}">
                                <c:if test="${s.slot eq 3}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(1)}">
                                <c:if test="${s.slot eq 3}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(2)}">
                                <c:if test="${s.slot eq 3}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(3)}">
                                <c:if test="${s.slot eq 3}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(4)}">
                                <c:if test="${s.slot eq 3}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(5)}">
                                <c:if test="${s.slot eq 3}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(6)}">
                                <c:if test="${s.slot eq 3}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>Slot 4</td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(0)}">
                                <c:if test="${s.slot eq 4}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(1)}">
                                <c:if test="${s.slot eq 4}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(2)}">
                                <c:if test="${s.slot eq 4}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(3)}">
                                <c:if test="${s.slot eq 4}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(4)}">
                                <c:if test="${s.slot eq 4}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(5)}">
                                <c:if test="${s.slot eq 4}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(6)}">
                                <c:if test="${s.slot eq 4}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>Slot 5</td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(0)}">
                                <c:if test="${s.slot eq 5}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(1)}">
                                <c:if test="${s.slot eq 5}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(2)}">
                                <c:if test="${s.slot eq 5}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(3)}">
                                <c:if test="${s.slot eq 5}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(4)}">
                                <c:if test="${s.slot eq 5}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(5)}">
                                <c:if test="${s.slot eq 5}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(6)}">
                                <c:if test="${s.slot eq 5}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>Slot 6</td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(0)}">
                                <c:if test="${s.slot eq 6}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(1)}">
                                <c:if test="${s.slot eq 6}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(2)}">
                                <c:if test="${s.slot eq 6}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(3)}">
                                <c:if test="${s.slot eq 6}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(4)}">
                                <c:if test="${s.slot eq 6}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(5)}">
                                <c:if test="${s.slot eq 6}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.session}" var="s">
                            <c:if test="${s.date eq requestScope.day.get(6)}">
                                <c:if test="${s.slot eq 6}">
                                    ${s.name} at ${s.room}
                                    <c:forEach items="${requestScope.attendance}" var="a">
                                        <c:if test="${a.session_id eq s.id}">
                                            (${a.status})
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </tbody>
        </table>
            <a href="attendance?id=${requestScope.lecture.id}">Take attendance</a>
    </body>
</html>
