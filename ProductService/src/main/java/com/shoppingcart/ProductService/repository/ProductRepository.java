package com.shoppingcart.ProductService.repository;

import com.shoppingcart.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
