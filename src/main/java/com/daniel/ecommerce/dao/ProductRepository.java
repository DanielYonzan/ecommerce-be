package com.daniel.ecommerce.dao;

import com.daniel.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author daniel <daniel.tamang@f1soft.com>
 * created on 2022-06-17
 */
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository <Product, Long> {

}
