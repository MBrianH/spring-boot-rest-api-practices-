# Spring Boot REST API Assignment

Simple REST API project built with Spring Boot for managing books, students, products, tasks, menu items, and user profiles.

## Running the Application

```bash
mvn spring-boot:run
```

The server will start on `http://localhost:8081`

## API Endpoints

### Books API

**Get all books**
```
GET /api/books
```

**Get book by ID**
```
GET /api/books/1
```

**Search books by title**
```
GET /api/books/search?title=clean
```

**Add new book**
```
POST /api/books
Body: {"id": 4, "title": "New Book", "author": "Author Name", "isbn": "123456", "publicationYear": 2024}
```

**Delete book**
```
DELETE /api/books/1
```

---

### Students API

**Get all students**
```
GET /api/students
```

**Get student by ID**
```
GET /api/students/1
```

**Get students by major**
```
GET /api/students/major/Computer Science
```

**Filter by GPA**
```
GET /api/students/filter?gpa=3.5
```

**Add student**
```
POST /api/students
Body: {"studentId": 6, "firstName": "John", "lastName": "Doe", "email": "john@example.com", "major": "Engineering", "gpa": 3.7}
```

**Update student**
```
PUT /api/students/1
Body: {"firstName": "Jane", "lastName": "Smith", "email": "jane@example.com", "major": "Business", "gpa": 3.9}
```

---

### Menu API

**Get all menu items**
```
GET /api/menu
```

**Get menu item by ID**
```
GET /api/menu/1
```

**Get items by category**
```
GET /api/menu/category/Appetizer
```

**Get available items**
```
GET /api/menu/available?available=true
```

**Search by name**
```
GET /api/menu/search?name=chicken
```

**Add menu item**
```
POST /api/menu
Body: {"id": 9, "name": "Salad", "description": "Fresh salad", "price": 7.99, "category": "Appetizer", "available": true}
```

**Toggle availability**
```
PUT /api/menu/1/availability
```

**Delete menu item**
```
DELETE /api/menu/1
```

---

### Products API

**Get all products**
```
GET /api/products
```

**Get products with pagination**
```
GET /api/products?page=0&limit=5
```

**Get product by ID**
```
GET /api/products/1
```

**Get by category**
```
GET /api/products/category/Electronics
```

**Get by brand**
```
GET /api/products/brand/Apple
```

**Search products**
```
GET /api/products/search?keyword=phone
```

**Get by price range**
```
GET /api/products/price-range?min=100&max=500
```

**Get in-stock products**
```
GET /api/products/in-stock
```

**Add product**
```
POST /api/products
Body: {"productId": 11, "name": "Laptop", "description": "Gaming laptop", "price": 1299.99, "category": "Electronics", "stockQuantity": 15, "brand": "Dell"}
```

**Update product**
```
PUT /api/products/1
Body: {"name": "Updated Phone", "description": "New description", "price": 599.99, "category": "Electronics", "stockQuantity": 40, "brand": "Apple"}
```

**Update stock**
```
PATCH /api/products/1/stock?quantity=100
```

**Delete product**
```
DELETE /api/products/1
```

---

### Tasks API

**Get all tasks**
```
GET /api/tasks
```

**Get task by ID**
```
GET /api/tasks/1
```

**Get by status**
```
GET /api/tasks/status?completed=false
```

**Get by priority**
```
GET /api/tasks/priority/HIGH
```

**Add task**
```
POST /api/tasks
Body: {"taskId": 5, "title": "New Task", "description": "Task details", "completed": false, "priority": "MEDIUM", "dueDate": "2024-12-25"}
```

**Update task**
```
PUT /api/tasks/1
Body: {"title": "Updated Task", "description": "New details", "completed": false, "priority": "HIGH", "dueDate": "2024-12-30"}
```

**Mark as complete**
```
PATCH /api/tasks/1/complete
```

**Delete task**
```
DELETE /api/tasks/1
```

---

### User Profiles API (Bonus)

All responses wrapped in ApiResponse format with success, message, and data fields.

**Get all users**
```
GET /api/users
```

**Get user by ID**
```
GET /api/users/1
```

**Search by username**
```
GET /api/users/search/username?username=john
```

**Get by country**
```
GET /api/users/search/country/USA
```

**Get by age range**
```
GET /api/users/search/age-range?min=25&max=35
```

**Get active users**
```
GET /api/users/active?active=true
```

**Add user**
```
POST /api/users
Body: {"userId": 6, "username": "new_user", "email": "user@example.com", "fullName": "New User", "age": 25, "country": "USA", "bio": "Developer", "active": true}
```

**Update user**
```
PUT /api/users/1
Body: {"username": "updated_user", "email": "updated@example.com", "fullName": "Updated Name", "age": 26, "country": "Canada", "bio": "Senior Developer", "active": true}
```

**Activate user**
```
PATCH /api/users/1/activate
```

**Deactivate user**
```
PATCH /api/users/1/deactivate
```

**Delete user**
```
DELETE /api/users/1
```

---

## Testing

Use Postman or the included `API Testing Page.html` file to test all endpoints.

## Technologies

- Spring Boot 4.0.2
- Java 17
- Maven
