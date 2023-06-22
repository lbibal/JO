package com.example.jo.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.example.jo.Controller.Athlete;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@SpringBootApplication
@RestController
public class AthleteController {
    private static final String JDBC_URL = "jdbc:postgresql://185.216.26.43:5432/jo";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    //private static final String COLUMN_NAME = "name";

    @GetMapping("/testee")
    public List<String> retrieveColumnValues(@RequestParam int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Athlete athlete = null;
        List<String> a=new ArrayList<>();

        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM athletes WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int athleteId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                int age = resultSet.getInt("age");
                int height = resultSet.getInt("height");
                String team = resultSet.getString("team");
                String sport = resultSet.getString("sport");


                String strID = Integer.toString(athleteId);
                String strAge = Integer.toString(age);
                String strHeight = Integer.toString(height);
                a.add(strID);
                a.add(name);
                a.add(sex);
                a.add(strAge);
                a.add(strHeight);
                a.add(team);
                a.add(sport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(resultSet, statement, connection);
        }

        return a;
    }
    private void closeResources(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
