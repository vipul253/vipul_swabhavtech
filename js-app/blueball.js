"use strict";
(function(){

    document.getElementById("btn").addEventListener('click', makeButtons);
    var rand;
    var count;
    function makeButtons() {
        var buttonField = document.getElementById("buttonField");
        buttonField.innerHTML = "";
        rand = Math.floor((Math.random() * 50));
        console.log(rand);
        count=3;
        for (var i = 0; i < 50; i++) {
            var btn = document.createElement("button");
            var btnText = document.createTextNode(i + 1);
            btn.className="button";
            btn.setAttribute("id",i);
            btn.setAttribute("value",i+1);
            btn.addEventListener('click', check);
            btn.appendChild(btnText);
            buttonField.append(btn);
        }

        function check() {
            if(count>0) {
                if(this.value==rand){
                    this.setAttribute("style","background-color: #3c47e4");
                    setTimeout(2000,clear);
                    alert("yow won!!");
                    makeButtons();
                }
                if(this.value>rand){
                    this.setAttribute("style","background-color: #0ae40a");
                    
                }
                else if(this.value<rand){
                    this.setAttribute("style","background-color: #f5091c");
                    
                }
                count--;
            }
            if(count<=0){
                
                alert("you loose!!");
                makeButtons();
            }
            document.getElementById("result").innerHTML="remaining "+count;
        }

        function clear(){
            document.getElementById("buttonField").innerHTML="";
        }
    }
}())




    
