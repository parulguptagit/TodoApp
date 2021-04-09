'use strict'

var todoApp = angular.module('todo', ['ui.bootstrap', 'todo.controllers','todo.services'
]);
todoApp.constant("CONSTANTS", {
   getTodoByIdUrl: "/todos/id",
   getAllTodos: "/todos",
   saveUser: "/user/saveUser"
});