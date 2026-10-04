# 🎟️ Ticket Booking System — Microservices Architecture

A scalable, distributed **Ticket Booking System** built using **Java 17**, **Spring Boot 3**, and **Spring Cloud**. Designed for handling real-time cinema and event ticket reservations with service registry, API gateway routing, resilient inter-service communication, and persistent relational storage.

---

## 🏗️️ Architecture Design

```
                     +-----------------------+
                     |  Client (Postman/UI)  |
                     +-----------+-----------+
                                 |
                                 v
                     +-----------------------+
                     |   API Gateway (:8080) | <---+
                     +-----------+-----------+     |
                                 |                 | (Service Discovery)
       +-------------------------+                 |
       |             |           |                 v
       v             v           v       +----------------------+
  +---------+   +---------+  +---------+ | Eureka Registry      |
  |  User   |   | Catalog |  | Booking | | (:8761)              |
  | Service |   | Service |  | Service | +----------------------+
  +---------+   +---------+  +----+----+
                                  | (OpenFeign)
                                  v
                             +---------+
                             | Payment |
                             | Service |
                             +---------+
```

---

## 🧩 Microservices Breakdown

| Service | Technology | Port | Description |
| :--- | :--- | :---: | :--- |
| **Service Registry** | Netflix Eureka Server | `8761` | Dynamic service discovery and client heartbeats. |
| **API Gateway** | Spring Cloud Gateway | `8080` | Unified entry point, request routing, rate limiting, and CORS handling. |
| **User Service** | Spring Boot, Data JPA | `8081` | User registration, authentication, profiles, and role management. |
| **Catalog Service** | Spring Boot, Data JPA | `8082` | Movies, theater halls, screens, and showtime schedules. |
| **Booking Service** | Spring Boot, Data JPA | `8083` | Seat allocation, reservation state transitions, and order histories. |
| **Payment Service** | Spring Boot, Data JPA | `8084` | Payment processing simulation and transaction receipts. |

---

## 🛠️ Tech Stack

- **Language:** Java 17+
- **Framework:** Spring Boot 3.x
- **Cloud & Distributed Tools:** Spring Cloud (Gateway, Eureka Server, OpenFeign, Resilience4j)
- **Database & Persistence:** MySQL 8.x, Spring Data JPA, Hibernate ORM
- **Build & Dependency Tool:** Apache Maven
- **Testing & API Tooling:** JUnit 5, Mockito, SpringDoc OpenAPI (Swagger UI), Postman

---

## 📁 Repository Directory Structure

```text
Tickets-Booking-Systems-Microservice-Spring-boot-project/
├── api-gateway/                # Spring Cloud Gateway
├── eureka-server/              # Netflix Eureka Discovery Server
├── user-service/               # User profiles and authentication
├── catalog-service/            # Movie & theater management
├── booking-service/            # Ticket reservation system
├── payment-service/            # Payment gateway simulation
├── pom.xml                     # Parent POM aggregating all child modules
└── README.md                   # Project documentation
```

---

## ⚙️ Getting Started

### 1. Prerequisites
- **JDK 17 or higher** installed (`java -version`)
- **Apache Maven 3.8+** installed (`mvn -version`)
- **MySQL 8.x** running locally or in Docker on port `3306`
- **Git** installed

### 2. Clone the Repository
```bash
git clone https://github.com/Swatantrakushwaha/Tickets-Booking-Systems-Microservice-Spring-boot-project.git
cd Tickets-Booking-Systems-Microservice-Spring-boot-project
```

### 3. Database Setup
Create the MySQL database:
```sql
CREATE DATABASE IF NOT EXISTS ticket_booking_db;
```

Update your database credentials inside `src/main/resources/application.properties` (or `application.yml`) in each microservice:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ticket_booking_db?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Build All Modules
Compile and package the parent and all child microservices:
```bash
mvn clean install -DskipTests
```

---

## 🚦 Recommended Startup Order

To prevent connection timeouts during startup, launch the microservices in the following order:

1. **Eureka Server** (`eureka-server`):
   ```bash
   cd eureka-server && mvn spring-boot:run
   ```
2. **User Service** (`user-service`):
   ```bash
   cd ../user-service && mvn spring-boot:run
   ```
3. **Catalog Service** (`catalog-service`):
   ```bash
   cd ../catalog-service && mvn spring-boot:run
   ```
4. **Payment Service** (`payment-service`):
   ```bash
   cd ../payment-service && mvn spring-boot:run
   ```
5. **Booking Service** (`booking-service`):
   ```bash
   cd ../booking-service && mvn spring-boot:run
   ```
6. **API Gateway** (`api-gateway`):
   ```bash
   cd ../api-gateway && mvn spring-boot:run
   ```

> 💡 **Eureka Dashboard:** Open `http://localhost:8761` in your browser to verify that all services are online and registered.

---

## 🔌 API Endpoints (via Gateway `:8080`)

All client requests should be routed directly through the **API Gateway**:

| Category | Method | Endpoint | Description |
| :--- | :--- | :--- | :--- |
| **Auth & Users** | `POST` | `/api/v1/users/register` | Register a new user |
| **Auth & Users** | `POST` | `/api/v1/users/login` | Authenticate and obtain session token |
| **Movies & Shows** | `GET` | `/api/v1/movies` | Get list of all available movies |
| **Movies & Shows** | `GET` | `/api/v1/movies/{id}/shows` | Get active showtimes for a specific movie |
| **Bookings** | `POST` | `/api/v1/bookings` | Reserve seats and generate booking order |
| **Bookings** | `GET` | `/api/v1/bookings/{id}` | Retrieve booking status by ID |
| **Payments** | `POST` | `/api/v1/payments/process` | Submit and verify ticket payment |

---

## 🛡️ Fault Tolerance & Communication

- **Synchronous Communication:** Implemented with declarative `Spring Cloud OpenFeign` REST clients.
- **Resilience:** Configured with `Resilience4j` Circuit Breakers to isolate failing downstream services and prevent cascade outages.

---

## 👨‍💻 Author

**Swatantra Kushwaha**
- GitHub: [@Swatantrakushwaha](https://github.com/Swatantrakushwaha)

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).