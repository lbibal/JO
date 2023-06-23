package com.example.jo.shop.clothes;
import com.example.jo.shop.Product;
import com.example.jo.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "shop/clothes")
public class ClothesController {

    @Autowired
    private ShopService<ClothesDto> clothesService;

    @GetMapping("/list")
    @ResponseBody
    public List<Product> listClothes() {
        return clothesService.listAvailableProducts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductWithId(@PathVariable("id") String id) {
        return clothesService.getProductWithId(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Product addNewClothes(@RequestBody ClothesDto newClothes) {
        return clothesService.addNewProduct(newClothes);
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public Product decreaseProductQty(@PathVariable("id") String id) {
        return clothesService.decreaseProductQty(id);
    }
}
