package com.example.demo.api.repository;

import com.example.demo.api.model.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Enderecos, Integer> {
}
