package com.jobapp.mona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.mona.model.Application;


public interface ApplicationRepository extends JpaRepository<Application,String>{

}
