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
        <style>
            #customers {
                font-family: Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #customers td, #customers th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #customers tr:nth-child(even){
                background-color: #f2f2f2;
            }

            #customers tr:hover {
                background-color: #ddd;
            }

            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #3333ff;
                color: white;
            }
            #td{
                width: 180px;
            }
            #div {
                font-family: Arial, Helvetica, sans-serif;
                width: 100%;
                align-content: center;
            }
        </style>
    </head>
    <body>
        <div id="div">
            <p>Attendance report</p>
            <p>Student: ${sessionScope.account.student.name}</p>
            <p>Subject:  ${requestScope.group.subject.name}</p>
            <p>Group: ${requestScope.group.name}</p>
            <p>Lecture: ${requestScope.group.lecture.name}</p>
        </div>
        <table id="customers" border="1px">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Date</th>
                    <th>Slot</th>
                    <th>Room</th>
                    <th>Attendance status</th>
                    <th>Comment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.group.sessions}" var="s">
                    <tr id="td">
                        <td>${s.index}</td>
                        <td>${s.date}</td>
                        <td>Slot ${s.t.id} (${s.t.from}-${s.t.to})</td>
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
        <p id="div">Absent: ${Math.round((requestScope.absent / requestScope.group.subject.slot * 100))}% so far (${requestScope.absent} on ${requestScope.group.subject.slot} total) </p>
    </body>
</html>
