document.addEventListener("DOMContentLoaded", function () {

    var requestList = document.querySelector("#requestList");
    var requestForm = document.querySelector("formList")
    var addRequestButton = document.querySelector("#addNewRequestBtn");
    var requestInput = document.querySelector("#requestInput");

    console.log("skrypt dziala");

    // addRequestButton.addEventListener("click", function (evt) {
    //
    //     console.log("skrypt dodajacy dziala");
    //     var listElement = newElement("li");
    //     listElement.innerText = requestInput.value;
    //     requestList.appendChild(listElement);
    //
    // });


    addRequestButton.addEventListener("click", function (evt) {

        console.log("skrypt dodajacy dziala");
        var newFormField = newElement("input");
        newFormField.value = requestInput.value;
        requestForm.appendChild(newFormField);

    });




});

