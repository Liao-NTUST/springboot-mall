package com.liao.mall.controller;

import com.liao.mall.dto.ProductRequest;
import com.liao.mall.model.Product;
import com.liao.mall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;

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

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productid = productService.createProduct(productRequest);

        Product product = productService.getProductById(productid);

                return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id,
                                                 @RequestBody @Valid ProductRequest productRequest) {

        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        productService.updateProduct(id,productRequest);
        Product updateProduct = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }
}
