package com.liao.mall.service;

import com.liao.mall.constant.ProductCategory;
import com.liao.mall.dto.ProductQueryParams;
import com.liao.mall.dto.ProductRequest;
import com.liao.mall.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer id);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer id,ProductRequest productRequest);

    void deleteProductById(Integer id);

    Integer countProduct(ProductQueryParams productQueryParams);
}
