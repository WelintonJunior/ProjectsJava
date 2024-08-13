package com.example.demo.service;

import com.example.demo.api.model.Enderecos;
import com.example.demo.api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return enderecoRepository.findById(id).orElse(null);
    }

    public void deleteEnderecoById(int id) {
        enderecoRepository.deleteById(id);
    }

    public Enderecos updateEnderecoById(int id, Enderecos endereco) {
        Optional<Enderecos> existingEndereco = enderecoRepository.findById(id);

        if (existingEndereco.isPresent()) {
            Enderecos updatedEndereco = existingEndereco.get();
            updatedEndereco.setRua(endereco.getRua());
            updatedEndereco.setCidade(endereco.getCidade());
            updatedEndereco.setEstado(endereco.getEstado());
            updatedEndereco.setCep(endereco.getCep());
            return enderecoRepository.save(updatedEndereco);
        } else {
            return null;
        }
    }
}
