<%-- 
    Document   : ResetPassWord
    Created on : Dec 9, 2019, 5:30:30 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Reset</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/send_pass.css">
        <link rel="shortcut icon" type="image/png" href="icon/favicon.png" />
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        <%
            Cookie cookie[] = request.getCookies();
            Cookie cook;
            String email = "";
            if (cookie != null) {
                for (int i = 0; i < cookie.length; i++) {
                    cook = cookie[i];
                    if (cook.getName().equalsIgnoreCase("email")) {
                        email += cook.getValue();
                    }

                }
            }
        %>
        <div class="container_header">

            <div class="container">
                <div class="logo">
                    <a href="#">
                        <img src="icon/infinity.png" alt="Unlimited">
                    </a>
                </div>

                <div class="title">Password Reset</div>

            </div>
        </div>

        <div class="container_main">

            <form class = "sendcode" action="SendPassServlet" method= "POST" >

                <ul>
                    <li class="title_big">
                        <div class="text1">

                            <h2>How do you want to reset your password?</h2>
                        </div>
                    </li>

                    <li class="title_small">
                        <div class="text2">
                            We found the following information associated with your account.
                        </div>
                    </li>

                    <li class="option">

                        <div class="detail_option">

                            <input type="radio" name="gender" class="checker" value="text">
                            <label for="text">Text a code to my phone ending in <strong>51</strong>.</label>

                        </div>

                    </li>
                    <li class="option2">
                        <div class="detail_option">
                            <input type="radio" name="gender" class="checker" value="text2">
                            <label for="text2">Email a link to <strong><%=email%></strong>.</label>

                        </div>
                    </li>
                    <!--<form class = "sendcode" action="NewServlet" method= "GET" >-->
                    <li class="button" >
                        <button name="email" value = "<%=email%>" type = "submit">Continue</button>
                    </li>
                    <!--</form>-->
                    <li class="link">
                        <div class="more_inf">
                            <a href="">I don't have access to any of these</a>
                        </div>
                    </li>
                </ul>


            </form>

        </div>
    </body>

</html>
