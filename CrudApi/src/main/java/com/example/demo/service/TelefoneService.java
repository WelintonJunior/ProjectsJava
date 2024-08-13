package com.example.demo.service;

import com.example.demo.api.model.User;
import com.example.demo.api.repository.TelefoneRepository;
import com.example.demo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelefoneService {
    private final TelefoneRepository telefoneRepository;
    private final UserRepository userRepository;

    @Autowired
    public TelefoneService(TelefoneRepository telefoneRepository, UserRepository userRepository) {
        this.telefoneRepository = telefoneRepository;
        this.userRepository = userRepository;
    }

    public User.Telefones saveTelefone(User.Telefones telefone) {
            return telefoneRepository.save(telefone);
    }

    public User.Telefones getTelefoneById(int id) {
        return telefoneRepository.findById(id).orElse(null);
    }

    public void deleteTelefoneById(int id) { telefoneRepository.deleteById(id); }

    public User.Telefones updateTelefoneById(int id, User.Telefones telefone) {
        Optional<User.Telefones> existingTelefone = telefoneRepository.findById(id);

        if(existingTelefone.isPresent()) {
            User.Telefones updatedTelefone = existingTelefone.get();
            updatedTelefone.setNumero_telefone(telefone.getNumero_telefone());

            if (telefone.getUser() != null && telefone.getUser().getId() > 0) {
                Optional<User> user = userRepository.findById(telefone.getUser().getId());
                if (user.isPresent()) {
                    updatedTelefone.setUser(user.get());
                } else {
                    throw new RuntimeException("User not found");
                }
            }

            return telefoneRepository.save(updatedTelefone);
        } else {
            return null;
        }
    }

}
