package com.daniel.ecommerce.service;

import com.daniel.ecommerce.dto.Purchase;
import com.daniel.ecommerce.dto.PurchaseResponse;

/**
 * @author daniel <daniel.tamang@f1soft.com>
 * created on 2022-07-02
 */
public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
