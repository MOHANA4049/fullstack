package com.jobapp.mona.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.UserResponse;
import com.jobapp.mona.model.User;
import com.jobapp.mona.repository.UserRepository;
import com.jobapp.mona.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Basicresponse<UserResponse> getAllUser(){
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream().map(user-> UserResponse.builder()
                      .id(user.getId())
                      .name(user.getName())
                      .email(user.getEmail())
                      .role(user.getRole())
                      .image(user.getImage())
                      .Address(user.getAddress())
                      .PhoneNumber(user.getPhoneNumber())
                      .build())
                      .collect(Collectors.toList());
                      return Basicresponse.<UserResponse>builder()
                               .message("User data fetched Successfully!")
                               .data(userResponses)
                               .build();
        // throw new UnsupportedOperationException("Unimplemented method 'getAllUser'");
    }
    

}
