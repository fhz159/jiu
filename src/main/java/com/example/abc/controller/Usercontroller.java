package com.example.abc.controller;

import com.example.abc.pojo.User;
import com.example.abc.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Usercontroller {
    @Autowired
    private Userservice userservice;

    @GetMapping("{id}")
    public String getbyid(@PathVariable Integer id){
        User user = userservice.selectbyid(id);
        return user + "";
    }
    @PostMapping
    public  String add(User user){
        userservice.insert(user);
        return "ok";
    }
}
