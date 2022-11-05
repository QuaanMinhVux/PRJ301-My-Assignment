<%-- 
    Document   : attreport
    Created on : Nov 5, 2022, 9:18:11 AM
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
                width: 100%;
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
            <p>Group ID: ${requestScope.group.id}</p>
            <p>Group Name: ${requestScope.group.name}</p>
            <p>Subject: ${requestScope.group.subject.name}</p>
        </div>
        <table id="customers" border="1px">
            <thead>
                <tr>
                    <th>-</th>
                        <c:forEach items="${requestScope.group.students.get(0).att}" var="a">
                        <th>${a.session.date}</th>
                        </c:forEach>
                    <th>Total absent</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.group.students}" var="s">
                    <tr>
                        <td>${s.name} - ID: ${s.id}</td>
                        <c:forEach items="${s.att}" var="a">
                            <td>
                                <c:if test="${a.session.attended}">
                                    <c:if test="${a.present}">
                                        P
                                    </c:if>
                                    <c:if test="${!a.present}">
                                        A
                                    </c:if>
                                </c:if>
                                <c:if test="${!a.session.attended}">
                                    F
                                </c:if>       
                            </td>

                        </c:forEach> 
                        <td>${Math.round(s.absent / requestScope.group.subject.slot * 100)} %</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p id="div">P: Present, A: Absent, F: Future</p>
    </body>
</html>
