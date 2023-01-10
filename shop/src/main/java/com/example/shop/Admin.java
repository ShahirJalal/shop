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
@Table(name = "shopAdmin")
public class Admin {

    @Id
    private String adminId;

    private String adminEmail;

    private String adminGender;

    private String adminPosition;
    private String adminPassword;

    @Transient
    private String adminPassword2;
}