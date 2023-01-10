package com.example.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepo repo;

    public Admin saveAdmin(Admin admin)
    {
        return repo.save(admin);
    }

    public Admin getadminbyId(String id)
    {
        return repo.findById(id).orElse(null);
    }
}