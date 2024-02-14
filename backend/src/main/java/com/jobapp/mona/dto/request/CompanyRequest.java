package com.jobapp.mona.dto.request;

import lombok.Data;

@Data
public class CompanyRequest {
    private String companyName;
    private String companyDescription;
    private String companyLocation;
}
