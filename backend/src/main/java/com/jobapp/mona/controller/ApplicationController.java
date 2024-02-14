package com.jobapp.mona.controller;
import static com.jobapp.mona.utils.MyConstant.Applicationlist;
import static com.jobapp.mona.utils.MyConstant.GetApplication;
import static com.jobapp.mona.utils.MyConstant.postApplication;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.mona.service.ApplicationService;
import com.jobapp.mona.dto.request.ApplicationRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.ApplicationResponse;
import com.jobapp.mona.dto.response.RegisterResponse;

import lombok.RequiredArgsConstructor;

@RequestMapping(Applicationlist)
@RestController
@RequiredArgsConstructor
public class ApplicationController {
  private final  ApplicationService applicationService;
     @GetMapping(GetApplication)
       public ResponseEntity<Basicresponse<ApplicationResponse>> create() {
        Basicresponse<ApplicationResponse> response=new Basicresponse<>();
           try {
               response=applicationService.getAllApplications();
               return new ResponseEntity<>(response,OK);
           } catch (Exception e) {
               response.setMessage("Something went wrong!");
               return new ResponseEntity<>(response, EXPECTATION_FAILED);
           }
       }

    @PostMapping(postApplication)
    public ResponseEntity<RegisterResponse>register(@RequestBody ApplicationRequest request)
    {
        RegisterResponse response=new RegisterResponse();
        try{
            response=applicationService.register(request);
            return new ResponseEntity<>(response,ACCEPTED);
        }catch (Exception e)
        {
            System.out.println(e);
            response.setMessage("Something went wrong!");
            return new ResponseEntity<>(response,EXPECTATION_FAILED);
        }
    }   
    
    @DeleteMapping("/deleteApplication/{applicationId}")
    public ResponseEntity<RegisterResponse> deleteCourse(@PathVariable String applicationId) {
        RegisterResponse response = applicationService.deleteApplication(applicationId);
        if (response.getMessage().equals("Application deleted successfully")) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else if (response.getMessage().equals("Application not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }
    }  
    
}
