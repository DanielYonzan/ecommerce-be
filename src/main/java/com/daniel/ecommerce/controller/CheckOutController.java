package com.daniel.ecommerce.controller;

import com.daniel.ecommerce.dto.Purchase;
import com.daniel.ecommerce.dto.PurchaseResponse;
import com.daniel.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author daniel <daniel.tamang@f1soft.com>
 * created on 2022-07-02
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/checkout")
public class CheckOutController {

    private CheckoutService checkoutService;

    @Autowired
    public CheckOutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
