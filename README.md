# Spring Boot REST API Assignment

## Project Overview
In this project, I developed a **Spring Boot–based RESTful API system** using **Java** and **Spring Boot** to demonstrate my understanding of RESTful API development. The application is implemented as a single Spring Boot project and organized into multiple independent API modules, where each module represents a real-world scenario and provides full **CRUD operations**, along with **searching, filtering, and status-based features**.

This project allowed me to apply:
- Proper REST API design principles  
- Appropriate HTTP methods  
- Clear separation of concerns  
- Clean, readable, and maintainable code  

---

## System Structure
The application consists of **six independent API modules**:

- Library (Book Management)
- Student Management
- Restaurant Menu Management
- Product Management (E-Commerce)
- Task Management
- User Profile Management *(Bonus Module)*

Each module follows REST principles and uses consistent endpoint naming and request-handling patterns.

---

## Library (Book) API
Manages library books and supports:
- Retrieve all books
- Retrieve a book by ID
- Search books by title
- Add new books
- Delete books

---

## Student Management API
Manages student records and supports:
- Retrieve all students
- Retrieve a student by ID
- Filter students by major
- Filter students by GPA
- Add new students
- Update existing student records

---

## Restaurant Menu API
Manages restaurant menu items and supports:
- Retrieve all menu items
- Filter items by category
- Filter by availability
- Search menu items by name
- Add new menu items
- Update item availability
- Delete menu items

---

## Product Management API
Simulates an e-commerce product system and supports:
- Retrieve all products
- Pagination support
- Filter by category and brand
- Search by keyword
- Filter by price range
- Retrieve in-stock products
- Create, update, and delete products
- Update product stock quantity

---

## Task Management API
Manages tasks and supports:
- Retrieve all tasks
- Retrieve a task by ID
- Filter by completion status
- Filter by priority
- Create new tasks
- Update existing tasks
- Mark tasks as completed
- Delete tasks

---

## User Profile API (Bonus)
Manages user profiles and uses a unified `ApiResponse` structure containing:
- Success status
- Message
- Response data

Supported operations:
- Retrieve all users
- Retrieve a user by ID
- Search by username
- Filter by country
- Filter by age range
- Filter active and inactive users
- Create user profiles
- Update user profiles
- Activate and deactivate users
- Delete user profiles

---

## API Design Principles
- RESTful endpoint structure
- Proper use of HTTP methods (**GET, POST, PUT, PATCH, DELETE**)
- Clear separation of modules
- Consistent naming conventions
- Clean and maintainable controller logic

---

## Testing
The APIs can be tested using:
- **Postman** or similar API testing tools
- A **web browser** (for GET requests)
- The included **HTML testing page** with one-click testing and real-time response display

---

## Technologies Used
- Java 17
- Spring Boot 4.0.2
- Maven

---

## Data Handling
- All data is stored in memory using `ArrayList`
- No database is used
- Data resets automatically when the application restarts

---

## API Operations Summary
Each module supports standard REST operations:
- **GET** – Retrieve data
- **POST** – Create data
- **PUT** – Update existing data
- **PATCH** – Partial updates
- **DELETE** – Remove data

---

## Running the Application

### Prerequisites
- Java 17
- Maven

### Run Command
From the project root directory, run:
```bash
mvn spring-boot:run
