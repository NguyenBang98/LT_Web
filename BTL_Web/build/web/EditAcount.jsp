<%-- 
    Document   : EditAcount
    Created on : Dec 9, 2019, 5:12:16 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container_header">

            <div class="container1">
                <div class="logo">
                    <a href="#">
                        <img src="icon/infinity.jpg" alt="Unlimited">
                    </a>
                </div>

                <div class="title">Edit Profile</div>

            </div>
        </div>
        <div class= "container">
            <div class= "title">
                <h1>Change your information on Unlimited</h1>
            </div>
            <div class = "d1">
                <span>
                    Every on Unlimited will get to know you through the information below
                </span>
            </div>
            <div class = "avatar">
                <span><img src="avata3.jpg" alt="Uchiha Itachi"></span>
                <button>Change</button>
            </div>
            <div class = "name">
                <div class = "b1">
                    <span class = "nametitle">First Name</span>
                    <span class = "inputname"><input type="text"></span>
                </div>
                <div class = "b1">
                    <span class = "nametitle">Last Name</span>
                    <span class = "inputname"><input type="text"></span>
                </div>	
            </div>
            <div class="Email">
                <div class ="b2">
                    <span>Email</span>
                    <span><input type="text" placeholder=".@gmail.com"></span>
                </div>
                <span class = "changeP"><a href="">Change Password</a></span>
            </div>
            <div class = "Introduce">
                <span class = "intro">Introduce your profile</span>
                <span class = "input"><input type="text"></span>
            </div>
            <div class = "confirm">
                <button class = "bt1">Confirm</button>
                <button class = "bt2">Cancel</button>
            </div>
        </div>
    </body>
</html>
