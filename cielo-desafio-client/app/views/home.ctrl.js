'use strict';
angular
    .module('app.core')
    .controller('HomeController', function($scope,lancamentos) {
        var vm = this;
        vm.lancamentos = lancamentos;
    });
