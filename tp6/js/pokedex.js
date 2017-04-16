var pokeApp = angular.module('pokedex', ['ngResource']);

// With this you can inject POKEAPI url wherever you want
pokeApp.constant('POKEAPI', 'http://pokeapi.co');

pokeApp.config(['$resourceProvider', function ($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

pokeApp.directive('pokedex', function() {});

//1er service dédié à l'API
pokeApp.factory('pokesirApi', ['$resource', 'POKEAPI', function ($resource, POKEAPI) {
    return $resource(POKEAPI + "/api/v1/pokedex/");
}]);

//2ème service permettant l'échange d'informations
pokeApp.factory('Service', function(){
    this.idPokemon = 0;
    this.nomPokemon = 0;
    return this.idPokemon, this.nomPokemon;
});

//controller 1 pour la recherche
pokeApp.controller('controller', ['$scope', 'Service', '$log', 'pokesirApi', function ($scope, Service, $log, pokesirApi) {

    $scope.idPokemon = "";
    $scope.nomPokemon = "";


    $scope.$log = $log;

    $scope.Pokemon = [
        /*{ nomPokemon: 'Pikachu', idPokemon: 1 },
        { nomPokemon: 'Tortank', idPokemon: 2 },
        { nomPokemon: 'Herbizarre', idPokemon: 3 },
        { nomPokemon: 'Dracaufeu', idPokemon: 4 },
        { nomPokemon: 'Psykokwak', idPokemon: 5 }*/
    ]

    var PokemonTemp = [];

    var Id = pokesirApi.get({/* id: $scope.idPokemon */ }, function () {
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
        console.log($scope.idPokemon);


    };

    $scope.reset = function () {
        $scope.nomPokemon = "";
        $scope.idPokemon = "";
    };

}]);

//controller 2 pour l'affichage
pokeApp.controller('controllerAffichage', ['$scope', 'Service', 'pokesirApi', function ($scope, Service, pokesirApi) {


    //Déclenche opérations lorsque valeurs de propriétés changent
    //1er param : propriété observée
    //2ème param : fonction appelée quand 1er param change
    $scope.$watch("$scope.idPokemon", function(newValue, oldValue){
        if(newValue) { 
            Service.idPokemon = newValue;
            console.log(Service.idPokemon);
        }
    });
}]);







