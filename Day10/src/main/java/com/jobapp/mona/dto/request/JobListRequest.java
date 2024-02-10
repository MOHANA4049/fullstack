package com.jobapp.mona.dto.request;

import lombok.Data;

@Data
public class JobListRequest {
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private String Salary;
    private String DatePosted;
}
