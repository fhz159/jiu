package com.example.abc.service;

import com.example.abc.dao.Userdao;
import com.example.abc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice implements Userdao{
    @Autowired
    private Userdao userdao;


    @Override
    public User selectbyid(Integer id) {
        return userdao.selectbyid(id);
    }

    @Override
    public void insert(User user) {
          userdao.insert(user);
    }
}
