package com.codegym.productspringboot.controller;

import com.codegym.productspringboot.model.Product;
import com.codegym.productspringboot.service.ICategoryService;
import com.codegym.productspringboot.service.IProductService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productSer;
    @Autowired
    private ICategoryService categorySer;
    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> list = productSer.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Product product){
        productSer.save(product);
        String message="Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        productSer.save(product);
        String message="Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        productSer.remove(id);
        String message="Delete success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productSer.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@Param("name")String name){
        List<Product> list = productSer.findByNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
