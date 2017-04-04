
var editingMode = { rect: 0, line: 1 };

//crayon avec couelur, épaisseur et type de forme
function Pencil(ctx, drawing, canvas) {
	this.currEditingMode = editingMode.line;
	this.currLineWidth = 5;
	this.currColour = '#000000';
	this.currentShape = 0;

	// Liez ici les widgets à la classe pour modifier les attributs présents ci-dessus.

	new DnD(canvas, this);

	// Implémentez ici les 3 fonctions onInteractionStart, onInteractionUpdate et onInteractionEnd
	function onInteractionStart(){

	}

	function onInteractionUpdate(){

	}

	function onInteractionEnd(){

	}

};


