<%-- 
    Document   : valid
    Created on : 23-Feb-2022, 8:04:08 AM
    Author     : arjun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
        <link rel="stylesheet" type="tsxt/css" href="style.css"/>
        <title>validation Page</title>
    </head>
    <body>
        <sql:setDataSource var="ds" driver="org.postgresql.Driver"
                           url="jdbc:postgresql://localhost:5432/postgres"
                           user="postgres" password="shree9592"/>
        <c:set var="username" value="${param.uname}" scope="session"/>
        <c:set var="password" value="${param.password}"  scope="session"/>
        <sql:query dataSource="${ds}" var="result">
            SELECT * from ajt.students where username=? and password=?
            <sql:param value="${username}"/>
            <sql:param value="${password}"/>
        </sql:query>
        <c:if test="${result.rowCount > 0}">
            <h1>Hello <c:out value="${username}"/>!</h1>
            <div>edit Detail</div>
            <c:forEach var="st" items="${result.rows}"> 
            <form action="edit.jsp" method="POST">
                <input type="text" name="uname" id="uname" value="${username}" readonly>
                <input type="text" name="email" value="${st.email}" placeholder="email">
                <input type="text" name="address" value="${st.address}" placeholder="address" >
                <input type="text" name="contact" value="${st.contact}" placeholder="contact number">
                <input type="password" name="password" value="${st.password}" placeholder="password" >
                <input type="submit" value="SUBMIT" name="submitButton">
                <!--<script>alert("entered");</script>-->
            </form>
            </c:forEach>
          

        </c:if>
    </body>
</html>
