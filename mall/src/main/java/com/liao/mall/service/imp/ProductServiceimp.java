package com.liao.mall.service.imp;

import com.liao.mall.dao.ProductDao;
import com.liao.mall.dto.ProductRequest;
import com.liao.mall.model.Product;
import com.liao.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceimp implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer id) {
        return productDao.getProductById(id);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer id, ProductRequest productRequest) {
        productDao.updateProduct(id,productRequest);
    }
}
