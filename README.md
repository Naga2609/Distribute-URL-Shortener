# Distributed URL Shortener

A full-stack URL shortening application built using Spring Boot, React, and MySQL.

This project allows users to shorten long URLs into compact shareable links, automatically redirect users to the original URLs, and track click counts.

---

# Features

- Shorten long URLs
- Generate unique short codes
- Redirect short URLs to original URLs
- Track click counts
- Copy shortened URLs
- Responsive frontend UI
- MySQL database integration
- REST API architecture

---

# Tech Stack

## Frontend
- React
- Material UI
- Axios

## Backend
- Spring Boot
- Spring Data JPA
- REST APIs
- Lombok

## Database
- MySQL

---

# Project Architecture

```text
React Frontend
       ↓
Spring Boot REST API
       ↓
MySQL Database
```

---

# Project Structure

```text
distributed-url-shortener/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   └── resources/
│
├── frontend/
│   ├── src/
│   └── public/
│
└── README.md
```

---

# API Endpoints

## Shorten URL

```http
GET /api/url/shorten?originalUrl=https://google.com
```

Response:

```json
{
  "id": 1,
  "originalUrl": "https://google.com",
  "shortCode": "Ab12Xy",
  "clickCount": 0,
  "createdAt": "2026-05-06T22:00:00"
}
```

---

## Redirect URL

```http
GET /api/url/{shortCode}
```

Example:

```http
GET /api/url/Ab12Xy
```

Automatically redirects to the original URL.

---

# Database Schema

## URLs Table

| Column | Type |
|---|---|
| id | bigint |
| original_url | varchar |
| short_code | varchar |
| click_count | bigint |
| created_at | datetime |

---

# Installation and Setup

## Backend Setup

### 1. Clone Repository

```bash
git clone <repository-url>
```

### 2. Navigate to Backend

```bash
cd backend
```

### 3. Configure MySQL

Create database:

```sql
CREATE DATABASE url_shortener;
```

Update:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 4. Run Backend

```bash
mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

# Frontend Setup

### 1. Navigate to Frontend

```bash
cd frontend
```

### 2. Install Dependencies

```bash
npm install
```

### 3. Start React App

```bash
npm start
```

Frontend runs on:

```text
http://localhost:3000
```

---

# Future Improvements

- JWT Authentication
- User Accounts
- Redis Caching
- Docker Deployment
- QR Code Generation
- Custom Short URLs
- URL Expiration
- Analytics Dashboard

---

# Learning Outcomes

This project helped in understanding:

- Full-stack development
- REST API development
- Database integration
- Frontend-backend communication
- URL shortening algorithms
- Spring Boot architecture
- React state management

---

# Author

Naga Panindra

---

# License

This project is developed for educational and learning purposes.
