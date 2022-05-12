<%-- 
    Document   : edit
    Created on : 23-Feb-2022, 12:42:51 PM
    Author     : arjun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
        <link rel="stylesheet" type="text/css" href="style.css"> 
        <title>Edit details</title>

    </head>
    <body>
        <sql:setDataSource var="ds" driver="org.postgresql.Driver"
                           url="jdbc:postgresql://localhost:5432/postgres"
                           user="postgres" password="shree9592"/>

        <c:set var="password" value="${param.password}"  scope="session"/>

        password ${password}
        <hr>contact Number  : ${param.contact}
        <hr>Email : ${param.email}
        <hr>address : ${param.address}
        <hr>user name : ${param.uname}
        
        
           
                <sql:update dataSource="${ds}" var="result">
                    UPDATE ajt.students SET password = ?,address= ?,contact=?,email=? WHERE username = ?
                    <sql:param value="${password}"/>
                    <sql:param value="${param.address}"/>
                    <sql:param value="${Long.parseLong(param.contact)}"/>
                    <sql:param value="${param.email}"/>
                    <sql:param value="${param.uname}"/>
                </sql:update>
                <hr>
                <div><h2> your details change succesfully </h2></div>
                <hr>
            


          
      
    </body>
</html>
