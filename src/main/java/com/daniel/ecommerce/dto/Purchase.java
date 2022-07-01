package com.daniel.ecommerce.dto;

import com.daniel.ecommerce.entity.Address;
import com.daniel.ecommerce.entity.Customer;
import com.daniel.ecommerce.entity.Order;
import com.daniel.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

/**
 * @author daniel <daniel.tamang@f1soft.com>
 * created on 2022-07-02
 */

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;

}
