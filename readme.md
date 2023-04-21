# Sky-Pharma

This is a sample project that implements a medication delivery system using drones.

## Technologies Used

- Java
- Spring Boot
- Lombok
- H2
- Swagger

## Project Structure

The file and folder structure of the project is as follows:
```
sky-pharma/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── com.skypharma.skypharma/
│ │ │ │ ├── controller/
│ │ │ │ ├── dto/
│ │ │ │ ├── entity/
│ │ │ │ ├── exception/
│ │ │ │ ├── repository/
│ │ │ │ ├── service/
│ │ │ ├── SkyPharmaApplication.java
│ │ ├── resources/
│ │ │ ├── application.properties
│ │ │ ├── data.sql
├── pom.xml
├── README.md
```
## Architecture:

The Sky-Pharma project is built using a layered architecture that separates concerns and promotes modularity, scalability, and maintainability. The project uses Spring Boot as the main framework for developing the REST API and implements the Model-View-Controller (MVC) pattern to handle HTTP requests and responses. The project also utilizes Lombok to reduce boilerplate code and H2 as an in-memory database for persistence. Finally, Swagger is used to document and test the REST API.




## Build, Run, and Test Instructions

To build and run the project, follow these steps:

1. Clone the repository to your local machine.
2. Open a terminal in the root folder of the project.
3. Run the command `mvn clean install` to build and generate the `.jar` file.
4. Run the command `java -jar target/sky-pharma-0.0.1-SNAPSHOT.jar` to start the application.
To test the system, you can use a tool like Postman or Swagger UI to send HTTP requests to the REST API.
5. To view the created endpoints and check their functionality, please go to the following URL to monitor
both the logs and the database tables.
   http://localhost:8080/swagger-ui.html
## Author

- Felipe Buitrago

## License

This project is licensed under the MIT License - see the `LICENSE` file for details.
