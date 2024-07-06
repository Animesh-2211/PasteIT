package com.jwt.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.example.entities.Link;
import com.jwt.example.entities.User;

public interface LinkRepository extends JpaRepository<Link, Long> {
    List<Link> findByUser(User user);

    void deleteLinkByName(String name);
}
