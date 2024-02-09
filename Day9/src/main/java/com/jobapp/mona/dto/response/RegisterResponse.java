package com.jobapp.mona.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private String message;
}
//dto is a layer between frontend and backend
//using dto we're getting request and response from backend
//this is allowing security purpose
//No user should directly access the database
