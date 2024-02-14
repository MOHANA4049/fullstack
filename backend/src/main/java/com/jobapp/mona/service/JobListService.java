package com.jobapp.mona.service;

// import java.util.List;

import com.jobapp.mona.dto.request.JobListRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.JobListResponse;
import com.jobapp.mona.dto.response.RegisterResponse;
// import com.jobapp.mona.model.JobList;
public interface JobListService {
     Basicresponse<JobListResponse> getAllJobs();
     RegisterResponse register(JobListRequest request);
     RegisterResponse editJob(String jobId, JobListRequest jobRequest);
//     List<JobList> getJobsByJobNameAndLocation(String jobTitle, String jobLocation);
}