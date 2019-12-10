
function readURL(input) {
    var x = document.getElementsByClassName("showimg")[0];
    x.setAttribute("style", "display:block;");

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }

}
function FollowClick()
{
    $(".btn").click(function () {

//        alert(this.textContent);
        if (this.textContent === "Follow")
        {
            this.textContent = "Following";
        } else if (this.textContent === "Following")
        {
            this.textContent = "Follow";
        }
        $.ajax({
            url: 'FollowServelet',
            method: 'POST',
            data: {name: this.value}
        });
        location.reload(true);
        $this.die('click');

    });


}

function BravoFunction() {
    $(".bravo").click(function () {

        var x = this.getAttribute("style", "color");

        if (String(x) === "null" || String(x) === "color:null; " || String(x) === "color: null")
        {

            this.setAttribute("style", "color:#2ecc71; ");
            this.getElementsByClassName("fa fa-sign-language")[0].setAttribute("style", "color:#2ecc71;");
//            alert();
            $.ajax({
                url: 'BravoUpdate',
                method: 'POST',
                data: {bravo: "add", postID: this.value},
                success: function (responseText) {

                    $("this span").text(responseText);
                    location.reload(true);
                }
            });


        } else {

            this.setAttribute("style", "color:null; ");
            this.getElementsByClassName("fa fa-sign-language")[0].setAttribute("style", "color:null;");
            $.ajax({
                url: 'BravoUpdate',
                method: 'POST',
                data: {bravo: "sub", postID: this.value},
                success: function (responseText) {

                    $("this span").text(responseText);
                    location.reload(true);
                }
            });

        }

        $this.die('click');
    });

}

function  PinFunction() {

    $('.btn_Pin').click(function () {

        var x = this.getAttribute("style", "color");

        if (String(x) === "null" || String(x) === "color:null; " || String(x) === "color: null")
        {
            this.setAttribute("style", "color:#2ecc71; ");
            this.getElementsByClassName("fa fa-thumb-tack")[0].setAttribute("style", "color:#2ecc71;");
            // Tạo mới một cái Pin và đổi màu của các icon 
            $.ajax({
                url: 'PinServlet',
                method: 'POST',
                data: {pinImg: this.value}
            });
            location.reload(true);
        } else {


        }
//        this.getElementById("myPopup").classList.toggle("show");
//        location.reload(true);
        $this.die('click');

    });
}


function more() {

    $('.fa-ellipsis-h').click(function () {

        var popup = this.getElementsByClassName("popup")[0];

        popup.classList.toggle("show");
        $this.die('click');

    });

}

function sleep(time) {
    return new Promise((resolve) => setTimeout(resolve, time));
}
function deleted(event)
{
//  var popupDel = document.getElementById("dkm");
    var postID = event.currentTarget.value;


    // get text button có ID =  post ID
    var id = "rel" + postID;
    var rel = $("#" + id).text();

    if (rel !== "My Self") {
        alert("You just can delete your post!");
    } else {

        document.querySelector('.delete_post').style.display = 'inline';

        $(".delete_post button").click(function () {

            //        alert("Đã gọi");
            closePop();
            // sao để ẩn cái có id =  đó

            $.ajax({
                url: 'DeletePostServlet',
                method: 'POST',
                data: {postDel: postID}

            });
            sleep(2000).then(() => {
                // Do something after the sleep!
                location.reload(true);
            });


        });

    }

//    location.reload(true);
//    popupDel.setAttribute(("style", "visibility: visible;");)

}

function closePop() {

    document.querySelector('.delete_post').style.display = 'none';

}

//function read_edt(input) {
//    if (input.files && input.files[0]) {
//        var reader = new FileReader();
//
//        reader.onload = function (e) {
//            $('#profile-img-tag').attr('src', e.target.result);
//        }
//        reader.readAsDataURL(input.files[0]);
//    }
//}
function edited(event) {

//    document.querySelector('.editPost').style.display = 'inline';
//    var modal = getElementsByClassName("editPost")[0];
    var postID = event.currentTarget.value;
    var modal = document.getElementById("edt" + postID);
    modal.style.display = 'block';

//    var span = document.getElementsByClassName("close")[0];
    var close = document.getElementById("close" + postID);

    close.onclick = function () {
        modal.style.display = "none";
    }
//    var imgE = document.querySelector("#edt_img" + postID);
//    alert("Sao không hiện" + imgE.value);
//    $(".input_edt").change(function (event) {
//        if (event.files && event.files[0]) {
//
//            var file = event.target.files[0];
//            alert(file);
//            var reader = new FileReader();
//            reader.onload = function (e) {
//                // The file's text will be printed here
//                alert(e.target.result);
//            };
//
//            reader.readAsText(file);
//        }
//    });
//    document.getElementsByClassName("container_main").setAttribute("style", "opacity: 0.2;")
}
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

function Editor(event) {

    var content = document.getElementById("edt_text" + event.currentTarget.value).value;
    var postID = event.currentTarget.value;
//    alert(content);
//    $(".btn_save").click(function () {

    $.ajax({
        url: 'EditServlet',
        method: 'POST',
        data: {postID: postID, Text: content},
        success: function (responseText) {
            document.getElementById("edt" + postID).style.display = "none";
            alert(responseText);
            location.reload(true);
        }

    });
    $this.die('click');
//    });

}
//
function loadCmt(event) {
//    alert("Change trang");
    var postID = event.currentTarget.value;
    $.ajax({
        url: 'CommentServlet',
        method: 'POST',
        data: {postID: postID}
    });
//    $this.die('click');    
}


function openNotice(event) {

    var x = document.getElementById("icon_notice").value;
//    alert("."+x+".");
    if (String(x) === "undefined")
    {
        document.getElementById("vkl").style.display = "block";
        document.getElementById("icon_notice").value = "close";
    } else {
        document.getElementById("vkl").style.display = "none";
        document.getElementById("icon_notice").value = "undefined";
    }


}

function openMore(event) {
    var x = document.getElementById("icon_more").value;
//    alert("."+x+".");
    if (String(x) === "undefined")
    {
        document.getElementById("cml").style.display = "block";
        document.getElementById("icon_more").value = "close";
    } else {
        document.getElementById("cml").style.display = "none";
        document.getElementById("icon_more").value = "undefined";
    }
}