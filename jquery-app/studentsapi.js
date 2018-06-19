"use strict";
$(document).ready(function () {
    var datalink = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students";
    var loader = document.getElementById("loader");

    loadTable();

    $("input").focus(function () {
        $(this).css("background-color", "#f3f37f");
    });



    function makeTable(data) {
        var table = document.getElementById("table");
        table.innerHTML = "<thead><th>roll no.</th><th>name</th><th>age</th><th>email</th><th>gender</th><th>date</th></thead>";
        for (var i = 0; i < data.length; i++) {
            var gender = "Female";
            if (data[i].isMale) {
                gender = "Male";
            }
            table.innerHTML += "<tr><td>" + data[i].rollNo +
                "</td><td>" + data[i].name +
                "</td><td>" + data[i].age +
                "</td><td>" + data[i].email +
                "</td><td>" + gender +
                "</td><td>" + data[i].date +
                "</td></tr>";
        }
    }

    function loadTable() {
        $.ajax({
            url: datalink,
            type: "GET",
            success: function (data) {
                makeTable(data);
                $("#statusbox").html('Data loaded');
            },
            error: function () {
                $("#statusbox.text").html('An error occurred');
            },
            complete: function (data) {
                $("#addStudentButton").prop("disabled", false);
                stopLoad();
            }
        });
    }

    function addData(data) {
        $.ajax({
            url: datalink,
            type: "POST",
            data: data,
            success: function (data) {
                loadTable();
                $("#statusbox").html('Added successfully');
            },
            error: function () {
                $("#statusbox").html('An error occurred');
            },
            complete: function (data) {
                $("#addStudentButton").prop("disabled", false);
                stopLoad();
            }
        });
    }

    $("#addStudentButton").click(function () {
        if (checkInput()) {
            $(this).prop("disabled", true);
            startLoad();

            var student = {};
            var dob = new Date($("#date").val());

            student.rollNo = $("#roll").val();
            student.name = $("#name").val();
            student.age = $("#age").val();
            student.email = $("#email").val();
            student.isMale = document.getElementById("male").checked;
            student.date = dob.getDay() + "/" + dob.getMonth() + "/" + dob.getFullYear();

            addData(student);
        }
    });

    function checkInput() {
        var isValid = true;
        $('input').each(function () {
            if ($(this).val() === '') {
                isValid = false;
                $(this).css("background-color", "#ff1a1a");
            }
        });
        return isValid;
    }

    function startLoad() {
        loader.style.display = "block";
    }

    function stopLoad() {
        loader.style.display = "none";
    }
});