package com.liao.mall.controller;

import com.liao.mall.model.Product;
import com.liao.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Productcontroller {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(Integer id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
