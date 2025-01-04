# Product Management System

## Overview
This is a Spring Boot-based application for managing a product inventory. The system provides CRUD (Create, Read, Update, Delete) operations for products. The application follows a layered architecture with a focus on modularity and scalability.

## Features
- Add new products
- Retrieve all products or a single product by ID
- Update product details
- Delete products
- Automatic timestamps for product creation and updates

## Technologies Used
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database** (or any JPA-compatible database)

## Project Structure

### **Controllers**
- **`ProductController`**: Handles HTTP requests and maps them to service methods.
  - `@GetMapping` for retrieving products.
  - `@PostMapping` for adding a new product.
  - `@PutMapping` for updating existing products.
  - `@DeleteMapping` for deleting a product.

### **Services**
- **`ProductService`**: Contains business logic and interacts with the repository layer.
  - Fetch all products.
  - Fetch a product by ID.
  - Create a new product.
  - Update product details.
  - Delete a product.

### **Entities**
- **`Products`**: Represents the product entity with attributes such as `id`, `name`, `description`, `price`, `quantity`, `createdAt`, and `updatedAt`. Uses JPA annotations for ORM mapping.

### **Repository**
- **`ProductRepository`**: Extends `JpaRepository` for database interactions.

## Endpoints

### General Endpoint
- **`GET /hello`**: Test endpoint returning a static message.

### Product Operations
- **`GET /products`**: Retrieve a list of all products.
- **`GET /products/{id}`**: Retrieve a single product by its ID.
- **`POST /products`**: Create a new product (expects JSON in the request body).
- **`PUT /products/{id}`**: Update an existing product by ID.
- **`DELETE /products/{id}`**: Delete a product by ID.

## Product Entity
| Attribute   | Type        | Description                |
|-------------|-------------|----------------------------|
| `id`        | `Long`      | Unique identifier          |
| `name`      | `String`    | Name of the product        |
| `description` | `String`  | Description of the product |
| `price`     | `BigDecimal`| Price of the product       |
| `quantity`  | `int`       | Available quantity         |
| `createdAt` | `LocalDateTime` | Timestamp of creation |
| `updatedAt` | `LocalDateTime` | Timestamp of last update |

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/ramk06/product-management.git
   cd product-management
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application:
   - Test endpoint: `http://localhost:8080/hello`
   - Product endpoints: `http://localhost:8080/products`

## Example Request and Response

### Add a Product
**Request:**
```json
POST /products
{
  "name": "Sample Product",
  "description": "A sample product description",
  "price": 100.50,
  "quantity": 10
}
```

**Response:**
```json
{
  "id": 1,
  "name": "Sample Product",
  "description": "A sample product description",
  "price": 100.50,
  "quantity": 10,
  "createdAt": "2025-01-04T12:00:00",
  "updatedAt": "2025-01-04T12:00:00"
}
```

### Retrieve All Products
**Request:**
```http
GET /products
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Sample Product",
    "description": "A sample product description",
    "price": 100.50,
    "quantity": 10,
    "createdAt": "2025-01-04T12:00:00",
    "updatedAt": "2025-01-04T12:00:00"
  }
]
```

## Error Handling
- **404 Not Found**: Returned when a requested resource is not found.
- **500 Internal Server Error**: Returned in case of server-side issues.

## Future Enhancements
- Add user authentication and authorization.
- Enhance error handling with custom exception handling.
- Add support for paginated and filtered product retrieval.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Author
[Ram Kumar](https://github.com/ramk06)

