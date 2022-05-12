<%-- 
    Document   : second
    Created on : Feb 2, 2022, 4:56:26 PM
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ex6.PersonBean" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello 
            <jsp:useBean id="st" class="ex6.PersonBean" scope="session"></jsp:useBean>
      
        Name    : <jsp:getProperty property="name" name="st"/><br>
        Age     : <jsp:getProperty property="age" name="st"/><br>
        height     : <jsp:getProperty property="hight" name="st"/><br>
            
        </h1>

    </body>
</html>
