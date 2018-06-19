angular.module('swabhavControllers', [])
    .controller('homeCtrl', ['$scope', '$log', function ($scope, $log) {
        $log.info("inside home");
        $scope.homedata = "home data";
    }])
    .controller('aboutCtrl', ['$scope', '$log', function ($scope, $log) {
        $log.info("inside about");
        $scope.aboutdata = "about data";
    }])
    .controller('careerCtrl', ['$scope', '$log', function ($scope, $log) {
        $log.info("inside career");
        $scope.careerdata = "career data";
    }]);
