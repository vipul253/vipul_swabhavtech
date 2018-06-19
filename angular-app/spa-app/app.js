angular.module('spa-app', ['ngRoute', 'swabhavControllers']).config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/',{
        templateUrl: 'partials/home.html',
        controller: 'homeCtrl',
    })
        .when('/home',{
            templateUrl: 'partials/home.html',
            controller: 'homeCtrl'
        })
        .when('/about',{
            templateUrl: 'partials/about.html',
            controller: 'aboutCtrl'
        })
        .when('/career',{
            templateUrl: 'partials/career.html',
            controller: 'careerCtrl'
        });
}]);