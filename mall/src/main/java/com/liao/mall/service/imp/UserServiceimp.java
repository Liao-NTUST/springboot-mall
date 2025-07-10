package com.liao.mall.service.imp;

import com.liao.mall.dao.UserDao;
import com.liao.mall.dto.UserRegisterRequest;
import com.liao.mall.model.User;
import com.liao.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceimp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userid) {
        return userDao.getUserById(userid);
    }
}
