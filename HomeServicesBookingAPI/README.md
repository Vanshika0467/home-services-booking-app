# Home Services Booking API

## Project Overview
A RESTful API built using Spring Boot that allows users
to explore home services and create service bookings.

## Technologies Used
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Hibernate
- Jakarta Bean Validation
- Swagger UI
- Maven

## Features
- View all available home services
- Search services by name
- View service details by ID
- Create a service booking
- View all bookings
- Update booking details
- Update booking status
- Delete a booking
- Global exception handling
- Request validation

## API Endpoints

| Method | Endpoint | Description |

| GET | /api/services | Get all services |

| GET | /api/services?search=clean | Search services |

| GET | /api/services/{id} | Get service by ID |

| POST | /api/bookings | Create booking |

| GET | /api/bookings | Get all bookings |

| PUT | /api/bookings/{id} | Update booking |

| PATCH | /api/bookings/{id}/status | Update booking status |

| DELETE | /api/bookings/{id} | Delete booking |

## Database
MySQL database: home_services_db

## API Documentation
Swagger UI: http://localhost:8080/swagger-ui/index.html

## How to Run
1. Clone or download the project.
2. Create the MySQL database.
3. Configure database credentials in application.properties.
4. Run the Spring Boot application.
5. Open Swagger UI in your browser.