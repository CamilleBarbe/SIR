Deuxième rendu avec le TP6 angularJS pokemon api ou swapi :
==================
*Camille BARBE - Safiah SEEDAT*

##2 fichiers importants :
-index.html : contient tout le html du pokesir avec le formulaire et les informations du pokemon affichés.
-pokedex.js : contient le javascript, notamment les deux controleurs du pokesir (controlleur et controlleurAffichage).

##Plusieurs étapes :
- Recherche du pokemon par son nom ou son id grâce aux deux premiers champs texte :
On utilise la directive "ng-model". Les directives sont utilisées lorsque l'on souhaite modifier ou transformer le DOM (Document Object Model). Les plus connues fournies par Angular sont : ngController, ngRepeat et ngModel. ngModel est une directive qui permet de lier la valeur d'une balise HTML à une variable du modèle.

- Recherche dans une liste : 
On utilise ici la directive ng-controller pour attacher le controleur à la vue. Dans un premier temps, la recherche dans les champs id et nom du Pokemon permettent de présélectionner un pokemon dans la liste.
3 boutons sont présents : "Go" pour lancer la recherche du pokemon et donc afficher ses informations (via le 2ème controlleur), "Reset" pour réinitialiser les champs, "Log" pour afficher dans la console le pokemon sélectionné. Chaque bouton renvoie à une fonction du controlleur.

- Accès à l'API http://pokeapi.co/ qui propose les infos sur les pokémons : 
On les récupère en utilisant le service $resource qui implémente les requêtes de bases pour interroger une API REST. Voici donc le service qui encapsule notre appel à $resource :
*//1er service dédié à l'API
pokeApp.factory('pokesirApi', ['$resource', 'POKEAPI', function ($resource, POKEAPI) {
    return $resource(POKEAPI + "/api/v1/pokedex/");
}]);*
La factory permet d'instancier un élément qu'une fois.
Le deuxième controlleur créé permet d'afficher les informations du pokemon. D'un point de vue html, il est intégré dans le premier ng-controller. Concernant, le javascript :
*//controller 2 pour l'affichage
pokeApp.controller('controllerAffichage', ['$scope', 'Service', 'pokesirApi', function ($scope, Service, pokesirApi) {}]);*

- Communication entre controleurs : 
Pour faire communiquer les deux contrôleurs, nous avons créé un nouveau service qui contient les informations à partager : 
*//2ème service permettant l'échange d'informations
pokeApp.factory('Service', function(){
    this.idPokemon = 0;
    this.nomPokemon = 0;
    return this.idPokemon, this.nomPokemon;
});*

Le service $watch permet de mettre à jour l'affichage du pokédex lors du changement du pokémon recherché :
*//controller 2 pour l'affichage
pokeApp.controller('controllerAffichage', ['$scope', 'Service', 'pokesirApi', function ($scope, Service, pokesirApi) {
    $scope.$watch("$scope.idPokemon", function(newValue, oldValue){
        if(newValue) { 
            Service.idPokemon = newValue;
            console.log(Service.idPokemon);
        }
    });
}]);*

- Création d'une directive : 
*pokeApp.directive('pokedex', function(){
	return {
		templateUrl: 'pokedex.html'
	};
});*
Où pokedex est la balise dans index.html et pokedex.html contient le code auparavant contenu dans index.html. 
