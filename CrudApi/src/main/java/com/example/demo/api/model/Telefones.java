package com.example.demo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="telefones")
public class Telefones {
    @Id
    private int id;
    private int usuario_id;
    private String numero_telefone;
}
