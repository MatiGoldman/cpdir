# Check Point Dir - Test Assignment

### Prerequisites

**Disclaimer**
> The current development has only been tested on Ubuntu 20.04.
> It should work on other platforms, anyways.

#### Locally
1) Install the JDK and JRE: `sudo apt-get install openjdk-11-jre openjdk-11-jdk`. In this case I used version 11.

2) Install Maven: `sudo apt install maven`

3) Install MySQL: `sudo apt-get install mysql-server`

#### Container

1) Install docker, please follow the official guidelines: https://docs.docker.com/engine/install/ubuntu/

## How to install it

#### Locally
1) Clone the repository to your machine:
` git clone https://github.com/MatiGoldman/cpdir.git`

2) Open your IDE of preference

3) In the *application.properties* file, change the following line:
`jdbc:mysql://mysqldb:3306/cpdir?allowPublicKeyRetrieval=true&useSSL=false` replacing *mysqldb* for *localhost*

4) Run the project.

#### Generate your Container using Docker-compose
1) Run Maven to generate the .jar file: `mvn install -DskipTests`

2) Run the `sudo docker-compose up` command in the project root folder.

## How to test it

You can test it using cURL commands on a shell or via Postman.

The following APIs are available:
- /addEmployee
- /getEmployees
- /getEmployeeById/{id}
- /deleteEmployeeById/{id}
- /updateEmployee

#### Shell
Example:
```
curl --location --request POST 'http://IP:8080/addEmployee' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Test",
    "lastName": "Test",
    "teamName": "team name",
    "positionName": "Data Analyst Intern",
    "managerId": 5,
    "phone": 34234
}'
```

#### Postman

You only need to put the URL: http://IP:8080/API and make the relevant request. 
