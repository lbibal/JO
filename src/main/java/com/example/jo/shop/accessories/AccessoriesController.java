package com.example.jo.shop.accessories;

import com.example.jo.shop.Product;
import com.example.jo.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "shop/accessories")
public class AccessoriesController {

    @Autowired
    private ShopService<AccessoryDto> accessoriesService;

    @GetMapping("/list")
    @ResponseBody
    public List<Product> listAccessories() {
        return accessoriesService.listAvailableProducts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductWithId(@PathVariable("id") String id) {
        return accessoriesService.getProductWithId(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Product addNewAccessory(@RequestBody AccessoryDto newAccessory) {
        return accessoriesService.addNewProduct(newAccessory);
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public Product decreaseProductQty(@PathVariable("id") String id) {
        return accessoriesService.decreaseProductQty(id);
    }
}
