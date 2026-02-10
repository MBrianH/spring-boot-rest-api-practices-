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

1. Library (Book Management)
2. Student Management
3. Restaurant Menu Management
4. Product Management (E-Commerce)
5. Task Management
6. User Profile Management *(Bonus Module)*

Each module follows REST principles and uses consistent endpoint naming and request-handling patterns.

---

## API Modules

### 1. Library (Book) API
Manages library books and supports:
- Retrieve all books
- Retrieve a book by ID
- Search books by title
- Add new books
- Delete books

**Base Path:** `/api/books`

---

### 2. Student Management API
Manages student records and supports:
- Retrieve all students
- Retrieve a student by ID
- Filter students by major
- Filter students by GPA
- Add new students
- Update existing student records

**Base Path:** `/api/students`

---

### 3. Restaurant Menu API
Manages restaurant menu items and supports:
- Retrieve all menu items
- Filter items by category
- Filter by availability
- Search menu items by name
- Add new menu items
- Update item availability
- Delete menu items

**Base Path:** `/api/menu`

---

### 4. Product Management API
Simulates an e-commerce product system and supports:
- Retrieve all products
- Pagination support
- Filter by category and brand
- Search by keyword
- Filter by price range
- Retrieve in-stock products
- Create, update, and delete products
- Update product stock quantity

**Base Path:** `/api/products`

---

### 5. Task Management API
Manages tasks and supports:
- Retrieve all tasks
- Retrieve a task by ID
- Filter by completion status
- Filter by priority
- Create new tasks
- Update existing tasks
- Mark tasks as completed
- Delete tasks

**Base Path:** `/api/tasks`

---

### 6. User Profile API (Bonus)
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

**Base Path:** `/api/users`

---

## API Design Principles
- RESTful endpoint structure
- Proper use of HTTP methods (**GET, POST, PUT, PATCH, DELETE**)
- Clear separation of modules
- Consistent naming conventions
- Clean and maintainable controller logic
- Appropriate HTTP status codes (200, 201, 204, 404)

---

## Project Structure
```
The application consists of **six independent API modules**:

- Library (Book Management)
- Student Management
- Restaurant Menu Management
- Product Management (E-Commerce)
- Task Management
- User Profile Management *(Bonus Module)*

Each module follows REST principles and uses consistent endpoint naming and request-handling patterns.
```

---

## Testing
The APIs can be tested using:
- **Postman** or similar API testing tools
- A **web browser** (for GET requests)
- The included **HTML testing page** (`API Testing Page.html`) with one-click testing and real-time response display

---

## Technologies Used
- **Java 17**
- **Spring Boot 4.0.2**
- **Maven** (Build Tool)
- **Spring Web** (REST API Development)

---

## Data Handling
- All data is stored in memory using `ArrayList`
- No database is used
- Data resets automatically when the application restarts
- Sample data is pre-loaded for each module

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
- Java 17 or higher installed
- Maven installed (or use the included Maven wrapper)

### Run Command
From the project root directory, run:
```bash
mvn spring-boot:run
```

Or using the Maven wrapper:
```bash
./mvnw spring-boot:run    # Linux/Mac
mvnw.cmd spring-boot:run  # Windows
```

### Access the APIs
Once the application starts, the APIs will be available at:
```
http://localhost:8081/api
```

Example endpoints:
- http://localhost:8081/api/books
- http://localhost:8081/api/students
- http://localhost:8081/api/menu
- http://localhost:8081/api/products
- http://localhost:8081/api/tasks
- http://localhost:8081/api/users

---

## Sample API Requests

### Get All Books
```
GET http://localhost:8081/api/books
```

### Add a New Student
```
POST http://localhost:8081/api/students
Content-Type: application/json

{
  "studentId": 6,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com",
  "major": "Computer Science",
  "gpa": 3.8
}
```

### Search Products
```
GET http://localhost:8081/api/products/search?keyword=phone
```

### Mark Task as Complete
```
PATCH http://localhost:8081/api/tasks/1/complete
```

---

## Key Features
-  Complete CRUD operations for all modules
-  Search and filter functionality
-  Proper HTTP status codes
-  Clean code structure
-  RESTful design principles
-  Easy to test and extend

---

## Notes
- This is a learning project focused on REST API development
- No authentication or authorization is implemented
- Data persistence is not included (in-memory storage only)
- The project demonstrates core Spring Boot REST concepts

---

## Author
Names:Mutsinzi Brian Heritier
ID: 26522 
