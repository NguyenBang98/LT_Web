<%-- 
    Document   : FogetPass
    Created on : Dec 9, 2019, 5:27:15 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Reset</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/forgetPass.css">
        <link rel="shortcut icon" type="image/png" href="icon/favicon.png" />
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
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

        <div class = "container_form">
            <form class = "find_acount" action="CheckAcount" method="POST">

                <ul class = "list_menu">

                    <li class "title_main">
                        <div>
                            <h2>Find your Ulimited account</h2>
                        </div>
                    </li>

                    <li class = "descrip">
                        <div class="descrip_detail">Enter your email, phone number or username.</div>
                    </li>
                    <li style="margin-bottom: 20px;">
                        <span style="color:red" class="inforLogin">
                            <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
                        </span>
                    </li>
                    <li class = "input_user">
                        <input name="email" class="email" type="text">
                    </li>

                    <li class = "confirn">
                        <button type="submit">Search</button>
                    </li>

                </ul>

            </form>

        </div>
    </body>
</html>
