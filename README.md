# Employee-Tax-Calculation Application

### Required Tool to Run and Test the Application
1. Spring Boot 3.1.7
2. Java 17
3. MySQL ([DB-Script link](https://github.com/Sudhansu67/finance/blob/master/db-script/sql-schema.sql))
4. STS 4
5. PostMan

<br/>

### List of APIs:

#### 1. Create a new Employee
URL: http://localhost:8081/employee <br/>
Type: POST <br/>
Screenshot: <br/>
![new_employee](https://github.com/Sudhansu67/finance/assets/13377554/9f480174-ab15-4108-b38c-10cea43c87e0)

#### 2. Update an Employee data
URL: http://localhost:8081/employee <br/>
Type: PUT <br/>
Screenshot: <br/>
![update_employee](https://github.com/Sudhansu67/finance/assets/13377554/ee573a16-e840-452c-a5c8-ceffb24e0c69)

#### 3. Get All Employee
URL: http://localhost:8081/employee <br/>
Type: GET <br/>
Screenshot: <br/>
![get_employee](https://github.com/Sudhansu67/finance/assets/13377554/43c3d3da-fb26-4d6a-b39d-fe8f93c0ad60)

#### 4. Get an Employee Tax Calculation
URL: http://localhost:8081/employee/taxCalculation/{empId} <br/>
Type: GET <br/>
Screenshot: <br/>
![employee_tax](https://github.com/Sudhansu67/finance/assets/13377554/fab96d22-b016-4849-837f-ecfbfb7dae0b)

### Input field validation while creating employee:
![validation_employee](https://github.com/Sudhansu67/finance/assets/13377554/cbca71d7-00e4-4763-bb18-43a41cfbc354)

