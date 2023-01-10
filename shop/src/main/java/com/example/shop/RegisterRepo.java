package com.example.shop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<User,String> {
}