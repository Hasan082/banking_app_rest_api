# Banking App REST API (Spring Boot)

A RESTful banking service built with **Java 17** and **Spring Boot 3**. It manages bank accounts through a clean, layered architecture (controller → service → repository) with DTOs and mappers, and runs out of the box on an in-memory H2 database.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen)
![Build](https://img.shields.io/badge/build-Maven-blue)
![Database](https://img.shields.io/badge/DB-H2%20%7C%20MySQL-lightgrey)

---

## Features

- Create a bank account
- Get an account by ID
- Layered architecture: `controller`, `service` (interface + implementation), `repository`, `entity`, `dto`, `mapper`
- Spring Data JPA with Hibernate
- Zero-setup local run with **H2** (in-memory database)
- Optional **MySQL** profile, with credentials read from environment variables (no secrets in the repository)

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.2 (Web, Data JPA) |
| Persistence | Hibernate, H2 (default), MySQL (optional) |
| Build | Maven (wrapper included) |
| Utilities | Lombok |

---

## Project Structure

```
src/main/java/com/hasan/bankingapp
├── BankingappApplication.java      # Application entry point
├── controller/AccountController.java  # REST endpoints
├── dto/AccountDto.java              # Data transfer object
├── entity/Account.java              # JPA entity (accounts table)
├── mapper/AccountMapper.java        # Entity <-> DTO mapping
├── repository/AccountRepo.java      # Spring Data JPA repository
└── service/
    ├── AccountService.java          # Service interface
    └── Impl/AccountServiceImpl.java # Business logic
```

---

## Getting Started

### Prerequisites

- Java 17 or later (tested on JDK 23)
- No database installation needed for the default H2 setup

### Run (H2, default)

```bash
git clone https://github.com/Hasan082/banking_app_rest_api.git
cd banking_app_rest_api
./mvnw spring-boot:run
```

The API starts on `http://localhost:8080`.

H2 console: `http://localhost:8080/h2-console`
(JDBC URL `jdbc:h2:mem:bankapp`, user `sa`, empty password)

### Run with MySQL (optional)

```bash
export DB_PASSWORD=your_mysql_password
# optional: export DB_URL=jdbc:mysql://localhost:3306/bankapp
# optional: export DB_USERNAME=root
./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql
```

---

## API Endpoints

Base URL: `/api/accounts`

| Method | Endpoint | Description | Success |
|---|---|---|---|
| `POST` | `/api/accounts` | Create a new account | `201 Created` |
| `GET` | `/api/accounts/{id}` | Get an account by ID | `200 OK` |

### Create an account

```bash
curl -X POST http://localhost:8080/api/accounts \
  -H "Content-Type: application/json" \
  -d '{"accountName":"Hasan","balance":1000}'
```

Response:

```json
{ "id": 1, "accountName": "Hasan", "balance": 1000.0 }
```

### Get an account

```bash
curl http://localhost:8080/api/accounts/1
```

Response:

```json
{ "id": 1, "accountName": "Hasan", "balance": 1000.0 }
```

---

## Roadmap

- [ ] List all accounts and delete an account
- [ ] Deposit and withdraw, with overdraft protection
- [ ] Use `BigDecimal` for monetary values
- [ ] Custom exceptions with a global `@RestControllerAdvice` (404 / 400 responses)
- [ ] Request validation with `@Valid`
- [ ] Unit tests (JUnit 5, Mockito) and controller tests (`@WebMvcTest`)
- [ ] Transaction history (`Transaction` entity)
- [ ] Docker Compose (app + database)
- [ ] GitHub Actions CI
- [ ] OpenAPI / Swagger documentation
- [ ] Spring Security with JWT

---

## Author

**Md Hasanuzzaman** · Senior Software Engineer
[LinkedIn](https://www.linkedin.com/in/mdhasanuzzamanhasan) · [GitHub](https://github.com/Hasan082) · [enghasan.com](https://enghasan.com)
