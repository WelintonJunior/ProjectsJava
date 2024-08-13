package com.example.demo.api.controller;

import com.example.demo.api.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUserBydId(@PathVariable int id, @RequestBody User user) {
        return userService.updateUserBydId(id, user);
    }
}
