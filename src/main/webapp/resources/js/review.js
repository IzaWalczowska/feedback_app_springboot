document.addEventListener("DOMContentLoaded", function () {

    var requestList = document.querySelector("#requestList");
    var requestForm = document.querySelector("#formList");
    var addRequestButton = document.querySelector("#addNewRequestBtn");
    var requestInput = document.querySelector("#requestInput");



    addRequestButton.addEventListener("click", function (evt) {

        console.log("skrypt dodajacy dziala");
        var newFormField = document.createElement("input");
        newFormField.name="request";
        newFormField.className="request-field";
        requestForm.prepend(newFormField);

    });
});

