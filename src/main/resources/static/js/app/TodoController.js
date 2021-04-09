'use strict'

var module = angular.module('todo.controllers', []);
module.controller("TodoController", ["$scope", "TodoService",
    function($scope, TodoService) {

        $scope.todoDto = {
            id: null,
            user: null
        };

        TodoService.getAllTodos().then(function(value) {
        	console.log("service called");
        	$scope.allTodos = value.data;
            console.log(value.data);
        }, function(reason) {
            console.log("error occured");
        }, function(value) {
            console.log("no callback");
        });
        /*        TodoService.getTodoById(1).then(function(value) {
            console.log(value.data);
        }, function(reason) {
            console.log("error occured");
        }, function(value) {
            console.log("no callback");
        });

      $scope.saveUser = function() {
            $scope.userDto.skillDtos = $scope.skills.map(skill => {
                return {
                    skillId: null,
                    skillName: skill
                };
            });
            UserService.saveUser($scope.userDto).then(function() {
                console.log("works");
                UserService.getAllUsers().then(function(value) {
                    $scope.allUsers = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });

                $scope.skills = [];
                $scope.userDto = {
                    userId: null,
                    userName: null,
                    skillDtos: []
                };
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }
       */
    }
]);