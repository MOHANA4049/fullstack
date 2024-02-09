package com.jobapp.mona.service;

import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.UserResponse;

public interface UserService {

    Basicresponse<UserResponse> getAllUser();

}