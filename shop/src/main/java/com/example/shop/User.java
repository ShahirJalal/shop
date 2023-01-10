package com.example.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shopUser")
public class User {

    @Id
    private String userId;

    private String email;

    private String gender;

    private String position;
    private String password;

    @Transient
    private String password2;
}