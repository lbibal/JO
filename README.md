# Olympic Games 2024

## Access API and Access Documentation

Launch API and then look at the console for instructions:
```shell
Server started at: localhost:8080
Documentation can be found at: localhost:8080/swagger-ui.html
```

## Connect to Database

Add this in `application.properties`

```properties
spring.datasource.jdbc-url=jdbc:postgresql://db-ip:db-port/jo
spring.datasource.username=username
spring.datasource.password=pwd
spring.datasource.oracleucp.database-name=jo
logging.level.org.springframework=ERROR
logging.level.io.app=TRACE
logging.level.com.example.jo.dbtest.DbTestService=DEBUG
logging.level.com.example.jo.dbtest.DbTestController=DEBUG
```

## Test connection to Database
1. Launch API
2. Connect to `localhost:8080/test`
3. Look at the console for the following message: `Successful connection to DB: 1 found row(s)`
