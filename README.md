# Spring Boot REST API Assignment

This project contains REST APIs for managing books, students, restaurant menu, products, tasks, and user profiles.

**Base URL:** `http://localhost:8081/api`

---

## Book API

### 1. Get All Books
```
GET /books
```
Returns all books in the library  
Example: http://localhost:8081/api/books

### 2. Get Book by ID
```
GET /books/{id}
```
Returns a specific book by ID  
Example: http://localhost:8081/api/books/1

### 3. Search Book by Title
```
GET /books/search?title={title}
```
Search for books by title (case-insensitive)  
Example: http://localhost:8081/api/books/search?title=clean

### 4. Add New Book
```
POST /books
```
Adds a new book to the library  
Request Body:
```json
{
  "id": 4,
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "978-0134685991",
  "publicationYear": 2017
}
```

### 5. Delete Book
```
DELETE /books/{id}
```
Deletes a book by ID  
Example: http://localhost:8081/api/books/1

---

## Student API

### 1. Get All Students
```
GET /students
```
Returns all students  
Example: http://localhost:8081/api/students

### 2. Get Student by ID
```
GET /students/{id}
```
Returns a specific student by ID  
Example: http://localhost:8081/api/students/1

### 3. Get Students by Major
```
GET /students/major/{major}
```
Returns all students in a specific major  
Example: http://localhost:8081/api/students/major/Computer Science

### 4. Filter Students by GPA
```
GET /students/filter?gpa={gpa}
```
Returns students with GPA greater than or equal to specified value  
Example: http://localhost:8081/api/students/filter?gpa=3.5

### 5. Add New Student
```
POST /students
```
Adds a new student  
Request Body:
```json
{
  "studentId": 6,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com",
  "major": "Engineering",
  "gpa": 3.7
}
```

### 6. Update Student
```
PUT /students/{id}
```
Updates an existing student by ID  
Request Body:
```json
{
  "firstName": "Jane",
  "lastName": "Smith",
  "email": "jane@example.com",
  "major": "Business",
  "gpa": 3.9
}
```

---

## Menu API

### 1. Get All Menu Items
```
GET /menu
```
Returns all menu items  
Example: http://localhost:8081/api/menu

### 2. Get Menu Item by ID
```
GET /menu/{id}
```
Returns a specific menu item by ID  
Example: http://localhost:8081/api/menu/1

### 3. Get Items by Category
```
GET /menu/category/{category}
```
Returns menu items in the specified category  
Example: http://localhost:8081/api/menu/category/Appetizer

### 4. Get Available Items
```
GET /menu/available?available={true|false}
```
Returns items filtered by availability  
Example: http://localhost:8081/api/menu/available?available=true

### 5. Search Menu Items by Name
```
GET /menu/search?name={name}
```
Searches menu items by name (case-insensitive)  
Example: http://localhost:8081/api/menu/search?name=chicken

### 6. Add New Menu Item
```
POST /menu
```
Adds a new menu item  
Request Body:
```json
{
  "id": 9,
  "name": "Caesar Salad",
  "description": "Fresh romaine lettuce",
  "price": 8.99,
  "category": "Appetizer",
  "available": true
}
```

### 7. Toggle Item Availability
```
PUT /menu/{id}/availability
```
Toggles the availability of a menu item  
Example: http://localhost:8081/api/menu/2/availability

### 8. Delete Menu Item
```
DELETE /menu/{id}
```
Removes the specified menu item  
Example: http://localhost:8081/api/menu/3

---

## Product API

### 1. Get All Products
```
GET /products
```
Returns all products  
Example: http://localhost:8081/api/products

### 2. Get Products with Pagination
```
GET /products?page={page}&limit={limit}
```
Returns paginated products  
Example: http://localhost:8081/api/products?page=0&limit=5

### 3. Get Product by ID
```
GET /products/{id}
```
Returns a specific product by ID  
Example: http://localhost:8081/api/products/1

### 4. Get Products by Category
```
GET /products/category/{category}
```
Returns all products in a specific category  
Example: http://localhost:8081/api/products/category/Electronics

### 5. Get Products by Brand
```
GET /products/brand/{brand}
```
Returns all products from a specific brand  
Example: http://localhost:8081/api/products/brand/Apple

### 6. Search Products by Keyword
```
GET /products/search?keyword={keyword}
```
Searches products by name or description  
Example: http://localhost:8081/api/products/search?keyword=phone

### 7. Get Products by Price Range
```
GET /products/price-range?min={min}&max={max}
```
Returns products within specified price range  
Example: http://localhost:8081/api/products/price-range?min=100&max=500

### 8. Get In-Stock Products
```
GET /products/in-stock
```
Returns only products with stock quantity greater than 0  
Example: http://localhost:8081/api/products/in-stock

### 9. Add New Product
```
POST /products
```
Adds a new product  
Request Body:
```json
{
  "productId": 11,
  "name": "Laptop",
  "description": "Gaming laptop",
  "price": 1299.99,
  "category": "Electronics",
  "stockQuantity": 15,
  "brand": "Dell"
}
```

### 10. Update Product
```
PUT /products/{id}
```
Updates an existing product by ID  
Request Body:
```json
{
  "name": "Updated Phone",
  "description": "New description",
  "price": 599.99,
  "category": "Electronics",
  "stockQuantity": 40,
  "brand": "Apple"
}
```

### 11. Update Product Stock
```
PATCH /products/{id}/stock?quantity={quantity}
```
Updates only the stock quantity of a product  
Example: http://localhost:8081/api/products/1/stock?quantity=100

### 12. Delete Product
```
DELETE /products/{id}
```
Deletes a product by ID  
Example: http://localhost:8081/api/products/1

---

## Task API

### 1. Get All Tasks
```
GET /tasks
```
Returns all tasks  
Example: http://localhost:8081/api/tasks

### 2. Get Task by ID
```
GET /tasks/{id}
```
Returns a specific task by ID  
Example: http://localhost:8081/api/tasks/1

### 3. Get Tasks by Status
```
GET /tasks/status?completed={true|false}
```
Returns tasks filtered by completion status  
Example: http://localhost:8081/api/tasks/status?completed=false

### 4. Get Tasks by Priority
```
GET /tasks/priority/{priority}
```
Returns tasks with specified priority (LOW, MEDIUM, HIGH)  
Example: http://localhost:8081/api/tasks/priority/HIGH

### 5. Add New Task
```
POST /tasks
```
Creates a new task  
Request Body:
```json
{
  "taskId": 5,
  "title": "Complete assignment",
  "description": "Finish REST API project",
  "completed": false,
  "priority": "HIGH",
  "dueDate": "2024-12-25"
}
```

### 6. Update Task
```
PUT /tasks/{id}
```
Updates an existing task by ID  
Request Body:
```json
{
  "title": "Updated Task",
  "description": "New description",
  "completed": false,
  "priority": "MEDIUM",
  "dueDate": "2024-12-30"
}
```

### 7. Mark Task as Complete
```
PATCH /tasks/{id}/complete
```
Marks a task as completed  
Example: http://localhost:8081/api/tasks/1/complete

### 8. Delete Task
```
DELETE /tasks/{id}
```
Deletes a task by ID  
Example: http://localhost:8081/api/tasks/1

---

## User Profile API (Bonus)

**Note:** All User Profile endpoints return responses wrapped in an ApiResponse object with `success`, `message`, and `data` fields.

### 1. Get All Users
```
GET /users
```
Returns all user profiles  
Example: http://localhost:8081/api/users

### 2. Get User by ID
```
GET /users/{id}
```
Returns a specific user profile by ID  
Example: http://localhost:8081/api/users/1

### 3. Search User by Username
```
GET /users/search/username?username={username}
```
Returns user profiles matching username  
Example: http://localhost:8081/api/users/search/username?username=john

### 4. Get Users by Country
```
GET /users/search/country/{country}
```
Returns all users from a specific country  
Example: http://localhost:8081/api/users/search/country/USA

### 5. Get Users by Age Range
```
GET /users/search/age-range?min={min}&max={max}
```
Returns users within specified age range  
Example: http://localhost:8081/api/users/search/age-range?min=25&max=35

### 6. Get Active/Inactive Users
```
GET /users/active?active={true|false}
```
Returns users filtered by active status  
Example: http://localhost:8081/api/users/active?active=true

### 7. Add New User
```
POST /users
```
Creates a new user profile (active by default)  
Request Body:
```json
{
  "userId": 6,
  "username": "new_user",
  "email": "user@example.com",
  "fullName": "New User",
  "age": 25,
  "country": "USA",
  "bio": "Software Developer",
  "active": true
}
```

### 8. Update User
```
PUT /users/{id}
```
Updates an existing user profile by ID  
Request Body:
```json
{
  "username": "updated_user",
  "email": "updated@example.com",
  "fullName": "Updated Name",
  "age": 26,
  "country": "Canada",
  "bio": "Senior Developer",
  "active": true
}
```

### 9. Activate User
```
PATCH /users/{id}/activate
```
Activates a user profile  
Example: http://localhost:8081/api/users/1/activate

### 10. Deactivate User
```
PATCH /users/{id}/deactivate
```
Deactivates a user profile  
Example: http://localhost:8081/api/users/1/deactivate

### 11. Delete User
```
DELETE /users/{id}
```
Deletes a user profile by ID  
Example: http://localhost:8081/api/users/1

---

## Running the Application

```bash
mvn spring-boot:run
```

The server will start on port 8081.

## Testing

You can test the APIs using:
- Postman
- Browser (for GET requests)
- The included HTML test page

## Technologies Used

- Spring Boot 4.0.2
- Java 17
- Maven

## Notes

- All data is stored in memory using ArrayList
- Data will reset when the server restarts
- No database is used in this project
