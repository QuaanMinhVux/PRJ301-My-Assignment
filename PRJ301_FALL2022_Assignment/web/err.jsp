<%-- 
    Document   : err.jsp
    Created on : Nov 9, 2022, 11:09:16 AM
    Author     : MSI_GF63
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@600;900&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/4b9ba14b0f.js" crossorigin="anonymous"></script>
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet"/>
        <style>
            .mainbox{
                margin-top: 10%;
                text-align: center;

            }
        </style>
    </head>
    <body>
        <div class="mainbox">
            4<i class="far fa-question-circle fa-spin"></i>4
            <div class="msg">
                Cant Found This Page
            </div>
        </div>
</html>
