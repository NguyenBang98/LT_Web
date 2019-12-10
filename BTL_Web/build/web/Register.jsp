<%-- 
    Document   : Register
    Created on : Nov 20, 2019, 10:18:06 AM
    Author     : vieet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title> Unlimited - Register </title>
        <link rel="shortcut icon" type="image/png" href="icon/favicon.png" />

        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/Register.css">

    </head>

    <body>

        <%
            String username_err = "", email_err = "", password_err = "", repassword_err = "", check_pass = "", check_email = "", check_username_same = "", check_email_same = "";
            if (request.getAttribute("username_err") != null) {
                username_err = (String) request.getAttribute("username_err");
            }
            if (request.getAttribute("email_err") != null) {
                email_err = (String) request.getAttribute("email_err");
            }
            if (request.getAttribute("password_err") != null) {
                password_err = (String) request.getAttribute("password_err");
            }
            if (request.getAttribute("repassword_err") != null) {
                repassword_err = (String) request.getAttribute("repassword_err");
            }
            if (request.getAttribute("check_pass") != null) {
                check_pass = (String) request.getAttribute("check_pass");
            }
            if (request.getAttribute("check_email") != null) {
                check_email = (String) request.getAttribute("check_email");
            }

            if (request.getAttribute("check_username_same") != null) {
                check_username_same = (String) request.getAttribute("check_username_same");
            }
            if (request.getAttribute("check_email_same") != null) {
                check_email_same = (String) request.getAttribute("check_email_same");
            }
        %>

        <script src="JS/Register.js"></script>
        <%--action gan ten class Servlet ma no bi lay gia tri --%>
        <form action="RegisterDAO" method="post" onsubmit="validateForm()">
            <div class="main_title">
                <h2> Sign Up </h2>
            </div>



            <div class="form_group">

                <ul style="list-style-type: none;">
                    <li id="user_name">

                        <p style="color: red"> <%= username_err%>  </p>
                        <p style="color: red"> <%= check_username_same%>  </p>

                        <i class="fa fa-user-circle-o" aria-hidden="true"></i>
                        <input type="text" placeholder="Your Name" id="name_user" size="33" value="" name = "username">


                    </li>

                    <li id="user_mail">
                        <p style="color: red"> <%= email_err%>  </p>
                        <p style="color: red"> <%= check_email%>  </p>
                        <p style="color: red"> <%= check_email_same%>  </p>

                        <i class="fa fa-envelope" aria-hidden="true"></i>
                        <input type="email" name="email" id="email" placeholder="Your Email" size="33">
                    </li>

                    <li id="pass">
                        <p style="color: red"> <%= password_err%>  </p>
                        <i class="fa fa-lock" aria-hidden="true"></i>
                        <input type="password" name="password" id="password" placeholder="Password" size="33">
                    </li>

                    <li id="repass">
                        <p style="color: red"> <%= repassword_err%>  </p>
                        <p style="color: red"> <%= check_pass%>  </p>

                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                        <input type="password" name="repassword" id="repassword" placeholder="Repeat Your Password" size="33">
                    </li>

                    <!--                    <li id="check_box">
                                            <input type="checkbox" id="label02" name="label02" value="" />
                                            I agree all statements in <a href="#" class="term-service">Terms of service</a>
                                        </li>-->
                    <li id="button_register">
                        <button> Register</button>
                    </li>

                </ul>

            </div>


            <div class="img_group">
                <img src="icon/signup-image.jpg" alt="img_back">
            </div>
            <div class="back_login">
                <a href="SignIn.jsp" target="_blank">I am already member</a>
            </div>
        </form>

    </body>

</html>

