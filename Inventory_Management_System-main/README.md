# Products Inventory Management System

This is a simple web application built with Spring Boot for managing products in an inventory.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Usage](#usage)

## Features

- Add new products with details like name, description, and barcode.
- View a list of all products in the inventory.
- Uses Thymeleaf for server-side HTML rendering.
- Integrates with jQuery for dynamic form submission and AJAX requests.
- Uses Spring Data JPA for database interactions with Hibernate.
- Implements basic validation and error handling.
- Responsive design using Bootstrap.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **Thymeleaf**: Template engine for server-side rendering.
- **Bootstrap**: Frontend framework for responsive design.
- **jQuery**: JavaScript library for DOM manipulation and AJAX requests.
- **Spring Data JPA**: Simplifies data access with Hibernate as the ORM.
- **MySQL**: Database management system.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK) 8 or later
- Apache Maven
- MySQL Server

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/HarishankarPrasad/Inventory_Management_System.git
2. Navigate to the project directory:
   ```bash
   cd products-inventory
3. Import the project into your favorite IDE (IntelliJ IDEA, Eclipse, etc.) as a Maven project.

### Running the Application

Create a MySQL database named products_inventory.

Configure the database connection in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/products_inventory?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password

3. Build and run the application using Maven:
```bash
mvn spring-boot:run
```
4. Open a web browser and go to http://localhost:8080 to view the application.

## Usage

### Add a Product

1. **Fill out the "Add Product" form:**

   - Navigate to the home page [http://localhost:8080](http://localhost:8080).
   - Fill out the "Add Product" form with product details (Product Name, Description, Barcode).
   - Click on the "Add Product" button to submit the form.

2. **Product Added Confirmation:**

   - Upon successful addition, the product will be added to the inventory.
   - You will see a confirmation message indicating that the product was added successfully.

### View Product List

1. **Navigate to Product List:**

   - Navigate to the "Product List" section of the application.
   - You can view all the products currently stored in the inventory.
   - Each product will display its Name, Description, and Barcode in a tabular format.



