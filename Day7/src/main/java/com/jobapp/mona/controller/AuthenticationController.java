package com.jobapp.mona.controller;

import static com.jobapp.mona.utils.MyConstant.AUTH;
import static com.jobapp.mona.utils.MyConstant.LOGIN;
import static com.jobapp.mona.utils.MyConstant.REGISTER;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.mona.dto.request.LoginRequest;
import com.jobapp.mona.dto.request.RegisterRequest;
import com.jobapp.mona.dto.response.LoginResponse;
import com.jobapp.mona.dto.response.RegisterResponse;
import com.jobapp.mona.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
//MyConstant.AUTH
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponse>register(@RequestBody RegisterRequest request)
    {
        RegisterResponse response=new RegisterResponse();
        try{
            response=authenticationService.register(request);
            //HttpStatus.ACCEPTED
            return new ResponseEntity<>(response,ACCEPTED);
        }
        catch(Exception e){
            response.setMessage("Something went wrong.");
            //HTTPStatus.EXPECTATION_FAILED;
            return new ResponseEntity<>(response,EXPECTATION_FAILED);
        }
    }
    //MyConstant.LOGIN
    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponse>login(@RequestBody LoginRequest request)
    {
        LoginResponse response=new LoginResponse();
        try{
            response=authenticationService.login(request);
            return new ResponseEntity<>(response,ACCEPTED);
        }
        catch(Exception e)
        {
            System.out.println(e);
            response.setMessage("Something went wrong!");
            response.setToken("");
            return new ResponseEntity<>(response,EXPECTATION_FAILED);
        }
    }
}
