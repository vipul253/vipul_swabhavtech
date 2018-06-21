angular.module('studentControllers', [])
    .controller('studentsCtrl', ['$scope', '$location', 'dataService', 'loginService', function ($scope, $location, dataService, loginService) {
        $scope.list;
        $scope.student = {};
        $scope.isLoading = false;

        $scope.gotoEdit = function (id) {
            if (!loginService.checkSession()) {
                $location.path("/login");
                return;
            }
            $location.path("/edit/" + id);
        }

        dataService.getData().then(function (x) {
            $scope.list = x.data;
            $scope.isLoading = true;
        });
    }])
    .controller('addCtrl', ['$scope', '$location', 'dataService', 'loginService', function ($scope, $location, dataService, loginService) {
        if (!loginService.checkSession()) {
            $location.path("/login");
        }

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
                $location.path("/students");
                $scope.isTrue = false;
            });
        }

        clearInput();
    }])
    .controller('deleteCtrl', ['$scope', '$route', '$window', '$location', 'dataService', 'loginService',
        function ($scope, $route, $window, $location, dataService, loginService) {
            $scope.deleteStudent = function (roll) {
                if (!loginService.checkSession()) {
                    $location.path("/login");
                    return;
                }
                $scope.isTrue = true;
                if ($window.confirm("confirm delete?")) {
                    dataService.deleteData(roll).then(function () {
                        $route.reload();
                    });
                }
                $scope.isTrue = false;
            }
        }])
    .controller('editCtrl', ['$scope', '$location', '$routeParams', 'dataService', 'loginService',
        function ($scope, $location, $routeParams, dataService, loginService) {
            $scope.roll = $routeParams.rollNo;
            $scope.isLoading = false;
            dataService.getStudent($scope.roll).then(function (x) {
                x.data.date = new Date(x.data.date);
                $scope.student = x.data;
                $scope.isLoading = true;
            });

            $scope.editStudent = function () {
                $scope.isTrue = true;
                dataService.editData($scope.roll, $scope.student).then(function () {
                    $scope.isTrue = false;
                    $location.path("/students");
                });
            }
        }])
    .controller('loginCtrl', ['$scope', '$location', 'loginService', function ($scope, $location, loginService) {
        if (loginService.checkSession()) {
            $location.path("/students");
        }

        $scope.user = {};
        $scope.user.name = "";
        $scope.user.pwd = "";
        $scope.remember = false;

        $scope.login = function (user, remember) {
            loginService.checkLogin(user, remember);
        }
    }])
    .controller('logoutCtrl', ['$scope', '$location', 'loginService', function ($scope, $location, loginService) {
        $scope.logout = function () {
            loginService.endSession();
        }
    }]);