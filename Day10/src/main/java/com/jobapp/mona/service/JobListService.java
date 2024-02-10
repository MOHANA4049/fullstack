package com.jobapp.mona.service;

import com.jobapp.mona.dto.request.JobListRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.JobListResponse;
import com.jobapp.mona.dto.response.RegisterResponse;
public interface JobListService {
     Basicresponse<JobListResponse> getAllJobs();
     RegisterResponse register(JobListRequest request);
}