[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7311e2295b464631a12ad3964aebb2fb)](https://www.codacy.com/app/ErickAi/testtask-manytomany?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ErickAi/testtask-manytomany&amp;utm_campaign=Badge_Grade)

Simple Web-application project 
==============================
demonstrates Many-to-Many relations
## Implementation stack:
- PostgreSQL
- Hibernate
- Spring-Boot
- Spring-data-jpa
- Spring-MVC
- Thymeleaf
- Bootstrap
- JQuerry
- Dependency managment - Maven

## Installing

##### Clone this repository
     git clone https://github.com/ErickAi/testtask-manytomany.git

##### Package file (from project directory)
     mvn clean package

##### Prepare DataBase
     create db manytomany (or change db name)
     change uesrname and password in application.properties
        (or use default username:user, password:password)

## Start application
     mvn spring-boot:run
     
##### application url
     http://localhost:8080/    