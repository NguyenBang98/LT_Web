<%-- 
    Document   : Comment
    Created on : Dec 8, 2019, 4:37:09 PM
    Author     : trung
--%>

<%@page import="Controler.PinDAO"%>
<%@page import="Controler.BravoDAO"%>
<%@page import="Model.Post"%>
<%@page import="Controler.RelationshipDAO"%>
<%@page import="Model.Person"%>
<%@page import="Model.Comment"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unlimited</title>
        <link rel="shortcut icon" type="image/png" href="icon/favicon.png" />
        <link rel="stylesheet" type="text/css" href="css/comment.css">
        <link rel="stylesheet" type="text/javascript" href="js/cmt.js">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    </head>
    <!--    <script type = "text/javascript">
                function BackPage() {
                    alert();
    //                window.history.back();
                }
            </script>-->

    <body>
        <script src="js/cmt.js"></script>
        <% List<Comment> list = (List) request.getAttribute("listCmt");
            Post post = (Post) request.getAttribute("post");
            Person postP = post.getP();
            RelationshipDAO r = new RelationshipDAO();
            HttpSession hs = request.getSession();
            Person p = (Person) hs.getAttribute("users");
            BravoDAO b = new BravoDAO();
            PinDAO pin = new PinDAO();
        %>
        <div class="main">

            <div class="main-stt">
                <div class="img-stt">
                    <img class="stt" src="<%=post.getUrlImg()%>" alt="error">
                </div>
                <div class="cmt-box">
                    <div class="user">
                        <span class="avata">
                            <img class="imge" src="<%=postP.getAvatar()%>" alt="error">
                        </span>
                        <h4>
                            <%=postP.getFullName()%>
                            <button><%=Utils.CovertRelation.check(r, p.getPersonID(), postP.getPersonID())%></button>
                        </h4>
                        <button class="more" >
                            <i class="fa fa-ellipsis-v" aria-hidden="true"></i>
                        </button>
                    </div>
                    <h5><%=post.getContent()%></h5>
                    <span class="reaction">
                        <span class="funtion">
                            <% String color = Utils.CovertBravo.checkBravo(b, p.getPersonID(), post.getID());%>
                            <button style="color: <%=color%>">
                                <i class="fa fa-sign-language" aria-hidden="true"></i>

                                <span style= "color: <%=color%>"><%=post.getNBravo() + " "%>Bravo</span>
                            </button>
                        </span>

                        <span class="funtion">
                            <button>
                                <i class="fa fa-comment-o" aria-hidden="true"></i>

                                <span>Reaction</span>
                            </button>

                        </span>

                        <span class="funtion">
                            <% String textPin = Utils.CovertPin.checkPin(pin, p.getPersonID(), post.getUrlImg());
                                String colorPin = "";
                                if (textPin.equalsIgnoreCase("Pined")) {
                                    colorPin += "#2ecc71";
                                } else {
                                    colorPin += "null";
                                }
                            %>
                            <button style="color: <%=colorPin%>">
                                <i class="fa fa-thumb-tack" aria-hidden="true" style="color: <%=colorPin%>"></i>
                                <span><%= textPin%></span>
                            </button>
                        </span>
                    </span>
                    <div class="box-cmt">
                        <div class="list-cmt">
                            <ul>
                                <% for (Comment cmt : list) {%>
                                <li>
                                    <div class="user">
                                        <span class="bg-img">
                                            <img class="imgs" src="<%=cmt.getPerson().getAvatar()%>" alt="error">
                                        </span>
                                        <div class="comment-cmt">
                                            <a class="name"><%=cmt.getPerson().getFullName()%></a>
                                            <span class="post"><%=cmt.getContent()%></span>
                                        </div>
                                    </div>
                                </li>
                                <%}%>             

                            </ul>
                        </div>
                        <div class="answer">
                            <div class="bg-img">
                                <img class="imgs" src="<%=p.getAvatar()%>" alt="error">
                            </div>
                            <div class="post-cmt-sec">

                                <input  id = "content" class="rep" type="text" placeholder="Add a comment...">
                                <button value="<%=post.getID()+" " + p.getPersonID()%>" id = "postCmt" onclick="PostComment()">Post</button>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <span class="close">
                <button onclick="backPage()">
                    <i class="fa fa-times" aria-hidden="true"></i>
                </button>
            </span>
        </div>

    </body>


</html>