<div align="center">
<h1><strong>E-commerce Platform API 🛒</strong></h1>
<img src="https://media.licdn.com/dms/image/v2/C5612AQGLJJgEjyzZuw/article-cover_image-shrink_600_2000/article-cover_image-shrink_600_2000/0/1520113802127?e=2147483647&v=beta&t=FMCM26ncvC7ybXFaSfA5jWfWVBEjhbs4d1wz4Mt9idg" alt="ecommerce" width="500"/>
</div>

<div align="center">
<br/>
<strong>A secure, role-based REST API for an e-commerce platform, built with Java and Spring Boot.</strong>
<br/>
<br/>
This project demonstrates a complete authentication and authorization system using JWT, data modeling with JPA, and a containerized PostgreSQL database with Docker.
<br/>
</div>
<br/>


📡 Features
----------

<strong>JWT Security:</strong> Implements a full authentication and authorization flow using Spring Security and JSON Web Tokens (JWT).
<br/>
<strong>Role-Based Access Control (RBAC):</strong> Features distinct roles with protected endpoints for specific actions, such as admin-only product management.
<br/>
<strong>Product Catalog Management:</strong> Provides public endpoints for browsing products and secure endpoints for administrators to manage the catalog.
<br/>
<strong>Shopping Cart Functionality:</strong> Includes secure endpoints for authenticated users to add items to and view their personal shopping cart.
<br/>
<strong>Containerized Database:</strong> Runs with a PostgreSQL database managed by Docker for a consistent and isolated development environment.
<br/>

⚠️ Prerequisites
------------


Java Development Kit (JDK 21 or newer).

Apache Maven.

Docker Desktop installed and running.

An API client like Insomnia for testing the endpoints.
<br/>

🛠️ Tech Stack
-----

<strong>Java 21:</strong> The core programming language.

<strong>Spring Boot:</strong> The primary framework for building the application.

<strong>Spring Security:</strong> Handles authentication and role-based authorization.

<strong>Spring Data JPA:</strong> Manages database interaction.

<strong>PostgreSQL:</strong> The relational database for data persistence.

<strong>Docker:</strong> Used for containerizing and running the database.

<strong>jjwt:</strong> A library for creating and validating JSON Web Tokens.

<strong>MapStruct:</strong> Generates mappers between DTOs and Entities.

<strong>Lombok:</strong> To reduce boilerplate code.

<strong>Maven:</strong> The project build and dependency management tool.
</br>


💻 Tools & Technologies
------------

<br/>
<p align="center">
<a href="#"><img src="https://img.shields.io/badge/macOS-000000?logo=apple&logoColor=F0F0F0" alt="macOS"></a>
<a href="#"><img src="https://img.shields.io/badge/Spotify-1ED760?logo=spotify&logoColor=white" alt="Spotify"></a> 
<a href="#"><img src="https://custom-icon-badges.demolab.com/badge/Visual%20Studio%20Code-0078d7.svg?logo=vsc&logoColor=white" alt="VSC"></a>
<a href="#"><img src="https://img.shields.io/badge/Insomnia-5849be?logo=insomnia&logoColor=white" alt="Insomnia"></a>
<a href="#"><img src="https://img.shields.io/badge/Apache%20Maven-C71A36?logo=apachemaven&logoColor=white" alt="Maven"></a>
<a href="#"><img src="https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white" alt="Git"></a>
<a href="#"><img src="https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white" alt="GitHub"></a>
<a href="#"><img src="https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=fff&style=flat" alt="Docker"></a>   
</p>
<br/>

▶️ Setup & Running the Application
-----

Start the Database

Open a terminal and run the following Docker command. Ensure the password (your_password) matches the one in your application.properties file.

<strong>docker run --name ecommerce-postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=your_password -e POSTGRES_DB=ecommerce_db -p 5432:5432 -d postgres</strong>

Run the Application

Navigate to the project's root directory in your terminal and run the application:


<strong>mvn spring-boot:run</strong>


The API will be available at http://localhost:8080.


🧑‍💻 API Endpoints & Testing Flow
--------

Use an API client like Insomnia to test the following endpoints in order.
</br>

Authentication (/api/auth)
</br>
Register User: 

<strong>POST</strong> /signup

Body: {"username": "marco", "email": "marco@email.com", "password": "password123"}
</br>
Register Admin: 

<strong>POST</strong> /signup

Body: {"username": "admin", "email": "admin@email.com", "password": "password123", "role": ["admin"]}
</br>
Login: 

<strong>POST</strong> /signin

Body: {"username": "your_username", "password": "password123"}
Action: Copy the "token" from the response for authenticated requests.
</br>

Product Catalog (/api/products)
</br>

Create Product (Admin Only): 

<strong>POST</strong> /

Auth: Bearer Token (use admin's token).

Body: {"name": "Skateboard Deck", "description": "8.25 inch", "price": 59.99}
</br>

View All Products (Public): 

<strong>GET</strong> /

Shopping Cart (/api/cart)
</br>

Add Product to Cart (User Only): 

<strong>POST</strong> /items

Auth: Bearer Token (use a regular user's token).

Body: {"productId": 1, "quantity": 2}
</br>

View Cart (User Only): 
<strong>GET</strong> /

Auth: Bearer Token (use the same user's token).

Expected Response: A JSON object showing the cart's content and the total price.
