# Simple Twitter Project 🐦

This project is a **simplified Twitter-like REST API** built with **Spring Boot**.  
It allows users to register, authenticate, and perform basic tweet operations with secure access control.

The main goal of this project is to practice **Spring Boot architecture**, **Spring Security**, **JPA/Hibernate**, and **RESTful API design**.

---

## 🚀 Features

- User Registration
- Basic Authentication (Spring Security)
- Create Tweet
- Update Tweet
- Delete Tweet
- Get Tweet by ID
- Get Tweets by User
- Secure endpoints with authentication
- DTO-based request & response structure
- Validation & custom exception handling

---

## 🛠 Tech Stack

- **Java**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL**
- **Maven**
- **Lombok**
- **Postman** (for API testing)

---


---

## 🔐 Security

- **Spring Security** is used with **Basic Authentication**
- Public endpoints:
  - `POST /register`
  - `POST /login`
- All other endpoints require authentication
- Passwords are stored **hashed (BCrypt)**

---

## 📌 API Endpoints

### Authentication

| Method | Endpoint   | Description          |
|------|-----------|----------------------|
| POST | /register | Register new user    |
| POST | /login    | Login with credentials |

### Tweet Operations

| Method | Endpoint              | Description                     |
|------|----------------------|---------------------------------|
| POST | /tweet                | Create a tweet                  |
| GET  | /tweet/findById       | Get tweet by tweet ID           |
| GET  | /tweet/findByUserId   | Get tweets by user ID           |
| PUT  | /tweet                | Update tweet text               |
| DELETE | /tweet/{id}         | Delete tweet                    |

---

## 🧪 Testing with Postman

1. Register a user via `/register`
2. Login using **Basic Auth**
3. Use the same credentials for secured endpoints
4. Test tweet CRUD operations

---

## 🧠 What I Learned

- Designing REST APIs with layered architecture
- Using DTOs instead of exposing entities
- Implementing authentication with Spring Security
- Handling validation and custom exceptions
- Working with JPA relationships (`@ManyToOne`)
- Debugging common Spring Security issues (401, CSRF, authentication flow)

---

## 📌 Future Improvements

- JWT-based authentication
- Like / Retweet functionality
- Pagination for tweets
- User follow system
- Global exception response standardization

---

## 👩‍💻 Author

**Beyza Can Sertel**  
- GitHub: https://github.com/beyzasertel  
- LinkedIn: https://linkedin.com/in/beyza-can-sertel  

---

⭐ If you find this project useful, feel free to star the repository!

