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
# Setup Instructions
## Prerequisites
 - Docker
 - Docker Compose
## Steps
1. Clone the repository to your local machine.
2. Navigate to the root directory of the cloned repository.
3. Create a new file named .env in the root directory of the project and set the following environment variables:
    ```text
    DB_HOST=database
    DB_PORT=3306
    DB_NAME=autifydb
    DB_USER=autifyuser
    DB_PASSWORD=password
    ```
4. Run the following command in your terminal to build the Docker images and start the containers:<br>
`docker-compose up --build`
5. Wait for the containers to start up and the application to be deployed. 
6. Access the application at http://localhost:8090
7. To stop the application and remove the containers, run the following command:<br>
   `docker-compose down`
# Database schema
1. `user`: Stores information about each user, such as their username, email address, and password (hashed for security).
2. `role`: Defines different user roles, such as "admin," "manager," and "user," each with different levels of access to different parts of your application.
3. `permission`: Defines specific permissions that can be assigned to different roles, such as "create user," "delete user," and "view user information."
4. `session`: Stores information about each user's current session, including their session ID, login time, and IP address.
5. `audit`: Keeps track of changes made to user data, including who made the change and when.
6. `password_reset`: Stores information about password reset requests, including the user's email address, the reset code, and when the request was made.
7. `refresh_token`: Stores information about refresh tokens, including the token itself, the associated user ID, and the expiration time.
## Role description
**SUPER ADMIN:** This role has the highest level of permissions and can perform all actions in the application, including creating, editing, and deleting other users, roles, and permissions.

**ADMIN:** This role has elevated permissions and can perform most actions in the application, except for creating or editing users with higher roles. They can manage users with lower roles, roles, and permissions.

**MANAGER:** This role can manage lower-level users and their data. They can view, edit, and delete users with lower roles.

**USER:** This is the standard role for regular users of the application. They have limited permissions and can only view and edit their own data.
## Migration changelog
1. **04/28/2023** - `V1679803433__create_user_table.sql`: contains the script to create the user table, which is required for issues 1, 2, 3, and 4.
2. **05/02/2023** - `V1683034012__Create_role_table.sql`: contains the script to create the permission table, which is required for issues 5, 6, 7, 8, 9, and 10.
3. **05/07/2023** - `V1683424141__Create_permission_table.sql`, `V1683424329__Create_role_permission_composite_table.sql`: contains the script to create the permission and role_permission tables, which is required for issues 5, 6, 7, 8, 9, and 10.
4. **05/14/2023** - `V1684036191__create_session_table.sql`: contains the script to create the session table, which is required for issues 12, 13, and 14.
5. `V5__create_audit_table.sql`: contains the script to create the audit table, which is required for issues 15 and 16.
6. `V6__create_password_reset_table.sql`: contains the script to create the password_reset table, which is required for issues 17 and 18.
7. `V7__create_refresh_token_table.sql`: contains the script to create the refresh_token table, which is required for issues 21 and 22.
# Contributing
Contributions are always welcome! If you'd like to contribute to Autify, please fork the repository and create a pull request with your changes.
