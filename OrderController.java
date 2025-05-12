package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.AppOrder;
import com.db.zepto.db_api.repository.AppOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/v1/db/order")
public class OrderController {

    @Autowired
    AppOrderRepository appOrderRepository;

    Logger logger = Logger.getLogger("Order");

    @PostMapping("/save")
    public AppOrder createOrder(@RequestBody AppOrder order){
        logger.info(order.toString());
        return appOrderRepository.save(order);

    }

    @GetMapping("/{orderId}")
    public AppOrder getOrderById(@PathVariable UUID orderId){
        return appOrderRepository.findById(orderId).orElse(null);
    }

}
