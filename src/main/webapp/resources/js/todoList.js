$(function () {

    submitCheckbox();
});

function submitCheckbox() {

    var chckboxes = $('#todo-checkbox');
console.log("działa");
    chckboxes.on('change', function f(e) {
        this.form.submit();
    })
}