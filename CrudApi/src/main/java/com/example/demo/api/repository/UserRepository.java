package com.example.demo.api.repository;

import com.example.demo.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNome(String nome);
}
