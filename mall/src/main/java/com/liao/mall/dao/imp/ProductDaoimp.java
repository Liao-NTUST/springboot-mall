package com.liao.mall.dao.imp;

import com.liao.mall.constant.ProductCategory;
import com.liao.mall.dao.ProductDao;
import com.liao.mall.dto.ProductQueryParams;
import com.liao.mall.dto.ProductRequest;
import com.liao.mall.model.Product;
import com.liao.mall.rowmapper.ProductRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoimp implements ProductDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql = "SELECT product_id,product_name,\n" +
                "       category,\n" +
                "       image_url,\n" +
                "       price,\n" +
                "       stock,\n" +
                "       description,\n" +
                "       create_date,\n" +
                "       last_modified_date FROM product WHERE 1=1";
        Map<String,Object> map = new HashMap<>();
        if (productQueryParams.getCategory() != null) {
            sql += " AND category = :category";
            map.put("category", productQueryParams.getCategory().name());
        }
        if (productQueryParams.getSearch() != null) {
            sql += " AND product_name LIKE :search";
            map.put("search", "%"+productQueryParams.getSearch()+"%");
        }
        List<Product> query = namedParameterJdbcTemplate.query(sql, map, new ProductRowmapper());

        return query;
    }

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

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql ="INSERT INTO product(product_name,category,image_url,price,stock,description,create_date,last_modified_date) \n" +
                "VALUES (:productName,:category,:image_url,:price,:stock,:description,:create_date,:last_modified_date)";
        Map<String,Object> map = new HashMap<>();
        map.put("productName",productRequest.getProductName());
        map.put("category",productRequest.getCategory().toString());
        map.put("image_url",productRequest.getImage_url());
        map.put("price",productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());

        Date now = new Date();
        map.put("create_date",now);
        map.put("last_modified_date",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        int productId = keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer id, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name=:product_name, category=:category, image_url=:image_url, price=:price, stock=:stock, description=:description, last_modified_date=:last_modified_date WHERE product_id= :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id); // 修正這裡的 key
        map.put("product_name", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("image_url", productRequest.getImage_url());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        map.put("last_modified_date", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }


    @Override
    public void deleteProductById(Integer id) {
        String sql = "DELETE FROM product WHERE product_id=:id";
        Map<String,Object> map = new HashMap<>();
        map.put("id", id);
        namedParameterJdbcTemplate.update(sql, map);
    }
}
