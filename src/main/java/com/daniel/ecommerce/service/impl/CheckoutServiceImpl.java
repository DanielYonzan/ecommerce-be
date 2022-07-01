package com.daniel.ecommerce.service.impl;

import com.daniel.ecommerce.dao.CustomerRepository;
import com.daniel.ecommerce.dto.Purchase;
import com.daniel.ecommerce.dto.PurchaseResponse;
import com.daniel.ecommerce.entity.Customer;
import com.daniel.ecommerce.entity.Order;
import com.daniel.ecommerce.entity.OrderItem;
import com.daniel.ecommerce.service.CheckoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

/**
 * @author daniel <daniel.tamang@f1soft.com>
 * created on 2022-07-02
 */
@Service
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {


    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems;
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        //For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier

        log.info("random generated UUID, {}", UUID.randomUUID().toString());
        return UUID.randomUUID().toString();

    }
}
