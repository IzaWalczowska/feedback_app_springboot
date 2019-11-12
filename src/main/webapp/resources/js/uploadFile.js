

    console.log("skrypt dziala");

    function previewFile() {

        var preview = document.querySelector('#preview');
        var file = document.querySelector('input[type=file]').files[0];
        var reader = new FileReader();

        reader.addEventListener("load", function () {
            console.log("event dziala");
            preview.src = reader.result;
        }, false);

        if (file) {
            reader.readAsDataURL(file);
        }
    }

    // todo zamykanie i reload dziala, ale controller nie odbiera danych z posta
    // function closeSelf(){
    //     self.close();
    //     window.opener.location.reload();
    //     return true;
    // }

