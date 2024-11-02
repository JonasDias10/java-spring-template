# Java Spring Template Backend

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

## API Documentation

- The API documentation can be found at http://localhost:8080/swagger-ui/index.html

## Spotless Linting

- Spotless linting is enabled by default.
- To run spotless, run `./gradlew spotlessCheck`
- To fix spotless, run `./gradlew spotlessApply`

### IntelliJ JRE Config

First install the google-java-format plugin. After that, restart the IDE.
The google-java-format plugin uses some internal classes that aren't available without extra configuration. To use the
plugin, you need to add some options to your IDE's Java runtime. To do that, go to Help→Edit Custom VM Options... and
paste in these lines:

````
--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED
````

Once you've done that, restart the IDE.

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