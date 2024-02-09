package com.jobapp.mona.service;

import com.jobapp.mona.dto.request.LoginRequest;
import com.jobapp.mona.dto.request.RegisterRequest;
import com.jobapp.mona.dto.response.LoginResponse;
import com.jobapp.mona.dto.response.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}
