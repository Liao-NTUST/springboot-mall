package com.liao.mall.service;

import com.liao.mall.dto.UserRegisterRequest;
import com.liao.mall.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userid);
}
