var pokeApp = angular.module('pokedex', ['ngResource']);

// With this you can inject POKEAPI url wherever you want
pokeApp.constant('POKEAPI', 'http://pokeapi.co');

pokeApp.config(['$resourceProvider', function ($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

pokeApp.factory('pokesirApi', ['$resource', 'POKEAPI', function ($resource, POKEAPI) {
    return $resource(POKEAPI + "/api/v1/pokedex/");
}]);

//pokeApp
pokeApp.controller('controller', ['$scope', '$log', 'pokesirApi', function ($scope, $log, pokesirApi) {
    $scope.$log = $log;
    $scope.Pokemon = [
        /*{ nomPokemon: 'Pikachu', idPokemon: 1 },
        { nomPokemon: 'Tortank', idPokemon: 2 },
        { nomPokemon: 'Herbizarre', idPokemon: 3 },
        { nomPokemon: 'Dracaufeu', idPokemon: 4 },
        { nomPokemon: 'Psykokwak', idPokemon: 5 }*/
    ]

    var PokemonTemp = [];

    var Id = pokesirApi.get({}, function () {
        $scope.Pokemon = Id;

        Id = Id["objects"]["0"]["pokemon"];
        console.log(Id.length);
        var h = 0;
        for (var i in Id) {
            var id = Id[i]["resource_uri"].split("/");
            id = id[id.length-2]; 
            PokemonTemp[id] = Id[i]["name"];
        }
        $scope.Pokemon = PokemonTemp;
        console.log($scope.Pokemon);
    });

    $scope.submit = function () {
        var slt = document.getElementById("Pokemon");
        slt = slt.options[slt.selectedIndex].text.split(" ");

        $scope.idPokemon = slt[0];
        $scope.nomPokemon = slt[1];


    };

    $scope.reset = function () {
        $scope.nomPokemon = "";
        $scope.idPokemon = "";
    };

}]);








