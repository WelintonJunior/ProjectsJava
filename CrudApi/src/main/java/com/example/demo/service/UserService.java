package com.example.demo.service;

import com.example.demo.api.model.User;
import com.example.demo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {return userRepository.findAll();}

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public User updateUserBydId(int id, User user) {
        Optional<User> existingUser = userRepository.findById(id);

        if(existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setNome(user.getNome());
            updatedUser.setIdade(user.getIdade());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setRole(user.getRole());
            return userRepository.save(updatedUser);
        } else {
            return null;
        }
    }
}
