angular.module('modA', ['modB', 'modC']).controller('invoiceController', function ($rootScope, $scope) {
    $rootScope.developer = "vipul";
    $scope.cost = 1000;
});

angular.module('modB', []).controller('addressController', function ($rootScope, $scope) {
    console.log($rootScope.developer);
    $scope.address = {
        city: "mumbai",
        state: "maharashtra",
        country: "India"

    }
});

angular.module('modC', []).controller('orderController', function ($rootScope, $scope) {
    console.log($rootScope.developer);
    $scope.product = {
        id: 123,
        name: "iphone"
    }
});