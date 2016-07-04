# springboot-rest-api-mysql-example
Sample showing REST API implementation using Spring Boot and MySql as the backend

## Run 
* `docker pull postgres`
* `docker run -p 5432:5432 -e POSTGRES_PASSWORD=root -d postgres`
* create a database called users
* `mvn clean spring-boot:run`

## Endpoints

### Create user 
`curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"firstname": "noah", "lastname": "ispas", "age": 28}' http://localhost:8989/user`

### Get all user
`curl -X GET http://localhost:8989/user`

### Get user detail 
`curl -X GET http://localhost:8989/user/<id>`

### Update user 
`curl -H "Accept: application/json" -H "Content-type: application/json" -X PUT -d '{"firstname": "noah", "lastname": "ispas", "age": 18}' http://localhost:8989/user/<id>`

### Delete user 
`curl -X DELETE http://localhost:8989/user/<id>`