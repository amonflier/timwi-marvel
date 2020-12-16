Bonjour,

Je n'ai pas pu obtenir une clé API sur le site Marvel, la page d'obtention de cette dernière tournant dans le vide.
J'ai donc créé un fichier json reprenant le template théorique de réponse du site avec quelques personnages
(db.json).

L'idée est de monter un serveur JSON en local en utilisant l'outil json-server.
Pour se faire :
	- Installer json-server via la commande Powershell "npm install -g json-server"
	- Depuis la racine du projet, lancer la commande Powershell "json-server db.json"
	- Vérification depuis le navigateur : "http://localhost:3000"

Le projet Angular peut ensuite être lancé, les deux pages webs étant accessibles aux adresses:
- http://localhost:4200/api/superteam
- http://localhost:4200/api/characters

Autre problème rencontré, pour une raison qui m'échappe je n'ai pas réussi à démarrer mon projet Spring-boot.
J'ai donc choisi de stocker les ids des membres de la Superteam dans le même fichier JSON.

Dans les deux cas de figures l'accès aux données se fait via appel http, il devrait dont y avoir peu d'impacts
sur ce qu'aurait du être la partie front.
J'ai tout de même laissé ma tentative de projet Spring-boot dans le répertoire "marvel" à la racine du projet.

Cordialement,

Antoine MONFLIER