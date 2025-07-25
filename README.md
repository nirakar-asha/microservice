# 🏦 MiniBank Microservices

MiniBank is a lightweight banking application built using the **Spring Boot** framework and **Microservices Architecture**. It simulates core banking functionalities such as managing accounts, loans, and cards.

---

## 📌 Project Modules

This project is divided into three independent microservices:

- **Accounts Service**: Manages customer account information.
- **Loans Service**: Handles loan applications and loan status.
- **Cards Service**: Manages debit/credit card issuance and status.

Each service is independently deployable and communicates via REST APIs.

---

## 🧱 Architecture

- **Spring Boot** for microservice development
- **Spring Cloud Eureka** for service discovery
- **Spring Cloud Gateway** for API routing
- **Spring Cloud Config Server** for centralized configuration
- **Spring Data JPA** for database interaction
- **H2 / MySQL** as the database (configurable)
- **Lombok** for boilerplate code reduction
