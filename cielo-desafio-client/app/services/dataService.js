'use strict';

/*
 * Contains a service to get the list of lancamento
 */
angular
    .module('app.services')
    .constant('BASE_URL', 'http://localhost:8081/serv/v1/lancamento')
    .factory('DataService', dataService);

function dataService($http, BASE_URL,$log) {
    var data = {
        'getList': getList
    };
    function makeRequest(url, params) {
        var requestUrl = BASE_URL + '/' + url;
        angular.forEach(params, function(value, key){
            requestUrl = requestUrl + '&' + key + '=' + value;
        });
        return $http({
            'url': requestUrl,
            'method': 'GET',
            'headers': {
                'Content-Type': 'application/json'
            },
            'cache': true
        }).then(function(response){
            return response.data;
        }).catch(dataServiceError);
    }
    function getList(id) {
        return makeRequest('list', {});
    }
    return data;

    function dataServiceError(errorResponse) {
        $log.error('XHR Failed for ShowService');
        $log.error(errorResponse);
        return errorResponse;
    }
}