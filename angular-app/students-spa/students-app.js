angular.module('students-app', ['ngRoute', 'studentControllers']).config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/', {
        templateUrl: 'partials/students.html',
        controller: 'studentsCtrl'
    })
    .when('/students', {
        templateUrl: 'partials/students.html',
        controller: 'studentsCtrl'
    })
    .when('/add', {
        templateUrl: 'partials/add.html',
        controller: 'addCtrl'
    })
    .when('/edit/:rollNo', {
        templateUrl: 'partials/edit.html',
        controller: 'editCtrl'
    })
    .when('/login', {
        templateUrl: 'partials/login.html',
        controller: 'loginCtrl'
    })
    .when('/logout', {
        templateUrl: 'partials/logout.html',
        controller: 'logoutCtrl'
    });
}]);