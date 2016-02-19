angular.module('app.mySets', ['ngRoute', 'app.mySets.templates'])
    .config(function ($routeProvider) {
        'use strict';
        $routeProvider.when('/mySets/owned', {templateUrl: 'mySets/owned/ownedSets.html'});
        $routeProvider.when('/mySets/wanted', {templateUrl: 'mySets/wanted/wantedSets.html'});
    });
