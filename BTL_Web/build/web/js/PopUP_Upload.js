

function myfunction_cover(){
    
    var popup = document.querySelector(".upload");
    popup.style.display = "block";
}

function loadImg(input){
    

    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
            $('#img_show').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
    
    
}
function closePopUp(){
    

    var popup = document.querySelector(".upload");
    popup.style.display = "none";
    
    
}