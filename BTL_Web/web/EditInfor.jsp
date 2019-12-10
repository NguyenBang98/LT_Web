<%-- 
    Document   : EditInfor
    Created on : Dec 6, 2019, 4:41:09 PM
    Author     : vieet
--%>

<%@page import="Model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Edit Information</title>
        <link rel="shortcut icon" type="image/png" href="icon/favicon.png" />
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/EditInfor.css">
    </head>

    <body>

        <%
            HttpSession hs = request.getSession();
            Person p = (Person) hs.getAttribute("users");
            
        %>


        <form action="EditInforServlet" method="post" >
            <div class="popup_edit_background">
                <div class="popup_edit">
                    <h1>Edit Information</h1>
                    <div class="edit1">
                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                        Quote
                        <input type="text" class="input_infor" name="Quotes" value="<%=p.getQuotes()%>">
                    </div>
                    <div class="edit2">
                        <i class="fa fa-briefcase" aria-hidden="true"></i>
                        Works at
                        <input type="text" class="input_infor" name = "work" value="<%=p.getWork()%>">
                    </div>


                    <div class="edit3">
                        <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                        Studied at
                        <input type="text" class="input_infor" name = "study" value="<%=p.getStudy()%>">
                    </div>

                    <div class="edit4">
                        <i class="fa fa-home" aria-hidden="true"></i>
                        Live in
                        <input type="text" class="input_infor" name = "live" value="<%=p.getAddress()%>">
                    </div>

                    <div class="edit5">
                        <img width="15px" height="15px" src="icon/followers.png" alt="follower_icon">
                        Followed by
                        <input type="text" class="input_infor" name = "follow" value="<%=p.getFlower()%>">
                    </div>

                    <div class="edit6">
                        <i class="fa fa-envelope" aria-hidden="true"></i>
                        Email
                        <input type="text" class="input_infor" name = "email" value="<%=p.getEmail()%>">
                    </div>
                    <div class="save_info">
                        <button>Save</button> 

                    </div>


                </div>
            </div>
        </form>
    </body>

</html>
