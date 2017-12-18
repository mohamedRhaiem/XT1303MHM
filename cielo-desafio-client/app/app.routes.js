'use strict';

angular
    .module('app.routes', ['ngRoute'])
    .config(config);

function config ($routeProvider) {
    $routeProvider
        .when('/lancamentos', {
            templateUrl: 'views/home.html',
            controller: 'HomeController as vm',
            resolve: {
                lancamentos: function(DataService) {
                    return DataService.getList();
                }
            }
        })
        .otherwise({
            redirectTo: '/lancamentos'
        });
}