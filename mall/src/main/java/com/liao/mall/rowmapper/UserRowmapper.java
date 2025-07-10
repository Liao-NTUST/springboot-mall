package com.liao.mall.rowmapper;

import com.liao.mall.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowmapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setUserid(rs.getInt("user_id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCreate_date(rs.getTimestamp("create_date"));
        user.setLast_modified_date(rs.getTimestamp("last_modified_date"));

        return user;
    }
}
