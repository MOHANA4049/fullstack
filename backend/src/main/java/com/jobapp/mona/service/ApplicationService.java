package com.jobapp.mona.service;

import com.jobapp.mona.dto.request.ApplicationRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.ApplicationResponse;
import com.jobapp.mona.dto.response.RegisterResponse;
public interface ApplicationService {
     Basicresponse<ApplicationResponse> getAllApplications();
     RegisterResponse deleteApplication(String applicationId);
     RegisterResponse register(ApplicationRequest request);
    //  RegisterResponse editJob(String jobId, ApplicationRequest jobRequest);
}