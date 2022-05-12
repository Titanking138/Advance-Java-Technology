<%-- 
    Document   : main
    Created on : Feb 2, 2022, 1:30:32 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css"/>
        <title>User Register</title>
    </head>
    <body>
       <div class="SignInContaier">
            <div class="column">
                <div class="header">
                    <h3>Sign In</h3>
                    <span>Continue to Result Portal </span>
                </div>
                <form action="Login" method="POST" >
                    <input type="text" name="username" id="username" placeholder="Username" >
                    <input type="password" name="password" id="password" placeholder="Password" >
                    <input type="submit" value="SUBMIT" name="submitButton">
                    <!--<script>alert("entered");</script>-->
                </form>
                <!--<span> have account ? Make one <a href="" class="signInMessage">here</a></span>-->
            </div>
        </div>
    </body>
</html>
