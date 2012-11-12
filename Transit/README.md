# Projet Transit

## Setup - analyse
- ++ finir setup (dépendances + 2 db)
- ++ faire un modèle UML pour les entity

## Data
- ++ écrire les classes (Trip, Stop, Route, Calendar, Agency, StopTime, CalendarDate) avec les champs et les annotations JPA
- ++ écrire l'interface DAO
- ++ implémenter les DAO 
- ++ ecrire les tests.

## Service
- implémenter le GTFSParser.java
- implementer GTFSSearch.java avec des requêtes JPQL

## Presentation
- ++ creer 3 jsp (index.jsp, import.jsp, search.jsp)
- ++ creer 2 actions (UploadAction.java, SearchAction.java)
- creer les mapping dans struts.xml
- implémenter import via le tuto struts
- implémenter search avec des tableaux ()


# Risques
- parser
- requetes de search
- l'affichage search.jsp


 


# BUG

BIG issue when accessing trip.getStopTimeList with this fuckin' stop_id

FIX THIS


