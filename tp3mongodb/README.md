Quelles sont les limites d’une base données orientées document ?
Il n’y a aucun schéma fixe, un document peut contenir n’importe quel type d’informations. 
C’est une base de données principalement utilisée pour du stockage et il est nécessaire que la base soit consciente de ce qu’elle stocke afin de permettre des fonctionnalités sur les documents. Par ailleurs, la modélisation en document ne permet pas la même flexibilité dans les requêtes et les chargements de données que la modélisation relationnelle.

Quelles sont les types de données stockés dans Redis, que peut on faire comme types de requêtes ?
Redis est une base de données opensource orientée clés-valeurs. C’est une sorte de grosse HashMap avec des données structurées de type chaînes de caractères (strings), compteurs atomiques (atomic counters), listes (lists), hash, set ou encore des sets triés (sorted set). Il est impossible de faire des requêtes sur les valeurs avec WHERE comme en SQL. 
Sur des strings, on pourra par exemple faire des SET, GET, INCR, DECR et GETSET de cette manière : redis 127.0.0.1:6379> SET compteur 10
