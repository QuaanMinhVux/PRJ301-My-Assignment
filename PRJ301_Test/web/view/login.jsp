<%-- 
    Document   : login
    Created on : Nov 3, 2022, 10:15:34 AM
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
        <<form action="login" method="POST">
            Username: <input type="text" name="user"/><br/>
            Password: <input type="password" name="password"/><br/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
