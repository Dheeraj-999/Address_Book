# Address_Book
# Address Book Application

A Java-based Address Book application developed using **Spring Boot, REST APIs, and MySQL**. The application allows users to manage contacts and organize them into multiple address books.

## About the Project

The Address Book application is designed to make contact management simple and organized. Users can create address books, add contacts, view contact details, update information, and delete contacts.

The project is developed step by step using different use cases, starting from basic Spring Boot setup and gradually adding more features.

## Technologies Used

- **Language:** Java 21
- **Backend Framework:** Spring Boot
- **Build Tool:** Maven
- **Database:** MySQL
- **ORM:** Spring Data JPA / Hibernate
- **API Testing:** Postman
- **IDE:** IntelliJ IDEA
- **Version Control:** Git and GitHub

## Use Cases

| Use Case | Description |
|---|---|
| UC1 – Spring Boot Setup | Create the Spring Boot project and configure a basic REST Controller. |
| UC2 – CRUD with MySQL | Connect MySQL and perform Create, Read, Update and Delete operations on contacts. |
| UC3 – DTO and Service Layer | Introduce DTOs and separate business logic into a service layer. |
| UC4 – In-Memory Storage | Manage multiple contacts using Java Collections. |
| UC5 – Multiple Address Books | Create and manage multiple address books, each with a unique name. |
| UC6 – Duplicate Contact Check | Prevent duplicate contacts with the same name within an address book. |

*Additional use cases will be documented as development progresses.*

## Project Structure

```text
Address_Book/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/adressbook/
│       │       ├── controller/
│       │       │   ├── AddressBookController.java
│       │       │   └── AddressBookManagementController.java
│       │       │
│       │       ├── dto/
│       │       │   └── ContactDTO.java
│       │       │
│       │       ├── model/
│       │       │   ├── Contact.java
│       │       │   └── AddressBook.java
│       │       │
│       │       ├── repository/
│       │       │   └── ContactRepository.java
│       │       │
│       │       ├── service/
│       │       │   ├── ContactService.java
│       │       │   └── AddressBookService.java
│       │       │
│       │       └── AddressBookApplication.java
│       │
│       └── resources/
│           └── application.properties
│
├── pom.xml
└── README.md
```

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/Dheeraj-999/Address_Book.git
   ```

2. Open the project in IntelliJ IDEA.

3. Configure MySQL database credentials in `application.properties`.

4. Make sure the MySQL server is running and the required database is available.

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

6. The application runs at:
   ```text
   http://localhost:8082
   ```

## API Testing

The REST APIs can be tested using **Postman**.

Base URL:

```text
http://localhost:8082
```

## Learning Outcomes

- Understanding Spring Boot application development.
- Building RESTful APIs.
- Performing database operations using Spring Data JPA.
- Implementing DTO and Service Layer architecture.
- Working with Java Collections.
- Managing multiple address books and contacts.
- Handling duplicate contact validation.
- Using Git and GitHub for version control and feature-based development.

## Author

Developed as a step-by-step Java and Spring Boot learning project.