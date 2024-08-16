package com.example.demo.api.controller;

import com.example.demo.api.infra.security.TokenService;
import com.example.demo.api.model.*;
import com.example.demo.api.model.dtos.AuthenticationDTO;
import com.example.demo.api.model.dtos.LoginResponseDTO;
import com.example.demo.api.model.dtos.RefreshTokenRequestDTO;
import com.example.demo.api.model.dtos.RegisterDTO;
import com.example.demo.api.repository.UserRepository;
import com.example.demo.service.RefreshTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        logger.info("Login request received for username: {}", data.nome());

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.nome(), data.password());

        try {
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) auth.getPrincipal());
            var refreshToken = refreshTokenService.createRefreshToken(data.nome());

            logger.info("Authentication successful for username: {}", data.nome());
            logger.info("Generated JWT token: {}", token);
            logger.info("Generated Refresh token: {}", refreshToken.getToken());

            LoginResponseDTO response = new LoginResponseDTO(token, refreshToken.getToken());
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            logger.error("Authentication failed for username: {}", data.nome(), e);
            return ResponseEntity.status(401).body("Authentication failed");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO data) {
        logger.info("Register request received for username: {}", data.nome());

        if (this.userRepository.findByNome(data.nome()) != null) {
            logger.warn("User already exists with username: {}", data.nome());
            return ResponseEntity.badRequest().body("User already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.id(), data.nome(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        logger.info("User registered successfully with username: {}", data.nome());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO) {
        logger.info("Refresh token request received with token: {}", refreshTokenRequestDTO.token());

        String requestToken = refreshTokenRequestDTO.token();
        Optional<RefreshToken> refreshTokenOpt = refreshTokenService.findByToken(requestToken);

        if (refreshTokenOpt.isPresent()) {
            RefreshToken refreshToken = refreshTokenService.verifyExpiration(refreshTokenOpt.get());

            String newToken = tokenService.generateToken(refreshToken.getUser());

            logger.info("Refresh token valid. New JWT token generated: {}", newToken);

            return ResponseEntity.ok(new LoginResponseDTO(newToken, ""));
        } else {
            logger.warn("Invalid refresh token: {}", requestToken);
            return ResponseEntity.status(403).body("Refresh token is invalid!");
        }
    }
}
