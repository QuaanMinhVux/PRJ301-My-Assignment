<%-- 
    Document   : attendance
    Created on : Oct 13, 2022, 6:00:41 AM
    Author     : MSI_GF63
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Lecture ${requestScope.id} take attendance</h2> 
        <form action="attendance" method="GET">
            <input type="hidden" name="id" value="${requestScope.student.id}"/>
            Select a group:<select name="subject">
                <option value="1">IOT1601_PRJ301</option>
            </select>
            <input type="submit" value="Submit"/>
        </form>
        <form>
            <table border="1px">
                <thead>
                    <tr>
                        <th>Student's name</th>                         
                        <th>Day</th>
                        <th>Slot</th>
                        <th>Status</th>
                        <th>Comment</th>
                        <th>Taker</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Student</td>
                        <td>dd-MM-yyyy</td>
                        <td>Slot 1</td>
                        <td><input type="radio"/> Present <input type="radio"/> Absent</td>
                        <td><input type="text"/></td>
                        <td>SonNT5</td>
                </tr>
                <tr>
                    <td>Student</td>
                    <td>dd-MM-yyyy</td>
                    <td>Slot 1</td>
                    <td><input type="radio"/> Present <input type="radio"/> Absent</td>
                    <td><input type="text"/></td>
                    <td>SonNT5</td>
                </tr>
                <tr>
                    <td>Student</td>
                    <td>dd-MM-yyyy</td>
                    <td>Slot 1</td>
                    <td><input type="radio"/> Present <input type="radio"/> Absent</td>
                    <td><input type="text"/></td>
                    <td>SonNT5</td>
                </tr>
                <tr>
                    <td>Student</td>
                    <td>dd-MM-yyyy</td>
                    <td>Slot 1</td>
                    <td><input type="radio"/> Present <input type="radio"/> Absent</td>
                    <td><input type="text"/></td>
                    <td>SonNT5</td>
                </tr>
                <tr>
                    <td>Student</td>
                    <td>dd-MM-yyyy</td>
                    <td>Slot 1</td>
                    <td><input type="radio"/> Present <input type="radio"/> Absent</td>
                    <td><input type="text"/></td>
                    <td>SonNT5</td>
                </tr>
                <tr>
                    <td>Student</td>
                    <td>dd-MM-yyyy</td>
                    <td>Slot 1</td>
                    <td><input type="radio"/> Present <input type="radio"/> Absent</td>
                    <td><input type="text"/></td>
                    <td>SonNT5</td>
                </tr>
                </tbody>
            </table>
            <input type="submit" value="Submit"/>
        </form>

    </form>
</body>
</html>
