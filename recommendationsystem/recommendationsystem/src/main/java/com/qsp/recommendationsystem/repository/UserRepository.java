package com.qsp.recommendationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.recommendationsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
   
}
