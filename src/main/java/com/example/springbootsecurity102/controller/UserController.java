package com.example.springbootsecurity102.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootsecurity102.entity.User;
import com.example.springbootsecurity102.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/isRunning")
    public String isRunning() {
        return "Service is running";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.addUser(user);
    }

    // @GetMapping("/getAllUsers")
    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    // public List<UserInfo> getAllUsers() {
    // return service.getAllUsers();
    // }

    // @GetMapping("/{id}")
    // @PreAuthorize("hasAuthority('ROLE_USER')")
    // public UserInfo getUserById(@PathVariable int id) {
    // return service.getUser(id);
    // }

    // @PostMapping("/getToken")
    // public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
    // Authentication authentication = authenticationManager.authenticate(
    // new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
    // authRequest.getPassword()));

    // if (authentication.isAuthenticated()) {
    // return jwtService.generateToken(authRequest.getUsername());
    // }

    // throw new UsernameNotFoundException("invalid user details.");
    // }

}
