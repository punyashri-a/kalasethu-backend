# Kalasethu Backend Service

> **Kalasethu** (*Kala* = Art & Culture, *Sethu* = Bridge) is a backend web service designed to connect traditional Indian classical performing arts with modern digital platforms. Built using Spring Boot and PostgreSQL, it provides RESTful APIs for managing classical artists, dance repertoires, performance cataloging, and administrative workflows.

---

## Key Features

- **Artist Profile Management**: REST APIs to onboard artists, track joining dates, manage active status, and store contact details.
- **Classical Dance Repertoire**: Centralized catalog for classical dance forms (such as Bharatanatyam, Kathak, and Odissi), performance durations, and cultural descriptions.
- **Secure Configuration Strategy**: Sensitive credentials (such as database passwords) are externalized using Spring environment variable interpolation (`${DB_PASSWORD:}`).
- **Layered Architecture**: Clear separation of concerns across Controllers, Business Services, Spring Data Repositories, and JPA Entities.
- **Reliable Data Persistence**: PostgreSQL database integration powered by Spring Data JPA and Hibernate for automatic schema generation and data integrity.

---

## Tech Stack

| Domain | Technology | Purpose |
| :--- | :--- | :--- |
| **Language** | Java 21 (LTS) | Core application programming language |
| **Framework** | Spring Boot 3.4 | REST Controllers, Dependency Injection, Application Context |
| **Data Access** | Spring Data JPA / Hibernate | Object-Relational Mapping (ORM) & Database Operations |
| **Database** | PostgreSQL | Relational database storage |
| **Utilities** | Lombok | Auto-generation of getters, setters, constructors, and boilerplate |
| **Build & Dependency Tool** | Apache Maven | Dependency management & project lifecycle automation |

---

## Project Architecture

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

## Getting Started

### Prerequisites

Before running the application, ensure you have the following installed on your system:
* **JDK 21** or later (`java -version`)
* **PostgreSQL** (v15+ recommended) running locally or via Docker
* **Git** for version control

---

### 1. Database Setup

Create a PostgreSQL database named `kalasethu_db`:

```sql
CREATE DATABASE kalasethu_db;
```

---

### 2. Environment Configuration

Kalasethu strictly separates application logic from secret credentials. Sensitive credentials are never hardcoded in the source code.

1. Set up your local environment variables:

   ```bash
   export DB_URL=jdbc:postgresql://localhost:5432/kalasethu_db
   export DB_USERNAME=postgres
   export DB_PASSWORD=your_secure_password_here
   export SERVER_PORT=8080
   ```

2. `.gitignore` is pre-configured to ensure `.env` files, build output (`target/`), and IDE configurations (`.idea/`, `.vscode/`) are excluded from version control.

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

The service will be available at `http://localhost:8080`.

---

## API Documentation & Reference

### Artists API (`/artists`)

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

### Dance Repertoire API (`/dances`)

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

## Security Best Practices

- **Zero Hardcoded Secrets**: All environment-sensitive properties use dynamic Spring placeholders (`${DB_PASSWORD:}`).
- **Strict `.gitignore` Policy**: Prevents accidental leakage of `.env` files, database credentials, build artifacts, and IDE configurations.
- **Parameterized SQL Queries**: Managed via Spring Data JPA to prevent SQL injection vulnerabilities.

---

## Contributing

Contributions, feedback, and suggestions are always welcome!

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature-name`)
3. Commit your changes (`git commit -m 'Add your feature description'`)
4. Push to your branch (`git push origin feature/your-feature-name`)
5. Open a Pull Request

---

## License

Distributed under the **MIT License**. See [`LICENSE`](LICENSE) for details.

---

<p align="center"><i>Crafted to empower classical Indian performing arts through technology.</i></p>
