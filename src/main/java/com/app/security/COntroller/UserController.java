package com.app.security.COntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok("Registered Successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        // Simuler une connexion réussie
        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("token", "fake-jwt-token");
        return ResponseEntity.ok(response);
    }
}