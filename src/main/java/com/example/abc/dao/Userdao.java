package com.example.abc.dao;

import com.example.abc.pojo.User;

import java.util.List;

public interface Userdao {


    User selectbyid(Integer id);

    void insert(User user);
}
