-----------------------------------------------------------------Task Management Project------------------------------------------------------------------------------------

The TaskManager API is a simple RESTful API built using Java Spring Boot for managing tasks. It allows users to create, retrieve, update, and delete tasks and users. 
The application uses MysqlSQL as its backend database.

Features
CRUD operations for Tasks: Create, Read, Update, and Delete tasks.
User Management: Add, update, and delete users.
Timezone Support: Handle tasks with different timezones and store dates in UTC.
Data Validation: Ensure required fields are filled and valid values are provided.
Error Handling: Return appropriate HTTP status codes and messages for errors.

Prerequisites
Java 17 or higher
Maven 3.6.3 or higher
Mysql Workbench

Setting Up the MySQL Database
Install MysqlSQL:

Create a Database: manually from Mysql Workbench with the command;
CREATE DATABASE taskmanager;

 or 
 
 In application.properties file you can use this property: spring.datasource.url=jdbc:mysql://localhost:3306/task-management?createDatabaseIfNotExist=true
 
 it will create the database task-management if it does not exists in your database.

 Clone the Repository:
If you haven’t already cloned the repository, clone it using Git:

git clone command

After cloning change directory to Task-Management

cd Task-Management

Configure Application Properties:

Open src/main/resources/application.properties and configure the database connection properties:

1.spring.datasource.url=jdbc:mysql://localhost:3306/task-management?createDatabaseIfNotExist=true

2.spring.datasource.username=root

3.spring.datasource.password=your Mysql workbench password

4.spring.jpa.hibernate.ddl-auto=update //it persists the data even after you close the application

5.spring.jpa.show-sql=true  // shows what sql queries are triggerd when application starts.

API Endpoints :
Task Endpoints

Create Task: POST localhost:/api/tasks

Get All Tasks: GET /api/tasks

Get Task by ID: GET /api/tasks/{id}

Update Task: PUT /api/tasks/{id}

Delete Task: DELETE /api/tasks/{id}

User Endpoints

Create User: POST /api/users

Update User: PUT /api/users/{id}

Delete User: DELETE /api/users/{id}


Assumptions

Tasks have many to one Relationship with users as a single user can have multiple tasks.

Timezone Handling: Tasks are stored in UTC, but the API allows for timezone conversion during task creation and updates.

Database Timezone: PostgreSQL is configured to store timestamps in UTC.

Validation: The title field in tasks is mandatory, and the status field only accepts specific values (PENDING, IN_PROGRESS, COMPLETED).

Error Handling: Custom exception handling is in place for scenarios like "Task not found" or "Validation errors".

 
