$(document).ready(function () {
    $("#slider").on('input', function () {
        makeButton();
    });

    makeButton();

    function makeButton() {
        var currentValue = $("#slider").val();
        
        $("#sliderValue").html(currentValue);
        $("#output").html("");

        for (i = 0; i < currentValue; i++) {
            var btn = $("<button></button>").text(i + 1);
            $(btn).val(i + 1);
            $(btn).click(function () {
                console.log(this.value);
            });
            $("#output").append(btn);
        }
    }
});