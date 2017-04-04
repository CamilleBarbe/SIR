
// La création d'un Dnd requière un canvas et un interacteur.
// L'interacteur viendra dans un second temps donc ne vous en souciez pas au départ.
function DnD(canvas, interactor) {
  
	// Définir ici les attributs de la 'classe'
	  this.xi = 0;
  	  this.yi = 0;
      this.xf = 0;
      this.yf = 0;
	  var b;


	// Developper les 3 fonctions gérant les événements
	this.mousedown = function(evt) {
		interactor.onInteractionStart(this);
		var xi = getMousePosition(canvas, evt).x;
  		var yi = getMousePosition(canvas, evt).y;
		console.log('mousedown xi : ' + xi);
		console.log('mousedown yi : ' + yi);

		//bouton souris appuyé
		b = true;
  	}.bind(this) ;
  	
  	this.mousemove = function(evt) {
  		if(b == true) {
			interactor.onInteractionUpdate(this);
			var xf = getMousePosition(canvas, evt).x;
			var yf = getMousePosition(canvas, evt).y;
			console.log('mousemove xf : ' + xf);
			console.log('mousemove yf : ' + yf);
		}
    }.bind(this) ;
  
    this.mouseup = function(evt) {
		interactor.onInteractionEnd(this);
		//bouton relaché donc pas de trait
    	b = false;
    }.bind(this) ;  
  
	// Associer les fonctions précédentes aux évènements du canvas.
	canvas.addEventListener('mousedown', this.mousedown, false);
	canvas.addEventListener('mousemove', this.mousemove, false);
	canvas.addEventListener('mouseup', this.mouseup, false);
	
};


// Place le point de l'événement evt relativement à la position du canvas.
function getMousePosition(canvas, evt) {
  var rect = canvas.getBoundingClientRect();
  return {
    x: evt.clientX - rect.left,
    y: evt.clientY - rect.top
  };
};



