# Java kata - Delivery APP

Cette application est une implémentation d'un système de gestion de livraison.

## Table des matières
- [Introduction](#introduction)
- [Technologies utilisées](#technologies-utilisées)
- [Fonctionnalités](#fonctionnalités)
- [Installation](#installation)
- [Utilisation](#utilisation)
- [Endpoints API REST](#endpoints-api-rest)
- [Documentation API](#documentation-api)
- [Tests](#tests)
- [Contribuer](#contribuer)
- [License](#license)

## Introduction
L'application permet aux clients de choisir leur mode de livraison ainsi que leur créneau horaire pour la livraison de leurs produits commandés.

## Technologies utilisées
- Java 21
- Spring Boot 3.2.x
- Spring Data JPA
- Swager
- Git
- Docker
- K8s
- Kafka
- Hateos

## Fonctionnalités
- Les clients peuvent choisir parmi les modes de livraison suivants : DRIVE, DELIVERY, DELIVERY_TODAY, DELIVERY_ASAP.
- Les clients peuvent sélectionner un jour et un créneau horaire spécifique pour leur livraison.
- Les créneaux horaires sont spécifiques à chaque mode de livraison et sont réservables par d'autres clients.

## Installation
1. Clonez ce repository : git clone https://github.com/ezzouine/DeliveryAPP.git
2. Assurez-vous d'avoir Java 21 et Maven installés sur votre machine.
3. Compilez le projet en utilisant Maven : `mvn clean install`
4. Generer l'image docker à partir dur fichier Dockerfile
5. Utiliser les fichiers .yml situés sous le dossier K8S pour le déploiement de l'application
6. deploy-app.yaml Permet de déployer l'application sous K8S 
7. app-service.yaml Permet d'exposer l'application comme un service
8. app-ingress.yaml Permet de créer l'ingress
9. Utiliser l'instruction suivante pour chaque fichier " kubectl create -f FILENAME "

## Utilisation
1. Configurez les paramètres de connexion à la base de données dans le fichier `src/main/resources/application.yml`.
2. Lancez l'application : `java -jar target/delivery-application-service.jar`

## Endpoints API REST
- **GET /delivery-modes** : Récupère la liste des modes de livraison disponibles.
- **GET /api/delivery** : Récupère la liste des créneaux horaires disponibles.
- **/api/delivery/reserve** : Réserve un créneau horaire pour une livraison.
- **/api/delivery/{id}** : Récupère un créneau horaire par identifiant.

## Documentation API
La documentation de l'API est disponible sur `/swagger-ui/index.html`.

## Contribuer
Les contributions sont les bienvenues. Pour toute suggestion ou rapport de bug, veuillez ouvrir une issue dans ce repository.

## License
Ce projet est sous licence MIT. Veuillez consulter le fichier LICENSE pour plus d'informations.
