"use strict";
angular.module('studentapi', []).controller('studentapiCtrl',['$scope','dataService', function ($scope, dataService) {

    $scope.list;
    $scope.btntxt = "add student";
    $scope.btnSwitch = true;
    $scope.isLoading = false;
    $scope.student = {};

    var clearInput = function () {
        $scope.student.rollNo = null;
        $scope.student.name = "";
        $scope.student.age = null;
        $scope.student.email = "";
        $scope.student.isMale = null;
        $scope.student.date = null;
    }

    clearInput();

    dataService.getData().then(function (x) {
        $scope.list = x.data;
        $scope.isLoading = true;
    });

    $scope.getList = function () {
        $scope.isLoading=false;
        dataService.getData().then(function (x) {
            $scope.list = x.data;
            enableEdit();
            $scope.isLoading=true;
        });
    }

    $scope.addStudent = function (student) {
        $scope.isLoading=false;
        if (checkInput()) {
            $scope.isTrue = true;
            dataService.addData(student).then(function () {
                clearInput();
                $scope.getList();
                $scope.isTrue = true;
            });
        }
    }

    $scope.edit = function (roll) {
        $scope.isTrue = true;
        $scope.btntxt = "edit button";
        $scope.btnSwitch = false;
        $scope.isLoading=false;
        dataService.getStudent(roll).then(function(x){
            x.data.date = new Date(x.data.date);
            $scope.student = x.data;
            $scope.isLoading=true;
        })
        
    }

    $scope.editStudent = function (roll) {
        if (checkInput()) {
            $scope.isLoading=false;
            dataService.editData(roll, $scope.student).then(function () {
                clearInput();
                $scope.btntxt = "add student";
                $scope.btnSwitch = true;
                $scope.getList();
            });
        }
    }

    $scope.deleteStudent = function (roll) {
        $scope.isTrue = true;
        $scope.isLoading=false;
        dataService.deleteData(roll).then(function () {
            $scope.getList();
        });
    }

    var enableEdit = function () {
        $scope.isTrue = false;
    }

    var checkInput = function () {
        var isValid = true;

        var isEmpty = function (val) {
            return angular.isUndefined(val) || val === null || val === "";
        }

        if (isEmpty($scope.student.rollNo)) {
            isValid = false;
        }
        if (isEmpty($scope.student.name)) {
            isValid = false;
        }
        if (isEmpty($scope.student.age)) {
            isValid = false;
        }
        if (isEmpty($scope.student.email)) {
            isValid = false;
        }
        if (isEmpty($scope.student.isMale)) {
            isValid = false;
        }
        if (isEmpty($scope.student.date)) {
            isValid = false;
        }
        return isValid;
    }
}]).controller('confirmDelete',['$scope','$window', function($scope,$window){
    $scope.showConfirm = function(roll){
        if ($window.confirm("Please confirm?")) {
           $scope.deleteStudent(roll);
        }
    }
}]);

angular.module('studentapi').factory('dataService',['$http', function ($http) {
    var url = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/";
    var service = {};

    service.getStudent = function (id) {
        return $http.get(url + id);
    }

    service.getData = function () {
        return $http.get(url);
    }

    service.addData = function (stud) {
        return $http.post(url, stud);
    }

    service.editData = function (id, student) {
        return $http.put(url + id, student);
    }

    service.deleteData = function (id) {
        return $http.delete(url + id);
    }

    return service;
}]);