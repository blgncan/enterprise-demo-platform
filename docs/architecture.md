# Enterprise Architecture

The project follows a layered architecture to ensure maintainability, scalability and separation of concerns.

## Controller Layer

Responsible for handling incoming HTTP requests and returning REST responses.

## Service Layer

Contains business logic and coordinates application workflows.

## Repository Layer

Handles data access using Spring Data JPA.

## Database

PostgreSQL is used as the relational database.

## DTO Layer

DTOs are used to separate API models from persistence models.

## Mapper Layer

MapStruct is used for automatic object mapping between DTOs and entities.