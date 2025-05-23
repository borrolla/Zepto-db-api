package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.WareHouse;
import com.db.zepto.db_api.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/db/warehouse")
public class WareHouseController {

    WareHouseRepository wareHouseRepository;

    @Autowired
    public WareHouseController(WareHouseRepository wareHouseRepository)
    {
        this.wareHouseRepository = wareHouseRepository;
    }
    @GetMapping("/{wareHouseId}")
    public WareHouse getWareHouseById(@PathVariable UUID wareHouseId){
        return wareHouseRepository.findById(wareHouseId).orElse(null);
    }

    @PostMapping("/save")
    public WareHouse createWareHouse(@RequestBody WareHouse wareHouse)
    {
        wareHouseRepository.save(wareHouse);
        return wareHouse;
    }

    @PutMapping("/update")
    public WareHouse updateWareHouse(@RequestBody WareHouse wareHouse){
        wareHouseRepository.save(wareHouse);
        return wareHouse;
    }

    @GetMapping("/pincode/{pincode}")
    public WareHouse getWareHouseByPincode(@PathVariable int pincode){
     return wareHouseRepository.getWareHouseByPincode(pincode);
    }
}
