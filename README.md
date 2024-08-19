
# Wonka Inventory Management System

## Overview

The Wonka Inventory Management System is a simple web application built with Spring Boot, Spring Security, Spring Data JPA, and Thymeleaf. It allows users to manage an inventory of products, with different access levels for users and administrators.

## Features

- User authentication and authorization using Spring Security.
- Role-based access control for different functionalities.
- CRUD operations for products in the inventory.
- Secure password storage using Spring Security's `PasswordEncoder`.
- Integration with MySQL for persistent data storage.

## Prerequisites

- Java 22 or higher
- Maven 3.6.0 or higher
- MySQL 8.0 or higher

## Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/wonka-inventory.git
   cd wonka-inventory
   ```

2. **Configure the Database**

   Ensure that you have a MySQL server running and create a database called `chocolate_factory`:

   ```sql
   CREATE DATABASE chocolate_factory;
   ```

   Then, configure the database credentials in the `src/main/resources/application.properties` file:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/chocolate_factory
   spring.datasource.username=willy-wonka
   spring.datasource.password=W0nka-8ar
   ```

3. **Set Up the Database Schema**

   Run the following SQL scripts to set up the required tables:

   ```sql
   create table members(
       `username` VARCHAR(50) not null,
       `password` VARCHAR(100) not null,
       `active` boolean not null,
     	PRIMARY KEY (`username`)
   );

   CREATE TABLE authorities (
     `username` VARCHAR(50) NOT NULL,
     `authority` VARCHAR(50) NOT NULL,
     CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES members(username) 
   );
   ```

4. **Build the Project**

   Use Maven to clean, compile, and package the application:

   ```bash
   mvn clean package
   ```

5. **Run the Application**

   After building, you can run the application using the following Maven command:

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run the generated JAR file:

   ```bash
   java -jar target/WonkaInventory-0.0.1-SNAPSHOT.jar
   ```

   The application will start on port 9090 by default. You can access it by navigating to `http://localhost:9090` in your web browser.

## Usage

- **Login**: Navigate to `/showLoginPage` to log in. Users with the role `USER` can view the list of products, while users with the role `ADMIN` can add, update, and delete products.
- **Manage Products**: Once logged in, admins can manage products by navigating to the respective URLs:
   - `/products/showFormForAdd` - Add a new product
   - `/products/showFormForUpdate?productId={id}` - Update an existing product
   - `/products/delete?productId={id}` - Delete a product

## Testing

You can run the test suite using Maven:

```bash
mvn test
```

This will execute the unit tests and integration tests defined in the project.

## Dependencies

- **Spring Boot 3.3.2**
- **Spring Security**
- **Spring Data JPA**
- **Thymeleaf**
- **MySQL Connector**
- **JUnit**

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries, please contact Willy Wonka at willy@wonka.com.


# TODO add inserts for members with ROLE_ADMIN and ROLE_USER ...