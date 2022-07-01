package com.daniel.ecommerce.dao;

import com.daniel.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author daniel <daniel.tamang@f1soft.com>
 * created on 2022-07-02
 */

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
