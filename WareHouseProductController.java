package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.WareHouseProducts;
import com.db.zepto.db_api.repository.WareHouseProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/warehouse/product")
public class WareHouseProductController {

    @Autowired
    WareHouseProductsRepository wareHouseProductsRepository;

    @PostMapping("/save")
    public WareHouseProducts addProduct(@RequestBody WareHouseProducts wareHouseProducts){

        wareHouseProductsRepository.save(wareHouseProducts);
        return wareHouseProducts;
    }

    @GetMapping("/{wid}")
    public List<WareHouseProducts> getAllProductsByWid(@PathVariable UUID wid){
        //repository layer
        return wareHouseProductsRepository.getWareHouseProductsByWid(wid);
    }

    @GetMapping("/{wid}/{pid}")
    public WareHouseProducts  getProductsByWidPid(@PathVariable UUID wid, @PathVariable UUID pid){
        return wareHouseProductsRepository.getProductsByWidPid(wid,pid);
    }
}
