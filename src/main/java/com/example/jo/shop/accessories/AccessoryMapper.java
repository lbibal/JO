package com.example.jo.shop.accessories;

import com.example.jo.shop.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessoryMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product p = new Accessory(
                Integer.parseInt(rs.getString("id")),
                rs.getString("name"),
                Integer.parseInt(rs.getString("price")),
                Integer.parseInt(rs.getString("qty")),
                rs.getString("section")
        );
        return p;
    }
}
