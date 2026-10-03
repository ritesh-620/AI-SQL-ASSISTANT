# AI SQL Assistant

AI SQL Assistant is a full-stack application that converts natural-language requests into SQL queries using an AI model.

The project combines a Java Spring Boot backend with a simple frontend and Ollama Cloud for AI-powered SQL generation.

## 🚀 Features

* Convert natural-language requests into SQL queries
* AI-powered SQL generation using Ollama
* REST API built with Spring Boot
* MySQL database integration
* Simple frontend interface for entering prompts
* Frontend-to-backend API communication
* JSON request and response handling
* SQL output extraction from the AI response

## 🛠️ Technologies Used

### Frontend

* HTML
* CSS
* JavaScript

### Backend

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate / JPA
* MySQL
* Maven

### AI

* Ollama
* `gpt-oss:20b-cloud`

## 📁 Project Structure

```text
AI-SQL-Assistant/
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── script.js
│
├── backend/
│   ├── pom.xml
│   └── src/
│       └── main/
│           └── java/
│
└── README.md
```

## 🔄 How It Works

```text
User enters a request
        ↓
Frontend sends POST request
        ↓
Spring Boot REST Controller
        ↓
Ollama Service
        ↓
Ollama Cloud AI Model
        ↓
AI generates SQL
        ↓
Backend extracts the SQL response
        ↓
SQL is displayed in the frontend
```

## 🧪 Example

### Input

```text
Find all users whose email ends with gmail.com
```

### Output

```sql
SELECT * FROM users WHERE email LIKE '%@gmail.com';
```

## ⚙️ Setup

### 1. Clone the repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
cd AI-SQL-Assistant
```

### 2. Start Ollama

Make sure Ollama is installed and running.

The project uses:

```text
gpt-oss:20b-cloud
```

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE ai_sql_db;
```

Configure your database connection in the Spring Boot application.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ai_sql_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Run the backend

Open the `backend` folder in IntelliJ IDEA and run the Spring Boot application.

The backend runs on:

```text
http://localhost:8080
```

### 5. Run the frontend

Open the frontend using a local development server and make sure it can communicate with the Spring Boot backend.

The SQL generation endpoint is:

```text
POST /api/sql/generate
```

Example request:

```json
{
    "prompt": "Show all users"
}
```

## 📚 What I Learned

This project helped me practice:

* Building REST APIs with Spring Boot
* Controller and service architecture
* Constructor-based dependency injection
* Spring Data JPA
* MySQL database integration
* Sending requests to an external AI API
* Working with JSON responses
* Using Jackson `ObjectMapper`
* Connecting a JavaScript frontend with a Spring Boot backend
* Debugging frontend/backend integration issues
* Using Git and GitHub for project management

## 🔮 Future Improvements

Some features I may add in the future:

* SQL query execution
* Database schema awareness
* Query history
* SQL syntax highlighting
* Better error handling
* Authentication
* Support for multiple database types
* Improved prompt handling and SQL validation

## 👨‍💻 Author

Ritesh Kumar Ray

B.Tech Computer Science Engineering Student

GitHub: YOUR_GITHUB_PROFILE_URL
