package com.liao.mall.dao;

import com.liao.mall.dto.ProductRequest;
import com.liao.mall.model.Product;

public interface ProductDao {
    Product getProductById(Integer id);

    Integer createProduct(ProductRequest productRequest);
}
