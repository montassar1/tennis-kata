# tennis-kata

# 🎾 Tennis Kata

Ce projet est une implémentation du **Tennis Kata**, un exercice de programmation visant à simuler le score d’un match de tennis selon les règles officielles.

---

## 🚀 Objectif

Simuler le score d’un match de tennis en respectant les règles classiques :  
**15**, **30**, **40**, **Deuce**, **Advantage**, **Win**.

---

## 🧱 Architecture utilisée

Le projet suit le modèle **Architecture Hexagonale (Ports & Adapters)** :

- **Domaine (core)** : logique métier pure (`TennisGame.java`)
- **Adapteur ** : contrôleur REST (`TennisController`)
- **Port ** :  interface (`PlayTennisGameUseCase`)

Ce découplage permet une meilleure testabilité, évolutivité et séparation des responsabilités.

---

## 🛠️ Technologies

- ☕ Java 17
- ✅ JUnit 5 (tests unitaires)
- 🔍 SonarLint (qualité du code locale)
- 🧪 Maven
- 🌐 Spring Boot (pour l'API REST)
- 🐙 Git & GitHub

---

## ⚙️ Exécution du projet

### 🔧 Build & Test

```bash
./mvnw clean install


### 🧪 Utilisation de l'API

Vous pouvez utiliser l'API POST pour effectuer des tests de simulation de match :

```bash
curl -X POST "http://localhost:8080/tennis/play?sequence=BABABA"
