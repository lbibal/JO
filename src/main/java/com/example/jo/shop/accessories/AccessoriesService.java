package com.example.jo.shop.accessories;

import com.example.jo.dbtest.DbTestService;
import com.example.jo.shop.ShopService;
import com.example.jo.shop.clothes.Clothes;
import com.example.jo.shop.Product;
import com.example.jo.shop.clothes.ClothesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoriesService implements ShopService<AccessoryDto> {

    private static final Logger logger = LoggerFactory.getLogger(AccessoriesService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> listAvailableProducts() {
        return jdbcTemplate.query("SELECT * FROM accessoire WHERE qty > 0", new AccessoryMapper());
    }

    public Product addNewProduct(AccessoryDto newAccessory) {
        Product newProduct = new Accessory(newAccessory.getName(), newAccessory.getPrice(), newAccessory.getQty(), newAccessory.getSection());
        logger.info("Request sent");
        jdbcTemplate.update(
                "INSERT INTO jo.public.accessoire (name, price, qty, section) VALUES (?, ?, ?, ?)",
                newAccessory.getName(),
                newAccessory.getPrice(),
                newAccessory.getQty(),
                newAccessory.getSection()
        );
        return newProduct;
    }

    @Override
    public Product decreaseProductQty(String productId) {
        Product product = getProductWithId(productId);
        int newQuantity = product.getQty() - 1;
        jdbcTemplate.update("UPDATE accessoire SET qty = ? where id = ?", newQuantity, Integer.parseInt(productId));
        product.setQty(newQuantity);
        return product;
    }

    @Override
    public Product getProductWithId(String id) {
        return jdbcTemplate.query("SELECT * FROM accessoire WHERE id = ?", new AccessoryMapper(), Integer.parseInt(id)).get(0);
    }
}
