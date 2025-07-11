package com.liao.mall.controller;

import com.liao.mall.dto.UserRegisterRequest;
import com.liao.mall.dto.Userloginrequest;
import com.liao.mall.model.User;
import com.liao.mall.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        Integer userid = userService.register(userRegisterRequest);
        User user = userService.getUserById(userid);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @PostMapping("/user/login")
    public ResponseEntity<User> login(@RequestBody @Valid Userloginrequest userloginrequest) {
        User user = userService.login(userloginrequest);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
