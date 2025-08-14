# Corexfin Banking Solutions

## Project Overview
Corexfin Banking Solutions is a scalable, secure microservices-based platform designed to support multiple banking institutions under a unified system. The platform enables each bank (e.g., Hex Bank, UBI, SBI) to maintain autonomy with dedicated owners, branches, and users, while benefiting from centralized operational efficiency.

Corexfin handles key banking operations, including account management, transaction processing, and internet banking approvals, all within a secure, compliant, and highly available architecture.

## Key Features
- Multi-bank support with role-based access control  
- Secure authentication using JWT and OAuth2  
- Microservices architecture enabling independent scalability and fault isolation  
- Distributed transaction management with SAGA pattern  
- Asynchronous event-driven communication via Kafka/RabbitMQ  
- Centralized audit logging for compliance  
- Modular services for registration, account, transaction, notification, and more  
- React-based multi-tenant frontend portals  

## Technology Stack
- **Backend:** Java, Spring Boot, Spring Cloud  
- **Authentication:** Spring Security, JWT, OAuth2  
- **Messaging:** Apache Kafka or RabbitMQ  
- **Database:** PostgreSQL (per microservice), Redis cache  
- **Frontend:** React.js  
- **Containerization & Orchestration:** Docker, Kubernetes  
- **CI/CD:** GitHub Actions or GitLab CI  
- **Monitoring & Logging:** ELK stack, Prometheus, Grafana, Jaeger  
- **Security:** TLS, optional mTLS, data encryption  

## Architecture & Microservices
1. **API Gateway** — request routing, authentication, rate limiting  
2. **Auth Service** — login, JWT token management  
3. **Registration Service** — user and bank owner registration, email verification  
4. **Bank Management** — bank and branch administration  
5. **User Service** — user profiles and roles  
6. **Account Service** — account creation, status, balance inquiries  
7. **Transaction Service** — deposits, withdrawals, transfers with SAGA  
8. **Internet Banking Service** — online banking access requests and approvals  
9. **Notification Service** — email, SMS, push notifications  
10. **Audit & Logging Service** — activity tracking and compliance logs  
11. **Admin Portal** — Corexfin global administration  
12. **Config & Discovery Service** — centralized configuration and service registry  
13. **Event Broker** — asynchronous event messaging  

## Development Roadmap
1. Setup infrastructure: Kubernetes, config server, service discovery, API Gateway  
2. Implement Auth & Registration services with JWT onboarding flows  
3. Build Bank Management and User Service  
4. Develop Account and Transaction Services with SAGA pattern  
5. Create Internet Banking module with request and approval workflows  
6. Setup Notification and Audit services  
7. Develop React-based bank and customer portals  
8. Implement testing, security hardening, and rate limiting  
9. Add observability: logging, monitoring, alerting, tracing  
10. Optimize for scale and resilience  

---

Data Modeling for Corexfin Banking Solutions


---

1. Database Tables (Simplified Schema)

#Bank

Column	Type	Notes

bank_id	VARCHAR (PK)	Unique bank identifier
name	VARCHAR	Bank name
domain	VARCHAR	Bank domain (e.g., hexbank.com)
owner_user_id	VARCHAR (FK)	Reference to bank owner user


#Branch

Column	Type	Notes

branch_id	VARCHAR (PK)	Unique branch identifier
bank_id	VARCHAR (FK)	Linked bank
name	VARCHAR	Branch name
address	TEXT	Branch address


#User

Column	Type	Notes

user_id	VARCHAR (PK)	Unique user id
username	VARCHAR	Login username/email
password	VARCHAR	Hashed password
roles	VARCHAR ARRAY	Roles (BANK_OWNER, MANAGER...)
bank_id	VARCHAR (FK)	Associated bank
branch_id	VARCHAR (FK)	Branch (nullable for bank owner)
profile	JSONB	User profile info (name, phone, email, etc.)
active	BOOLEAN	Active status


#Account

Column	Type	Notes

account_id	VARCHAR (PK)	Unique account id
bank_id	VARCHAR (FK)	Associated bank
branch_id	VARCHAR (FK)	Branch
customer_id	VARCHAR (FK)	User who owns the account
account_type	VARCHAR	SAVINGS, CURRENT, etc.
balance	DECIMAL	Current balance
status	VARCHAR	ACTIVE, SUSPENDED, CLOSED
internet_banking_enabled	BOOLEAN	IB enabled flag


#InternetBankingRequest

Column	Type	Notes

request_id	VARCHAR (PK)	Unique request id
account_id	VARCHAR (FK)	Account linked
customer_id	VARCHAR (FK)	Customer requesting IB
status	VARCHAR	PENDING, APPROVED, REJECTED
requested_at	TIMESTAMP	Request timestamp
approved_by	VARCHAR (FK)	User who approved
approved_at	TIMESTAMP	Approval timestamp


#Transaction

Column	Type	Notes

transaction_id	VARCHAR (PK)	Unique transaction id
from_account	VARCHAR (FK)	Source account (nullable for deposits)
to_account	VARCHAR (FK)	Destination account (nullable for withdrawals)
amount	DECIMAL	Transaction amount
type	VARCHAR	TRANSFER, DEPOSIT, WITHDRAWAL
status	VARCHAR	PENDING, POSTED, FAILED
created_at	TIMESTAMP	Creation time



---
```
2. Entity Classes (Java)

// Bank Entity
@Entity
public class Bank {
  @Id
  private String bankId;
  private String name;
  private String domain;
  private String ownerUserId;
}

// Branch Entity
@Entity
public class Branch {
  @Id
  private String branchId;
  private String bankId;
  private String name;
  private String address;
}

// User Entity
@Entity
public class User {
  @Id
  private String userId;
  private String username;
  private String password;
  
  @ElementCollection(fetch = FetchType.EAGER)
  private Set<String> roles;
  
  private String bankId;
  private String branchId;
  
  @Type(type = "jsonb")
  private String profile; // JSON stored as string
  
  private boolean active;
}

// Account Entity
@Entity
public class Account {
  @Id
  private String accountId;
  private String bankId;
  private String branchId;
  private String customerId;
  private String accountType;
  private BigDecimal balance;
  private String status;
  private boolean internetBankingEnabled;
}

// InternetBankingRequest Entity
@Entity
public class InternetBankingRequest {
  @Id
  private String requestId;
  private String accountId;
  private String customerId;
  private String status;
  private Instant requestedAt;
  private String approvedBy;
  private Instant approvedAt;
}

// Transaction Entity
@Entity
public class Transaction {
  @Id
  private String transactionId;
  private String fromAccount;
  private String toAccount;
  private BigDecimal amount;
  private String type;
  private String status;
  private Instant createdAt;
}


---

3. DTOs (Data Transfer Objects)

// BankDTO
public class BankDTO {
  private String bankId;
  private String name;
  private String domain;
  private String ownerUserId;
}

// UserDTO
public class UserDTO {
  private String userId;
  private String username;
  private Set<String> roles;
  private String bankId;
  private String branchId;
  private Map<String, String> profile; // e.g. name, email, phone
  private boolean active;
}

// AccountDTO
public class AccountDTO {
  private String accountId;
  private String bankId;
  private String branchId;
  private String customerId;
  private String accountType;
  private BigDecimal balance;
  private String status;
  private boolean internetBankingEnabled;
}

// InternetBankingRequestDTO
public class InternetBankingRequestDTO {
  private String requestId;
  private String accountId;
  private String customerId;
  private String status;
  private Instant requestedAt;
  private String approvedBy;
  private Instant approvedAt;
}

// TransactionDTO
public class TransactionDTO {
  private String transactionId;
  private String fromAccount;
  private String toAccount;
  private BigDecimal amount;
  private String type;
  private String status;
  private Instant createdAt;
}

```
---

Notes:

Use UUID strings or similar unique identifiers for IDs.

profile stored as JSONB in DB, mapped as String or Map in DTO.

Roles as a set of Strings for flexibility.

Use mapping libraries like MapStruct or ModelMapper to convert Entity ⇄ DTO.



---

If you want, I can help generate full Spring Boot entity/repository/service code snippets, or the database DDL scripts for these tables! Would you like that?


## API Endpoints Highlights

### Auth Service
- `POST /auth/login` — user login, returns JWT  
- `POST /auth/refresh-token` — refresh JWT token  
- `POST /auth/change-password` — change user password  

### Registration Service
- `POST /register/bank-owner` — register bank owner and create bank  
- `POST /register/manager` — register branch manager or accountant  
- `POST /register/customer` — customer self-registration (optional)  
- `POST /register/verify-email` — verify user email  
- `POST /register/resend-verification` — resend verification email  

### Bank Management Service
- `POST /banks` — create bank (admin only)  
- `POST /banks/{bankId}/branches` — add branch  
- `GET /banks/{bankId}/branches` — list branches  

### User Service
- `POST /banks/{bankId}/branches/{branchId}/users` — create manager/accountant  
- `GET /banks/{bankId}/users` — list bank users  

### Account Service
- `POST /banks/{bankId}/branches/{branchId}/accounts` — create customer account  
- `GET /accounts/{accountId}` — get account details  

### Transaction Service
- `POST /transactions/transfer` — money transfer with SAGA  
- `GET /accounts/{accountId}/transactions` — transaction history  

### Internet Banking Service
- `POST /accounts/{accountId}/internet-banking/request` — request IB access  
- `POST /ib/requests/{reqId}/approve` — approve IB request  

### Notification Service
- `POST /notifications/email` — send email  
- `POST /notifications/sms` — send SMS  

### Audit & Logging Service
- `GET /audit/logs` — query audit logs  

---

## Getting Started

1. Clone the repository  
2. Setup PostgreSQL databases for each microservice  
3. Configure Kafka/RabbitMQ event broker  
4. Build and deploy microservices using Docker and Kubernetes  
5. Run API Gateway and frontends  
6. Use provided Swagger/OpenAPI docs for API exploration  

---

## Contributing  
Contributions are welcome! Please follow the coding standards and submit pull requests for review.

---

## License  
Specify your license here.

---

*For more details or support, contact the Corexfin development team. *
---
# Company : `HCLTech` 
  ## Team : `Corexfin`
    -Leader : Mr.Brijesh (bnlv1212@gmail.com)
    -Member1: Ankit Kumar Sahoo
    -Member2: Suhani Shroff (suhanishroff03@gmail.com)
    -Member3: Shrisht dev (shrishtdev@gmail.com)
---
