package com.jobapp.mona.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jobapp.mona.repository.UserRepository;
import com.jobapp.mona.enumerated.Role;
import com.jobapp.mona.model.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
// @SuppressWarnings("null")
public class UserCLI implements CommandLineRunner{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
       if(userRepository.count() > 0)
          return;
       var user = User.builder()
           .name("Admin")
           .email("admin@123")
           .password(passwordEncoder.encode("Admin@123"))
           .role(Role.ADMIN)
           .build();
        userRepository.save(user);
    }
    
}