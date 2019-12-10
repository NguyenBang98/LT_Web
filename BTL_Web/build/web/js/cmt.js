function backPage() {

    window.history.back();
}
function sleep(time) {
    return new Promise((resolve) => setTimeout(resolve, time));
}
function PostComment()
{
    var x = document.getElementById("postCmt").value;
    var content = document.getElementById("content").value;

    $.ajax({
        url: 'CommentUpdate',
        method: 'POST',
        data: {name: x, data: content}
    });
    sleep(2000).then(() => {
        // Do something after the sleep!
        location.reload(true);
    });


}
