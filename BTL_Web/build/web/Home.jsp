<%-- 
    Document   : Home
    Created on : Dec 2, 2019, 3:08:33 PM
    Author     : trung
--%>

<%@page import="Model.Notification"%>
<%@page import="Controler.NotificationDAO"%>
<%@page import="Controler.PinDAO"%>
<%@page import="Controler.BravoDAO"%>
<%@page import="Model.Relation"%>
<%@page import="Utils.CovertRelation"%>
<%@page import="Controler.RelationshipDAO"%>
<%@page import="Model.Person"%>
<%@page import="java.util.List"%>
<%@page import="Model.Post"%>
<%@page import="Controler.LoadHome"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Refresh" content="300">
        <title>Unlimited</title>
        <link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
        <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" type="text/css" href="css/tus.css">
        <link rel="stylesheet" type="text/css" href="css/editPost.css">
        <link rel="stylesheet" type="text/css" href="css/recomend.css">
        <link rel="stylesheet" type="text/css" href="css/popup.css">
        <link rel="stylesheet" type="text/css" href="css/delete.css">
        <link rel="stylesheet" type="text/css" href="css/notification.css">
        <link rel="stylesheet" type="text/css" href="css/more.css">
        <link rel="shortcut icon" type="image/png" href="icon/infinity.png" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>


        <script src="js/home.js">

        </script>

        <% HttpSession hs = request.getSession();
            Person p = (Person) hs.getAttribute("users");
//            List<Post> list = (List) hs.getAttribute("data");
            List<Post> list = Controler.LoadHome.loadPost();
            RelationshipDAO r = new RelationshipDAO();
            BravoDAO b = new BravoDAO();
            PinDAO pin = new PinDAO();
            NotificationDAO n = new NotificationDAO();%>

        <div class="navigation">

            <div id="logo">
                <a href="Home.jsp"><img src="icon/infinity.png" alt="Unlimited" width="50" height="50"></a>
                
            </div>

            <ul>
                <li id="search_bar">

                    <input class="search-txt" type="text" placeholder="Type to search">
                    <a class="search-btn" href="">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </a>

                </li>
                <li id='persional'>
                    
                    <a href="Profile.jsp"><img src="<%=p.getAvatar()%>" alt="Avatar" width="40" height="40"></a>
                    
                </li>

                <li id="add">
                    <i class="fa fa-paper-plane" aria-hidden="true"></i>
                </li>

                <li id='notice'>

                    <i id = "icon_notice" class="fa fa-bell-o" aria-hidden="true" value ="close" onclick="openNotice(event)"></i>

                </li>

                <li id='more'>
                    <i id ="icon_more" value = "close" class="fa fa-bars" aria-hidden="true" onclick="openMore(event)"></i>
                </li>
            </ul>

        </div>



        <div class="container_main">

            <div class="poster">

                <form action = "UploadServlet" method = "post" enctype = "multipart/form-data" accept-charset="UTF-8">
                    <div class = "post_tus">
                        <div class="avatarTus">
                            <img src="<%=p.getAvatar()%>" name = "image">
                            <textarea name="Text1" cols="40" rows="5" placeholder="Có chuyện gì đang xảy ra?"></textarea>

                        </div>
                        <div class="showimg">
                            <img id="blah" src="#" alt="yourImage"  />
                        </div>
                        <div class = "item">
                            <input type = "file" name = "file" id = "file" size = "50" accept="image/*" style="display:none;" onchange="readURL(this);" />
                            <label for="file">
                                <i class="fa fa-picture-o" aria-hidden="true" onchange="readURL(this);"></i>
                            </label>
                            <i class="fa fa-video-camera" aria-hidden="true"></i>
                            <i class="fa fa-smile-o" aria-hidden="true"></i>
                            <button id = 'post' type = "submit" value = "Upload File">Post</button>
                        </div>
                    </div>
                </form>
                <ul class="list_tus">
                    <% for (Post post : list) {%>

                    <li class="tus1" id = <%= post.getID()%> >

                        <span class="container_tus">

                            <span class="header_tus">

                                <span class="avt">
                                    <img class="img" src="<%= post.getP().getAvatar()%>" alt="fake">
                                </span>

                                <h4>
                                    <%= post.getP().getFullName()%>
                                    <button id = "<%="rel" + post.getID()%>" class = "btn" name = "btn" value="<%= post.getID()%>" onclick= "FollowClick()"><%= CovertRelation.check(r, p.getPersonID(), post.getP().getPersonID())%></button>

                                </h4>

                                <i value="<%= post.getID()%>" class="fa fa-ellipsis-h" aria-hidden="true" style="margin-top: 17px; font-size: 20px;" onclick="more()">
                                    <div class="popup" value="<%= post.getID()%>">

                                        <ul>
                                            <li class = "li_btn" value="<%= post.getID()%>" onclick="edited(event)">
                                                <i class="fa fa-pencil" aria-hidden="true"></i>
                                                <span> Edit Post </span>
                                            </li>

                                            <li class = "li_btn" value="<%= post.getID()%>" onclick="deleted(event)">
                                                <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                <span>Delete Post</span>
                                            </li>

                                            <li  class = "li_btn">
                                                <i class="fa fa-flag-o" aria-hidden="true"></i>
                                                <span>Report</span>
                                            </li>

                                            <li  class = "li_btn">
                                                <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                                <span>Pin</span>
                                            </li>
                                        </ul>

                                    </div>
                                </i>

                            </span>


                            <h5 class="text">
                                <%= post.getContent()%>
                            </h5>

                            <span class="main_tus">

                                <img src="<%=post.getUrlImg()%>" alt="fake" style="max-height: 350px;">

                            </span>

                            <span class="comment">

                                <span class="funtion">

                                    <% String color = Utils.CovertBravo.checkBravo(b, p.getPersonID(), post.getID());%>
                                    <button style= "color: <%=color%>" class = "bravo"  onclick="BravoFunction()" value="<%= post.getID()%>">
                                        <i class="fa fa-sign-language" aria-hidden="true" style= "color:<%=color%>" > </i>

                                        <span style= "color: <%=color%>"> <%=post.getNBravo() + " "%>Bravo</span>
                                    </button>
                                </span>
                                <!--<form action="CommentServlet" method="POST">//-->
                                <span class="funtion">
                                    <!--//onclick="loadCmt(event)"-->
                                    <form action="CommentServlet" method="POST" style="width: 100%; height: 100%;">
                                        <button class = "btnCmt" name = "postID" value="<%=post.getID()%>" type="submit" >
                                            <i class="fa fa-comment-o" aria-hidden="true"></i>

                                            <span name = "span" value="<%=post.getID()%>">Reaction</span>
                                        </button>
                                    </form>
                                </span>
                                <!--</form>//-->
                                <span class="funtion">

                                    <% String textPin = Utils.CovertPin.checkPin(pin, p.getPersonID(), post.getUrlImg());
                                        String colorPin = "";
                                        if (textPin.equalsIgnoreCase("Pined")) {
                                            colorPin += "#2ecc71";
                                        } else {
                                            colorPin += "null";
                                        }
                                    %>
                                    <button class = "btn_Pin" onclick="PinFunction()" style="color: <%=colorPin%>" value="<%=post.getUrlImg()%>" >
                                        <i class="fa fa-thumb-tack" aria-hidden="true" style="color: <%=colorPin%>"></i>
                                        <span><%= textPin%></span>

                                    </button>

                                </span>

                            </span>

                        </span>

                        <div id = "<%= "edt" + post.getID()%>" name ="postID" value ="<%= post.getID()%>" class="editPost">

                            <div class="edt_head">

                                <span class="text1">Edit Post?</span>

                                <span id = "<%= "close" + post.getID()%>" class="close">&times;</span>


                            </div>

                            <div class="edt_body">

                                <div class="avatarTus_edt">
                                    <img src="<%=post.getP().getAvatar()%>" name="image_edt">
                                    <textarea id ='<%= "edt_text" + post.getID()%>' name="Text1_edt" cols="40" rows="5" placeholder="Chỉnh sửa tiêu đề và nội dung bài viết?" value = "<%= post.getContent()%>"><%= post.getContent()%></textarea>

                                </div>
                                <div class="showimg_edt">
                                    <img id = "<%= "edt_img" + post.getID()%>" src="<%=post.getUrlImg()%>" alt="fake" value ="<%= "edt_img" + post.getID()%>" >
                                </div>

                                <div class="item_edt">
                                    <input type = "file" class ="input_edt" name = "<%= post.getID()%>" id ="<%="file" + post.getID()%>" value = "<%=post.getID()%>" size = "50" accept="image/*" style="display:none;" onchange="onChange(this)" />
                                    <label for="<%="file" + post.getID()%>">
                                        <i class="fa fa-picture-o" aria-hidden="true" value = "<%=post.getID()%>" onchange="onChange(this)" ></i>
                                    </label>

                                    <i class="fa fa-video-camera" aria-hidden="true"></i>
                                    <i class="fa fa-smile-o" aria-hidden="true"></i>

                                </div>
                            </div>

                            <div class="edt_foot">
                                <button class = "btn_save" value = "<%=post.getID()%>" type="submit" onclick="Editor(event)">Save</button>
                            </div>


                        </div>

                    </li>

                    <%}%>
                </ul>

            </div>

            <div class="recomend">

                <div class="trend">

                    <ul>

                        <li class="title">
                            <h4>Trends for you</h4>
                        </li>

                        <li>
                            <a href="">#1 - Wedding Photography</a>
                        </li>

                        <li>
                            <a href="">#2 - Event Photography</a>
                        </li>

                        <li>
                            <a href="">#3 - Portrait Photography</a>
                        </li>

                        <li>
                            <a href="">#4 - Product Photography</a>
                        </li>

                        <li>
                            <a href="">#5 - Fine Art Photography</a>
                        </li>

                        <li class="more_tag">
                            <a href="">Hiển thị thêm</a>
                        </li>
                    </ul>

                </div>


                <div class="friend">

                    <ul>

                        <li>
                            <h3>Recommend follow</h3>
                        </li>

                        <li>
                            <span>

                                <span>
                                    <img src="icon/avtv.jpg" alt="avt" width="50px" height="50px">
                                </span>
                                <a href="">Viet Sherlock</a>

                                <button type="submit">
                                    Follow
                                </button>
                            </span>
                        </li>


                        <li>
                            <span>

                                <span>
                                    <img src="icon/avt9.jpg" alt="avt" width="50px" height="50px">
                                </span>
                                <a href="">Alexander Pie</a>

                                <button type="submit">
                                    Follow
                                </button>
                            </span>

                        </li>

                        <li>
                            <span>

                                <span>
                                    <img src="icon/avt10.png" alt="avt" width="50px" height="50px">
                                </span>
                                <a href="">Dang CS VN</a>

                                <button type="submit">
                                    Follow
                                </button>
                            </span>

                        </li>

                        <li>
                            <span>

                                <span>
                                    <img src="icon/avt6.jpg" alt="avt" width="50px" height="50px">
                                </span>
                                <a href="">Frida Kahlo</a>

                                <button type="submit">
                                    Follow
                                </button>
                            </span>
                        </li>

                        <li class="more_tag">
                            <a href="">Hiển thị thêm</a>
                        </li>

                    </ul>

                </div>
            </div>

        </div>
        <div class="delete_post" id ="dkm" value = "main" >

            <div class="del_head">

                <span id="txt1">Delete Post?</span>

                <span id="txt2" onclick="closePop()"><a href=""></a>&times;</span>

            </div>

            <div class="del_main">
                <span>You can edit it if you just need to change something. </span>

                <span>If you didn't create this post, we can help you secure your account.</span>
            </div>

            <div class="del_foot">

                <button>OK</button>

            </div>

        </div>
        <% List<Notification> listN = Controler.LoadNotice.loadNotice(n, p.getPersonID());%>
        <div id = "vkl" class="noti_container">

            <h3>Notifications</h3>

            <ul class="noti_content" style="list-style-type:none;">
                <% for (Notification noti : listN) {%>
                <form name ="postID" value="<%=noti.getPost().getID()%>" action="CommentServlet" method="POST" style="width: 100%; height: 100%;">
                    <button id = "<%="btn" + noti.getID()%>" name ="postID" value="<%=noti.getPost().getID()%>" style="display: none;" ></button>
                    <label for="<%="btn" + noti.getID()%>">
                        <li class="noti_content1" type = "submit" >
                            <img src="<%= noti.getpSend().getAvatar()%>" alt="image">
                            <span class="name_text"><%=noti.getpSend().getFullName()%></span>
                            <span class="notice"><%=noti.getContent()%></span>
                            <img class = "postImg" src="<%= noti.getPost().getUrlImg()%>" alt="image">
                        </li>
                    </label>
                </form>
                <%}%>

            </ul>
        </div>

        <div class="more_div" id = "cml" >

            <div class="more_head">

                <h3>Options</h3>

            </div>

            <div class="more_body">

                <ul>
                    <li>
                        <span>Change Password</span>
                    </li>

                    <li>
                        <span>Setting</span>
                    </li>
                    <li>

                    </li>

                </ul>

            </div>
            <form action="LogOut" method="GET">
                <div class="more_foot">
                    <button type="submit">Log Out</button>
                </div>
            </form>

        </div>

    </body>

</html>