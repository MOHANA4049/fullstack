package com.jobapp.mona.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jobapp.mona.repository.ApplicationRepository;

import com.jobapp.mona.service.ApplicationService;
import com.jobapp.mona.dto.request.ApplicationRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.ApplicationResponse;
import com.jobapp.mona.dto.response.RegisterResponse;
import com.jobapp.mona.model.Application;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
  

    private final ApplicationRepository applicationRepository;
   
    @Override
    public Basicresponse<ApplicationResponse> getAllApplications() {
        List<Application> apps = applicationRepository.findAll();
        List<ApplicationResponse> ApplicationResponses = apps.stream()
    .map(app -> ApplicationResponse.builder().applicationId(app.getApplicationId())
    .applicantName(app.getApplicantName())
    .applicantContact(app.getApplicantContact())
    .applicantEmail(app.getApplicantEmail())
    .workExperience(app.getWorkExperience())
    .applicantSkills(app.getApplicantSkills())
    .resumePath(app.getResumePath())
    .build())
    .collect(Collectors.toList());
        return Basicresponse.<ApplicationResponse>builder()
        .message("Application data fetched successfully!")
          .data(ApplicationResponses)
          .build();
    }
    @Override
    public RegisterResponse register(ApplicationRequest request) {
        var user=Application.builder()
        .applicantName(request.getApplicantName())
        .applicantContact(request.getApplicantContact())
        .workExperience(request.getWorkExperience())
        .applicantEmail(request.getApplicantEmail())
        .applicantSkills(request.getApplicantSkills())
        .resumePath(request.getResumePath())
                .build();
        applicationRepository.save(user);
        return RegisterResponse.builder()
        .message("Application create successfully!")
        .build();
    }
    @Override
    public RegisterResponse deleteApplication(String courseId) {
    RegisterResponse response = new RegisterResponse();
    try {
        
        Optional<Application> optionalCourse = applicationRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            applicationRepository.deleteById(courseId);
            response.setMessage("Application deleted successfully");
            return response;
        } else {
            response.setMessage("Application not found");
            return response;
        }
    } catch (Exception e) {
        response.setMessage("Something went wrong");
        return response;
    }
}
}

