# Projet Transit

## Setup - analyse
- ++ finir setup (d�pendances + 2 db)
- ++ faire un mod�le UML pour les entity

## Data
- ++ �crire les classes (Trip, Stop, Route, Calendar, Agency, StopTime, CalendarDate) avec les champs et les annotations JPA
- ++ �crire l'interface DAO
- ++ impl�menter les DAO 
- ++ ecrire les tests.

## Service
- impl�menter le GTFSParser.java
- implementer GTFSSearch.java avec des requ�tes JPQL

## Presentation
- ++ creer 3 jsp (index.jsp, import.jsp, search.jsp)
- ++ creer 2 actions (UploadAction.java, SearchAction.java)
- creer les mapping dans struts.xml
- impl�menter import via le tuto struts
- impl�menter search avec des tableaux ()


# Risques
- parser
- requetes de search
- l'affichage search.jsp


 


# BUG

BIG issue when accessing trip.getStopTimeList with this fuckin' stop_id

FIX THIS


