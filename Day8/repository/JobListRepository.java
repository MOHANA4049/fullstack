package com.jobapp.mona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.mona.model.JobList;

public interface JobListRepository extends JpaRepository<JobList,String> {

}
