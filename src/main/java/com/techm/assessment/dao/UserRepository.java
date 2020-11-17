package com.techm.assessment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.assessment.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
