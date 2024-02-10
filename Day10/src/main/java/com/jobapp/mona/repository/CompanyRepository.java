package com.jobapp.mona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.mona.model.Company;

public interface CompanyRepository extends JpaRepository<Company,String> {

}
