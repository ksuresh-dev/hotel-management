# Hotel Management System

## Overview
This is a simple Hotel Management System built with **Spring Boot** for the backend and **basic HTML + JavaScript** for the front-end.

## Features
- **Room Management**: Add, view, update, and delete rooms.
- **REST API**: Provides endpoints to interact with the hotel database.
- **Web Front-End**: Basic HTML page to manage rooms.
- **In-Memory Database**: Uses H2 for easy testing.

## Technologies Used
### Backend:
- Java (Spring Boot)
- Spring Data JPA
- H2 Database
- Maven

### Frontend:
- HTML
- JavaScript (Fetch API)

## Getting Started

### Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven
- A browser (for testing the front-end)

### Setup & Running the Backend
1. Clone the repository:
   ```sh
   git clone https://github.com/ksuresh-dev/hotel-management.git
   cd hotel-management
   ```
2. Build and run the Spring Boot application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. Open H2 Console (optional for debugging):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa` (no password required)

### Running the Front-End
1. Open `index.html` in a browser.
2. It will fetch and display available rooms.
3. Use the form to **add a room**, or click **delete** to remove one.

## API Endpoints
- **GET /rooms** → Fetch all rooms
- **POST /rooms** → Add a new room
- **DELETE /rooms/{id}** → Delete a room

## Future Enhancements
- Add a **Guest Management System**.
- Implement **Reservations & Booking Logic**.
- Improve UI with **Bootstrap or a framework like React**.

## License
This project is open-source and available under the MIT License.

---
Feel free to contribute and improve the project!

