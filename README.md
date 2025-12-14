# 🚀 Todo API - Mini Projet DevSecOps

API REST simple pour gérer des tâches (todos) avec un pipeline CI/CD sécurisé.

## 📦 Technologies

- Java 17
- Spring Boot 3.2
- Maven
- Docker
- GitHub Actions
- Gitleaks (scan de secrets)
- Trivy (scan de vulnérabilités)

## 🔧 Installation locale

### Prérequis
- Java 17
- Maven
- Docker

### Lancer l'application
```bash
# Compiler
mvn clean package

# Lancer
java -jar target/todo-api-1.0.0.jar

# Ou avec Maven
mvn spring-boot:run
```

## 🐳 Docker
```bash
# Build
docker build -t todo-api .

# Run
docker run -p 8080:8080 todo-api
```

## 📡 Endpoints API

### Health Check
```bash
GET http://localhost:8080/api/todos/health
```

### Récupérer tous les todos
```bash
GET http://localhost:8080/api/todos
```

### Récupérer un todo
```bash
GET http://localhost:8080/api/todos/1
```

### Créer un todo
```bash
POST http://localhost:8080/api/todos
Content-Type: application/json

{
  "title": "Apprendre Docker",
  "description": "Comprendre les conteneurs",
  "completed": false
}
```

### Modifier un todo
```bash
PUT http://localhost:8080/api/todos/1
Content-Type: application/json

{
  "title": "Apprendre Docker",
  "description": "Maîtriser les conteneurs",
  "completed": true
}
```

### Supprimer un todo
```bash
DELETE http://localhost:8080/api/todos/1
```

## 🔒 Pipeline CI/CD

Le pipeline s'exécute automatiquement à chaque push sur `main` :

1. ✅ Checkout du code
2. 🔍 Scan Gitleaks (secrets)
3. 📦 Build Maven
4. ✅ Tests unitaires
5. 🐳 Build Docker image
6. 🧪 Test de l'image
7. 🛡️ Scan Trivy (vulnérabilités)
8. 📤 Push sur Docker Hub

## 🎯 Résultats attendus

- Image Docker publiée : `username/todo-api:latest`
- Pipeline vert ✅
- Aucun secret détecté
- Aucune vulnérabilité critique