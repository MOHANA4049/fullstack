package com.jobapp.mona.controller;

import static com.jobapp.mona.utils.MyConstant.GETJOB;
import static com.jobapp.mona.utils.MyConstant.Joblist;
import static com.jobapp.mona.utils.MyConstant.REGISTER;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;

// import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.mona.service.JobListService;
import com.jobapp.mona.dto.request.JobListRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.JobListResponse;
import com.jobapp.mona.dto.response.RegisterResponse;
// import com.jobapp.mona.model.JobList;

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
//        @GetMapping("/getjob/{jobTitle}/{jobLocation}")
// public ResponseEntity<List<JobList>> getJobsByJobNameAndLocation(
//         @PathVariable String jobTitle, @PathVariable String jobLocation) {
//     try {
//         List<JobList> jobs = jobListService.getJobsByJobNameAndLocation(jobTitle, jobLocation);
//         return ResponseEntity.ok(jobs);
//     } catch (Exception e) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//     }
// }
     

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
    @PutMapping("/addJob/{jobId}")
        public ResponseEntity<RegisterResponse> editCourse(@PathVariable String jobId, @RequestBody JobListRequest jobRequest) {
            RegisterResponse response = jobListService.editJob(jobId, jobRequest);
            if (response.getMessage().equals("Job updated successfully")) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
            } else if (response.getMessage().equals("Job not found")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
            }
        }
        
}
