# Java Template Backend

The Java Template Application is a Spring Boot-based backend template designed to serve as a foundation for building
robust web applications. This project incorporates various essential features such as security, database management, API
documentation, and more.

## Features

- Spring Boot Integration: Quick setup with Spring Boot, facilitating rapid development.
- Database Management: Uses Spring Data JPA for ORM and Flyway for database migrations.
- Security: Implements Spring Security for securing APIs.
- Validation: Integrated validation support with Spring Boot.
- API Documentation: Automatically generates OpenAPI documentation using Springdoc.
- Environment Configuration: Manages environment variables with Dotenv.
- Logging: Uses Logback for logging.
- Mapping: Utilizes MapStruct for efficient object mapping.
- Testing: Includes Spring Boot and Spring Security testing support.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 21 or later
- PostgreSQL database

## Getting Started

Clone the Repository

```markdown
git clone https://github.com/JonasDias10/java-template.git

cd java-template
```

## Configuration

- Create a PostgreSQL database and update environment variables in .env, if you haven't already just copy .env.example
  and rename it to .env and update the values.

## Dependencies

This project includes several key dependencies:

- Spring Boot: Core framework for building applications.
- Flyway: For managing database migrations.
- Spring Security: For securing the application.
- Springdoc OpenAPI: For API documentation.
- Auth0 Java JWT: For JWT token handling.
- Lombok: For reducing boilerplate code.
- MapStruct: For mapping between Java objects.
- PostgreSQL: Database driver.
- Logback: Logging framework.

## Contributing

Contributions are welcome! Please follow the standards of the project.

- Fork the repository.
- Create your feature branch (git checkout -b feature/YourFeature).
- Commit your changes (git commit -m 'Add some feature').
- Push to the branch (git push origin feature/YourFeature).
- Open a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.