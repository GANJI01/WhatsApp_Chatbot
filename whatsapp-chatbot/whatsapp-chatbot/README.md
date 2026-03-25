# 💬 WhatsApp Chatbot Backend Simulation
### Jarurat Care — Java Developer Internship Assessment

A simple **WhatsApp chatbot backend simulation** built with **Java 17 + Spring Boot 3**, featuring a REST webhook API that accepts simulated WhatsApp messages and responds with predefined replies.

---

## 🚀 Features

- ✅ `POST /webhook` — Accepts JSON WhatsApp messages, returns chatbot replies
- ✅ Predefined replies: `Hi → Hello`, `Bye → Goodbye` (+ more!)
- ✅ All incoming messages are **logged** via SLF4J/Logback
- ✅ `GET /webhook/logs` — View all received messages
- ✅ `GET /health` — Health check endpoint
- ✅ Input validation with meaningful error messages
- ✅ Unit tests with JUnit 5
- ✅ Docker-ready for deployment on Render

---

## 🛠️ Tech Stack

| Technology      | Version |
|----------------|---------|
| Java            | 17      |
| Spring Boot     | 3.2.0   |
| Maven           | 3.9+    |
| JUnit 5         | Built-in|
| Docker          | Any     |

---

## 📦 Project Structure

```
whatsapp-chatbot/
├── src/
│   ├── main/java/com/jarurat/chatbot/
│   │   ├── WhatsappChatbotApplication.java   ← Main entry point
│   │   ├── controller/
│   │   │   └── WebhookController.java        ← REST endpoints
│   │   ├── model/
│   │   │   ├── IncomingMessage.java           ← Request model
│   │   │   └── ChatbotResponse.java           ← Response model
│   │   └── service/
│   │       └── ChatbotService.java            ← Business logic + logging
│   └── resources/
│       └── application.properties
├── Dockerfile
└── pom.xml
```

---

## ▶️ Running Locally

### Prerequisites
- Java 17+
- Maven 3.9+

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/whatsapp-chatbot.git
cd whatsapp-chatbot

# 2. Build the project
mvn clean install

# 3. Run the application
mvn spring-boot:run
```

The server starts at: **http://localhost:8080**

---

## 🔌 API Endpoints

### `POST /webhook` — Send a message

**Request:**
```json
{
  "from": "+919876543210",
  "message": "Hi",
  "timestamp": "2024-01-15T10:30:00"
}
```

**Response:**
```json
{
  "to": "+919876543210",
  "reply": "Hello! 👋 Welcome to Jarurat Care. How can I help you today?",
  "status": "success",
  "originalMessage": "Hi"
}
```

---

### Supported Keywords

| Input (case-insensitive) | Reply |
|--------------------------|-------|
| `Hi` / `Hello`           | Hello! 👋 Welcome to Jarurat Care... |
| `Bye` / `Goodbye`        | Goodbye! 👋 Take care and stay healthy! |
| `Help`                   | Instructions on how to use the bot |
| `Thanks` / `Thank you`   | You're welcome! 😊 |
| Anything else            | "Sorry, I didn't understand..." |

---

### `GET /webhook/logs` — View all received messages

```bash
curl http://localhost:8080/webhook/logs
```

### `GET /health` — Health check

```bash
curl http://localhost:8080/health
```

---

## 🧪 Running Tests

```bash
mvn test
```

---

## 🐳 Docker Deployment

```bash
# Build Docker image
docker build -t whatsapp-chatbot .

# Run the container
docker run -p 8080:8080 whatsapp-chatbot
```

---

## ☁️ Deploy on Render (Bonus)

1. Push this repo to GitHub
2. Go to [render.com](https://render.com) → New → Web Service
3. Connect your GitHub repo
4. Set **Build Command**: `mvn clean package -DskipTests`
5. Set **Start Command**: `java -jar target/whatsapp-chatbot-0.0.1-SNAPSHOT.jar`
6. Set **Environment**: Java
7. Deploy! 🎉

---

## 📝 Sample cURL Commands

```bash
# Send "Hi"
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"from": "+919876543210", "message": "Hi", "timestamp": "2024-01-15T10:00:00"}'

# Send "Bye"
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"from": "+919876543210", "message": "Bye", "timestamp": "2024-01-15T10:05:00"}'

# View logs
curl http://localhost:8080/webhook/logs

# Health check
curl http://localhost:8080/health
```

---

## 👤 Author

G Swathi  
Java Developer Intern Applicant — Jarurat Care  

---

*Built as part of the Jarurat Care Java Developer Internship Assessment.*
