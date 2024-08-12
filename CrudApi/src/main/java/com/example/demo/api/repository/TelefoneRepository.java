package com.example.demo.api.repository;

import com.example.demo.api.model.Telefones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefones, Integer> {
}
