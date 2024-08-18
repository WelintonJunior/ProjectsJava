package com.example.apiLoja.api.repository;

import com.example.apiLoja.api.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
