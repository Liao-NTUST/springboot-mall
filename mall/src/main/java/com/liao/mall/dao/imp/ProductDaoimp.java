package com.liao.mall.dao.imp;

import com.liao.mall.dao.ProductDao;
import com.liao.mall.model.Product;
import com.liao.mall.rowmapper.ProductRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoimp implements ProductDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Product getProductById(Integer id) {
        String sql = "SELECT product_id,product_name,\n" +
                "       category,\n" +
                "       image_url,\n" +
                "       price,\n" +
                "       stock,\n" +
                "       description,\n" +
                "       create_date,\n" +
                "       last_modified_date FROM product WHERE product_id =:id";
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        List<Product> query = namedParameterJdbcTemplate.query(sql, map, new ProductRowmapper());
        if (query.size()>0){
            return query.get(0);
        }else {
            return null;
        }
    }
}
