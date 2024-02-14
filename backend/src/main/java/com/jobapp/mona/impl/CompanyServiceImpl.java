package com.jobapp.mona.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jobapp.mona.repository.CompanyRepository;

import com.jobapp.mona.service.CompanyService;
import com.jobapp.mona.dto.request.CompanyRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.CompanyResponse;
import com.jobapp.mona.dto.response.RegisterResponse;
import com.jobapp.mona.model.Company;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
  

    private final CompanyRepository companyRepository;
   
    @Override
    public Basicresponse<CompanyResponse> getAllCompanies() {
        List<Company> com = companyRepository.findAll();
        List<CompanyResponse> CompanyResponses = com.stream().map(comp->CompanyResponse.builder()
        .companyId(comp.getCompanyId())
        .companyName(comp.getCompanyName())
        .companyDescription(comp.getCompanyDescription())
        .companyLocation(comp.getCompanyLocation())
        .build())
        .collect(Collectors.toList());
        return Basicresponse.<CompanyResponse>builder()
        .message("Company data fetched successfully!")
        .data(CompanyResponses)
        .build();
        
    }

    @Override
    public RegisterResponse register(CompanyRequest request) {
    
        var user=Company.builder()
        .companyName(request.getCompanyName())
        .companyDescription(request.getCompanyDescription())
        .companyLocation(request.getCompanyLocation())
                .build();
                companyRepository.save(user);
        return RegisterResponse.builder()
        .message("company created successfully!")
        .build();
    }

}


