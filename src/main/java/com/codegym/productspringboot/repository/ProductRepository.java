package com.codegym.productspringboot.repository;

import com.codegym.productspringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByPriceBetween(double from, double to);
    List<Product> findByCategory_Id(Long id);

}
