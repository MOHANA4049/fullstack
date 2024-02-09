package com.jobapp.mona.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse {
    private String companyId;
    private String companyName;
    private String companyDescription;
    private String companyLocation;
}
