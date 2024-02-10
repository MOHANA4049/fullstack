package com.jobapp.mona.service;

import com.jobapp.mona.dto.request.CompanyRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.CompanyResponse;
import com.jobapp.mona.dto.response.RegisterResponse;
public interface CompanyService {
     Basicresponse<CompanyResponse> getAllJobs();
     RegisterResponse register(CompanyRequest request);
}