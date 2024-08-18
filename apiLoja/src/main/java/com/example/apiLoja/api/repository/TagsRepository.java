package com.example.apiLoja.api.repository;

import com.example.apiLoja.api.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Long> {
}
