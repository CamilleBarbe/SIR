
// Implémenter ici les fonctions paint à ajouter dans chacune des classes du modèle.

//Configure la couleur et l'épaisseur du trait et du contexte du canvas
MyForm.prototype.clear = function(ctx){
    canvas.getContext('2d').fillStyle = "#FOFOFO";
    ctx.fullRect(0,0, canvas.width, canvas.height);
};

Rectangle.prototype.paint = function(ctx) {
//TODO Manager color
    ctx.rect(this.getXi(), this.getYi(), this.getXf(), this.getYf());
    ctx.stroke();
};

Line.prototype.paint = function(ctx) {
//TODO Manager color

    ctx.beginPath();
    ctx.moveTo(this.getXi(), this.getYi());
    ctx.lineTo(this.getXf(), this.getYf());
    ctx.stroke();

};

//Peint le fond du canvas en gris clair
Drawing.prototype.paint = function(ctx) {
    console.log(this.getForms());
    ctx.fillStyle = '#F0F0F0'; // set canvas' background color
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    this.getForms().forEach(function(eltDuTableau) {
        // now fill the canvas
        eltDuTableau.paint(ctx);
    });
};
