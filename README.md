================================================================================
TICKET BOOKING SYSTEM - MICROSERVICES ARCHITECTURE

A distributed, production-ready Ticket Booking System built with Java,
Spring Boot, and Spring Cloud Microservices Architecture. This project manages
movie/event ticket reservations with service discovery, API gateway routing,
resilient service-to-service communication, and relational database persistence.

Author: Swatantra Kushwaha
GitHub: https://github.com/Swatantrakushwaha
Repository: Tickets-Booking-Systems-Microservice-Spring-boot-project

ARCHITECTURE OVERVIEW

Client Request (Postman / Web App)
|
v
+-----------------+
|   API Gateway   | <---------------+
|   (Port 8080)   |                 |
+--------+--------+                 | (Service Discovery)
|                          v
+---------+---------+      +-------------------+
|         |         |      |   Eureka Server   |
v         v         v      |    (Port 8761)    |
+-------+ +---------+ +-------+ +-------------------+
| User  | | Catalog | |Booking|
|Service| | Service | |Service|
+-------+ +---------+ +---+---+
| (OpenFeign Client)
v
+---------+
| Payment |
| Service |
+---------+

MICROSERVICES BREAKDOWN

Service Registry (eureka-server):
Dynamic service discovery and registry built with Netflix Eureka.

API Gateway (api-gateway):
Single entry point for all client requests; handles routing and load balancing.

User Service (user-service):
Manages user registration, profiles, and authentication credentials.

Catalog Service (catalog-service / movie-service):
Manages movies, venues, screens, and showtime schedules.

Booking Service (booking-service):
Coordinates seat reservation workflows, booking confirmation, and ticket generation.

Payment Service (payment-service):
Simulates payment gateway transactions and updates payment statuses.

TECH STACK

Language: Java 17+

Framework: Spring Boot 3.x

Microservices: Spring Cloud (Eureka Server, Spring Cloud Gateway, OpenFeign)

Persistence: Spring Data JPA, Hibernate, MySQL Driver

Resilience: Resilience4j Circuit Breaker

Build Tool: Apache Maven 3.8+

API Documentation: SpringDoc OpenAPI (Swagger UI)

PREREQUISITES

Make sure you have installed on your local system:

JDK 17 or higher (Verify: java -version)

Apache Maven 3.8+ (Verify: mvn -version)

MySQL Server 8.x running on localhost:3306

Git

LOCAL INSTALLATION & CONFIGURATION

Step 1: Clone the repository
git clone https://github.com/Swatantrakushwaha/Tickets-Booking-Systems-Microservice-Spring-boot-project.git
cd Tickets-Booking-Systems-Microservice-Spring-boot-project

Step 2: Database Setup
Log in to MySQL and create the database:
CREATE DATABASE IF NOT EXISTS ticket_booking_db;

Step 3: Update Application Properties
In each microservice under src/main/resources/application.properties
(or application.yml), set your database credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/ticket_booking_db?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Step 4: Build the Project
mvn clean install -DskipTests

STARTUP ORDER & PORTS

Launch each service in this exact order to prevent connection failures:

Step | Service Name     | Directory         | Default Port
-----+------------------+-------------------+-------------
1   | Eureka Registry  | eureka-server     | 8761
2   | User Service     | user-service      | 8081
3   | Catalog Service  | catalog-service   | 8082
4   | Payment Service  | payment-service   | 8084
5   | Booking Service  | booking-service   | 8083
6   | API Gateway      | api-gateway       | 8080

Run command from inside each service directory:
mvn spring-boot:run

Verify services on Eureka Dashboard:
http://localhost:8761

SAMPLE REST API ENDPOINTS (VIA API GATEWAY)

Base URL: http://localhost:8080

User Service:

POST /api/v1/users/register   -> Create a new account

GET  /api/v1/users/{id}        -> Get user profile details

Catalog Service:

GET  /api/v1/movies           -> Fetch list of available movies

GET  /api/v1/movies/{id}/shows-> List showtimes for a specific movie

POST /api/v1/movies           -> Add new movie (Admin)

Booking Service:

POST /api/v1/bookings         -> Book seats for a show

GET  /api/v1/bookings/{id}    -> Fetch booking receipt/status

Payment Service:

POST /api/v1/payments/process -> Process payment transaction

CONTACT & LICENSE

Author: Swatantra Kushwaha
GitHub: https://github.com/Swatantrakushwaha
License: MIT License
