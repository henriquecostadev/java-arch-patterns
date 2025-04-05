# Hexagonal Arch Java

---

## Pros

- Code more organized
- Any adapter replacement does not require changing the core of the application
- The business rules are completely isolated from the rest of the code, depending only on the core interfaces
- Easy to test the business rules
- Enforce SOLID principles
    - Single Responsibility Principle (SRP)
    - Open (exention)/Closed (modification) Principle (OCP)
    - Liskov Substitution Principle (LSP)
    - Interface Segregation Principle (ISP)
    - Dependency Inversion Principle (DIP)

## Cons

- High amount of generated code

## Project Structure

```
.
└── hexagonal
    ├── adapters
    │   ├── in
    │   └── out
    ├── application
    │   ├── core
    │   │   ├── domain
    │   │   └── use_case
    │   └── ports
    │       ├── in
    │       └── out
    └── config
```

### **adapters**

Implementation of the input and output ports interfaces.

- **in**  
  Implementation of the input ports.  
  *Examples:* Controllers (REST), Consumers (Message Brokers), etc.

- **out**  
  Implementation of the output ports.  
  *Examples:* REST Clients, Database Repositories, etc.

---

### **application**

Core of the application where all business rules should be implemented.

- Should **not** access external systems directly.
- Must **not** depend on frameworks (e.g., Lombok, CDI).
- Must remain **fully isolated**.

- **core**  
  The central logic of the application.
    - **domain**  
      Domain entities and models.
    - **use_case**  
      Contains all business logic implementations.  
      Must implement interfaces from `/application/ports/in`.

- **ports**  
  Defines interfaces for application boundaries.
    - **in**  
      Input ports (interfaces for accessing the core).
    - **out**  
      Output ports (interfaces for external interactions).

---

### **config**

Application configuration files (e.g., dependency injection, framework setups).