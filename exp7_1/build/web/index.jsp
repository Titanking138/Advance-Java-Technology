<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>login form</title>
        <link rel="stylesheet" type="text/css" href="style.css"> 
    </head>
    <body>
        <div class="SignInContaier">
            <div class="column">
                <div class="header">
                    <h3>Sign In</h3>
                    <span>Continue to Result Portal </span>
                </div>
                <form action="valid.jsp" method="POST">
                    <input type="text" name="uname" id="uname" placeholder="uname" >
                    <input type="password" name="password" id="password" placeholder="Password" >
                    <input type="submit" value="SUBMIT" name="submitButton">
                    <!--<script>alert("entered");</script>-->
                </form>
                <!--<span> have account ? Make one <a href="" class="signInMessage">here</a></span>-->
            </div>
        </div>
    </body>
</html>