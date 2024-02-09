package com.jobapp.mona.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Getting response from backend to the frontend
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String message;//ex.Login successfull login mismatched details from the backend which is stored in message.

}