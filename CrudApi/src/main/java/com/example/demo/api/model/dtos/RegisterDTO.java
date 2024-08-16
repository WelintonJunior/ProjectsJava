package com.example.demo.api.model.dtos;

import com.example.demo.api.model.UserRole;

public record RegisterDTO(int id, String nome, String password, UserRole role) {
}
