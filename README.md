# Example Spring-boot Microservice (Maven)
This project is created to understand, how spring-boot(Java) microservice works.
In this project, I provide some example of `api-gateway` and `service` that connect each other.

# Tools in this project
- **Mongo database** for `order-service`
- **MySql database** for `product-service`

# Docker-compose 
In docker compose, I provide service like **Mongo** and **MySql** databases.

# How to run ?

1. Clone repository to Java project

   ```
    git clone https://github.com/Thapakornd/example-spring-boot-microservice
   ```

2. Run each service with this, in terminal
    ```
      ./mvnw spring-boot:run
    ```

# Improvement
- Use some **eureka-netflix**, I forget its name ,but it is tool for monitoring `gateway-api`, I think, it provided more scalibity.
