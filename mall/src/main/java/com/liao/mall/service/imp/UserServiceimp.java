package com.liao.mall.service.imp;

import com.liao.mall.dao.UserDao;
import com.liao.mall.dto.UserRegisterRequest;
import com.liao.mall.model.User;
import com.liao.mall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceimp implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceimp.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if(user!=null){
            log.warn("該email {} 已經被註冊",userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userid) {
        return userDao.getUserById(userid);
    }
}
