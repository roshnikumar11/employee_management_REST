# Employee Management REST API
A comprehensive REST API for managing employee data built using Spring Boot, Spring data JPA and Java.

This project is used to:
- Create new employee records
- Retrieve employee information (single or all employees)
- Update existing employee details
- Delete employee records
- Search employees by their id
- Input validation and error handling
- RESTful API design principles
- JSON response format

### Technologies Used
- Java: Programming language
- Spring Boot: Framework for building REST APIs
- Spring Data JPA: Data persistence layer
- MySQL- Database 
- Maven: Build tool
- Postman: API testing

### Prerequisites
Before running this application, make sure you have:
- Java 8 or higher installed
- Maven 3.6+ installed
- MySQL database (if using MySQL)
- IDE (Eclipse, IntelliJ IDEA, or VS Code)

### Installation
1. *Clone the repository*
   bash
   git clone https://github.com/roshnikumar11/employee_management_REST.git
   cd employee_management_REST
   
2. *Configure Database* (if using MySQL)
   properties
   *In src/main/resources/application.properties*
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   
3. *Build the project*
   bash
   mvn clean install
   
4. *Run the application*
   bash
   mvn spring-boot:run
   
The application will start on http://localhost:(port-number)

### API Endpoints

| Method | Endpoint            | Description         |
|--------|---------------------|---------------------|
| GET    | /api/employees      | Get all employees   |
| GET    | /api/employees/{id} | Get employee by ID  |
| POST   | /api/employees      | Create new employee |
| PUT    | /api/employees/{id} | Update employee     |
| DELETE | /api/employees/{id} | Delete employee     |

### Examples

#### Get All Employees
bash
GET http://localhost:8080/api/employees


#### Create New Employee
bash
POST http://localhost:8080/api/employees
Content-Type: application/json

{
    "name": "John",
    "salary": 50000,
    "age": 25,
    "mobile": 9847213506,
    "role": "IT"
}


#### Update Employee
bash
PUT http://localhost:8080/api/employees/1
Content-Type: application/json

{
    "name": "John",
    "salary": 55000
    "age": 26,
    "mobile": 9568772153,
    "role": "IT"
}


### Database Schema

#### Employee Table
| Column | Type        | Description                  |
|--------|-------------|------------------------------|
| id     | BIGINT      | Primary key (auto-generated) |
| name   | VARCHAR(50) | Employee's name              |
| salary | DECIMAL     | Employee's salary            |
| age    | INTEGER     | Employee's age               |
| mobile | BIGINT      | Employee's phone number      |
| role   | VARCHAR(50) | Employee's job role          |

### Testing
Run the tests using:
bash
mvn test

You can also test the API using:
- Postman
- curl commands

### Author

*Roshni N Kumar* - [GitHub](https://github.com/roshnikumar11)

### Support

If you have any questions or issues, please open an issue on GitHub or contact me at [roshnikumar749@gmail.com].

---
