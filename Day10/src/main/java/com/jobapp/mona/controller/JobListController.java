package com.jobapp.mona.controller;

import static com.jobapp.mona.utils.MyConstant.GETJOB;
import static com.jobapp.mona.utils.MyConstant.Joblist;
import static com.jobapp.mona.utils.MyConstant.REGISTER;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.mona.service.JobListService;
import com.jobapp.mona.dto.request.JobListRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.JobListResponse;
import com.jobapp.mona.dto.response.RegisterResponse;

import lombok.RequiredArgsConstructor;

@RequestMapping(Joblist)
@RestController
@RequiredArgsConstructor
public class JobListController {
  private final  JobListService jobListService;
     @GetMapping(GETJOB)
       public ResponseEntity<Basicresponse<JobListResponse>> create() {
        Basicresponse<JobListResponse> response=new Basicresponse<>();


           try {
               response=jobListService.getAllJobs();
               return new ResponseEntity<>(response,OK);
           } catch (Exception e) {
               response.setMessage("Something went wrong!");
               return new ResponseEntity<>(response, EXPECTATION_FAILED);
           }
       }

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponse>register(@RequestBody JobListRequest request)
    {
        RegisterResponse response=new RegisterResponse();
        try{
            response=jobListService.register(request);
            return new ResponseEntity<>(response,ACCEPTED);
        }catch (Exception e)
        {
            System.out.println(e);
            response.setMessage("Something went wrong!");
            return new ResponseEntity<>(response,EXPECTATION_FAILED);
        }
    }
   
}
