# 🎭 Kalasethu Backend Service

[![Java 21](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot 3.4](https://img.shields.io/badge/Spring%20Boot-3.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-purple.svg?style=for-the-badge)](LICENSE)

> **Kalasethu** (*Kala* = Art & Culture, *Sethu* = Bridge) is a dedicated backend web service engineered to connect traditional Indian classical performing arts with modern digital platforms. Built on Spring Boot and PostgreSQL, it delivers high-performance RESTful APIs for managing classical artists, dance repertoires, performance cataloging, and administrative workflows.

---

## 🌟 Key Features

- **🧑‍🎨 Artist Profile Management**: Full CRUD REST APIs to onboard artists, track joining dates, manage active status, and store contact information.
- **💃 Classical Dance Repertoire**: Centralized catalog for classical dance forms (e.g., Bharatanatyam, Kathak, Odissi), performance durations, and cultural descriptions.
- **🔐 Secure Configuration Strategy**: Zero-hardcoded credentials policy with Spring environment variable interpolation (`${DB_PASSWORD:}`).
- **⚡ Layered Architecture**: Strict separation of concerns across Controllers, Business Services, Spring Data Repositories, and JPA Entities.
- **🛡 Enterprise Persistence**: PostgreSQL database integration powered by Spring Data JPA and Hibernate for automatic schema generation and data integrity.

---

## 🛠 Tech Stack

| Domain | Technology | Purpose |
| :--- | :--- | :--- |
| **Language** | Java 21 (LTS) | Core application programming language |
| **Framework** | Spring Boot 3.4 | REST Controllers, Dependency Injection, Application Context |
| **Data Access** | Spring Data JPA / Hibernate | Object-Relational Mapping (ORM) & Database Operations |
| **Database** | PostgreSQL | Relational database storage |
| **Utilities** | Lombok | Auto-generation of getters, setters, constructors, and standard boilerplate |
| **Build & Dependency Tool** | Apache Maven | Dependency management & project lifecycle automation |

---

## 📁 Project Architecture

```text
kalasethu-backend/
├── src/
│   ├── main/
│   │   ├── java/com/example/kalasethubackend/
│   │   │   ├── controller/               # REST Endpoints (ArtistController, DanceController)
│   │   │   ├── model/                    # JPA Entities (Artist, Dance)
│   │   │   ├── repository/               # Spring Data Repositories (ArtistRepository, DanceRepository)
│   │   │   ├── service/                  # Business Logic Layer (ArtistService, DanceService)
│   │   │   └── KalasethuBackendApplication.java # Application Main Entry Point
│   │   └── resources/
│   │       └── application.properties    # Externalized Environment Configuration
│   └── test/                             # Automated Unit & Integration Tests
├── .env.example                          # Safe Environment Variable Template
├── .gitignore                            # Excluded Build Artifacts & Credentials
├── pom.xml                               # Maven Build Descriptor
├── LICENSE                               # MIT License
└── README.md                             # Documentation
```

---

## 🚀 Getting Started

### Prerequisites

Before running the application, ensure you have the following installed on your machine:
* **JDK 21** or later: Verify with `java -version`
* **PostgreSQL** (v15+ recommended): Running locally on port `5432` or via cloud/Docker
* **Git**: For source version control

---

### 1. Database Setup

Create a PostgreSQL database named `kalasethu_db`:

```sql
CREATE DATABASE kalasethu_db;
```

---

### 2. Environment Configuration & Hiding Credentials

Kalasethu strictly separates application logic from secret credentials. Sensitive credentials like database passwords are **never hardcoded** in the codebase.

1. Create your local `.env` file or set environment variables in your environment:

   ```bash
   export DB_URL=jdbc:postgresql://localhost:5432/kalasethu_db
   export DB_USERNAME=postgres
   export DB_PASSWORD=your_secure_password_here
   export SERVER_PORT=8080
   ```

2. `.gitignore` is pre-configured to ensure `.env`, secret key files (`*.key`, `*.pem`), build targets (`target/`), and IDE settings (`.idea/`, `.vscode/`) are never committed to version control.

---

### 3. Build & Run

Run the application locally using the bundled Maven Wrapper:

```bash
# 1. Clone the repository
git clone https://github.com/punyashri-a/kalasethu-backend.git
cd kalasethu-backend

# 2. Build the project
./mvnw clean package -DskipTests

# 3. Start the Spring Boot application
./mvnw spring-boot:run
```

The service will start listening at `http://localhost:8080`.

---

## 📖 API Documentation & Reference

### 🧑‍🎨 Artists API (`/artists`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/artists` | Fetch list of all registered artists |
| `GET` | `/artists/{id}` | Fetch a specific artist profile by ID |
| `POST` | `/artists` | Register a new artist profile |
| `PUT` | `/artists/{id}` | Update an existing artist profile |
| `DELETE` | `/artists/{id}` | Delete an artist profile |

#### Example Request: Create Artist (`POST /artists`)

```bash
curl -X POST http://localhost:8080/artists \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Ananya Sharma",
    "phoneNumber": "+91 9876543210",
    "joiningDate": "2024-01-15",
    "active": true
  }'
```

#### Example Response
```json
{
  "artistId": 1,
  "name": "Ananya Sharma",
  "phoneNumber": "+91 9876543210",
  "joiningDate": "2024-01-15",
  "active": true
}
```

---

### 💃 Dance Repertoire API (`/dances`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/dances` | Fetch all recorded dance art forms |
| `GET` | `/dances/{id}` | Fetch details for a specific dance form |
| `POST` | `/dances` | Add a new dance form to the repertoire |
| `PUT` | `/dances/{id}` | Update dance form details |
| `DELETE` | `/dances/{id}` | Delete a dance form record |

#### Example Request: Add Dance Form (`POST /dances`)

```bash
curl -X POST http://localhost:8080/dances \
  -H "Content-Type: application/json" \
  -d '{
    "danceName": "Bharatanatyam",
    "duration": "45 mins",
    "description": "Classical Indian dance form originating from Tamil Nadu showcasing expressive storytelling and rhythmic footwork.",
    "active": true
  }'
```

#### Example Response
```json
{
  "danceId": 1,
  "danceName": "Bharatanatyam",
  "duration": "45 mins",
  "description": "Classical Indian dance form originating from Tamil Nadu showcasing expressive storytelling and rhythmic footwork.",
  "active": true
}
```

---

## 🔒 Security Best Practices

- **Zero Hardcoded Secrets**: All environment-sensitive properties use dynamic Spring placeholders (e.g. `${DB_PASSWORD:}`).
- **Strict `.gitignore` Enforcements**: Prevents unintended leakage of `.env`, database configuration files, and IDE workspace data.
- **Parametrized SQL Queries**: Handled via Spring Data JPA to safeguard against SQL injection risks.

---

## 🤝 Contributing

Contributions, feedback, and feature suggestions are always welcome!
1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📜 License

Distributed under the **MIT License**. See [`LICENSE`](LICENSE) for more details.

---

<p center><i>Crafted with ❤️ to empower classical Indian performing arts through technology.</i></p>
