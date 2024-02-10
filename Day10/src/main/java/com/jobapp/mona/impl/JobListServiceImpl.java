package com.jobapp.mona.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jobapp.mona.repository.JobListRepository;

import com.jobapp.mona.service.JobListService;
import com.jobapp.mona.dto.request.JobListRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.JobListResponse;
import com.jobapp.mona.dto.response.RegisterResponse;
import com.jobapp.mona.model.JobList;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobListServiceImpl implements JobListService {
  

    private final JobListRepository jobListRepository;
   
    @Override
    public Basicresponse<JobListResponse> getAllJobs() {
        List<JobList> jobs = jobListRepository.findAll();
        List<JobListResponse> JobListResponses = jobs.stream().map(job->JobListResponse.builder()
        .jobId(job.getJobId())
        .jobTitle(job.getJobTitle())
        .jobLocation(job.getJobLocation())
        .jobDescription(job.getJobDescription())
        .DatePosted(job.getDatePosted())
        .Salary(job.getSalary())
        .build())
        .collect(Collectors.toList()); 
        return Basicresponse.<JobListResponse>builder()
        .message("Job data fetched successfully!")
          .data(JobListResponses)
          .build();
        
    }

    @Override
    public RegisterResponse register(JobListRequest request) {
    
        var user=JobList.builder()
        .jobTitle(request.getJobTitle())
        .jobLocation(request.getJobLocation())
        .jobDescription(request.getJobDescription())
        .Salary(request.getSalary())
        .DatePosted(request.getDatePosted())
                .build();
        jobListRepository.save(user);
        // throw new UnsupportedOperationException("Unimplemented method 'register'");
        return RegisterResponse.builder()
        .message("job create successfully!")
        .build();
    }

}

