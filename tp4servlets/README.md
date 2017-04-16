#Premier rendu avec backend en JAva (TP JPA + JaxRS + Servlet)
*Camille BARBE - Safiah SEEDAT*

##Plusieurs technologies utilisées :
- JPA (Java Persistence Application) : 
C'est un fournisseur de persistance c'est à dire une spécification qui définit un ensemble de règles permettant la gestion de la correspondance entre des objets Java et une base de données (ORM : Object-Relational Mapping).
JPA est donc une API, c’est-à-dire une description d'un standard à respecter. Hibernate est un framework ORM qui permet d'implémenter JPA.

- Servlets :
Ce sont des classes JAVA qui permettent de recevoir et de traiter des requêtes HTTP et de renvoyer une réponse HTTP. 

- JaxRS : 
API qui propose notamment des annotations pour lier une URI et des verbes HTTP à des méthodes d'une classe java. Jersey est un framework qui permet de développer des services web selon l'architecture REST et suivant ces spécifications.

##JPA :
On met de préférence les annotations sur les getters et les setters.
@Entity permet de déclarer la classe en tant qu'entité.
Pour les collections, on utilise l'annotation @ManyToMany.
Pour les Id, on utilise @Id et @GeneratedValue pour qu'ils soient générés automatiquement.
Eventuellement, pour les dates, on utilisera @Temporal.
Pour les relations bi-directionnelles, on utilisera @ManyToMany(mappedBy="").
Pour les @OneToOne et @ManyToMany, peu importe de quel côté on met l'annotation. En revanche, pour les @OneToMany, on mettra l'annotation là où on aura la collection.
Transient permet de déclarer les clés étrangères.

La classe de service JpaTest permet de remplir la base mais aussi de faire des requêtes sur la base de données.

##Servlets :
La requête HTTP part du client et arrive sur le serveur.
Le serveur HTTP écoute les requêtes HTTP sur le port 80.

Le serveur transmet à un autre élément : un conteneur de servlets. Celui-ci va alors créer deux nouveaux objets :
•	HttpServletRequest : cet objet contient la requête HTTP, et donne accès à toutes ses informations (header et corps de la requête).
•	HttpServletResponse : cet objet initialise la réponse HTTP qui sera renvoyée au client, et permet de la personnaliser, en initialisant par exemple les en-têtes et le corps.

Une servlet HTTP doit hériter de la classe abstraite HttpServlet. Les méthodes doGet() et doPost() permettront de répondre aux requêtes HTTP suivantes :
-	GET : récupérer et lire une ressource web du serveur via une URL
-	POST : envoyer au serveur des données.

myform.html permet de rentrer des données.
Une classe Java permet ensuite de récupérer ses infos pour les envoyer en base de données.

A appeler pour afficher le formulaire :
http://localhost:8080/myform.html

##JaxRS :
Permet de réaliser l'API REST facilement grâce à des annotations : @GET, @Path...
