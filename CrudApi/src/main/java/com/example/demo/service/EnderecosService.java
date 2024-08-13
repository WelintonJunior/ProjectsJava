package com.example.demo.service;

import com.example.demo.api.model.User;
import com.example.demo.api.repository.EnderecoRepository;
import com.example.demo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecosService {
    private final EnderecoRepository enderecoRepository;
    private final UserRepository userRepository;

    @Autowired
    public EnderecosService(EnderecoRepository enderecoRepository, UserRepository userRepository) {
        this.enderecoRepository = enderecoRepository;
        this.userRepository = userRepository;
    }

    public User.Enderecos saveEndereco(User.Enderecos endereco) {
        return enderecoRepository.save(endereco);
    }

    public User.Enderecos getEnderecoById(int id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public void deleteEnderecoById(int id) {
        enderecoRepository.deleteById(id);
    }

    public User.Enderecos updateEnderecoById(int id, User.Enderecos endereco) {
        Optional<User.Enderecos> existingEndereco = enderecoRepository.findById(id);

        if (existingEndereco.isPresent()) {
            User.Enderecos updatedEndereco = existingEndereco.get();
            updatedEndereco.setRua(endereco.getRua());
            updatedEndereco.setCidade(endereco.getCidade());
            updatedEndereco.setEstado(endereco.getEstado());
            updatedEndereco.setCep(endereco.getCep());

            if (endereco.getUser() != null && endereco.getUser().getId() > 0) {
                Optional<User> user = userRepository.findById(endereco.getUser().getId());
                if (user.isPresent()) {
                    updatedEndereco.setUser(user.get());
                } else {
                    throw new RuntimeException("User not found");
                }
            }
            return enderecoRepository.save(updatedEndereco);
        } else {
            return null;
        }
    }
}
