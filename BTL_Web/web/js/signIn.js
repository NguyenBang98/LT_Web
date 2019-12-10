function validateForm() {
    // Bước 1: Lấy giá trị của username và password
    var username = document.getElementsByClassName('username')[0].value;
    var password = document.getElementsByClassName('password')[0].value;
 
    // Bước 2: Kiểm tra dữ liệu hợp lệ hay không
    if (username == ''){
        
        var element1 = document.getElementsByClassName('username')[0];
        element1.setAttribute("style", "border-bottom:1px solid red;");
        var element2 = document.getElementsByClassName('input_user')[0];
        element2.setAttribute("style", "border-bottom:none;")
        alert("Username is empty!");
        return false;
        
    }
    else if (password == '')
    {
        var element1 = document.getElementsByClassName('password')[0];
        element1.setAttribute("style", "border-bottom:1px solid red;");
        var element2 = document.getElementsByClassName('input_user')[1];
        element2.setAttribute("style", "border-bottom:none;");
        alert("Password is empty!");
        return false;
    }
    return true;

}