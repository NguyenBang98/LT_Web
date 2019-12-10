
function myfunction_ava(){

    var popup = document.querySelector(".change_avatar");
    popup.style.display = "block";
}

function loadImg_ava(input){
    
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
            $('#ava_show').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
    
    
}
function closePopUp_ava(){
    
    var popup = document.querySelector(".change_avatar");
    popup.style.display = "none";
    
    
}

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