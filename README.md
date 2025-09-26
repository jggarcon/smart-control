# 🏠 SmartControl

SmartControl is a simple **Spring Boot + Thymeleaf** monolithic web application that simulates controlling smart home devices such as **Lights**, **Fans**, and **Air Conditioners**.

## ✨ Features

- **Light toggle** (ON/OFF)
- **Fan speed control** with slider (0–2)
- **Air Conditioner** with temperature input (16–30 °C) and ON/OFF toggle
- **Dark mode** responsive UI
- Basic MVC structure (Model, Service, Controller, View)
- Unit tests for models
- Dockerized build for easy deployment

---

## ⚙️ Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Thymeleaf**
- **JUnit 5**
- **Maven**
- **Docker & Docker Compose**

---

## 🚀 Getting Started

### Prerequisites

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

### Run Locally

```bash
# clone repo
git clone https://github.com/jggarcon/smart-control.git
cd smart-control

# build and run
./mvnw spring-boot:run

# Run with Docker
docker-compose up --build -d

Visit http://localhost:8080/
```
