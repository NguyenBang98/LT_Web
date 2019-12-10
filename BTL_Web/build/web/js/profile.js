var tabButtons=document.querySelectorAll(".tabcontent .follow_tab button");
var tabPanels=document.querySelectorAll(".tabcontent .tab_follow");

function showPanel(panelIndex,colorCode) {
    tabButtons.forEach(function(node){
        node.style.backgroundColor="";
        node.style.color="";
    });
    tabButtons[panelIndex].style.backgroundColor=colorCode;
    tabButtons[panelIndex].style.color="white";
    tabPanels.forEach(function(node){
        node.style.display="none";
    });
    tabPanels[panelIndex].style.display="block";
    tabPanels[panelIndex].style.backgroundColor=colorCode;
}
showPanel(0,'#f44336');


function BravoFunction() {

    $(".bravo").click(function () {

        var x = this.getAttribute("style", "color");
        
        if (String(x) === "null" || String(x) === "color:null; " || String(x) === "color: null")
        {

            this.setAttribute("style", "color:#2ecc71; ");
            this.getElementsByClassName("fa fa-sign-language")[0].setAttribute("style", "color:#2ecc71;");

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
function loadCmt(event){
    alert("VKl");
    var postID = event.currentTarget.value;
    $.ajax({
        url: 'CommentServlet',
        method: 'POST',
        data: {postID: postID}
    });
//    $this.die('click');    
}