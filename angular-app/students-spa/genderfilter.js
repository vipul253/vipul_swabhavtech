angular.module('students-app').filter('gender',function(){
    return function(isMale){
        if(isMale){
            return "Male";
        }
        return "Female";
    };
});