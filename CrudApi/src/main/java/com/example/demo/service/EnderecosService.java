package com.example.demo.service;

import com.example.demo.api.model.Enderecos;
import com.example.demo.api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecosService {
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecosService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Enderecos saveEndereco(Enderecos endereco) {
        return enderecoRepository.save(endereco);
    }

    public Enderecos getEnderecoById(int id) {
        return enderecoRepository.findById(id).get();
    }
}
