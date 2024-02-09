package com.jobapp.mona.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobListResponse {
    private String jobId;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private String Salary;
    private String DatePosted;
}