package com.liao.mall.dao;

import com.liao.mall.dto.UserRegisterRequest;
import com.liao.mall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userid);
}
