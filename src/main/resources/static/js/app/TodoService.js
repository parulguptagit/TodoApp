'use strict'

angular.module('todo.services', []).factory('TodoService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getAllTodos = function() {
        return $http.get(CONSTANTS.getAllTodos);
    }
    /*service.getTodoById = function(Id) {
        var url = CONSTANTS.getTodoByIdUrl + Id;
        return $http.get(url);
    }
    service.getAllUsers = function() {
        return $http.get(CONSTANTS.getAllUsers);
    }
    service.saveUser = function(userDto) {
        return $http.post(CONSTANTS.saveUser, userDto);
    }
    */
    return service;
}]);