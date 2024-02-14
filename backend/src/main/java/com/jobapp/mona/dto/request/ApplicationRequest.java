package com.jobapp.mona.dto.request;
import lombok.Data;

@Data
public class ApplicationRequest {
    private String applicantName;
    private String applicantContact;
    private String workExperience;
    private String applicantEmail;
    private String applicantSkills;
    private String resumePath;
}
