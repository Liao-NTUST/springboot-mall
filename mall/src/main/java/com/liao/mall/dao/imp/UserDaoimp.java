package com.liao.mall.dao.imp;

import com.liao.mall.dao.UserDao;
import com.liao.mall.dto.UserRegisterRequest;
import com.liao.mall.model.Product;
import com.liao.mall.model.User;
import com.liao.mall.rowmapper.ProductRowmapper;
import com.liao.mall.rowmapper.UserRowmapper;
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
public class UserDaoimp implements UserDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {
        String sql = "INSERT INTO user(email,password,create_date,last_modified_date) " +
                "VALUES (:email,:password,:create_date,:last_modified_date)";
        Map<String, Object> map = new HashMap<>();
        map.put("email", userRegisterRequest.getEmail());
        map.put("password", userRegisterRequest.getPassword());

        Date now = new Date();
        map.put("create_date", now);
        map.put("last_modified_date", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int userid = keyHolder.getKey().intValue();
        return userid;
    }

    @Override
    public User getUserById(Integer userid) {
        String sql = "SELECT user_id,email,\n" +
                "       password,\n" +
                "       create_date,\n" +
                "       last_modified_date FROM user WHERE user_id =:userid";
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userid);
        List<User> query = namedParameterJdbcTemplate.query(sql, map, new UserRowmapper());
        if (query.size()>0){
            return query.get(0);
        }else {
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT user_id,email,\n" +
                "       password,\n" +
                "       create_date,\n" +
                "       last_modified_date FROM user WHERE email =:email";
        Map<String,Object> map = new HashMap<>();
        map.put("email",email);
        List<User> query = namedParameterJdbcTemplate.query(sql, map, new UserRowmapper());
        if (query.size()>0){
            return query.get(0);
        }else {
            return null;
        }
    }
}
