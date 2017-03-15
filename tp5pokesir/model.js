
// Implémenter ici les 4 classes du modèle.
// N'oubliez pas l'héritage !

// Représente un dessin
function Drawing(){
    //Liste des formes d'un dessin
    this.forms = new array();
    this.getForms = function (){
        for(var i = 0; i < array.length; i++){
            return array[i];
        }
    }

    this.addForms = function (i) {
        this.array.push(i);
    }
}


function MyForm(xi, yi, xf, yf, couleur, epaisseur) {
    this.xi = xi;
    this.yi = yi;
    this.xf = xf;
    this.yf = yf;
    this.couleur = couleur;
    this.epaisseur = epaisseur;

    //getters
    this.getXi = function (){
        return this.xi;
    }.bind(this);

    this.getYi = function (){
        return this.yi;
    }.bind(this);

    this.getXf = function (){
        return this.xi;
    }.bind(this);

    this.getYf = function (){
        return this.xf;
    }.bind(this);

    this.getCouleur = function (){
        return this.couleur;
    }.bind(this);

    this.getEpaisseur = function (){
        return this.epaisseur;
    }.bind(this);

    //setters
    this.setXi = function (xi){
        return this.xi = xi;
    }.bind(this);

    this.setXf = function (xf){
        return this.xf = xf;
    }.bind(this);

    this.setYi = function (yi){
        return this.yi = yi;
    }.bind(this);

    this.setYf = function (yf){
        return this.yf = yf;
    }.bind(this);

    this.setCouleur = function (couleur){
        return this.couleur = couleur;
    }.bind(this);

    this.setEpaisseur = function (epaisseur){
        return this.epaisseur = epaisseur;
    }.bind(this);
}

//Forme possible ligne
//Récupérer point initial et final
function Line(xi, yi, xf, yf){
    //Héritage
    MyForm.call(this, xi, yi, xf, yf);
    return xi, yi, xf, yf;
}
Line.prototype = new MyForm();

//Forme possible Rectangle
//Récupérer Xi - Xf et Yi - Yf
function Rectangle(xi, yi, largeur, hauteur){
    //Héritage
    MyForm.call(this, xi, yi, largeur, hauteur);
    largeur = this.xf-xi;
    hauteur = this.yf-yi;
    return xi, yi, largeur, hauteur;
}
Rectangle.prototype = new MyForm();