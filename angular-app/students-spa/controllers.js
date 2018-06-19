angular.module('studentControllers', [])
    .controller('studentsCtrl', ['$scope', 'dataService', function ($scope, dataService) {
        $scope.list;
        $scope.student = {};
        dataService.getData().then(function (x) {
            $scope.list = x.data;
        });
    }])
    .controller('addCtrl', ['$scope','$location', 'dataService', function ($scope, $location, dataService) {
        $scope.student = {};

        var clearInput = function () {
            $scope.student.rollNo = null;
            $scope.student.name = "";
            $scope.student.age = null;
            $scope.student.email = "";
            $scope.student.isMale = null;
            $scope.student.date = null;
        }

        $scope.addStudent = function (student) {
                $scope.isTrue = true;
                dataService.addData(student).then(function () {
                    clearInput();
                    $location.path("\students");
                    $scope.isTrue = false;
                });
        }

        clearInput();
    }])
    .controller('deleteCtrl', ['$scope','$location', 'dataService', function ($scope, $location, dataService) {
        $scope.deleteStudent = function (roll) {
            $scope.isTrue = true;
            dataService.deleteData(roll).then(function () {
                $scope.isTrue = false;
            });
        }
    }])
    .controller('confirmDelete',['$scope','$window', function($scope,$window){
        $scope.showConfirm = function(roll){
            if ($window.confirm("Please confirm?")) {
               $scope.deleteStudent(roll);
            }
        }
    }]);