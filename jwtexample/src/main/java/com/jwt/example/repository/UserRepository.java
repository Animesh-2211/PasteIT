package com.jwt.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.example.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findByEmail(String email);

    public void deleteByemail(String email);

}