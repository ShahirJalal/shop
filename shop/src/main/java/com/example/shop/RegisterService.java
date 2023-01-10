package com.example.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepo repo;

    public User saveUser(User user)
    {
        return repo.save(user);
    }

    public User getuserbyId(String id)
    {
        return repo.findById(id).orElse(null);
    }
}