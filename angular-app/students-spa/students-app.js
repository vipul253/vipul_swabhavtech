angular.module('students-app', ['ngRoute', 'studentControllers']).config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/',{
        templateUrl: 'partials/students.html',
        controller: 'studentsCtrl',
    })
        .when('/students',{
            templateUrl: 'partials/students.html',
            controller: 'studentsCtrl'
        })
        .when('/add',{
            templateUrl: 'partials/add.html',
            controller: 'addCtrl'
        });   
}]);