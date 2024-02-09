package com.jobapp.mona.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.mona.model.User;

public interface UserRepository extends JpaRepository<User,String>{
//check email during login
    Optional<User> findByEmail(String email);

}
