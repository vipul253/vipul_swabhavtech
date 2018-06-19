angular.module('studentControllers').service('dataService',['$http', function ($http) {
    var url = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/";

    this.getStudent = function (id) {
        return $http.get(url + id);
    }

    this.getData = function () {
        return $http.get(url);
    }

    this.addData = function (stud) {
        return $http.post(url, stud);
    }

    this.editData = function (id, student) {
        return $http.put(url + id, student);
    }

    this.deleteData = function (id) {
        return $http.delete(url + id);
    }
}]);