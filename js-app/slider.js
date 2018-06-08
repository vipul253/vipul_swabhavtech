(function () {

    document.getElementById("slider").addEventListener('input', makeButton);

    makeButton();
    function makeButton() {
        var slider = document.getElementById("slider");
        var sliderValue = document.getElementById('sliderValue');
        var buttonBox = document.getElementById('output');
        var currentValue = slider.value;

        sliderValue.innerHTML = currentValue;
        buttonBox.innerHTML = "";

        for (i = 0; i < currentValue; i++) {
            var btn = document.createElement("button");
            var btnText = document.createTextNode(i + 1);

            btn.value = i + 1;
            btn.addEventListener('click', addInConsole);
            btn.appendChild(btnText);
            document.getElementById('output').append(btn);

            function addInConsole() {
                console.log(this.value);
            }
        }
    }
})();