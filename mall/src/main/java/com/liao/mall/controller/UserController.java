package com.liao.mall.controller;

import com.liao.mall.dto.UserRegisterRequest;
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
}
