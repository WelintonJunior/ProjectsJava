package com.example.demo.service;

import com.example.demo.api.model.User;
import com.example.demo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

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
            return userRepository.save(updatedUser);
        } else {
            return null;
        }
    }
}
