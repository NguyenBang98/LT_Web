<%-- 
    Document   : Profile
    Created on : Dec 3, 2019, 2:46:32 PM
    Author     : vieet
--%>

<%@page import="Model.Acount"%>
<%@page import="Controler.PinDAO"%>
<%@page import="Controler.BravoDAO"%>
<%@page import="Controler.LoadHome"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Controler.RelationshipDAO"%>
<%@page import="Controler.AcountDAO"%>
<%@page import="Controler.PersonDAO"%>
<%@page import="Model.Person"%>
<%@page import="java.util.List"%>
<%@page import="Model.Post"%>
<%@page import="Controler.LoadProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <%
        HttpSession hs = request.getSession();
        Person p = (Person) hs.getAttribute("users");
    %>
    <head>
        <meta charset="UTF-8">
        <title><%=p.getFullName()%></title>
        <link rel="shortcut icon" type="image/png" href="icon/favicon.png" />
        <link rel="stylesheet" type="text/css" href="css/profile.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" type="text/css" href="css/tus.css">
        <link rel="stylesheet" type="text/css" href="css/recomend.css">
        <link rel="stylesheet" type="text/css" href="css/PopUp_Upload.css">
        <link rel="stylesheet" type="text/css" href="css/PopupAvatar.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/lightbox.min.css">
        <script type="text/javascript" src="js/lightbox-plus-jquery.min.js"></script>
        <script type="text/javascript" src="js/PopUP_Upload.js"></script>
        <script type="text/javascript" src="js/PopupAvatar.js"></script>
        <script type="text/javascript" src="js/cmt.js"></script>
        <script type="text/javascript" src="js/home.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
    </head>

    <body>

        <script src="js/profile.js"></script>
        <%

            PersonDAO personDAO = new PersonDAO();
            AcountDAO acountDAO = new AcountDAO();

            Person person = personDAO.getPersonByID(p.getPersonID());
            Acount account = acountDAO.getAccount(p.getID());

            //Load album
            List<String> list_user_img = Controler.LoadProfile.loadUserImage(p.getPersonID());
            List<String> list_pin_img = Controler.LoadProfile.loadPinImage(p.getPersonID());

            //Load post
            List<Post> list_post_user = LoadProfile.loadPostUser(p.getPersonID());

            RelationshipDAO r = new RelationshipDAO();
            BravoDAO b = new BravoDAO();
            PinDAO pin = new PinDAO();
        %>

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

                    <i class="fa fa-bell-o" aria-hidden="true"></i>

                </li>

                <li id='more'>
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </li>
            </ul>

        </div>

        <div class="profie">

            <!--------Avatar&Cover-------->

            <div class="frame">
                <!----Cover----->
                <div class="ava_cover">
                    <form action="ProfileServlet" method="post" enctype = "multipart/form-data">
                        <div class="cover">
                            <a href="<%=p.getCover()%>" data-lightbox="mygallery"> 
                                <img id="u_cover" src="<%=p.getCover()%>" alt="your_cover"> </a>

                            <!--Upload image-->


                            <i id ="change_cover" class="fa fa-camera" aria-hidden="true" onclick="myfunction_cover()"></i>


                        </div>
                    </form>


                    <!------avatar------->
                    <div class="ava">
                        <div class="u_ava">
                            <!--PopUp image-->
                            <a href="<%=p.getAvatar()%>" data-lightbox="mygallery">
                                <img class="ava_popup" src="<%=p.getAvatar()%>" alt="your_ava" ></a>

                            <!--Upload image-->

                            <i id = "change_avat" class="fa fa-camera" aria-hidden="true" onclick="myfunction_ava()"></i>

                            <div class="show_image">

                            </div>

                            <h3 id="nick_name">
                                <%=p.getFullName()%>
                            </h3>
                        </div>

                    </div>


                </div>
            </div>



            <!--------Content---------->

            <div class="content">

                <div class="profile_tab">
                    <button class="tablinks active">Posts</button>
                    <button class="tablinks">Album</button>
                    <button class="tablinks">Follow</button>
                    <button class="tablinks">Introduction</button>
                </div>
                <!------Post tab-------->
                <div id="Posts" class="tabcontent">
                    <div class="tab_c">

                        <% for (Post post : list_post_user) {%>
                        <ul class="list_tus">

                            <li class="tus1">

                                <span class="container_tus">

                                    <span class="header_tus">

                                        <span class="avt">
                                            <a href="<%=post.getP().getAvatar()%>" data-lightbox="mygallery">
                                                <img class="img" src="<%=post.getP().getAvatar()%>" alt="avatar">
                                            </a>
                                        </span>

                                        <h4>
                                            <%=post.getP().getFullName()%>

                                            <!--                                            <button>
                                                                                            Following
                                                                                        </button>-->
                                        </h4>


                                    </span>

                                    <h5 class="text">
                                        <%=post.getContent()%>
                                    </h5>

                                    <span class="main_tus">
                                        <img src="<%=post.getUrlImg()%>" alt="fake">
                                    </span>

                                    <span class="comment">

                                        <span class="funtion">
                                            <%-----Brabvo---%>

                                            <% String color = Utils.CovertBravo.checkBravo(b, p.getPersonID(), post.getID());%>
                                            <button style= "color: <%=color%>" class = "bravo" id = "bravo" onclick="BravoFunction()" value="<%= post.getID()%>">
                                                <i class="fa fa-sign-language" aria-hidden="true" style= "color:<%=color%>" > </i>

                                                <span style= "color: <%=color%>" > <%=post.getNBravo() + " "%>Bravo</span>
                                            </button>
                                        </span>

                                        <span class="funtion">

                                            <form action="CommentServlet" method="POST" style="width: 100%; height: 100%;">
                                                <button name = "postID" value="<%=post.getID()%>" type="submit" style="height: 100%;">
                                                    <i class="fa fa-comment-o" aria-hidden="true"></i>

                                                    <span name = "span" value="<%=post.getID()%>">Reaction</span>
                                                </button>
                                            </form>

                                        </span>

                                        <span class="funtion">

                                            <button>
                                                <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                                <span>Pin</span>

                                            </button>

                                        </span>

                                    </span>

                                </span>


                            </li>

                        </ul>
                        <%}%>

                    </div>

                </div>



                <!----Ablbum---->
                <div id="Album" class="tabcontent">

                    <div class="Album_tab">

                        <button class="album_button active" onclick="showContent2('your_image')">Your Image</button>

                        <button class="album_button" onclick="showContent2('pin_image')"> Image Pin</button>

                    </div>


                    <ul>


                        <li style="list-style-type: none;">
                            <div id="your_image" class="tab_album">
                                <% for (String a : list_user_img) {%>
                                <a href="<%=a%>" data-lightbox="mygallery">
                                    <img src="<%=a%>" alt="image">
                                </a>
                                <%}%>  
                            </div>
                        </li>

                    </ul>


                    <div id="pin_image" class="tab_album">
                        <% for (String a : list_pin_img) {%>
                        <a href="<%=a%>" data-lightbox="mygallery">
                            <img src="<%=a%>" alt="image">
                        </a>
                        <%}%>  

                    </div>



                </div>

                <%
                    RelationshipDAO relationshipDAO = new RelationshipDAO();
                    List<Person> listFollower = new ArrayList<Person>();
                    listFollower = relationshipDAO.getFollower(p.getPersonID());

                    List<Person> listFollowing = new ArrayList<Person>();
                    listFollowing = relationshipDAO.getFollowing(p.getPersonID());
                %>

                <!----Follow tab---->

                <div id="Follow" class="tabcontent">

                    <div class="follow_tab">
                        <button class="follow_link active" onclick="showContent1('following')"> Following </button>
                        <button class="follow_link" onclick="showContent1('follower')"> Follower </button>
                    </div>

                    <!----Following tab---->
                    <div id="following" class="tab_follow">
                        <% for (Person person2 : listFollowing) {%>
                        <span class="header_tus">
                            <span class="avt">
                                <img class="img" src="<%=person2.getAvatar()%>" alt="avatar">
                            </span>

                            <h4>
                                <form action="ProfileGuest" method="POST" accept-charset="UTF-8">
                                    <button class="page_guest" name = "PersonID" value="<%=person2.getPersonID()%>">
                                        <%=person2.getFullName()%>
                                    </button>

                                </form>

                                <button id="following_sta">
                                    Following
                                </button>
                            </h4>
                        </span>
                        <%}%>



                    </div>

                    <!----Follower tab---->

                    <div id="follower" class="tab_follow">
                        <% for (Person person1 : listFollower) {%>
                        <span class="header_tus">
                            <span class="avt">
                                <img class="img" src="<%=person1.getAvatar()%>" alt="avatar">
                            </span>

                            <h4>
                                <form action="ProfileGuest" method="POST" accept-charset="UTF-8">
                                    <button class="page_guest" name = "PersonID" value="<%=person1.getPersonID()%>">
                                        <%=person1.getFullName()%>
                                    </button>

                                </form>

                                <button id="following_sta">
                                    Following
                                </button>
                            </h4>
                        </span>

                        <!--                        <span class="header_tus">
                                                    <span class="avt">
                                                        <img class="img" src="img/stampede%20wall.png" alt="avatar">
                                                    </span>
                        
                                                    <h4>
                                                        <a href="#" style="text-decoration: none; color: black;">Alexander Andrew</a>
                        
                                                        <button>
                                                            Follow
                                                        </button>
                                                    </h4>
                                                </span>-->
                        <%}%>
                    </div>

                </div>
                <!------Intro tab------->

                <div id="Introduction" class="tabcontent">
                    <div class="quote">
                        <h3>
                            <i class="fa fa-quote-left" aria-hidden="true"></i>
                            Quote
                        </h3>
                        <p>
                            <span class="input_db"><%= person.getQuotes()%></span>
                        </p>
                    </div>

                    <div class="infor">
                        <p>
                            <i class="fa fa-briefcase" aria-hidden="true"></i>
                            Work at <span class="input_db"><%= person.getWork()%></span>
                        </p>

                        <p>
                            <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                            Studied in <span class="input_db"><%= person.getStudy()%></span>
                        </p>

                        <p>
                            <i class="fa fa-home" aria-hidden="true"></i>
                            Lived in <span class="input_db"><%= person.getAddress()%></span>
                        </p>

                        <p id="follow_number">
                            <img src="icon/followers.png" alt="follower_icon">
                            Follower <span class="input_db"><%= person.getFlower()%></span>
                        </p>

                        <p>
                            <i class="fa fa-envelope" aria-hidden="true"></i>
                            Email <span class="input_db"><%= account.getEmail()%></span>
                        </p>
                        <div class="edit">
                            <a href="EditInfor.jsp" target="_blank">Edit</a>
                        </div>

                        <!--                    <button> Edit </button>-->
                    </div>
                </div>

            </div>

        </div>
        <!--------------Upload Cover--------------->     

        <form action="UpdateCoverServlet" method="POST" enctype = "multipart/form-data" accept-charset="UTF-8">


            <div class="upload">
                <div class="close_upload" onclick="closePopUp()"><i class="fa fa-times-circle" aria-hidden="true"></i></div>
                <h2>Create new cover</h2>
                <div class="upload_img">
                    <input type = "file" name = "file" id = "file" size = "50" accept="image/*" style="display:none;"  onchange = "loadImg(this)">
                    <div id="cover_file">
                        <label for="file">Upload Cover</label>
                    </div>

                </div>
                <div class="show_img">
                    <img id ="img_show" src="<%=p.getCover()%>" alt="image">
                </div>
                <div class="save_img">
                    <button type="submit"> Save</button>
                </div>
            </div>


        </form>

        <!--------------Upload Avatar--------------->
        <form action="UpdateAvatarServlet" method="POST" enctype = "multipart/form-data" accept-charset="UTF-8">
            <div class="change_avatar">
                <div class="close_avatar" onclick = "closePopUp_ava()"><i class="fa fa-times-circle" aria-hidden="true"></i></div>
                <h2>Create new avatar</h2>
                <div class="upload_avatar">

                    <input type="file" name="file_ava" id="file_ava" size="50" accept="image/*" style="display:none;" onchange="loadImg_ava(this)">
                    <div id="ava_file">
                        <label for="file_ava">Upload Avatar</label>
                    </div>



                </div>
                <div class="show_avatar">
                    <img id ="ava_show" src="<%=p.getAvatar()%>" alt="image">
                </div>
                <div class="save_ava">
                    <button type = "submit"> Save</button>
                </div>
            </div>
        </form>

    </body>
    <!--------------JavaScript--------------->
    <script type="text/javascript">
        /*========main tab============*/
        var buttons = document.getElementsByClassName('tablinks');
        var contents = document.getElementsByClassName('tabcontent');

        function showContent(id) {
            for (var i = 0; i < contents.length; i++) {
                contents[i].style.display = 'none';
            }
            var content = document.getElementById(id);
            content.style.display = 'block';

        }
        for (var i = 0; i < buttons.length; i++) {
            buttons[i].addEventListener("click", function () {
                var id = this.textContent;
                for (var i = 0; i < buttons.length; i++) {
                    buttons[i].classList.remove("active");
                }
                this.className += " active";
                showContent(id);
            });
        }
        showContent('Posts');


        /*========follow tab==========*/

    </script>

    <script type="text/javascript">
        var contents1 = document.getElementsByClassName('tab_follow');
        var buttons1 = document.getElementsByClassName('follow_link');

        function showContent1(id) {
            for (var i = 0; i < contents1.length; i++) {
                contents1[i].style.display = 'none';
                //            content1.style.borderBottomColor = 'none';

            }
            var content1 = document.getElementById(id);
            content1.style.display = 'block';
            //        content1.style.borderBottomColor = '#27ae60';

        }
        for (var i = 0; i < buttons1.length; i++) {
            buttons1[i].addEventListener("click", function () {
                var id = this.textContent;
                for (var i = 0; i < buttons1.length; i++) {
                    buttons1[i].classList.remove("active");
                }
                this.className += " active";
                //            showContent1(id);
            });
        }



        showContent1('following');

    </script>

    <!----------Album Tab---------->

    <script type="text/javascript">
        var contents2 = document.getElementsByClassName('tab_album');
        var buttons2 = document.getElementsByClassName('album_button');

        function showContent2(id) {
            for (var i = 0; i < contents2.length; i++) {
                contents2[i].style.display = 'none';
            }
            var content2 = document.getElementById(id);
            content2.style.display = 'block';
            //        content2.style.borderBottomColor = '#27ae60';
        }

        for (var i = 0; i < buttons2.length; i++) {
            buttons2[i].addEventListener("click", function () {
                var id = this.textContent;
                for (var i = 0; i < buttons2.length; i++) {
                    buttons2[i].classList.remove("active");
                }
                this.className += " active";
                //            showContent1(id);
            });
        }

        showContent2('your_image');

    </script>

    <script type="text/javascript">
        function onChange(input) {

//    alert(input.name + input.value);
            var postID = input.name;
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#edt_img' + postID).attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }

        }
    </script>
</html>



