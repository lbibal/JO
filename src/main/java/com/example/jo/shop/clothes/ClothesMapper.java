package com.example.jo.shop.clothes;

import com.example.jo.shop.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClothesMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product p = new Clothes(
                Integer.parseInt(rs.getString("id")),
                rs.getString("name"),
                Integer.parseInt(rs.getString("price")),
                Integer.parseInt(rs.getString("qty")),
                rs.getString("size")
        );
        return p;
    }
}
