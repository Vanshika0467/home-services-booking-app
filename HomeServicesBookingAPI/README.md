# Home Services Booking API

A RESTful web service built using Java and Spring Boot that allows users to explore available home services and manage service bookings.

The application provides APIs for viewing services, searching services, creating bookings, updating booking details, managing booking status, and cancelling bookings.

## Table of Contents

- Project Overview
- Technologies Used
- Features
- Project Structure
- API Endpoints
- Booking Status
- Database Configuration
- How to Run the Project
- API Documentation
- Error Handling

## Project Overview

The Home Services Booking API is a backend application developed using Spring Boot.

It allows users to view available home services and create bookings based on their requirements. The application uses MySQL to store service and booking information.

The project follows a layered architecture with separate packages for controllers, services, repositories, entities, DTOs, and exception handling.

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Jakarta Bean Validation
- Maven
- Swagger UI / OpenAPI
- REST APIs

## Features

- Retrieve all available home services.
- Search services by name.
- Retrieve service details using an ID.
- Create a new service booking.
- View all bookings.
- Update existing booking details.
- Update booking status.
- Cancel a booking.
- Delete a booking.
- Validate incoming request data.
- Handle exceptions globally.
- Return structured error responses.
- Global exception handling
- Explore and test APIs using Swagger UI.

## Project Structure

The project follows a layered architecture.


HomeServicesBookingAPI
|
+-- src/main/java/com/adityax/homeservices
|   |

|   +-- config
|   |   +-- DataSeeder.java
|   |

|   +-- controller
|   |   +-- ServiceController.java
|   |   +-- BookingController.java
|   |

|   +-- dto
|   |   +-- ServiceResponse.java
|   |   +-- BookingRequest.java
|   |   +-- BookingResponse.java
|   |   +-- ApiError.java
|   |

|   +-- entity
|   |   +-- ServiceItem.java
|   |   +-- Booking.java
|   |

|   +-- exception
|   |   +-- GlobalExceptionHandler.java
|   |   +-- ResourceNotFoundException.java
|   |

|   +-- repository
|   |   +-- ServiceRepository.java
|   |   +-- BookingRepository.java
|   |

|   +-- service
|   |   +-- ServiceCatalogService.java
|   |   +-- BookingService.java
|   |

|   +-- HomeServicesBookingApiApplication.java
|
+-- src/main/resources
|   +-- application.properties
|

| +-- src/test/java
|

| +-- pom.xml
| +-- README.md
```

## API Endpoints

### Service APIs

| HTTP Method | Endpoint | Description |

|---|---|---|

| GET | `/api/services` | Retrieve all available services |

| GET | `/api/services?search=clean` | Search services by name |

| GET | `/api/services/{id}` | Retrieve a service by ID |

### Booking APIs

| HTTP Method | Endpoint | Description |

|---|---|---|

| POST | `/api/bookings` | Create a new booking |

| GET | `/api/bookings` | Retrieve all bookings |

| PUT | `/api/bookings/{id}` | Update booking details |

| PATCH | `/api/bookings/{id}/status?status=CONFIRMED` | Update booking status |

| PATCH | `/api/bookings/{id}/cancel` | Cancel a booking |

| DELETE | `/api/bookings/{id}` | Delete a booking |

## Booking Status

Bookings support the following statuses:

- `PENDING`
- `CONFIRMED`
- `CANCELLED`
- `COMPLETED`

A new booking is created with the `PENDING` status.

The status can be updated using the booking status endpoint. A booking can also be cancelled using the dedicated cancellation endpoint.

## Database Configuration

The application uses MySQL as its relational database.

### Database Name

 home_services_db;

### Configure Database Credentials

Open the following file:

`src/main/resources/application.properties`

Configure the database connection using your local MySQL credentials.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/home_services_db
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:your_password}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

Replace `your_password` with your MySQL password, or configure the `DB_USERNAME` and `DB_PASSWORD` environment variables.

## How to Run the Project

### Prerequisites

Make sure the following are installed:

- Java Development Kit (JDK) 17 or later
- MySQL Server
- Eclipse STS or another Java IDE
- Maven

### Step 1: Clone the Repository

```bash
git clone https://github.com/Vanshika0467/home-services-booking-app.git
```

### Step 2: Open the Project

Import the project into Eclipse STS as an existing Maven project.

### Step 3: Create the Database

Create the MySQL database:

```sql
CREATE DATABASE home_services_db;
```

### Step 4: Configure MySQL

Update the database URL, username, and password in `application.properties` or configure the corresponding environment variables.

### Step 5: Update Maven Dependencies

In Eclipse STS:

1. Right-click the project.
2. Select **Maven**.
3. Select **Update Project**.
4. Wait for Maven to download the required dependencies.

### Step 6: Run the Application

Run the main application class:

`HomeServicesBookingApiApplication.java`

Select **Run As → Spring Boot App**.

The application starts on port `8080`, provided the port is available.

## API Documentation

Swagger UI is integrated for exploring and testing the REST APIs.

After starting the application, open:

http://localhost:8080/swagger-ui/index.html

You can use Swagger UI to:

- View available API endpoints.
- Inspect request parameters and request bodies.
- Execute API requests.
- Review HTTP status codes and responses.

The Swagger URL above is for local development. Other users must run the application on their own systems to access their local Swagger UI.

## Error Handling

The application uses global exception handling to provide consistent error responses.

The implementation includes:

- Request validation errors.
- Resource not found errors.
- Invalid request body handling.
- Database integrity error handling.

Validation failures return HTTP `400 Bad Request`, while requests for missing resources return HTTP `404 Not Found`, where applicable.


## Author

**Vanshika Pandey**

GitHub: [Vanshika0467](https://github.com/Vanshika0467)
---

This project was developed as part of a Java and Spring Boot learning and assignment exercise.