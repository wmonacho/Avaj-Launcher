# Avaj-Launcher

Un simulateur de vol en Java implémentant le pattern Observer pour gérer les interactions entre appareils volants et conditions météorologiques.

## 🎯 Description

Avaj-Launcher est un projet de simulation de vol développé dans le cadre du cursus 42. Le programme simule le comportement de différents types d'appareils volants (ballons, hélicoptères, avions à réaction) dans diverses conditions météorologiques.

## 🏗️ Architecture

Le projet utilise plusieurs design patterns :

- **Observer Pattern** : La tour météo notifie les appareils des changements de conditions
- **Singleton Pattern** : WeatherProvider assure une source météo unique
- **Factory Pattern** : AircraftFactory crée les appareils selon leur type
- **Strategy Pattern** : Chaque appareil a sa propre stratégie de réaction météo

### Structure des packages

```
src/
├── simulator/          # Point d'entrée et utilitaires
│   ├── Simulator.java
│   └── SimulationLogger.java
├── aircraft/           # Appareils volants et coordonnées
│   ├── Aircraft.java
│   ├── AircraftFactory.java
│   ├── Coordinates.java
│   ├── Baloon.java
│   ├── Helicopter.java
│   └── JetPlane.java
├── weather/            # Système météorologique
│   ├── Tower.java
│   ├── WeatherTower.java
│   └── WeatherProvider.java
└── flyable/            # Interface commune
    └── Flyable.java
```

## 🚀 Compilation et Exécution

### Prérequis
- Java 11 ou supérieur
- JDK installé

### Compilation
```bash
# Compilation automatique
./Simulator.sh

# Ou manuellement
find . -name "*.java" > sources.txt
javac @sources.txt
```

### Exécution
```bash
java -cp src simulator.Simulator scenario/scenario_subject.txt
```

## 📋 Format du fichier scénario

Le fichier de scénario doit respecter ce format :

```
[NOMBRE_DE_CYCLES]
[TYPE] [NOM] [LONGITUDE] [LATITUDE] [HAUTEUR]
[TYPE] [NOM] [LONGITUDE] [LATITUDE] [HAUTEUR]
...
```

### Exemple
```
5
Baloon B1 2 3 20
JetPlane J1 23 44 32
Helicopter H1 654 33 20
```

### Types d'appareils supportés
- `Baloon` : Ballon dirigeable
- `JetPlane` : Avion à réaction  
- `Helicopter` : Hélicoptère

## 🌤️ Conditions météorologiques

Le simulateur gère 4 types de météo : **SUN**, **RAIN**, **FOG**, **SNOW**

### Comportements par appareil

#### Baloon
- **SUN** : longitude +2, hauteur +4
- **RAIN** : hauteur -5
- **FOG** : hauteur -3
- **SNOW** : hauteur -15

#### JetPlane
- **SUN** : latitude +10, hauteur +2
- **RAIN** : latitude +5
- **FOG** : latitude +1
- **SNOW** : hauteur -7

#### Helicopter
- **SUN** : longitude +10, hauteur +2
- **RAIN** : longitude +5
- **FOG** : longitude +1
- **SNOW** : hauteur -12

## 📄 Sortie

Le programme génère un fichier `simulation.txt` contenant :

1. **Messages d'enregistrement** : `Tower says: TYPE#NAME(ID) registered to weather tower.`
2. **Messages de conditions** : `TYPE#NAME(ID): [message selon la météo]`
3. **Messages d'atterrissage** : `TYPE#NAME(ID) landing.`
4. **Messages de désenregistrement** : `Tower says: TYPE#NAME(ID) unregistered from weather tower.`

### Exemple de sortie
```
Tower says: Baloon#B1(1) registered to weather tower.
Tower says: JetPlane#J1(2) registered to weather tower.
Baloon#B1(1): Let's enjoy the good weather and take some pics.
JetPlane#J1(2): It's raining. Better watch out for lightings.
Baloon#B1(1) landing.
Tower says: Baloon#B1(1) unregistered from weather tower.
```

## 🔧 Règles de simulation

- **Coordonnées** : Doivent être positives
- **Hauteur** : Limitée entre 0 et 100
- **Atterrissage** : Automatique quand hauteur ≤ 0
- **ID unique** : Chaque appareil reçoit un identifiant unique
- **Météo déterministe** : Basée sur la position (longitude + latitude + hauteur) % 4

## 🧪 Tests

Le projet inclut des scénarios de test :

- `scenario/scenario_subject.txt` : Scénario principal
- `scenario/scenario_1.txt` : Test avec peu d'appareils
- `scenario/scenario_2.txt` : Test avec nombreux cycles
- `scenario/scenario_3.txt` : Test d'atterrissage rapide

## 📝 Validation

Le programme valide automatiquement :

- ✅ Format du fichier scénario
- ✅ Types d'appareils supportés
- ✅ Coordonnées positives
- ✅ Hauteur dans la plage [0, 100]
- ✅ Nombre de paramètres par ligne

## 🎓 Objectifs pédagogiques

Ce projet permet d'apprendre :

- **Design Patterns** : Observer, Singleton, Factory
- **Programmation Orientée Objet** : Héritage, polymorphisme, encapsulation
- **Architecture logicielle** : Séparation des responsabilités
- **Gestion d'erreurs** : Validation, exceptions
- **I/O Java** : Lecture de fichiers, écriture de logs

## 👨‍💻 Auteur

Développé dans le cadre du cursus 42.

## 📄 Licence

Ce projet est développé à des fins éducatives dans le cadre de l'école 42.