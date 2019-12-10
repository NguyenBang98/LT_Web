<%-- 
    Document   : ConfirmCode
    Created on : Dec 9, 2019, 11:34:59 PM
    Author     : vieet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Password Reset</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Unlimited</title>
        <link rel="stylesheet" type="text/css" href="css/ConfirmCode.css">
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

                <div class="title">Confirm Code</div>

            </div>
        </div>

        <div class = "container_form">
            <form action="ConfirmCodeServlet" method="post" >

                <ul class = "list_menu">

                    <li class = "title_main">
                        <div>
                            <h2>Finish creating your account</h2>
                        </div>
                    </li>

                    <li class = "descrip">
                        <div class="descrip_detail">Enter the code we send to your email.</div>
                    </li>

                    <li class = "input_user">
                        <input type="text" name = "enter_code">
                    </li>

                    <li class = "confirn">
                        <button type="submit">Confirm</button>
                    </li>
                </ul>

            </form>

        </div>

    </body>

</html>
