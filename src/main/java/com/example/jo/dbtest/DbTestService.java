package com.example.jo.dbtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DbTestService {

    private static final Logger logger = LoggerFactory.getLogger(DbTestService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testDbConnector() {
        String sql = "SELECT COUNT(*) FROM test";
        int res = jdbcTemplate.queryForObject(sql, Integer.class);
        if (res == 1)
            logger.info("Successful connection to DB: " + res + " found row(s)");
        else
            logger.error("Cannot connect to DB");
    }
}
