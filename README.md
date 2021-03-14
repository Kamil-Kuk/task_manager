# Task manager
A Spring Boot REST API with CRUD operations

## General info
This is a repository for a simple Spring Boot REST API project which can perform CRUD operations. It is modeled as a task manager that allows the user to assign, update and delete
task for members of a project. Application has a security layer that is role-based - USER is allowed only to GET methods, ADMIN is allowed to all methods

## Technologies
Technologies and frameworks used in this project:
<ul>
        <li>Spring</li>
          <ul>
            <li>Spring-data</li>
            <li>Spring-security</li>
            <li>Spring-mvc</li>
          </ul>
        <li>Hibernate</li>
        <li>REST</li>
        <li>MySQL</li>
    </ul>
    
## Setup
In order to properly run the program follow these steps:
    <ol>
        <li>Make sure you have Java version 11+</li>
        <li>Clone this project to your local directory</li>
        <li>Create database schema named 'task_manager' for your root user</li>
        <li>Set username and password for your SQL account in application.properties file</li>
        <li>Run the program and go to localhost:8080</li>
        <li>Log in using 'admin' or 'user' usernames and 'password' as a password for both roles</li>
    </ol>
