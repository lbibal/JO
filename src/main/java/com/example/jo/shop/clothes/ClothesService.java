package com.example.jo.shop.clothes;

import com.example.jo.shop.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService implements ShopService<ClothesDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Product addNewProduct(ClothesDto newClothes) {
        Product newProduct = new Clothes(newClothes.getModelName(), newClothes.getPrice(), newClothes.getQty(), newClothes.getSize());
        jdbcTemplate.update(
                "INSERT INTO jo.public.vetement (name, price, qty, size) VALUES (?, ?, ?, ?)",
                newClothes.getModelName(),
                newClothes.getPrice(),
                newClothes.getQty(),
                newClothes.getSize()
        );
        return newProduct;
    }

    @Override
    public Product decreaseProductQty(String productId) {
        Product product = getProductWithId(productId);
        if (product.getQty() == 0)
            return product;

        int newQuantity = product.getQty() - 1;
        jdbcTemplate.update("UPDATE vetement SET qty = ? where id = ?", newQuantity, Integer.parseInt(productId));
        product.setQty(newQuantity);
        return product;
    }

    @Override
    public List<Product> listAvailableProducts() {
        return jdbcTemplate.query("SELECT * FROM vetement WHERE qty > 0", new ClothesMapper());
    }

    @Override
    public Product getProductWithId(String id) {
        return jdbcTemplate.query("SELECT * FROM vetement WHERE id = ?", new ClothesMapper(), Integer.parseInt(id)).get(0);
    }
}
