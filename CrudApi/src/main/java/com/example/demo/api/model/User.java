package com.example.demo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    private int id;
    private String nome;
    private int idade;
}

