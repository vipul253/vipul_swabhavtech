angular.module('studentControllers').service('loginService', ['$rootScope','$location', function ($rootScope,$location) {
    var url = "partials/users.json";

    var users = {
        "vipul": "123",
        "abc": "abc",
        "neiu": "neiu"
    };

    $rootScope.sessionState = JSON.parse(sessionStorage.getItem("session")) || localStorage.getItem("session") || false;
    $rootScope.username = sessionStorage.getItem("username") || localStorage.getItem("session") || "Guest";

    if (JSON.parse(localStorage.getItem("session")) == true) {
        $rootScope.sessionState = true;
    }
    function toRemember(user, remember) {
        if (remember) {
            localStorage.setItem("session", true);
            localStorage.setItem("username", user.name);
        }
    }

    this.checkLogin = function (user, remember) {
        if (users[user.name] == user.pwd) {
            $rootScope.sessionState=true;
            $rootScope.username=user.name;
            sessionStorage.setItem("session", true);
            sessionStorage.setItem("username", user.name);
            toRemember(user, remember);
            $location.path("/students");
        }
    }

    this.checkSession = function () {
        return $rootScope.sessionState;
    }

    this.endSession = function () {
        sessionStorage.removeItem("session");
        sessionStorage.removeItem("username");
        localStorage.removeItem("session");
        localStorage.removeItem("username");
        $rootScope.sessionState=false;
        $rootScope.username="Guest";
        $location.path("/students");
    }
}]);