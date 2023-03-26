# Autify

Autify is a user management web application built with Angular and Spring Boot. It allows you to manage users, roles, and permissions, as well as track user activity and audit logs.

## Getting Started

To run the backend service, follow these steps:

1. Clone the repository: `git clone https://github.com/<username>/<repository>.git`
2. Navigate to the backend directory: `cd autify-backend`
3. Build the project: `mvn clean install`
4. Start the service: `mvn spring-boot:run`

## Database Migration

Autify uses Flyway to manage database schema changes. To run database migrations, use the following command:


## Configuration

Autify is configured to use a MySQL database. The following configuration properties can be set in the `application.yml` file:

```yml
# Database configuration
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/autify
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver

# Flyway configuration
flyway:
  enabled: true
  locations: classpath:db/migration
  baseline-version: 1
  baseline-description: "Baseline version"
  target: latest
  sql-migration-prefix: V
  sql-migration-suffix: .sql
  placeholder-prefix: ${flyway.placeholderPrefix}
  placeholder-suffix: ${flyway.placeholderSuffix}
  placeholders:
    key: value
```
# Contributing
Contributions are always welcome! If you'd like to contribute to Autify, please fork the repository and create a pull request with your changes.
