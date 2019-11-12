$(function () {

    popup();
});

function popup() {

    var uploadButton = $('#uploadButton');
    var url = uploadButton.attr("href");

    uploadButton.on('click', function f(e) {
        e.preventDefault();
        console.log("skrypt działa");
        popupWindow = window.open(url, 'popUpWindow',
            'height=400,width=700,left=50,top=50,resizable=yes,scrollbars=no, toolbar=yes,menubar=yes,location=no,directories=no, status=no')

    })
}

