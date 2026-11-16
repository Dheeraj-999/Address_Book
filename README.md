# Address_Book
## UC6 – Prevent Duplicate Contacts

### What I Did
- Implemented duplicate contact validation.
- Prevented adding the same person more than once in an Address Book.
- Added case-insensitive name checking.
- Allowed the same person to be added to different Address Books.
- Used Java Stream API and `anyMatch()` to check duplicate contacts.
- Returned HTTP 409 Conflict when a duplicate contact is added.

### What I Learned
- Working with Java Streams.
- Using `anyMatch()` for searching collections.
- Implementing duplicate validation.
- Handling HTTP status codes in Spring Boot.

### Issues Faced
- Address Books were cleared after restarting the application because data is stored in memory.
- Recreated Address Books for testing.

### Technologies Used
- Java 21
- Spring Boot
- REST API
- Java Collections
- Maven
- Postman
