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
                            <th>Absent</th>
                            <th>Present</th>
                            <th>Comment</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Vu Minh Quan</td>
                            <td><input type="radio"/></td>
                            <td><input type="radio"/></td>
                            <td><input type="text"/></td>
                        </tr>
                        
                    </tbody>
                </table>
                <input type="submit" value="Submit"/>
            </form>
                
</form>
    </body>
</html>
