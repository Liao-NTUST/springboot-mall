package com.liao.mall.service;

import com.liao.mall.dto.ProductRequest;
import com.liao.mall.model.Product;

public interface ProductService {
    Product getProductById(Integer id);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer id,ProductRequest productRequest);
}
