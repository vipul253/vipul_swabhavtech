"use strict";
$(document).ready(function(){
    var rand,count;
    $("#start").click(makeButtons);

    function makeButtons() {
        clear();
        rand = Math.floor((Math.random() * 50));
        console.log(rand);
        for (var i = 0; i < 50; i++) {
            var btn = $("<button></button>").html(i+1);
            $(btn).prop("class","button");
            $(btn).prop("id",i);
            $(btn).val(i + 1);
            $(btn).click(check);
            $("#buttonField").append(btn);
        }
    }

    function check() {
        if (this.value == rand) {
            this.setAttribute("style", "background-color: #3c47e4");
            result("you won!!");
            return;
        }
        if (this.value > rand) {
            this.setAttribute("style", "background-color: #0ae40a");
        }
        if (this.value < rand) {
            this.setAttribute("style", "background-color: #f5091c");
        }
        count--;
        $("#result").html("remaining "+count);
        if(count==0){
            result("you loose");
        }
    }

    function result(msg){
        setTimeout(function(){
            alert(msg);
            makeButtons();
        },1000);
    }

    function clear() {
        $("#buttonField").html("");
        count = 3;
        $("#result").html("remaining "+count);
        $("#result").val(count);
    }
});