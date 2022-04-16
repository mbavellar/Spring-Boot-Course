package com.mbavellar.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbavellar.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

  
}