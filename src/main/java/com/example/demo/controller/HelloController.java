package com.example.demo.controller;

import com.example.demo.domain.StatusRet;
import com.example.demo.domain.User;
import com.example.demo.util.StatusMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
    @GetMapping("/")
    public Object index(){
        User user = new User();
        user.setBirth(new Date());
        user.setName("zsq");
        user.setSex(1);
        try {
            Integer i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return user;
    }

    @GetMapping("/user_error")
    public Object testError(){
        return "3001";
    }
}
