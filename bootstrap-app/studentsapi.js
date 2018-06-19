"use strict";
$(document).ready(function () {
    var datalink = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/";
    var loader = document.getElementById("loader");

    function makeTable(data) {
        var tabledata = document.getElementById("tabledata");
        tabledata.innerHTML = "";
        for (var i = 0; i < data.length; i++) {
            var gender = "Female";
            if (data[i].isMale) {
                gender = "Male";
            }
            tabledata.innerHTML += "<tr><td>" + data[i].rollNo +
                "</td><td>" + data[i].name +
                "</td><td>" + data[i].age +
                "</td><td>" + data[i].email +
                "</td><td>" + gender +
                "</td><td>" + data[i].date +
                "</td><td><button class='btn btn-default edit' value='" + data[i].rollNo + "'>" +
                "<span class='glyphicon glyphicon-pencil'></span></button></td><td>" +
                "<button class='btn btn-default delete' value='" + data[i].rollNo + "'>" +
                "<span class='glyphicon glyphicon-remove'></span></button></td></tr>";
        }
    }

    function loadTable() {
        $.ajax({
            url: datalink,
            type: "GET",
            beforeSend: function () {
                $('#addStudentButton').prop("disabled", true);
                startLoad();
            },
            success: function (data) {
                makeTable(data);
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

    function addData(data1) {
        $.ajax({
            url: datalink,
            type: "POST",
            data: data1,
            beforeSend: function () {
                $('#addStudentButton').prop("disabled", true);
                startLoad();
            },
            success: function (data) {
                loadTable();
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

    $(document).on('click', '#addStudentButton', function () {
        if (checkInput()) {
            $(this).prop("disabled", true);
            startLoad();

            var student = makeStudent();

            addData(student);
        }
    });

    $(document).on('click', '.edit', function () {
        $(".edit").prop("disabled", true);
        $("#addStudentButton").html("edit student").prop("id", "editbtn");
    });

    $(document).on('click', '#editbtn', function () {
        if (checkInput()) {
            $(this).prop("disabled", true);
            var student = makeStudent();
            $.ajax({
                url: datalink + student.rollNo,
                type: "PUT",
                data: student,
                beforeSend: function () {
                    startLoad();
                },
                success: function (data) {
                    loadTable();
                },
                error: function () {
                    $(this).prop("disabled",false);
                    $("#statusbox").html('An error occurred');
                },
                complete: function (data) {
                    $('#editbtn').html("Add Student").prop("id", "addStudentButton");
                    $('#addStudentButton').prop("disabled", false);
                    stopLoad();
                }
            });
        }
    });

    $(document).on('click', '.delete', function () {
        $.ajax({
            url: datalink + $(this).val(),
            type: "DELETE",
            beforeSend: function () {
                startLoad();
                $(this).prop("disabled", true);
            },
            success: function (data) {
                loadTable();
            },
            error: function () {
                $("#statusbox").html('An error occurred');
            },
            complete: function (data) {
                $(this).prop("disabled", false);
                stopLoad();
            }
        });
    });

    function makeStudent() {
        var student = {};
        
        student.rollNo = $("#roll").val();
        student.name = $("#name").val();
        student.age = $("#age").val();
        student.email = $("#email").val();
        student.isMale = document.getElementById("male").checked;
        student.date = $("#date").val();

        return student;
    }

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

    loadTable();
});