# Fitness Monolith Backend Application

A scalable and secure backend application built using **Java Spring Boot** for managing fitness activities, user authentication, and personalized recommendations.

This project follows a layered architecture with RESTful APIs, JWT-based authentication, and MySQL database integration.

---

# 🚀 Features

- User Registration & Login Authentication
- JWT Token-Based Security
- Role-Based Authorization
- Activity Management APIs
- Personalized Recommendation Module
- RESTful API Architecture
- Exception Handling Mechanism
- Layered Backend Structure
- MySQL Database Integration
- Secure Spring Security Configuration
- API Testing with Postman

---

# 🛠️ Tech Stack

## Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Maven

## Database
- MySQL

## Authentication
- JWT (JSON Web Token)

## Testing Tool
- Postman

---

# 📂 Project Structure

```text
src
 └── main
      ├── java/com/project/fitness
      │     ├── config
      │     ├── controller
      │     ├── dto
      │     ├── exception
      │     ├── model
      │     ├── repository
      │     ├── security
      │     ├── service
      │     └── FitnessApplication.java
      │
      └── resources
            └── application.properties
```

---

# 🔐 Authentication Flow

1. User registers using registration API
2. User logs in with credentials
3. JWT token is generated
4. Protected APIs are accessed using Bearer Token

---

# ⚙️ Installation & Setup

## 1️⃣ Clone Repository

```bash
git clone https://github.com/vkfullstack/fitness-monolith.git
```

---

## 2️⃣ Navigate to Project

```bash
cd fitness-monolith
```

---

## 3️⃣ Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fitnessdb
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

## 4️⃣ Run Application

```bash
mvn spring-boot:run
```

---

# 📮 API Testing

All APIs were tested using **Postman**.

## Sample APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register User |
| POST | `/api/auth/login` | User Login |
| GET | `/api/activity` | Get Activities |
| POST | `/api/activity` | Create Activity |
| GET | `/api/recommendation` | Get Recommendations |

---

# 🧠 Learning Outcomes

- Spring Boot Backend Development
- JWT Authentication
- REST API Design
- Layered Architecture
- Exception Handling
- Database Integration
- Secure API Development
- Git & GitHub Workflow

---

# 📌 Future Enhancements

- Frontend Integration with React
- Docker Containerization
- Cloud Deployment
- Admin Dashboard
- Activity Analytics
- Email Verification System

---

# 👨‍💻 Author

## Vijay Khetre

- GitHub: https://github.com/vkfullstack

---

# ⭐ Project Status

Backend development is actively improving with new modules and security enhancements.
