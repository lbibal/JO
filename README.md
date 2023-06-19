# Olympic Games 2024

## Connect to Database

Add this in `application.properties`

```properties
spring.datasource.jdbc-url=jdbc:postgresql://185.216.26.43:5432/jo
spring.datasource.username=admin
spring.datasource.password=admin
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