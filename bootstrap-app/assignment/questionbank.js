$(document).ready(function () {
    var data = $.parseJSON($.ajax({
        url: 'qb.json',
        type: "GET",
        dataType: "JSON",
        async: false
    }).responseText);

    var score = 0;
    var ranNums = [];
    loadQuestions();

    $("#checkScorebtn").click(function () {
        for (var i = 1; i <= 5; i++) {
            var rand = ranNums[i];
            var options = $("[name='"+rand+"']");
            console.log(options);
            var answer;
            for (var j = 0; j < options.length; j++) {
                console.log(options[j].checked);
                if (options[j].checked) {
                    
                    answer = options[j].value;
                }
            }
            if (answer == data[rand].answer) {
                score = score + 1;
            }
            console.log(score);
        }
        $("#result").html("your score is " + score + "/5");
    });

    $("#loadbtn").click(function () {
        score=0;
        loadQuestions();
        $("#result").html("");
    });

    function loadQuestions() {
        ranNums = getRandom([0, 1, 2, 3, 4, 5, 6, 7, 8, 9]);
        $("#questions").html("");
        for (var i = 1; i <= 5; i++) {
            var rand = ranNums[i];
            var optionsLength = getOptionCount(data[rand].options);
            $("#questions").append("<label class='control-label'>" + i + " " + data[rand].text + "</label><br>");
            for (var j = 1; j <= optionsLength; j++) {
                $("#questions").append("<input type='radio' name='" + rand +
                    "' value='" + data[rand].options[j] + "'>" + data[rand].options[j] + "<br>");
            }
            $("#questions").append("<hr>");
        }
    }

    function getRandom(array) {
        var i = array.length;
        var j = 0;
        var temp;

        while (i--) {
            j = Math.floor(Math.random() * (i + 1));
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    function getOptionCount(opt) {
        var count = 0;
        for (var k in opt) {
            if (opt.hasOwnProperty(k)) {
                count += 1;
            }
        }
        return count;
    }
});