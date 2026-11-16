# Address_Book
## UC5 – Multiple Address Books

### What I Did
- Created support for multiple Address Books.
- Each Address Book has a unique name.
- Used a Map to store Address Books with their names as keys.
- Added REST APIs to create and retrieve Address Books.
- Updated contact management to store contacts separately in each Address Book.
- Tested the APIs using Postman.

### What I Learned
- Working with Java Map collections.
- Managing multiple objects using a unique key.
- Connecting Spring Boot controllers with service classes.
- Handling REST API requests and responses.

### Issues Faced
- Address Books were cleared whenever the application restarted because data was stored in memory.
- Fixed the issue during testing by recreating the Address Books after restarting the application.

### Technologies Used
- Java 21
- Spring Boot
- REST API
- Maven
- Postman
