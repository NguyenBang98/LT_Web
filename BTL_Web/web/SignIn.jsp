<%-- 
    Document   : SignIn
    Created on : Dec 2, 2019, 1:45:29 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Unlimited - Sign In</title>

        <link rel="shortcut icon" type="image/png" href="icon/favicon.png" />

        <link rel="stylesheet" type="text/css" href="css/singIn.css">
    </head>

    <body>

        <script src="js/signIn.js"></script>
        <div class="limited">
            <div class="login">

                <span class="title">
                    <h1>Welcome</h1>
                </span>
                <span class="avatar">
                    <img src="icon/avatar-01.jpg" alt="Avatar" height="120" weight="120">
                </span>

                <span style="color:red" class="inforLogin">
                    <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
                </span>

                <form action="SignIn" method="post" onsubmit="return validateForm()">
                    <div class="input_user">
                        <input class="username" type="text" placeholder="Username" value="" name = "username">
                    </div>

                    <div class="input_user">
                        <input class="password" type="password" placeholder="Password" value="" name = "password">
                    </div>

                    <div class="button_login">
                        <button class="btn_login" onclick="validateForm()">LOGIN</button>
                    </div>
                </form>
                <ul class="login_more">
                    <li class="link_1">
                        <span class="txt1">
                            Forgot
                        </span>
                        <a href="/BTL_Web/FogetPass.jsp" class="txt2"> Username / Password?</a>
                    </li>
                    <li class="link_2">
                        <span class="txt1">
                            Don’t have an account?
                        </span>
                        <a class="txt2" href="/BTL_Web/Register.jsp">Sign up</a>
                    </li>
                </ul>
            </div>
        </div>
    </body>

</html>