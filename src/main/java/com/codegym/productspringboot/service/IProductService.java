package com.codegym.productspringboot.service;

import com.codegym.productspringboot.model.Product;

import java.util.List;

public interface IProductService extends IGenerateService<Product> {
    List<Product> findByNameContaining(String name);
    List<Product> findByCategory_Id(Long id);
}
