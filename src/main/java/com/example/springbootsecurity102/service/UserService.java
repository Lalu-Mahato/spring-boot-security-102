package com.example.springbootsecurity102.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springbootsecurity102.entity.User;
import com.example.springbootsecurity102.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUser(int id) {
        Optional<User> userInfo = userRepository.findById(id);
        if (userInfo.isPresent()) {
            return userInfo.get();
        }

        throw new RuntimeException("User details not found for id " + id);
    }

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
