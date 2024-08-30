package com.app.security.COntroller;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DashboardController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/dashboard")
    public Map<String, String> showDashboard(Principal principal) {
        Map<String, String> response = new HashMap<>();
        Set<String> roles = userDetailsService.loadUserByUsername(principal.getName()).getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        if (roles.contains("ADMIN")) {
            response.put("message", "Welcome Admin to the Dashboard!");
        } else if (roles.contains("USER")) {
            response.put("message", "Welcome User to the Dashboard!");
        } else {
            response.put("message", "Welcome to the Dashboard!");
        }

        return response; // Retourner la réponse sous forme de JSON
    }
}