angular.module('app.allSets').controller('SearchForSetCntl', function($scope, $http, $location){
    'use strict';

    $scope.model = {type: 'M'};

    $scope.searchForLegoSet = function () {
        $http({
            method: 'GET',
            url: 'https://rebrickable.com/api/search',
            params: {
                key: 'JfDxhwY7Cn',
                format: 'json',
                type: $scope.model.type,
                query: $scope.model.query
            }
        }).then(function(result) {
            $scope.searchResults = result.data.results;

        });
    };

    $scope.displaySetParts = function(setID){
        $location.path("/allSets/searchParts").search({set_id: setID});;
    };

});


