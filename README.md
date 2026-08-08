![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-4.0-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![License](https://img.shields.io/badge/License-MIT-success)

# Enterprise Demo Platform
## 📸 Project Preview

![Project Overview](screenshots/project-overview.png)

A modern enterprise backend application built with Java, Spring Boot and PostgreSQL.

This project is being developed to demonstrate real-world enterprise software architecture and best practices.

---

## Getting Started

### Configuration

The project includes an example configuration file:

```text
backend/enterprise-api/src/main/resources/application-example.properties
```

Copy this file and rename it to:

```text
backend/enterprise-api/src/main/resources/application.properties
```

Then update the database username and password according to your local PostgreSQL configuration.

The `application.properties` file is excluded from Git because it may contain sensitive environment-specific configuration.

Do not commit database passwords or other sensitive credentials to the repository.


Go to project

```bash
cd enterprise-api
```

Run

```bash
mvn spring-boot:run
```

## 🚀 Technologies

- Java 21
- Spring Boot 4
- Spring Data JPA
- PostgreSQL
- MapStruct
- Bean Validation
- Lombok
- Maven
- REST API

---

## 📁 Project Structure

```
enterprise-api
│
├── src
├── docker
├── docs
├── postman
├── screenshots
└── README.md
```

---


## Current Features

✔ RESTful CRUD APIs

✔ Layered Architecture

✔ DTO Pattern

✔ MapStruct Object Mapping

✔ Bean Validation

✔ Global Exception Handling

✔ PostgreSQL Integration

✔ Maven Project Structure

## Architecture

This project follows a layered architecture.

Controller

↓

Service

↓

Repository

↓

PostgreSQL

### Department Module

✔ Create Department

✔ Get Department

✔ Get All Departments

✔ Update Department

✔ Delete Department

### Employee Module

✔ Create Employee

✔ Get Employee

✔ Get All Employees

✔ Update Employee

✔ Delete Employee

---

## API Examples

### Create Department

POST

```
### Create Department

**POST** `/api/departments`

```

Request

```json
{
  "name": "IT",
  "description": "Information Technology"
}
```

---

### Create Employee

POST

```
### Create Employee
**POST** `/api/employees`
```

```json
{
  "firstName": "Bilgin",
  "lastName": "Can",
  "email": "blgncan@gmail.com",
  "salary": 75000,
  "departmentId": 1
}
```

---

## Validation

Bean Validation is used.

Implemented validations

- Required fields
- Maximum field lengths
- Email format validation

---

## Exception Handling

A centralized GlobalExceptionHandler is used.

Example response

```json
{
  "message": "Department not found"
}
```

---

## Database

Database Engine

- PostgreSQL

Main Tables

- departments
- employees

---

## Future Roadmap

- Authentication (JWT)
- Role Based Authorization
- Swagger / OpenAPI
- Docker
- Pagination
- Sorting
- Filtering
- Unit Tests
- Integration Tests
- CI/CD
- Audit Logging
---

## Author ##

Bilgin Can

Senior Full Stack Developer

Java | Spring Boot | React | PostgreSQL

LinkedIn:
https://www.linkedin.com/in/bilgincann/
